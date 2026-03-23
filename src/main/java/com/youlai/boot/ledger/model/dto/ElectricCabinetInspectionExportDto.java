package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;

import java.time.LocalDate;

public class ElectricCabinetInspectionExportDto {
    /**
     * 报告编号
     */
    @ExcelProperty("报告编号")
    private String eciReportNo;
    /**
     * 检修 / 试验日期
     */
    @ExcelProperty("检修")
    private LocalDate eciInspectDate;
    /**
     * 检修 / 试验单位
     */
    @ExcelProperty("检修 / 试验单位")
    private String eciInspectUnit;
    /**
     * 检修 / 试验人员
     */
    @ExcelProperty("检修 / 试验人员")
    private String eciInspectPerson;
    /**
     * 检修 / 试验类型
     */
    @ExcelProperty("检修 / 试验类型")
    private String eciInspectType;
    /**
     * 检修 / 试验项目
     */
    @ExcelProperty("检修 / 试验项目")
    private String eciInspectItem;
    /**
     * 试验数据
     */
    @ExcelProperty("试验数据")
    private String eciTestData;
    /**
     * 合格标准
     */
    @ExcelProperty("合格标准")
    private String eciStandard;
    /**
     * 结果判定
     */
    @ExcelProperty("结果判定")
    private String eciResult;
    /**
     * 整改内容
     */
    @ExcelProperty("整改内容")
    private String eciRectifyContent;
    /**
     * 复检结果
     */
    @ExcelProperty("复检结果")
    private String eciRecheckResult;
    /**
     * 所属工厂
     */
    @ExcelProperty("所属工厂")
    private String eciFactory;

}
