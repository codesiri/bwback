package com.youlai.boot.ledger.listener;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.converter.ElectricCabinetMainComponentConverter;
import com.youlai.boot.ledger.model.dto.ElectricCabinetMainComponentDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetMainComponent;
import com.youlai.boot.ledger.service.ElectricCabinetMainComponentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ElectricCabinetMainComponentsImportListener extends AnalysisEventListener<ElectricCabinetMainComponentDto> {
    @Getter
    ExcelResult excelResult;
    ElectricCabinetMainComponentService electricCabinetMainComponentService;
    ElectricCabinetMainComponentConverter electricCabinetMainComponentConverter;

    private Integer currentRow = 1;
    public ElectricCabinetMainComponentsImportListener(){
        this.excelResult = new ExcelResult();
        this.electricCabinetMainComponentService = SpringUtil.getBean(ElectricCabinetMainComponentService.class);
        this.electricCabinetMainComponentConverter = SpringUtil.getBean(ElectricCabinetMainComponentConverter.class);
    }

    @Override
    public void invoke(ElectricCabinetMainComponentDto electricCabinetMainComponentDto, AnalysisContext analysisContext) {
      log.info("解析到一条用户数据:{}", JSONUtil.toJsonStr(electricCabinetMainComponentDto));
      boolean validation = true;
      String errorMsg = "第" + currentRow + "行数据校验失败：";
      if(validation) {
          ElectricCabinetMainComponent entity = electricCabinetMainComponentConverter.toEntity(electricCabinetMainComponentDto);
          boolean saveResult = this.electricCabinetMainComponentService.save(entity);
          if(saveResult){
              //保存成功
              excelResult.setInvalidCount(excelResult.getValidCount() + 1);
          }else{
              excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
              errorMsg += "第" + currentRow + "行数据保存失败；";
              excelResult.getMessageList().add(errorMsg);
          }
      }else{
          excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
          errorMsg += "第" + currentRow + "行数据保存失败；";
          excelResult.getMessageList().add(errorMsg);
      }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
