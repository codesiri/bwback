package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 抽屉柜维护保养记录导出DTO
 *
 * @author c
 * @since 2026-04-16
 */
@Getter
@Setter
@Schema(description = "抽屉柜维护保养记录导出DTO")
public class ElectricCabinetMaintenanceExportDto {

    @ExcelProperty(value = "序号")
    private Long id;

    @ExcelProperty(value = "保养日期")
    private LocalDate ecmMaintainDate;

    @ExcelProperty(value = "保养人员")
    private String ecmMaintainPerson;

    @ExcelProperty(value = "保养级别")
    private String ecmMaintainLevel;

    @ExcelProperty(value = "保养项目")
    private String ecmMaintainItem;

    @ExcelProperty(value = "保养内容")
    private String ecmMaintainContent;

    @ExcelProperty(value = "更换元器件")
    private String ecmReplaceComponent;

    @ExcelProperty(value = "保养结果")
    private String ecmMaintainResult;

    @ExcelProperty(value = "验收人")
    private String ecmChecker;

    @ExcelProperty(value = "下次保养日期")
    private LocalDate ecmNextMaintainDate;

    @ExcelProperty(value = "所属工厂")
    private String ecmFactory;
}