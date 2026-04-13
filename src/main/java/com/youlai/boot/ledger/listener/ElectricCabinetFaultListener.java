package com.youlai.boot.ledger.listener;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.converter.ElectricCabinetFaultConverter;
import com.youlai.boot.ledger.model.dto.ElectricCabinetFaultExportDto;
import com.youlai.boot.ledger.service.ElectricCabinetFaultService;
import lombok.Getter;

@lombok.extern.slf4j.Slf4j
public class ElectricCabinetFaultListener extends AnalysisEventListener<ElectricCabinetFaultExportDto> {
    @Getter
    private ExcelResult excelResult;
    private ElectricCabinetFaultService electricCabinetFaultService;
    private ElectricCabinetFaultConverter electricCabinetFaultConverter;

    public ElectricCabinetFaultListener(){
        this.excelResult = new ExcelResult();
        this.electricCabinetFaultService = SpringUtil.getBean(ElectricCabinetFaultService.class);
        this.electricCabinetFaultConverter = SpringUtil.getBean(ElectricCabinetFaultConverter.class);
    }

    private Integer currentRow = 1;
    @Override
    public void invoke(ElectricCabinetFaultExportDto electricCabinetFaultExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条数据： {}", JSONUtil.toJsonStr(electricCabinetFaultExportDto));
        String errorMsg = "第" + currentRow +"数据解析错误";
        //直接入库
        var entity = electricCabinetFaultConverter.toEntity(electricCabinetFaultExportDto);
        //TODO 上线切换为美团leaf
        var id = IDUtil.genIdByJdk();
        entity.setId(id);
        boolean saveResult = this.electricCabinetFaultService.save(entity);
        if(saveResult){
            excelResult.setValidCount(excelResult.getValidCount() + 1);
            log.info("数据保存成功");
        }else{
            excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
            excelResult.getMessageList().add(errorMsg);
        }
        currentRow ++;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
