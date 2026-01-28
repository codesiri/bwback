package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "温度试图对象")
public class DvTemperatureGaugesExportDTO {
    @ExcelProperty(value = "设备名称")
    private String deviceName;
    /**
     * 位号
     */
    @ExcelProperty(value = "位号")
    private String tagNumber;
    /**
     * 安装位置以及用途
     */
    @ExcelProperty(value = "安装位置以及用途")
    private String installationLocationAndPurpose;
    /**
     * 设备名称
     */
    @ExcelProperty(value = "装置名称")
    private String deviceNameSuffix;
    /**
     * 分度号
     */
    @ExcelProperty(value = "分度号")
    private String indexNumber;
    /**
     * 规格型号
     */
    @ExcelProperty("规格型号")
    private String specificationModel;
    /**
     * 生产厂家
     */
    @ExcelProperty(value = "生产厂家")
    private String manufacturer;
    /**
     * 测量范围
     */
    @ExcelProperty(value = "测量范围")
    private String measurementRange;
    /**
     * 插入深度
     */
    @ExcelProperty(value = "测量深度")
    private String insertionDepth;
    /**
     * 连接方式及规格
     */
    @ExcelProperty(value = "连接方式及规格")
    private String connectionMethodAndSpecifications;
    /**
     * 精度
     */
    @ExcelProperty(value = "精度")
    private String precision;
    /**
     * 套管规格和及材质
     */
    @ExcelProperty(value = "套管规格和及材质")
    private String casingSpecificationsAndMaterial;
    /**
     * 是否带连锁
     */
    @ExcelProperty(value = "是否带联锁")
    private int interlocked;
    /**
     * 联锁设定值
     */
    @ExcelProperty(value = "联锁设定值")
    private String interlockSetValue;
    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;
    @ExcelProperty(value = "设备类型")
    private String dvType;
    @ExcelProperty(value = "设备状态")
    private int status;
    //所属工厂
    @ExcelProperty(value = "所属工厂")
    private String factory;
}
