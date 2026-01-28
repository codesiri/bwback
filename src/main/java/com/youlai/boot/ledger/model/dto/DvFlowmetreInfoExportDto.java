package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "流量计试图对象")
public class DvFlowmetreInfoExportDto {
    /**
     * 仪表位号
     */
    @ExcelProperty("位号")
    private String tagNumber;
    /**
     * 装置
     */
    @ExcelProperty("装置")
    private String device;
    /**
     * 用途
     */
    @ExcelProperty("用途")
    private String purpose;
    /**
     * 仪表名称
     */
    @ExcelProperty("仪表名称")
    private String instrumentName;
    /**
     * 量程
     */
    @ExcelProperty("量程")
    private String measurementRange;
    /**
     * 厂家
     */
    @ExcelProperty("厂家")
    private String manufacturer;
    /**
     * 工艺介质-介质
     */
    @ExcelProperty("工艺介质-介质")
    private String medium;
    /**
     * 工艺介质-状态
     */
    @ExcelProperty("工艺介质-状态")
    private Integer mediumStatus;
    /**
     * 工艺介质-压力
     */
    @ExcelProperty("工艺介质-压力")
    private String mediumPressure;
    /**
     * 工艺介质-温度
     */
    @ExcelProperty("工艺介质-温度")
    private String mediumTemperature;
    /**
     * 出厂编号
     */
    @ExcelProperty("出厂编号")
    private String factoryNumber;
    /**
     * 备注
     */
    @ExcelProperty("备注")
    private String remark;
    /**
     * 设备状态
     */
    @ExcelProperty("设备状态")
    private Integer status;
    /**
     * 设备类型
     */
    @ExcelProperty("设备类型")
    private String dvType;
}
