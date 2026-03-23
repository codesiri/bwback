package com.youlai.boot.ledger.model.dto;


import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CableLineEquipmentExportDto {
    /**
     * 电缆编号
     */
    @ExcelProperty("电缆编号")
    private String cleCableCode;
    /**
     * 电缆名称
     */
    @ExcelProperty("电缆名称")
    private String cleCableName;
    /**
     * 规格型号
     */
    @ExcelProperty("规格型号")
    private String cleSpecModel;
    /**
     * 绝缘等级
     */
    @ExcelProperty("绝缘等级")
    private String cleInsulationLevel;
    /**
     * 电缆长度（m）
     */
    @ExcelProperty("电缆长度（m）")
    private String cleCableLength;
    /**
     * 敷设方式
     */
    @ExcelProperty("敷设方式")
    private String cleLayingMethod;
    /**
     * 敷设路径
     */
    @ExcelProperty("敷设路径")
    private String cleLayingPath;
    /**
     * 安装区域及危险等级
     */
    @ExcelProperty("安装区域及危险等级")
    private String cleInstallArea;
    /**
     * 电缆芯数
     */
    @ExcelProperty("电缆芯数")
    private String cleCoreNumber;
    /**
     * 芯线截面（mm²）
     */
    @ExcelProperty("芯线截面（mm²）")
    private String cleCoreSection;
    /**
     * 生产厂家
     */
    @ExcelProperty("生产厂家")
    private String cleManufacturer;
    /**
     * 生产日期
     */
    @ExcelProperty("生产日期")
    private LocalDate cleProductionDate;
    /**
     * 敷设安装日期
     */
    @ExcelProperty("敷设安装日期")
    private LocalDate cleInstallDate;
    /**
     * 上次耐压 / 绝缘测试日期
     */
    @ExcelProperty("上次耐压 / 绝缘测试日期")
    private LocalDate cleLastTestDate;
    /**
     * 上次测试数据（MΩ/kV）
     */
    @ExcelProperty("上次测试数据（MΩ/kV）")
    private String cleLastTestData;
    /**
     * 中间接头数量
     */
    @ExcelProperty("中间接头数量")
    private String cleJointCount;
    /**
     * 电缆状态（在用 / 备用 / 停用）
     */
    @ExcelProperty("电缆状态（在用 / 备用 / 停用）")
    private String cleStatus;
    /**
     * 所属工厂
     */
    @ExcelProperty("所属工厂")
    private String cleFactory;
}
