package com.youlai.boot.ledger.model.dto;


import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExplosionProofElectricEquipmentExportDto {
    /**
     * 设备编号
     */
    @ExcelProperty("设备编号")
    private String equipmentCode;
    /**
     * 设备名称
     */
    @ExcelProperty("设备名称")
    private String equipmentName;
    /**
     * 规格型号
     */
    @ExcelProperty("规格型号")
    private String specModel;
    /**
     * 防爆标志（如 Ex d IIB T4 Gb）
     */
    @ExcelProperty("防爆标志（如 Ex d IIB T4 Gb）")
    private String exMark;
    /**
     * 防爆合格证号
     */
    @ExcelProperty("防爆合格证号")
    private String exCertNo;
    /**
     * 防爆合格证有效期
     */
    @ExcelProperty("防爆合格证有效期")
    private String exCertExpire;
    /**
     * 温度组别
     */
    @ExcelProperty("温度组别")
    private String tempClass;
    /**
     * 适用爆炸性介质
     */
    @ExcelProperty("适用爆炸性介质")
    private String applicableMedium;
    /**
     * 安装位置及危险区域等级
     */
    @ExcelProperty("安装位置及危险区域等级")
    private String installArea;
    /**
     * 生产厂家
     */
    @ExcelProperty("生产厂家")
    private String manufacturer;
    /**
     * 投运日期
     */
    @ExcelProperty("投运日期")
    private LocalDate commissioningDate;
    /**
     * 接地电阻测试值（Ω）
     */
    @ExcelProperty("接地电阻测试值（Ω）")
    private String groundResistance;
    /**
     * 上次防爆检查日期
     */
    @ExcelProperty("上次防爆检查日期")
    private LocalDate lastExCheckDate;
    /**
     * 下次防爆检查日期
     */
    @ExcelProperty("下次防爆检查日期")
    private LocalDate nextExCheckDate;
    /**
     * 设备状态（在用 / 备用 / 停用 / 报废）
     */
    @ExcelProperty("设备状态（在用 / 备用 / 停用 / 报废）")
    private String status;
    /**
     * 所属工厂
     */
    @ExcelProperty("所属工厂")
    private String factory;
}
