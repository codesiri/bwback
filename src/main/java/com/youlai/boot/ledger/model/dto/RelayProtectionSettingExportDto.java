package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class RelayProtectionSettingExportDto {
    /**
     * 继电器编号
     */
    @ExcelProperty("继电器编号")
    private String rpsRelayCode;
    /**
     * 继电器类型
     */
    @ExcelProperty("继电器类型")
    private String rpsRelayType;
    /**
     * 继电器型号
     */
    @ExcelProperty("继电器型号")
    private String rpsRelayModel;
    /**
     * 过流保护定值（A）
     */
    @ExcelProperty("过流保护定值（A）")
    private String rpsOvercurrentSetting;
    /**
     * 过流保护延时（s）
     */
    @ExcelProperty("过流保护延时（s）")
    private String rpsOvercurrentDelay;
    /**
     * 速断保护定值（A）
     */
    @ExcelProperty("速断保护定值（A）")
    private String rpsInstantaneousSetting;
    /**
     * 接地故障定值（A）
     */
    @ExcelProperty("接地故障定值（A）")
    private String rpsEarthFaultSetting;
    /**
     * 过载保护定值（%）
     */
    @ExcelProperty("过载保护定值（%）")
    private String rpsOverloadSetting;
    /**
     * 定值整定日期
     */
    @ExcelProperty("定值整定日期")
    private LocalDate rpsSettingDate;
    /**
     * 整定人员
     */
    @ExcelProperty("整定人员")
    private String rpsSettingPerson;
    /**
     * 上次校验日期
     */
    @ExcelProperty("上次校验日期")
    private LocalDate rpsLastCheckDate;
    /**
     * 下次校验日期
     */
    @ExcelProperty("下次校验日期")
    private LocalDate rpsNextCheckDate;
    /**
     * 定值变更记录
     */
    @ExcelProperty("定值变更记录")
    private String rpsChangeRecord;
    /**
     * 安装位置
     */
    @ExcelProperty("安装位置")
    private String rpsInstallPosition;
    /**
     * 所属工厂
     */
    @ExcelProperty("所属工厂")
    private String rpsFactory;

}
