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
import com.youlai.boot.ledger.converter.RadiationInstrumentConverter;
import com.youlai.boot.ledger.converter.SePumpConverter;
import com.youlai.boot.ledger.model.dto.RadiationInstrumentExportDTO;
import com.youlai.boot.ledger.model.dto.SePumpExportDto;
import com.youlai.boot.ledger.model.entity.RadiationInstrument;
import com.youlai.boot.ledger.model.entity.SePump;
import com.youlai.boot.ledger.service.RadiationInstrumentService;
import com.youlai.boot.ledger.service.SePumpService;
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
public class SePumpImportListener extends AnalysisEventListener<SePumpExportDto> {

    /**
     * Excel 导入结果
     */
    @Getter
    private final ExcelResult excelResult;
    private final SePumpService sePumpServices;
    private final SePumpConverter sePumpConverters;

    /**
     * 当前行
     */
    private Integer currentRow = 1;

    /**
     * 构造方法
     * <p>在构造方法中给需要查询的内容查询好，尽量避免每条数据查询一次</p>
     */
    public SePumpImportListener() {
        this.sePumpServices = SpringUtil.getBean(SePumpService.class);
        this.sePumpConverters = SpringUtil.getBean(SePumpConverter.class);
        this.excelResult = new ExcelResult();
    }

    /**
     * 每一条数据解析都会来调用
     * <p>
     * 1. 数据校验；全字段校验
     * 2. 数据持久化；
     *
     * @param sePumpExportDto 一行数据，类似于 {@link AnalysisContext#readRowHolder()}
     */
    @Override
    public void invoke(SePumpExportDto sePumpExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条用户数据:{}", JSONUtil.toJsonStr(sePumpExportDto));

        boolean validation = true;
        String errorMsg = "第" + currentRow + "行数据校验失败：";



        String pressureTag = sePumpExportDto.getSePumpEquipCode();
        if (StrUtil.isBlank(pressureTag)) {
            errorMsg += "位号为空；";
            validation = false;
        } else {
            long count = sePumpServices.count(new LambdaQueryWrapper<SePump>().eq(SePump::getSePumpEquipCode, pressureTag));
            if (count > 0) {
                errorMsg += "位号已存在；";
                validation = false;
            }
        }

        if (validation) {
            // 校验通过，持久化至数据库
            SePump entity = sePumpConverters.toEntity(sePumpExportDto);
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            //生成id
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult = sePumpServices.save(entity);
            if (saveResult) {
                excelResult.setValidCount(excelResult.getValidCount() + 1);
            } else {
                excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
                errorMsg += "第" + currentRow + "行数据保存失败；";
                excelResult.getMessageList().add(errorMsg);
            }
        } else {
            excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
            excelResult.getMessageList().add(errorMsg);
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

