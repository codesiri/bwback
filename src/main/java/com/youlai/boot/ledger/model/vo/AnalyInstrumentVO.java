package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 分析仪视图对象
 *
 * @author dazao
 * @since 2026-01-23 14:48
 */
@Getter
@Setter
@Schema( description = "分析仪视图对象")
public class AnalyInstrumentVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "设备位号")
    private String analyInstrumentCode;
    @Schema(description = "用途(原设备用途)")
    private String analyInstrumentPurpose;
    @Schema(description = "所属部门")
    private String analyInstrumentDept;
    @Schema(description = "设备类型")
    private String analyInstrumentType;
    @Schema(description = "设备大类")
    private String analyInstrumentBig;
    @Schema(description = "设备状态")
    private Integer analyInstrumentStatus;
    @Schema(description = "装置")
    private String analyInstrumentPlant;
    @Schema(description = "单元")
    private String analyInstrumentUnit;
    @Schema(description = "是否参与检测")
    private Integer analyInstrumentMonitor;
    @Schema(description = "是否参与联锁")
    private String analyInstrumentLock;
    @Schema(description = "联锁值")
    private String analyInstrumentLinkVal;
    @Schema(description = "报警值")
    private String analyInstrumentAlarmVal;
    @Schema(description = "设备名称")
    private String analyInstrumentName;
    @Schema(description = "工艺介质")
    private String analyInstrumentProcess;
    @Schema(description = "操作温度")
    private String analyInstrumentOpTemp;
    @Schema(description = "操作压力")
    private String analyInstrumentOpPress;
    @Schema(description = "测量范围")
    private String analyInstrumentRange;
    @Schema(description = "单位")
    private String analyInstrumentMeasUnit;
    @Schema(description = "台件数")
    private String analyInstrumentSet;
    @Schema(description = "回路数")
    private String analyInstrumentCircuit;
    @Schema(description = "供应商")
    private String analyInstrumentSupplier;
    @Schema(description = "生产日期")
    private LocalDateTime analyInstrumentProdDate;
    @Schema(description = "投用日期")
    private LocalDateTime analyInstrumentUseDate;
    @Schema(description = "质保日期")
    private LocalDateTime analyInstrumentGuaranteeDate;
    @Schema(description = "是否质保期内(0/1)")
    private Integer analyInstrumentMaintainFlag;
    @Schema(description = "润滑周期")
    private String analyInstrumentLubePeriod;
    @Schema(description = "润滑日期")
    private LocalDateTime analyInstrumentLubeDate;
    @Schema(description = "供电电压")
    private String analyInstrumentVoltage;
    @Schema(description = "防爆等级")
    private String analyInstrumentExplosion;
    @Schema(description = "防护等级")
    private String analyInstrumentProtection;
    @Schema(description = "生产厂家")
    private String analyInstrumentManufacturer;
    @Schema(description = "规格型号")
    private String analyInstrumentSpec;
    @Schema(description = "定修时间")
    private LocalDateTime analyInstrumentCalibDate;
}
