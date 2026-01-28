package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class AnalyInstrumentExportDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备位号
     */
    @ExcelProperty(value = "设备位号")
    private String analyInstrumentCode;
    /**
     * 用途(原设备用途)
     */
    @ExcelProperty(value = "用途(原设备用途)")
    private String analyInstrumentPurpose;
    /**
     * 所属部门
     */
    @ExcelProperty(value = "所属部门")
    private String analyInstrumentDept;
    /**
     * 设备类型
     */
    @ExcelProperty(value = "设备类型")
    private String analyInstrumentType;
    /**
     * 设备大类
     */
    @ExcelProperty(value = "设备大类")
    private String analyInstrumentBig;
    /**
     * 设备状态
     */
    @ExcelProperty(value = "设备状态")
    private Integer analyInstrumentStatus;
    /**
     * 装置
     */
    @ExcelProperty(value = "装置")
    private String analyInstrumentPlant;
    /**
     * 单元
     */
    @ExcelProperty(value = "单元")
    private String analyInstrumentUnit;
    /**
     * 是否参与检测
     */
    @ExcelProperty(value = "是否参与检测")
    private Integer analyInstrumentMonitor;
    /**
     * 是否参与联锁
     */
    @ExcelProperty(value = "是否参与联锁")
    private String analyInstrumentLock;
    /**
     * 联锁值
     */
    @ExcelProperty(value = "联锁值")
    private String analyInstrumentLinkVal;
    /**
     * 报警值
     */
    @ExcelProperty(value = "报警值")
    private String analyInstrumentAlarmVal;
    /**
     * 设备名称
     */
    @ExcelProperty(value = "设备名称")
    private String analyInstrumentName;
    /**
     * 工艺介质
     */
    @ExcelProperty(value = "工艺介质")
    private String analyInstrumentProcess;
    /**
     * 操作温度
     */
    @ExcelProperty(value = "操作温度")
    private String analyInstrumentOpTemp;
    /**
     * 操作压力
     */
    @ExcelProperty(value = "操作压力")
    private String analyInstrumentOpPress;
    /**
     * 测量范围
     */
    @ExcelProperty(value = "测量范围")
    private String analyInstrumentRange;
    /**
     * 单位
     */
    @ExcelProperty(value = "单位")
    private String analyInstrumentMeasUnit;
    /**
     * 台件数
     */
    @ExcelProperty(value = "台件数")
    private String analyInstrumentSet;
    /**
     * 回路数
     */
    @ExcelProperty(value = "回路数")
    private String analyInstrumentCircuit;
    /**
     * 供应商
     */
    @ExcelProperty(value = "供应商")
    private String analyInstrumentSupplier;
    /**
     * 生产日期
     */
    @ExcelProperty(value = "生产日期")
    private LocalDateTime analyInstrumentProdDate;
    /**
     * 投用日期
     */
    @ExcelProperty(value = "投用日期")
    private LocalDateTime analyInstrumentUseDate;
    /**
     * 质保日期
     */
    @ExcelProperty(value = "质保日期")
    private LocalDateTime analyInstrumentGuaranteeDate;
    /**
     * 是否质保期内(0/1)
     */
    @ExcelProperty(value = "是否质保期内(0/1)")
    private Integer analyInstrumentMaintainFlag;
    /**
     * 润滑周期
     */
    @ExcelProperty(value = "润滑周期")
    private String analyInstrumentLubePeriod;
    /**
     * 润滑日期
     */
    @ExcelProperty(value = "润滑日期")
    private LocalDateTime analyInstrumentLubeDate;
    /**
     * 供电电压
     */
    @ExcelProperty(value = "供电电压")
    private String analyInstrumentVoltage;
    /**
     * 防爆等级
     */
    @ExcelProperty(value = "防爆等级")
    private String analyInstrumentExplosion;
    /**
     * 防护等级
     */
    @ExcelProperty(value = "防护等级")
    private String analyInstrumentProtection;
    /**
     * 生产厂家
     */
    @ExcelProperty(value = "生产厂家")
    private String analyInstrumentManufacturer;
    /**
     * 规格型号
     */
    @ExcelProperty(value = "规格型号")
    private String analyInstrumentSpec;
    /**
     * 定修时间
     */
    @ExcelProperty(value = "定修时间")
    private LocalDateTime analyInstrumentCalibDate;
}
