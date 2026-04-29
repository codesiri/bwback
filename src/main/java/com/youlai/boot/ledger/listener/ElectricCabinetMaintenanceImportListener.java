package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.converter.ElectricCabinetMaintenanceConverter;
import com.youlai.boot.ledger.model.dto.ElectricCabinetMaintenanceExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetMaintenance;
import com.youlai.boot.ledger.service.ElectricCabinetMaintenanceService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/**
 * 抽屉柜维护保养记录导入监听器
 *
 * @author c
 * @since 2026-04-16
 */
@Slf4j
public class ElectricCabinetMaintenanceImportListener extends AnalysisEventListener<ElectricCabinetMaintenanceExportDto> {

    @Getter
    private final ExcelResult excelResult;
    private final ElectricCabinetMaintenanceService electricCabinetMaintenanceService;
    private final ElectricCabinetMaintenanceConverter electricCabinetMaintenanceConverter;

    private Integer currentRow = 1;

    public ElectricCabinetMaintenanceImportListener() {
        this.electricCabinetMaintenanceService = SpringUtil.getBean(ElectricCabinetMaintenanceService.class);
        this.electricCabinetMaintenanceConverter = SpringUtil.getBean(ElectricCabinetMaintenanceConverter.class);
        this.excelResult = new ExcelResult();
    }

    @Override
    public void invoke(ElectricCabinetMaintenanceExportDto exportDto, AnalysisContext analysisContext) {
        log.info("解析到一条抽屉柜维护保养记录数据:{}", JSONUtil.toJsonStr(exportDto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验保养日期
        LocalDate ecmMaintainDate = exportDto.getEcmMaintainDate();
        if (ecmMaintainDate == null) {
            errorMsg.append("保养日期为空；");
            validation = false;
        }

        // 校验保养人员
        String ecmMaintainPerson = exportDto.getEcmMaintainPerson();
        if (StrUtil.isBlank(ecmMaintainPerson)) {
            errorMsg.append("保养人员为空；");
            validation = false;
        }

        // 校验保养级别
        String ecmMaintainLevel = exportDto.getEcmMaintainLevel();
        if (StrUtil.isBlank(ecmMaintainLevel)) {
            errorMsg.append("保养级别为空；");
            validation = false;
        }

        // 校验保养项目
        String ecmMaintainItem = exportDto.getEcmMaintainItem();
        if (StrUtil.isBlank(ecmMaintainItem)) {
            errorMsg.append("保养项目为空；");
            validation = false;
        }

        // 校验所属工厂
        String ecmFactory = exportDto.getEcmFactory();
        if (StrUtil.isBlank(ecmFactory)) {
            errorMsg.append("所属工厂为空；");
            validation = false;
        }

        if (validation) {
            // 校验通过，持久化至数据库
            ElectricCabinetMaintenance entity = electricCabinetMaintenanceConverter.toEntity(exportDto);

            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);

            boolean saveResult = electricCabinetMaintenanceService.save(entity);
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
        log.info("所有数据解析完成！");
    }
}