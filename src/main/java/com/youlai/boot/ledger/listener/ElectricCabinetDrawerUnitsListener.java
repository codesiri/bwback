package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.converter.ElectricCabinetDrawerUnitConverter;
import com.youlai.boot.ledger.model.dto.ElectricCabinetDrawerUnitsExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetDrawerUnit;
import com.youlai.boot.ledger.service.ElectricCabinetDrawerUnitService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ElectricCabinetDrawerUnitsListener extends AnalysisEventListener<ElectricCabinetDrawerUnitsExportDto> {
    @Getter
    private ExcelResult excelResult;
    private ElectricCabinetDrawerUnitService electricCabinetDrawerUnitService;
    private ElectricCabinetDrawerUnitConverter electricCabinetDrawerUnitConverter;

    public ElectricCabinetDrawerUnitsListener(){
        this.excelResult = new ExcelResult();
        this.electricCabinetDrawerUnitService = SpringUtil.getBean(ElectricCabinetDrawerUnitService.class);
        this.electricCabinetDrawerUnitConverter = SpringUtil.getBean(ElectricCabinetDrawerUnitConverter.class);
    }

    private Integer currentRow = 1;


    @Override
    public void invoke(ElectricCabinetDrawerUnitsExportDto electricCabinetDrawerUnitsExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条数据: {}", JSONUtil.toJsonStr(electricCabinetDrawerUnitsExportDto));
        String errorMsg = "第" + currentRow + "条数据错误";
        boolean validation = true;
        if(StrUtil.isBlank(electricCabinetDrawerUnitsExportDto.getEcduDrawerNo())) {
            validation = false;
            errorMsg += "编号不能为空";
        }
        long count = this.electricCabinetDrawerUnitService
                .count(new QueryWrapper<ElectricCabinetDrawerUnit>().eq("ecdu_drawer_no", electricCabinetDrawerUnitsExportDto.getEcduDrawerNo()));
        if(count != 0){
            validation = false;
            errorMsg += "编号已经存在";
        }
        if(validation){
            //准备入库
            ElectricCabinetDrawerUnit  entity =this.electricCabinetDrawerUnitConverter.toEntity(electricCabinetDrawerUnitsExportDto);
            long idByLeaf = IDUtil.genIdByLeaf();
            entity.setId(idByLeaf);
            boolean saveResult = this.electricCabinetDrawerUnitService.save(entity);
            if(saveResult){
                this.excelResult.setValidCount(excelResult.getValidCount() + 1);
            }else{
                this.excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
                errorMsg += "数据保存失败";
                this.excelResult.getMessageList().add(errorMsg);
            }
        }else {
            this.excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
            errorMsg += "数据保存失败";
            this.excelResult.getMessageList().add(errorMsg);
        }
        this.currentRow ++;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
