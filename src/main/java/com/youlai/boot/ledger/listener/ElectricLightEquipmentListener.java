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
    private Integer currentRow = 1;
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
        log.info("解析到一条照明设备数据:{}", JSONUtil.toJsonStr(electricLightEquipmentDto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验照明设备编号
        String eleLightCode = electricLightEquipmentDto.getEleLightCode();
        if (StrUtil.isBlank(eleLightCode)) {
            errorMsg.append("照明设备编号为空；");
            validation = false;
        } else {
            long count = this.electricLightEquipmentService
                    .count(new QueryWrapper<ElectricLightEquipment>()
                            .eq("ele_light_code", eleLightCode));
            if (count > 0) {
                errorMsg.append("照明设备编号已存在；");
                validation = false;
            }
        }

        // 校验设备名称
        String eleLightName = electricLightEquipmentDto.getEleLightName();
        if (StrUtil.isBlank(eleLightName)) {
            errorMsg.append("设备名称为空；");
            validation = false;
        }

        // 校验规格型号
        String eleSpecModel = electricLightEquipmentDto.getEleSpecModel();
        if (StrUtil.isBlank(eleSpecModel)) {
            errorMsg.append("规格型号为空；");
            validation = false;
        }

        if (validation) {
            // 校验通过，持久化至数据库
            ElectricLightEquipment entity = electricLightEquipmentConverter.toEntity(electricLightEquipmentDto);
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult = electricLightEquipmentService.save(entity);
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
