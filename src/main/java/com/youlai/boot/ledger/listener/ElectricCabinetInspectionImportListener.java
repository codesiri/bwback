package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.converter.ElectricCabinetInspectionConverter;
import com.youlai.boot.ledger.model.dto.ElectricCabinetInspectionExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetInspection;
import com.youlai.boot.ledger.service.ElectricCabinetInspectionService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/**
 * 抽屉柜检修试验记录导入监听器
 *
 * @author youlaitech
 * @since 2026-04-28
 */
@Slf4j
public class ElectricCabinetInspectionImportListener extends AnalysisEventListener<ElectricCabinetInspectionExportDto> {

    @Getter
    private final ExcelResult excelResult;
    private final ElectricCabinetInspectionService electricCabinetInspectionService;
    private final ElectricCabinetInspectionConverter electricCabinetInspectionConverter;

    private Integer currentRow = 1;

    public ElectricCabinetInspectionImportListener() {
        this.electricCabinetInspectionService = SpringUtil.getBean(ElectricCabinetInspectionService.class);
        this.electricCabinetInspectionConverter = SpringUtil.getBean(ElectricCabinetInspectionConverter.class);
        this.excelResult = new ExcelResult();
    }

    @Override
    public void invoke(ElectricCabinetInspectionExportDto dto, AnalysisContext analysisContext) {
        log.info("解析到一条抽屉柜检修试验记录数据:{}", JSONUtil.toJsonStr(dto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验报告编号
        String eciReportNo = dto.getEciReportNo();
        if (StrUtil.isBlank(eciReportNo)) {
            errorMsg.append("报告编号为空；");
            validation = false;
        }

        // 校验检修日期
        LocalDate eciInspectDate = dto.getEciInspectDate();
        if (eciInspectDate == null) {
            errorMsg.append("检修日期为空；");
            validation = false;
        }

        // 校验检修人员
        String eciInspectPerson = dto.getEciInspectPerson();
        if (StrUtil.isBlank(eciInspectPerson)) {
            errorMsg.append("检修人员为空；");
            validation = false;
        }

        // 校验所属工厂
        String eciFactory = dto.getEciFactory();
        if (StrUtil.isBlank(eciFactory)) {
            errorMsg.append("所属工厂为空；");
            validation = false;
        }

        if (validation) {
            ElectricCabinetInspection entity = electricCabinetInspectionConverter.toEntity(dto);
            long id = IDUtil.genIdByLeaf();
            entity.setId(id);

            boolean saveResult = electricCabinetInspectionService.save(entity);
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