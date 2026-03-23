package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GroundSystemEquipmentExportDto {
    /**
     * 接地编号
     */
    @ExcelProperty("接地编号")
    private String gseGroundCode;
    /**
     * 接地类型
     */
    @ExcelProperty("接地类型")
    private String gseGroundType;
    /**
     * 接地结构
     */
    @ExcelProperty("接地结构")
    private String gseGroundStruct;
    /**
     * 材质
     */
    @ExcelProperty("材质")
    private String gseMaterial;
    /**
     * 安装位置
     */
    @ExcelProperty("安装位置")
    private String gseInstallArea;
    /**
     * 安装区域及危险等级
     */
    @ExcelProperty("安装区域及危险等级")
    private String gseInstallPosition;
    /**
     * 设计接地电阻值（Ω）
     */
    @ExcelProperty("设计接地电阻值")
    private String gseDesignResistance;
    /**
     * 上次接地电阻测试日期
     */
    @ExcelProperty("上次接地电阻测试日期")
    private LocalDate gseLastTestDate;
    /**
     * 上次测试电阻值（Ω）
     */
    @ExcelProperty("上次测试电阻值（Ω）")
    private String gseLastTestData;
    /**
     * 下次测试日期
     */
    @ExcelProperty("下次测试日期")
    private LocalDate gseNextTestDate;
    /**
     * 测试人员
     */
    @ExcelProperty("测试人员")
    private String gseTestPerson;
    /**
     * 安装日期
     */
    @ExcelProperty("安装日期")
    private LocalDate gseInstallDate;
    /**
     * 接地状态
     */
    @ExcelProperty("接地状态")
    private String gseStatus;
    /**
     * 所属工厂
     */
    @ExcelProperty("所属工厂")
    private String gseFactory;
}
