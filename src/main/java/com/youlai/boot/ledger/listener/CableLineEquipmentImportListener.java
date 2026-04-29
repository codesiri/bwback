package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
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

@Slf4j
public class CableLineEquipmentImportListener extends AnalysisEventListener<CableLineEquipmentExportDto> {
    @Getter
    ExcelResult excelResult;
    CableLineEquipmentService cableLineEquipmentService;
    CableLineEquipmentConverter cableLineEquipmentConverter;

    private Integer currentRow = 1;

    public CableLineEquipmentImportListener() {
        this.excelResult = new ExcelResult();
        this.cableLineEquipmentConverter = SpringUtil.getBean(CableLineEquipmentConverter.class);
        this.cableLineEquipmentService = SpringUtil.getBean(CableLineEquipmentService.class);
    }

    @Override
    public void invoke(CableLineEquipmentExportDto cableLineEquipmentExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条电缆线路设备数据:{}", JSONUtil.toJsonStr(cableLineEquipmentExportDto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验电缆编号
        String cleCableCode = cableLineEquipmentExportDto.getCleCableCode();
        if (StrUtil.isBlank(cleCableCode)) {
            errorMsg.append("电缆编号为空；");
            validation = false;
        } else {
            long count = this.cableLineEquipmentService.count(new QueryWrapper<CableLineEquipment>().eq("cle_cable_code", cleCableCode));
            if (count > 0) {
                errorMsg.append("电缆编号已存在；");
                validation = false;
            }
        }

        // 校验电缆名称
        String cleCableName = cableLineEquipmentExportDto.getCleCableName();
        if (StrUtil.isBlank(cleCableName)) {
            errorMsg.append("电缆名称为空；");
            validation = false;
        }

        // 校验规格型号
        String cleSpecModel = cableLineEquipmentExportDto.getCleSpecModel();
        if (StrUtil.isBlank(cleSpecModel)) {
            errorMsg.append("规格型号为空；");
            validation = false;
        }

        // 校验绝缘等级
        String cleInsulationLevel = cableLineEquipmentExportDto.getCleInsulationLevel();
        if (StrUtil.isBlank(cleInsulationLevel)) {
            errorMsg.append("绝缘等级为空；");
            validation = false;
        }

        // 校验电缆长度
        String cleCableLength = cableLineEquipmentExportDto.getCleCableLength();
        if (StrUtil.isBlank(cleCableLength)) {
            errorMsg.append("电缆长度为空；");
            validation = false;
        }

        // 校验敷设方式
        String cleLayingMethod = cableLineEquipmentExportDto.getCleLayingMethod();
        if (StrUtil.isBlank(cleLayingMethod)) {
            errorMsg.append("敷设方式为空；");
            validation = false;
        }

        // 校验敷设路径
        String cleLayingPath = cableLineEquipmentExportDto.getCleLayingPath();
        if (StrUtil.isBlank(cleLayingPath)) {
            errorMsg.append("敷设路径为空；");
            validation = false;
        }

        // 校验安装区域及危险等级
        String cleInstallArea = cableLineEquipmentExportDto.getCleInstallArea();
        if (StrUtil.isBlank(cleInstallArea)) {
            errorMsg.append("安装区域及危险等级为空；");
            validation = false;
        }

        // 校验所属工厂
        String cleFactory = cableLineEquipmentExportDto.getCleFactory();
        if (StrUtil.isBlank(cleFactory)) {
            errorMsg.append("所属工厂为空；");
            validation = false;
        }

        if (validation) {
            // 校验通过，持久化至数据库
            long id = IDUtil.genIdByLeaf();
            CableLineEquipment entity = this.cableLineEquipmentConverter.toEntity(cableLineEquipmentExportDto);
            entity.setId(id);
            boolean saveResult = this.cableLineEquipmentService.save(entity);
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
