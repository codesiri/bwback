package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.converter.DvFlowmetreInfoConverter;
import com.youlai.boot.ledger.model.dto.DvFlowmetreInfoExportDto;
import com.youlai.boot.ledger.model.entity.DvFlowmetreInfo;
import com.youlai.boot.ledger.service.DvFlowmetreInfoService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DvFlowmetreInfoImportListener extends AnalysisEventListener<DvFlowmetreInfoExportDto> {
    @Getter
    private final ExcelResult excelResult;
    private final DvFlowmetreInfoService dvFlowmetreInfoService;
    private final DvFlowmetreInfoConverter dvFlowmetreInfoConverter;
    private Integer currentRow = 1;

    public DvFlowmetreInfoImportListener() {
        this.dvFlowmetreInfoService = SpringUtil.getBean(DvFlowmetreInfoService.class);
        this.dvFlowmetreInfoConverter = SpringUtil.getBean(DvFlowmetreInfoConverter.class);
        this.excelResult = new ExcelResult();
    }

    @Override
    public void invoke(DvFlowmetreInfoExportDto dvFlowmetreInfoExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条数据");
        boolean validation = true;
        String errorMsg = "第" + this.currentRow + "行数据校验失败：";
        String tagNumber = dvFlowmetreInfoExportDto.getTagNumber();
        if (StrUtil.isBlank(tagNumber)) {
            validation = false;
            errorMsg += "位号为空";
        } else {
            long count = dvFlowmetreInfoService
                    .count(new QueryWrapper<DvFlowmetreInfo>()
                            .eq("tag_number",
                                    dvFlowmetreInfoExportDto.getTagNumber()));
            if (count > 0) {
                validation = false;
                errorMsg += "位号已经存在";
            }
        }
        String instrumentName = dvFlowmetreInfoExportDto.getInstrumentName();
        if (StrUtil.isBlank(instrumentName)) {
            validation = false;
            errorMsg += "仪表名称为空";
        }
        if (StrUtil.isBlank(dvFlowmetreInfoExportDto.getDevice())) {
            validation = false;
            errorMsg += "装置为空";
        }
        if (dvFlowmetreInfoExportDto.getStatus() == null) {
            validation = false;
            errorMsg += "设备状态为空";
        }
        if (StrUtil.isBlank(dvFlowmetreInfoExportDto.getDvType())) {
            validation = false;
            errorMsg += "设备类型为空";
        }
        if (validation) {
            //校验通过入库
            DvFlowmetreInfo entity = this.dvFlowmetreInfoConverter.toEntity(dvFlowmetreInfoExportDto);
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult = this.dvFlowmetreInfoService.save(entity);
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

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成");
    }
}
