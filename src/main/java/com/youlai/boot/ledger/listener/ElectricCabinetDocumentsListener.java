package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.converter.ElectricCabinetDocumentConverter;
import com.youlai.boot.ledger.model.dto.ElectricCabinetDocumentExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetDocument;
import com.youlai.boot.ledger.service.ElectricCabinetDocumentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ElectricCabinetDocumentsListener extends AnalysisEventListener<ElectricCabinetDocumentExportDto> {
    @Getter
    private ExcelResult excelResult;
    private ElectricCabinetDocumentConverter electricCabinetDocumentConverter;
    private ElectricCabinetDocumentService electricCabinetDocumentService;

    private Integer currentRow = 1;
    public ElectricCabinetDocumentsListener(){
        this.excelResult = new ExcelResult();
        this.electricCabinetDocumentConverter = SpringUtil.getBean(ElectricCabinetDocumentConverter.class);
        this.electricCabinetDocumentService = SpringUtil.getBean(ElectricCabinetDocumentService.class);
    }

    @Override
    public void invoke(ElectricCabinetDocumentExportDto electricCabinetDocumentExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条消息: {}", JSONUtil.toJsonStr(electricCabinetDocumentExportDto));
        String errorMsg = "第" + currentRow + "行数据校验失败：";
        boolean validation = true;
        //检测是否有重复编号
        String ecdDocNo = electricCabinetDocumentExportDto.getEcdDocNo();
        if(StrUtil.isBlank(ecdDocNo)){
            validation = false;
            errorMsg += "编号为空";
        }
        long count = this.electricCabinetDocumentService
                .count(new QueryWrapper<ElectricCabinetDocument>()
                        .eq("ecd_doc_no",ecdDocNo));
        if(count != 0){
            errorMsg += "编号已经存在";
            validation = false;
        }
        if(validation){
            com.youlai.boot.ledger.model.entity.ElectricCabinetDocument entity =this.electricCabinetDocumentConverter.toEntity(electricCabinetDocumentExportDto);
            IDgenAdapterLeaf iDgenAdapterLeaf = new IDgenAdapterLeaf();
            long id = iDgenAdapterLeaf.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult=this.electricCabinetDocumentService.save(entity);
            if(saveResult){
                excelResult.setValidCount(excelResult.getValidCount() + 1);
            }else{
                excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
                errorMsg += "第" + currentRow + "行数据保存失败；";
                excelResult.getMessageList().add(errorMsg);
            }
        }else {
            excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
            errorMsg += "第" + currentRow + "行数据保存失败；";
            excelResult.getMessageList().add(errorMsg);
        }
        currentRow ++;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
