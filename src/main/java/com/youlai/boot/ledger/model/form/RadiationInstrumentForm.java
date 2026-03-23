package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 放射仪表单对象
 *
 * @author baiwei
 * @since 2026-01-28 09:50
 */
@Getter
@Setter
@Schema(description = "放射仪表单对象")
public class RadiationInstrumentForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "装置名称")
    @NotBlank(message = "装置名称不能为空")
    @Size(max=255, message="装置名称长度不能超过255个字符")
    private String unitName;

    @Schema(description = "位号")
    @NotBlank(message = "位号不能为空")
    @Size(max=255, message="位号长度不能超过255个字符")
    private String tagNumber;

    @Schema(description = "仪表名称")
    @NotBlank(message = "仪表名称不能为空")
    @Size(max=255, message="仪表名称长度不能超过255个字符")
    private String instrumentName;

    @Schema(description = "射源位号")
    @NotBlank(message = "射源位号不能为空")
    @Size(max=255, message="射源位号长度不能超过255个字符")
    private String sourceTagNumber;

    @Schema(description = "射源形式")
    @Size(max=255, message="射源形式长度不能超过255个字符")
    private String sourceForm;

    @Schema(description = "材质")
    @NotBlank(message = "材质不能为空")
    @Size(max=255, message="材质长度不能超过255个字符")
    private String material;

    @Schema(description = "强度")
    @Size(max=255, message="强度长度不能超过255个字符")
    private String strength;

    @Schema(description = "供电")
    @Size(max=255, message="供电长度不能超过255个字符")
    private String powerSupply;

    @Schema(description = "输出信号")
    @Size(max=255, message="输出信号长度不能超过255个字符")
    private String outputSignal;

    @Schema(description = "测量范围")
    @NotBlank(message = "测量范围不能为空")
    @Size(max=255, message="测量范围长度不能超过255个字符")
    private String measuringRange;

    @Schema(description = "精度")
    @NotBlank(message = "精度不能为空")
    @Size(max=255, message="精度长度不能超过255个字符")
    private String accuracy;

    @Schema(description = "是否联锁（是 / 否）")
    @NotNull(message = "是否联锁（是 / 否）不能为空")
    private Integer whetherInterlocked;

    @Schema(description = "联锁设定值")
    @Size(max=255, message="联锁设定值长度不能超过255个字符")
    private String interlockSetpoint;

    @Schema(description = "安装位置及用途")
    @NotBlank(message = "安装位置及用途不能为空")
    @Size(max=255, message="安装位置及用途长度不能超过255个字符")
    private String installationLocationAndPurpose;

    @Schema(description = "规格型号")
    @NotBlank(message = "规格型号不能为空")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String specificationModel;

    @Schema(description = "生产厂家")
    @NotBlank(message = "生产厂家不能为空")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String manufacturer;

    @Schema(description = "状态")
    @NotNull(message = "状态不能为空")
    private Integer radioactiveStatus;

    @Schema(description = "所属工厂")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String factory;


}

