package com.youlai.boot.ledger.listener;


import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.converter.ElectricCabinetRecordConverter;
import com.youlai.boot.ledger.model.dto.ElectricCabinetRecordExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetRecord;
import com.youlai.boot.ledger.service.ElectricCabinetRecordService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ElectricCabinetRecordsListener extends AnalysisEventListener<ElectricCabinetRecordExportDto> {

    @Getter
    private  ExcelResult excelResult;
    private ElectricCabinetRecordService electricCabinetRecordService;
    private ElectricCabinetRecordConverter electricCabinetRecordConverter;

    public ElectricCabinetRecordsListener(){
        this.excelResult = new ExcelResult();
        this.electricCabinetRecordService = SpringUtil.getBean(ElectricCabinetRecordService.class);
        this.electricCabinetRecordConverter = SpringUtil.getBean(ElectricCabinetRecordConverter.class);
    }

    private  Integer currentRow = 1;

    @Override
    public void invoke(ElectricCabinetRecordExportDto electricCabinetRecordDto, AnalysisContext analysisContext) {
      log.info("解析到一条消息: {}", JSONUtil.toJsonStr(electricCabinetRecordDto));
      String errorMsg = "第" + currentRow +"条消息保存失败";
      //直接入库,因为没有需要强制检查的消息
        var entity = this.electricCabinetRecordConverter.toEntity(electricCabinetRecordDto);
        //TODO 之后需要换为美团leaf进行生成
        var id = IDUtil.genIdByLeaf();
        entity.setId(id);
        boolean saveResult = this.electricCabinetRecordService.save(entity);
        if(saveResult){
            //保存成功
            this.excelResult.setValidCount(this.excelResult.getValidCount() + 1);
        }else{
            errorMsg += "原因：入库失败";
            this.excelResult.setInvalidCount(this.excelResult.getInvalidCount() + 1);
            this.excelResult.getMessageList().add(errorMsg);
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
