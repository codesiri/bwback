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
import com.youlai.boot.ledger.converter.ControlValveConverter;
import com.youlai.boot.ledger.model.dto.ControlValveExportDto;
import com.youlai.boot.ledger.model.entity.ControlValve;
import com.youlai.boot.ledger.service.ControlValveService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 导入监听器
 * <p>
 * <a href="https://easyexcel.opensource.alibaba.com/docs/current/quickstart/read#%E6%9C%80%E7%AE%80%E5%8D%95%E7%9A%84%E8%AF%BB%E7%9A%84%E7%9B%91%E5%90%AC%E5%99%A8">最简单的读的监听器</a>
 *
 * @author Ray
 * @since 2022/4/10
 */
@Slf4j
public class ControlValveImportListener extends AnalysisEventListener<ControlValveExportDto> {

    /**
     * Excel 导入结果
     */
    @Getter
    private final ExcelResult excelResult;
    private final ControlValveService controlValveService;
    private final ControlValveConverter controlValveConverter;

    /**
     * 当前行
     */
    private Integer currentRow = 1;

    /**
     * 构造方法
     * <p>在构造方法中给需要查询的内容查询好，尽量避免每条数据查询一次</p>
     */
    public ControlValveImportListener() {
        this.controlValveService = SpringUtil.getBean(ControlValveService.class);
        this.controlValveConverter = SpringUtil.getBean(ControlValveConverter.class);
        this.excelResult = new ExcelResult();
    }

    /**
     * 每一条数据解析都会来调用
     * <p>
     * 1. 数据校验；全字段校验
     * 2. 数据持久化；
     *
     * @param controlValveExportDto 一行数据，类似于 {@link AnalysisContext#readRowHolder()}
     */
    @Override
    public void invoke(ControlValveExportDto controlValveExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条调节阀数据:{}", JSONUtil.toJsonStr(controlValveExportDto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验装置名称
        String dveName = controlValveExportDto.getDveName();
        if (StrUtil.isBlank(dveName)) {
            errorMsg.append("装置名称为空；");
            validation = false;
        }

        // 校验位号
        String tagNo = controlValveExportDto.getTagNo();
        if (StrUtil.isBlank(tagNo)) {
            errorMsg.append("位号为空；");
            validation = false;
        } else {
            long count = controlValveService.count(new LambdaQueryWrapper<ControlValve>().eq(ControlValve::getTagNo, tagNo));
            if (count > 0) {
                errorMsg.append("位号已存在；");
                validation = false;
            }
        }

        // 校验名称
        String name = controlValveExportDto.getName();
        if (StrUtil.isBlank(name)) {
            errorMsg.append("名称为空；");
            validation = false;
        }

        // 校验生产厂家
        String manufacturer = controlValveExportDto.getManufacturer();
        if (StrUtil.isBlank(manufacturer)) {
            errorMsg.append("生产厂家为空；");
            validation = false;
        }

        // 校验执行机构作用形式
        String actuatorActionForm = controlValveExportDto.getActuatorActionForm();
        if (StrUtil.isBlank(actuatorActionForm)) {
            errorMsg.append("执行机构作用形式为空；");
            validation = false;
        }

        // 校验执行机构行程
        String actuatorStroke = controlValveExportDto.getActuatorStroke();
        if (StrUtil.isBlank(actuatorStroke)) {
            errorMsg.append("执行机构行程为空；");
            validation = false;
        }

        // 校验设备类型
        String dvType = controlValveExportDto.getDvType();
        if (StrUtil.isBlank(dvType)) {
            errorMsg.append("设备类型为空；");
            validation = false;
        }

        // 校验设备状态
        Integer status = controlValveExportDto.getStatus();
        if (status == null || (status != 0 && status != 1)) {
            errorMsg.append("设备状态必须是0或1；");
            validation = false;
        }

        if (validation) {
            // 校验通过，持久化至数据库
            ControlValve entity = controlValveConverter.toEntity(controlValveExportDto);

            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            //生成id
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);

            boolean saveResult = controlValveService.save(entity);
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


