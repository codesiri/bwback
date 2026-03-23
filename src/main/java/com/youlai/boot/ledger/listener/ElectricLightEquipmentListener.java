package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.converter.ElectricLightEquipmentConverter;
import com.youlai.boot.ledger.model.dto.ElectricLightEquipmentDto;
import com.youlai.boot.ledger.model.entity.ElectricLightEquipment;
import com.youlai.boot.ledger.service.ElectricLightEquipmentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ElectricLightEquipmentListener extends AnalysisEventListener<ElectricLightEquipmentDto> {
    private Integer currentRow;
    @Getter
    private final ExcelResult excelResult;
    private final ElectricLightEquipmentService electricLightEquipmentService;
    private final ElectricLightEquipmentConverter electricLightEquipmentConverter;

    public ElectricLightEquipmentListener() {
        this.excelResult = new ExcelResult();
        this.electricLightEquipmentService = SpringUtil.getBean(ElectricLightEquipmentService.class);
        this.electricLightEquipmentConverter = SpringUtil.getBean(ElectricLightEquipmentConverter.class);
    }

    @Override
    public void invoke(ElectricLightEquipmentDto electricLightEquipmentDto, AnalysisContext analysisContext) {
        log.info("解析到一条用户数据:{}", JSONUtil.toJsonStr(electricLightEquipmentDto));
        boolean validation = true;
        String errorMsg = "第" + currentRow + "行数据校验失败：";
        String eleLightCode = electricLightEquipmentDto.getEleLightCode();
        if (StrUtil.isBlank(eleLightCode)) {
            errorMsg += "编号已经存在";
            validation = false;
        } else {
            long count = this.electricLightEquipmentService
                    .count(new QueryWrapper<ElectricLightEquipment>()
                            .eq("ele_light_code", eleLightCode));
            if (count > 0) {
                errorMsg += "位号已经存在";
                validation = false;
            }
        }
        if (validation) {
            ElectricLightEquipment entity = electricLightEquipmentConverter.toEntity(electricLightEquipmentDto);
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult
                    = electricLightEquipmentService.save(entity);
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
        currentRow ++;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
