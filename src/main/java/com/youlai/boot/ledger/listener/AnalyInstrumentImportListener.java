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
import com.youlai.boot.ledger.converter.AnalyInstrumentConverter;
import com.youlai.boot.ledger.model.dto.AnalyInstrumentExportDto;
import com.youlai.boot.ledger.model.entity.AnalyInstrument;
import com.youlai.boot.ledger.service.AnalyInstrumentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@Slf4j
public class AnalyInstrumentImportListener extends AnalysisEventListener<AnalyInstrumentExportDto> {
    @Getter
    private ExcelResult excelResult;
    private AnalyInstrumentService analyInstrumentService;
    private AnalyInstrumentConverter analyInstrumentConverter;

    private Integer currentRow = 1;

    public AnalyInstrumentImportListener (){
        this.excelResult = new ExcelResult();
        analyInstrumentService = SpringUtil.getBean(AnalyInstrumentService.class);
        analyInstrumentConverter = SpringUtil.getBean(AnalyInstrumentConverter.class);
    }


    @Override
    public void invoke(AnalyInstrumentExportDto analyInstrumentExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条数据");
        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + this.currentRow + "行数据校验失败：");

        String tagNumber = analyInstrumentExportDto.getAnalyInstrumentCode();
        if (StrUtil.isBlank(tagNumber)) {
            errorMsg.append("设备位号为空；");
            validation = false;
        } else {
            long analyInstrumentCode = this.analyInstrumentService.count(
                    new QueryWrapper<AnalyInstrument>().eq("analy_instrument_code", tagNumber));
            if (analyInstrumentCode != 0) {
                validation = false;
                errorMsg.append("设备位号已经存在；");
            }
        }

        if (StrUtil.isBlank(analyInstrumentExportDto.getAnalyInstrumentPurpose())) {
            errorMsg.append("用途为空；");
            validation = false;
        }

        if (StrUtil.isBlank(analyInstrumentExportDto.getAnalyInstrumentDept())) {
            errorMsg.append("所属部门为空；");
            validation = false;
        }

        if (StrUtil.isBlank(analyInstrumentExportDto.getAnalyInstrumentType())) {
            errorMsg.append("设备类型为空；");
            validation = false;
        }

        Integer analyInstrumentStatus = analyInstrumentExportDto.getAnalyInstrumentStatus();
        if (analyInstrumentStatus == null) {
            errorMsg.append("设备状态为空；");
            validation = false;
        } else if (analyInstrumentStatus != 0 && analyInstrumentStatus != 1) {
            errorMsg.append("设备状态只能是0或者1；");
            validation = false;
        }

        if (analyInstrumentExportDto.getAnalyInstrumentMonitor() == null) {
            errorMsg.append("是否参与检测为空；");
            validation = false;
        }

        if (StrUtil.isBlank(analyInstrumentExportDto.getAnalyInstrumentLock())) {
            errorMsg.append("是否参与联锁为空；");
            validation = false;
        }

        if (StrUtil.isBlank(analyInstrumentExportDto.getAnalyInstrumentProcess())) {
            errorMsg.append("工艺介质为空；");
            validation = false;
        }

        if (analyInstrumentExportDto.getAnalyInstrumentProdDate() == null) {
            errorMsg.append("生产日期为空；");
            validation = false;
        }

        if (analyInstrumentExportDto.getAnalyInstrumentUseDate() == null) {
            errorMsg.append("投用日期为空；");
            validation = false;
        }

        if (analyInstrumentExportDto.getAnalyInstrumentGuaranteeDate() == null) {
            errorMsg.append("质保日期为空；");
            validation = false;
        }

        if (analyInstrumentExportDto.getAnalyInstrumentMaintainFlag() == null) {
            errorMsg.append("是否质保期内为空；");
            validation = false;
        }

        if (StrUtil.isBlank(analyInstrumentExportDto.getAnalyInstrumentManufacturer())) {
            errorMsg.append("生产厂家为空；");
            validation = false;
        }

        if (validation) {
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            AnalyInstrument analyInstrument = new AnalyInstrument();
            BeanUtils.copyProperties(analyInstrumentExportDto, analyInstrument);
            analyInstrument.setId(id);
            boolean saveResult = this.analyInstrumentService.save(analyInstrument);
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

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
