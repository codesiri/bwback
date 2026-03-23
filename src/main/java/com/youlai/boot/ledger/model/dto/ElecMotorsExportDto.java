package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema( description = "视图对象")
public class ElecMotorsExportDto {

    /**
     * 位号
     */
    @ExcelProperty("位号")
    private String elecMotorTag;
    /**
     * 工艺名称
     */
    @ExcelProperty("工艺名称")
    private String elecMotorProcess;
    /**
     * 型号
     */
    @ExcelProperty("型号")
    private String elecMotorModel;
    /**
     * 额定功率
     */
    @ExcelProperty("额定功率")
    private String elecMotorRatedPower;
    /**
     * 额定电压
     */
    @ExcelProperty("额定电压")
    private String elecMotorRatedVoltage;
    /**
     * 额定电流
     */
    @ExcelProperty("额定电流")
    private String elecMotorRatedCurrent;
    /**
     * 额定频率
     */
    @ExcelProperty("额定频率")
    private String elecMotorRatedFreq;
    /**
     * 转速
     */
    @ExcelProperty("转速")
    private String elecMotorSpeed;
    /**
     * 功率因数
     */
    @ExcelProperty("功率因数")
    private String elecMotorPowerFactor;
    /**
     * 工作效率
     */
    @ExcelProperty("工作效率")
    private String elecMotorEfficiency;
    /**
     * 接线方式
     */
    @ExcelProperty("接线方式")
    private String elecMotorWiringMode;
    /**
     * 轴承型号
     */
    @ExcelProperty("轴承型号")
    private String elecMotorBearingModel;
    /**
     * 防爆标志
     */
    @ExcelProperty("防爆标志")
    private String elecMotorExplosionMark;
    /**
     * 绝缘等级
     */
    @ExcelProperty("绝缘等级")
    private String elecMotorInsulation;
    /**
     * 防护等级
     */
    @ExcelProperty("防护等级")
    private String elecMotorProtection;
    /**
     * 工作制
     */
    @ExcelProperty("工作制")
    private String elecMotorWorkSystem;
    /**
     * 出厂编号
     */
    @ExcelProperty("出厂编号")
    private String elecMotorFactoryNo;
    /**
     * 重量（KG）
     */
    @ExcelProperty("重量（KG）")
    private String elecMotorWeight;
    /**
     * 生产日期
     */
    @ExcelProperty("生产日期")
    private LocalDateTime elecMotorProdDate;
    /**
     * 生产厂家
     */
    @ExcelProperty("生产厂家")
    private String elecMotorManufacturer;
}
