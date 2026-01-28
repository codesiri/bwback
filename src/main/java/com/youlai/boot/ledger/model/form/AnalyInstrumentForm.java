package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * 分析仪表单对象
 *
 * @author dazao
 * @since 2026-01-23 14:48
 */
@Getter
@Setter
@Schema(description = "分析仪表单对象")
public class AnalyInstrumentForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "设备位号")
    @NotBlank(message = "设备位号不能为空")
    @Size(max=255, message="设备位号长度不能超过255个字符")
    private String analyInstrumentCode;

    @Schema(description = "用途(原设备用途)")
    @NotBlank(message = "用途(原设备用途)不能为空")
    @Size(max=255, message="用途(原设备用途)长度不能超过255个字符")
    private String analyInstrumentPurpose;

    @Schema(description = "所属部门")
    @NotBlank(message = "所属部门不能为空")
    @Size(max=255, message="所属部门长度不能超过255个字符")
    private String analyInstrumentDept;

    @Schema(description = "设备类型")
    @NotBlank(message = "设备类型不能为空")
    @Size(max=255, message="设备类型长度不能超过255个字符")
    private String analyInstrumentType;

    @Schema(description = "设备大类")
    @Size(max=255, message="设备大类长度不能超过255个字符")
    private String analyInstrumentBig;

    @Schema(description = "设备状态")
    @NotNull(message = "设备状态不能为空")
    private Integer analyInstrumentStatus;

    @Schema(description = "装置")
    @Size(max=255, message="装置长度不能超过255个字符")
    private String analyInstrumentPlant;

    @Schema(description = "单元")
    @Size(max=255, message="单元长度不能超过255个字符")
    private String analyInstrumentUnit;

    @Schema(description = "是否参与检测")
    @NotNull(message = "是否参与检测不能为空")
    private Integer analyInstrumentMonitor;

    @Schema(description = "是否参与联锁")
    @NotBlank(message = "是否参与联锁不能为空")
    @Size(max=255, message="是否参与联锁长度不能超过255个字符")
    private String analyInstrumentLock;

    @Schema(description = "联锁值")
    @Size(max=255, message="联锁值长度不能超过255个字符")
    private String analyInstrumentLinkVal;

    @Schema(description = "报警值")
    @Size(max=255, message="报警值长度不能超过255个字符")
    private String analyInstrumentAlarmVal;

    @Schema(description = "设备名称")
    @Size(max=255, message="设备名称长度不能超过255个字符")
    private String analyInstrumentName;

    @Schema(description = "工艺介质")
    @NotBlank(message = "工艺介质不能为空")
    @Size(max=255, message="工艺介质长度不能超过255个字符")
    private String analyInstrumentProcess;

    @Schema(description = "操作温度")
    @Size(max=255, message="操作温度长度不能超过255个字符")
    private String analyInstrumentOpTemp;

    @Schema(description = "操作压力")
    @Size(max=255, message="操作压力长度不能超过255个字符")
    private String analyInstrumentOpPress;

    @Schema(description = "测量范围")
    @Size(max=255, message="测量范围长度不能超过255个字符")
    private String analyInstrumentRange;

    @Schema(description = "单位")
    @Size(max=255, message="单位长度不能超过255个字符")
    private String analyInstrumentMeasUnit;

    @Schema(description = "台件数")
    @Size(max=255, message="台件数长度不能超过255个字符")
    private String analyInstrumentSet;

    @Schema(description = "回路数")
    @Size(max=255, message="回路数长度不能超过255个字符")
    private String analyInstrumentCircuit;

    @Schema(description = "供应商")
    @Size(max=255, message="供应商长度不能超过255个字符")
    private String analyInstrumentSupplier;

    @Schema(description = "生产日期")
    @NotNull(message = "生产日期不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime analyInstrumentProdDate;

    @Schema(description = "投用日期")
    @NotNull(message = "投用日期不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime analyInstrumentUseDate;

    @Schema(description = "质保日期")
    @NotNull(message = "质保日期不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime analyInstrumentGuaranteeDate;

    @Schema(description = "是否质保期内(0/1)")
    @NotNull(message = "是否质保期内(0/1)不能为空")
    private Integer analyInstrumentMaintainFlag;

    @Schema(description = "润滑周期")
    @Size(max=255, message="润滑周期长度不能超过255个字符")
    private String analyInstrumentLubePeriod;

    @Schema(description = "润滑日期")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime analyInstrumentLubeDate;

    @Schema(description = "供电电压")
    @Size(max=255, message="供电电压长度不能超过255个字符")
    private String analyInstrumentVoltage;

    @Schema(description = "防爆等级")
    @Size(max=255, message="防爆等级长度不能超过255个字符")
    private String analyInstrumentExplosion;

    @Schema(description = "防护等级")
    @Size(max=255, message="防护等级长度不能超过255个字符")
    private String analyInstrumentProtection;

    @Schema(description = "生产厂家")
    @NotBlank(message = "生产厂家不能为空")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String analyInstrumentManufacturer;

    @Schema(description = "规格型号")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String analyInstrumentSpec;

    @Schema(description = "定修时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime analyInstrumentCalibDate;


}
