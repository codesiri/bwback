package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.converter.SwitchValveConverter;
import com.youlai.boot.ledger.model.dto.SwitchValveExportDto;
import com.youlai.boot.ledger.model.entity.SwitchValve;
import com.youlai.boot.ledger.service.SwitchValveService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 开关阀导入监听器
 *
 * @author dazao
 * @since 2026-04-15
 */
@Slf4j
public class SwitchValveImportListener extends AnalysisEventListener<SwitchValveExportDto> {

    /**
     * Excel 导入结果
     */
    @Getter
    private final ExcelResult excelResult;
    private final SwitchValveService switchValveService;
    private final SwitchValveConverter switchValveConverter;

    /**
     * 当前行
     */
    private Integer currentRow = 1;

    /**
     * 构造方法
     * <p>在构造方法中给需要查询的内容查询好，尽量避免每条数据查询一次</p>
     */
    public SwitchValveImportListener() {
        this.switchValveService = SpringUtil.getBean(SwitchValveService.class);
        this.switchValveConverter = SpringUtil.getBean(SwitchValveConverter.class);
        this.excelResult = new ExcelResult();
    }

    /**
     * 每一条数据解析都会来调用
     * <p>
     * 1. 数据校验；全字段校验
     * 2. 数据持久化；
     *
     * @param switchValveExportDto 一行数据，类似于 {@link AnalysisContext#readRowHolder()}
     */
    @Override
    public void invoke(SwitchValveExportDto switchValveExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条开关阀数据:{}", JSONUtil.toJsonStr(switchValveExportDto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验位号
        String switchValveTag = switchValveExportDto.getSwitchValveTag();
        if (StrUtil.isBlank(switchValveTag)) {
            errorMsg.append("位号为空；");
            validation = false;
        } else {
            long count = switchValveService.count(new LambdaQueryWrapper<SwitchValve>().eq(SwitchValve::getSwitchValveTag, switchValveTag));
            if (count > 0) {
                errorMsg.append("位号已存在；");
                validation = false;
            }
        }

        // 校验装置名称
        String switchValveDevice = switchValveExportDto.getSwitchValveDevice();
        if (StrUtil.isBlank(switchValveDevice)) {
            errorMsg.append("装置名称为空；");
            validation = false;
        }

        // 校验名称
        String switchValveName = switchValveExportDto.getSwitchValveName();
        if (StrUtil.isBlank(switchValveName)) {
            errorMsg.append("名称为空；");
            validation = false;
        }

        // 校验生产厂家
        String switchValveManu = switchValveExportDto.getSwitchValveManu();
        if (StrUtil.isBlank(switchValveManu)) {
            errorMsg.append("生产厂家为空；");
            validation = false;
        }

        // 校验安装位置及用途
        String switchValveLocation = switchValveExportDto.getSwitchValveLocation();
        if (StrUtil.isBlank(switchValveLocation)) {
            errorMsg.append("安装位置及用途为空；");
            validation = false;
        }

        if (validation) {
            // 校验通过，持久化至数据库
            SwitchValve entity = switchValveConverter.toEntity(switchValveExportDto);

            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            //生成id
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult = switchValveService.save(entity);
            if (saveResult) {
                excelResult.setValidCount(excelResult.getValidCount() + 1);
            } else {
                excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
                errorMsg = new StringBuilder("第" + currentRow + "行数据保存失败；");
                excelResult.getMessageList().add(errorMsg.toString());
            }
        } else {
            excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
            excelResult.getMessageList().add(errorMsg.toString());
        }
        currentRow++;
    }

    /**
     * 所有数据解析完成会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }
}
