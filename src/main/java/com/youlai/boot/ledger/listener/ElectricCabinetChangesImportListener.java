package com.youlai.boot.ledger.listener;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.converter.ElectricCabinetChangeConverter;
import com.youlai.boot.ledger.converter.ElectricCabinetDocumentConverter;
import com.youlai.boot.ledger.model.dto.ElectricCabinetChangeExportDto;
import com.youlai.boot.ledger.service.ElectricCabinetChangeService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class ElectricCabinetChangesImportListener extends AnalysisEventListener<ElectricCabinetChangeExportDto> {
    @Getter
    private ExcelResult excelResult;
    private ElectricCabinetChangeService electricCabinetChangeService;
    private ElectricCabinetChangeConverter electricCabinetDocumentConverter;


    public ElectricCabinetChangesImportListener(){
        this.electricCabinetChangeService = SpringUtil.getBean(ElectricCabinetChangeService.class);
        this.electricCabinetDocumentConverter = SpringUtil.getBean(ElectricCabinetChangeConverter.class);
        this.excelResult = new ExcelResult();
    }

    private  Integer currentRow = 1;
    @Override
    public void invoke(ElectricCabinetChangeExportDto electricCabinetChangeExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条消息: {}", JSONUtil.toJsonStr(electricCabinetChangeExportDto));
        String errorMsg = "第" + currentRow + "条消息出现错误";
        //验证数据是否合法
        boolean validation = true;
        if(StringUtils.isBlank(electricCabinetChangeExportDto.getEccApplicant())){
            errorMsg += "申请人为空";
            validation = false;
        }
        if(validation){
            //如果数据合法,入库
            var entity = this.electricCabinetDocumentConverter.toEntity(electricCabinetChangeExportDto);
            IDgenAdapterLeaf iDgenAdapterLeaf = new IDgenAdapterLeaf();
            long id = iDgenAdapterLeaf.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult = this.electricCabinetChangeService.save(entity);
            if(saveResult){
                excelResult.setValidCount(excelResult.getValidCount() + 1);
            }else {
                excelResult.setInvalidCount(excelResult.getInvalidCount() + 1 );
                errorMsg+= "保存错误";
                excelResult.getMessageList().add(errorMsg);
            }
        }else{
            excelResult.setInvalidCount(excelResult.getInvalidCount() + 1 );
            errorMsg+= "保存错误";
            excelResult.getMessageList().add(errorMsg);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
