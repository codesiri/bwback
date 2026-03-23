package com.youlai.boot.ledger.model.dto;


import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * 放射仪导出视图对象
 *
 * @author baiwei
 * @since 2026-01-14 09:44
 */
@Getter
@Setter
@Schema( description = "视图对象")
public class RadiationInstrumentExportDTO {

    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "装置名称")
    private String unitName;
    @ExcelProperty(value = "位号")
    private String tagNumber;
    @ExcelProperty(value = "仪表名称")
    private String instrumentName;
    @ExcelProperty(value = "射源位号")
    private String sourceTagNumber;
    @ExcelProperty(value = "射源形式")
    private String sourceForm;
    @ExcelProperty(value = "材质")
    private String material;
    @ExcelProperty(value = "强度")
    private String strength;
    @ExcelProperty(value = "供电")
    private String powerSupply;
    @ExcelProperty(value = "输出信号")
    private String outputSignal;
    @ExcelProperty(value = "测量范围")
    private String measuringRange;
    @ExcelProperty(value = "精度")
    private String accuracy;
    @ExcelProperty(value = "是否联锁（是 / 否）")
    private Integer whetherInterlocked;
    @ExcelProperty(value = "联锁设定值")
    private String interlockSetpoint;
    @ExcelProperty(value = "安装位置及用途")
    private String installationLocationAndPurpose;
    @ExcelProperty(value = "规格型号")
    private String specificationModel;
    @ExcelProperty(value = "生产厂家")
    private String manufacturer;
    @ExcelProperty(value = "状态")
    private Integer radioactiveStatus;
    @ExcelProperty(value = "所属工厂")
    private String factory;
}

