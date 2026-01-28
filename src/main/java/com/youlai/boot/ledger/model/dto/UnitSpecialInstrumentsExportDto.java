package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;

@Getter
public class UnitSpecialInstrumentsExportDto {
    @ExcelProperty(value = "位号")
    private String tagNumber;
    @ExcelProperty(value = "仪表名称")
    private String instrumentName;
    @ExcelProperty(value = "设备名称")
    private String deviceName;
    @ExcelProperty(value = "装置")
    private String device;
    @ExcelProperty(value = "安装位置及用途")
    private String installationLocation;
    @ExcelProperty(value = "规格型号")
    private String specificationModel;
    @ExcelProperty(value = "量程")
    private String measurementRange;
    @ExcelProperty(value = "数量")
    private String quantity;
    @ExcelProperty(value = "厂家")
    private String manufacturer;
    @ExcelProperty(value = "编号")
    private String unitSpecialCode;
    @ExcelProperty(value = "设备状态")
    private Integer status;
    @ExcelProperty(value = "设备类型")
    private String dvType;

}
