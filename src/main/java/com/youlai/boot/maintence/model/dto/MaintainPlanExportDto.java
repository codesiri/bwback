package com.youlai.boot.maintence.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class MaintainPlanExportDto {

    @ExcelProperty("计划类型")
    private String maintainPlanType;

    @ExcelProperty("计划年度")
    private Integer maintainPlanYear;

    @ExcelProperty("计划月份")
    private Integer maintainPlanMonth;

    @ExcelProperty("设备编号")
    private String maintainPlanEquipCode;

    @ExcelProperty("设备名称")
    private String maintainPlanEquipName;

    @ExcelProperty("设备类型")
    private String maintainPlanEquipType;

    @ExcelProperty("维修/检修内容")
    private String maintainPlanContent;

    @ExcelProperty("计划执行日期")
    private LocalDate maintainPlanScheduleDate;

    @ExcelProperty("计划时长")
    private BigDecimal maintainPlanDuration;

    @ExcelProperty("负责部门")
    private String maintainPlanDept;

    @ExcelProperty("负责人")
    private String maintainPlanPerson;

    @ExcelProperty("安全风险等级")
    private String maintainPlanSafetyLevel;

    @ExcelProperty("安全防护措施")
    private String maintainPlanSafetyMeasure;

    @ExcelProperty("计划状态")
    private String maintainPlanStatus;

    @ExcelProperty("实际执行日期")
    private LocalDate maintainPlanActualDate;
}
