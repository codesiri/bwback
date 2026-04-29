package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.converter.ElectricCabinetDrawerUnitConverter;
import com.youlai.boot.ledger.model.dto.ElectricCabinetDrawerUnitsExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetDrawerUnit;
import com.youlai.boot.ledger.service.ElectricCabinetDrawerUnitService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 抽屉柜抽屉单元明细导入监听器
 *
 * @author youlaitech
 * @since 2026-04-28
 */
@Slf4j
public class ElectricCabinetDrawerUnitImportListener extends AnalysisEventListener<ElectricCabinetDrawerUnitsExportDto> {

    @Getter
    private final ExcelResult excelResult;
    private final ElectricCabinetDrawerUnitService electricCabinetDrawerUnitService;
    private final ElectricCabinetDrawerUnitConverter electricCabinetDrawerUnitConverter;

    private Integer currentRow = 1;

    public ElectricCabinetDrawerUnitImportListener() {
        this.electricCabinetDrawerUnitService = SpringUtil.getBean(ElectricCabinetDrawerUnitService.class);
        this.electricCabinetDrawerUnitConverter = SpringUtil.getBean(ElectricCabinetDrawerUnitConverter.class);
        this.excelResult = new ExcelResult();
    }

    @Override
    public void invoke(ElectricCabinetDrawerUnitsExportDto dto, AnalysisContext analysisContext) {
        log.info("解析到一条抽屉柜抽屉单元明细数据:{}", JSONUtil.toJsonStr(dto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验抽屉编号
        String ecduDrawerNo = dto.getEcduDrawerNo();
        if (StrUtil.isBlank(ecduDrawerNo)) {
            errorMsg.append("抽屉编号为空；");
            validation = false;
        }

        // 校验单元名称
        String ecduUnitName = dto.getEcduUnitName();
        if (StrUtil.isBlank(ecduUnitName)) {
            errorMsg.append("单元名称为空；");
            validation = false;
        }

        // 校验所属工厂
        String ecduFactory = dto.getEcduFactory();
        if (StrUtil.isBlank(ecduFactory)) {
            errorMsg.append("所属工厂为空；");
            validation = false;
        }

        if (validation) {
            ElectricCabinetDrawerUnit entity = electricCabinetDrawerUnitConverter.toEntity(dto);
            long id = IDUtil.genIdByLeaf();
            entity.setId(id);

            boolean saveResult = electricCabinetDrawerUnitService.save(entity);
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