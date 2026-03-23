package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ElectricLightEquipmentDto {
    /**
     * 照明设备编号
     */
    @ExcelProperty("照明设备编号")
    private String eleLightCode;
    /**
     * 设备名称
     */
    @ExcelProperty("设备名称")
    private String eleLightName;
    /**
     * 规格型号
     */
    @ExcelProperty("规格型号")
    private String eleSpecModel;
    /**
     * 防爆标志
     */
    @ExcelProperty("防爆标志")
    private String eleExMark;
    /**
     * 防爆合格证号（仅防爆区域照明设备填写）
     */
    @ExcelProperty("防爆合格证号（仅防爆区域照明设备填写）")
    private Integer eleExCertNo;
    /**
     * 防爆合格证有效期（仅防爆区域照明设备填写）
     */
    @ExcelProperty("防爆合格证有效期（仅防爆区域照明设备填写）")
    private String eleExCertExpire;
    /**
     * 额定功率（W）
     */
    @ExcelProperty("额定功率（W）")
    private String eleRatedPower;
    /**
     * 额定电压（如 AC220V、DC36V、AC380V）
     */
    @ExcelProperty("额定电压（如 AC220V、DC36V、AC380V）")
    private String eleRatedVoltage;
    /**
     * 安装位置及危险区域等级
     */
    @ExcelProperty("安装位置及危险区域等级")
    private String eleInstallArea;
    /**
     * 安装高度（m）
     */
    @ExcelProperty("安装高度（m）")
    private Double eleInstallHeight;
    /**
     * 生产厂家
     */
    @ExcelProperty("生产厂家")
    private String eleManufacturer;
    /**
     * 投运日期
     */
    @ExcelProperty("投运日期")
    private LocalDateTime eleCommissioningDate;
    /**
     * 上次维护日期
     */
    @ExcelProperty("上次维护日期")
    private LocalDateTime eleLastMaintainDate;
    /**
     * 下次维护日期
     */
    @ExcelProperty("下次维护日期")
    private LocalDateTime eleNextMaintainDate;
    /**
     * 是否为应急照明（0 = 否，1 = 是）
     */
    @ExcelProperty("是否为应急照明（0 = 否，1 = 是）")
    private String eleIsEmergency;
    /**
     * 	设备状态
     */
    @ExcelProperty("设备状态")
    private Integer eleStatus;
    /**
     * 所属工厂
     */
    @ExcelProperty("所属工厂")
    private String eleFactory;
}
