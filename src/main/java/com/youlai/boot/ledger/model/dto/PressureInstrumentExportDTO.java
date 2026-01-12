package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 压力导出视图对象
 *
 * @author wy
 * @since 2025-12-29 11:00
 */
@Getter
@Setter
@Schema( description = "压力视图对象")
public class PressureInstrumentExportDTO  {

    @ExcelProperty(value = "主键id")
    private Long id;
    @ExcelProperty(value = "装置名称")
    private String pressureDevice;
    @ExcelProperty(value = "位号")
    private String pressureTag;
    @ExcelProperty(value = "安装位置以及用途")
    private String pressureLocation;
    @ExcelProperty(value = "设备名称")
    private String pressureEquip;
    @ExcelProperty(value = "规格型号")
    private String pressureModel;
    @ExcelProperty(value = "生产厂家")
    private String pressureManu;
    @ExcelProperty(value = "测量范围")
    private String pressureRange;
    @ExcelProperty(value = "连接方式及规格")
    private String pressureConnection;
    @ExcelProperty(value = "精度")
    private String pressureAccuracy;
    @ExcelProperty(value = "电源（如 24V DC）")
    private String pressurePower;
    @ExcelProperty(value = "输出信号（如 4-20mA）")
    private String pressureOutput;
    @ExcelProperty(value = "是否伴热（是 / 否）")
    private String pressureHeat;
    @ExcelProperty(value = "是否带连锁")
    private String pressureInterlock;
    @ExcelProperty(value = "联锁设定值")
    private String pressureInterlockVal;
    @ExcelProperty(value = "备注")
    private String pressureRemark;



}

