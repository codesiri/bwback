package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ElectricCabinetFaultExportDto {
    /**
     * 故障日期
     */
    @ExcelProperty("故障日期")
    private LocalDate ecfFaultDate;
    /**
     * 故障发生时间
     */
    @ExcelProperty("故障发生时间")
    private LocalDate ecfFaultTime;
    /**
     * 故障柜体 / 抽屉编号
     */
    @ExcelProperty("故障柜体 / 抽屉编号")
    private String ecfFaultCabinet;
    /**
     * 故障现象
     */
    @ExcelProperty("故障现象")
    private String ecfFaultPhenomenon;
    /**
     * 故障原因分析
     */
    @ExcelProperty("故障原因分析")
    private String ecfFaultReason;
    /**
     * 维修人员
     */
    @ExcelProperty("维修人员")
    private String ecfRepairPerson;
    /**
     * 维修方案
     */
    @ExcelProperty("维修方案")
    private String ecfRepairScheme;
    /**
     * 更换元器件
     */
    @ExcelProperty("更换元器件")
    private String ecfReplaceComponent;
    /**
     * 维修完成时间
     */
    @ExcelProperty("维修完成时间")
    private LocalDateTime ecfRepairCompleteTime;
    /**
     * 	恢复运行时间
     */
    @ExcelProperty("恢复运行时间")
    private LocalDateTime ecfRecoverTime;
    /**
     * 维修结果
     */
    @ExcelProperty("维修结果")
    private String ecfRepairResult;
    /**
     * 验收人
     */
    @ExcelProperty("验收人")
    private String ecfChecker;
    /**
     * 故障分类
     */
    @ExcelProperty("故障分类")
    private String ecfFaultType;
    /**
     * 所属工厂
     */
    @ExcelProperty("所属工厂")
    private String ecfFactory;
}
