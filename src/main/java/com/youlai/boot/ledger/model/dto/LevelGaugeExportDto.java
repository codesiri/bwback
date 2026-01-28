package com.youlai.boot.ledger.model.dto;


import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema( description = "压力视图对象")
public class LevelGaugeExportDto {
    /**
     * 装置名称
     */
    @ExcelProperty("装置名称")
    private String levelDevice;
    /**
     * 位号
     */
    @ExcelProperty("位号")
    private String levelTag;
    /**
     * 安装位置及用途
     */
    @ExcelProperty("安装位置及用途")
    private String levelLocation;
    /**
     * 设备名称（液位计）
     */
    @ExcelProperty("设备名称")
    private String levelEquip;
    /**
     * 规格型号
     */
    @ExcelProperty("规格型号")
    private String levelModel;
    /**
     * 生产厂家
     */
    @ExcelProperty("生产厂家")
    private String levelManu;
    /**
     * 介质
     */
    @ExcelProperty("介质")
    private String levelMedium;
    /**
     * 测量范围
     */
    @ExcelProperty("测量范围")
    private String levelRange;
    /**
     * 精度
     */
    @ExcelProperty("精度")
    private String levelAccuracy;
    /**
     * 电源
     */
    @ExcelProperty("电源")
    private String levelPower;
    /**
     * 输出信号
     */
    @ExcelProperty("输出信号")
    private String levelOutput;
    /**
     * 连接方式及规格
     */
    @ExcelProperty("连接方式及规格")
    private String levelConnection;
    /**
     * 是否联锁（是 / 否）
     */
    @ExcelProperty("是否联锁")
    private Integer levelInterlock;
    /**
     * 联锁设定值
     */
    @ExcelProperty("联锁设定值")
    private String levelInterlockVal;
    /**
     * 备注
     */
    @ExcelProperty("备注")
    private String levelRemark;
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
