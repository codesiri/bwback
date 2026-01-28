package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import cn.idev.excel.annotation.format.DateTimeFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema( description = "罐区仪视图对象")
public class TnkMeterExportDto {
    /**
     * 仪表位号
     */
    @ExcelProperty("仪表位号")
    private String tnkMeterTag;
    /**
     * 装置
     */
    @ExcelProperty("装置")
    private String tnkMeterDev;
    /**
     * 用途
     */
    @ExcelProperty("用途")
    private String tnkMeterPurp;
    /**
     * 回路分类
     */
    @ExcelProperty("回路分类")
    private String tnkMeterLoop;
    /**
     * 仪表名称
     */
    @ExcelProperty("仪表名称")
    private String tnkMeterName;
    /**
     * 型号
     */
    @ExcelProperty("型号")
    private String tnkMeterModel;
    /**
     * 规格
     */
    @ExcelProperty("规格")
    private String tnkMeterSpec;
    /**
     * 量程
     */
    @ExcelProperty("量程")
    private String tnkMeterRange;
    /**
     * 厂家
     */
    @ExcelProperty("厂家")
    private String tnkMeterManu;
    /**
     * 测量值
     */
    @ExcelProperty("测量值")
    private String tnkMeterMeas;
    /**
     * 工艺介质
     */
    @ExcelProperty("工艺介质")
    private String tnkMeterMedProc;
    /**
     * 介质状态
     */
    @ExcelProperty("介质状态")
    private Integer tnkMeterMedStat;
    /**
     * 压力（Kpa）
     */
    @ExcelProperty("压力（Kpa）")
    private String tnkMeterPress;
    /**
     * 温度（℃）
     */
    @ExcelProperty("温度（℃）")
    private String tnkMeterTemp;
    /**
     * 公称通径
     */
    @ExcelProperty("公称通径")
    private String tnkMeterNomDia;
    /**
     * 故障压力
     */
    @ExcelProperty("故障压力")
    private String tnkMeterFaultPress;
    /**
     * 泄露状态
     */
    @ExcelProperty("泄露状态")
    private Integer tnkMeterLeakStat;
    /**
     * 等级
     */
    @ExcelProperty("等级")
    private String tnkMeterLeakLv;
    /**
     * 检查时间
     */
    @ExcelProperty("检查时间")
    @DateTimeFormat("yyyy/MM/dd HH:mm:ss")
    private LocalDateTime tnkMeterChkTime;
    /**
     * 检查周期
     */
    @ExcelProperty("检查周期")
    private String tnkMeterChkCycle;
    /**
     * 出厂编号
     */
    @ExcelProperty("出厂编号")
    private String tnkMeterFactoryNo;
    /**
     * 备注
     */
    @ExcelProperty("备注")
    private String tnkMeterRemark;
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
