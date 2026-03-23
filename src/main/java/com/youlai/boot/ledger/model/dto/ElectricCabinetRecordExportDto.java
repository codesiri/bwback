package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class ElectricCabinetRecordExportDto {
    /**
     * 巡检日期
     */
    @ExcelProperty("巡检日期")
    private LocalDate ecrInspectDate;
    /**
     * 巡检人
     */
    @ExcelProperty("巡检人")
    private String ecrInspectPerson;
    /**
     * 巡检项目
     */
    @ExcelProperty("巡检项目")
    private String ecrInspectItem;
    /**
     * 巡检结果
     */
    @ExcelProperty("巡检结果")
    private String ecrInspectResult;
    /**
     * 问题描述
     */
    @ExcelProperty("问题描述")
    private String ecrProblemDesc;
    /**
     * 处理措施
     */
    @ExcelProperty("处理措施")
    private String ecrMeasure;
    /**
     * 处理人
     */
    @ExcelProperty("处理人")
    private String ecrHandler;
    /**
     * 所属工厂
     */
    @ExcelProperty("所属工厂")
    private String ecrFactory;
}
