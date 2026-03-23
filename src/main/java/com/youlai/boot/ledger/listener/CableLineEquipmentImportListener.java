package com.youlai.boot.ledger.listener;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.converter.CableLineEquipmentConverter;
import com.youlai.boot.ledger.model.dto.CableLineEquipmentExportDto;
import com.youlai.boot.ledger.model.entity.CableLineEquipment;
import com.youlai.boot.ledger.service.CableLineEquipmentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class CableLineEquipmentImportListener extends AnalysisEventListener<CableLineEquipmentExportDto> {
    @Getter
    ExcelResult excelResult;
    CableLineEquipmentService cableLineEquipmentService;
    CableLineEquipmentConverter cableLineEquipmentConverter;

    public CableLineEquipmentImportListener() {
        this.excelResult = new ExcelResult();
        this.cableLineEquipmentConverter = SpringUtil.getBean(CableLineEquipmentConverter.class);
        this.cableLineEquipmentService = SpringUtil.getBean(CableLineEquipmentService.class);
    }

    private Integer currentRow = 1;

    @Override
    public void invoke(CableLineEquipmentExportDto cableLineEquipmentExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条消息: {}", JSONUtil.toJsonStr(cableLineEquipmentExportDto));
        String errorMsg = "第" + currentRow + "条消息错误";
        boolean validation = true;
        String cleCableCode = cableLineEquipmentExportDto.getCleCableCode();
        long count = this.cableLineEquipmentService.count(new QueryWrapper<CableLineEquipment>().eq("cle_cable_code", cleCableCode));
        if(StringUtils.isBlank(cleCableCode)){
            validation = false;
            errorMsg += "编号为空";
        }
        if (count > 0) {
            validation = false;
            errorMsg += "编号已经存在";
        }
        if(validation) {
            //TODO 后续换位美团leaf
            long id = IDUtil.genIdByJdk();
            CableLineEquipment entity = this.cableLineEquipmentConverter.toEntity(cableLineEquipmentExportDto);
            entity.setId(id);
            boolean saveResult = this.cableLineEquipmentService.save(entity);
            if(saveResult){
                //如果保存失败
                excelResult.setValidCount(excelResult.getValidCount() + 1);
            }else{
                errorMsg += "数据保存失败";
                excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
                excelResult.getMessageList().add(errorMsg);
            }
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
