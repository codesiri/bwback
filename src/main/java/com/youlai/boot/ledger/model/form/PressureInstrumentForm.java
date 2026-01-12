package com.youlai.boot.ledger.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 温度表单对象
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
@Getter
@Setter
@Schema(description = "温度表单对象")
public class PressureInstrumentForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键id")
    private Long id;

    @Schema(description = "装置名称")
    @NotBlank(message = "装置名称不能为空")
    @Size(max=255, message="装置名称长度不能超过255个字符")
    private String pressureDevice;

    @Schema(description = "位号")
    @NotBlank(message = "位号不能为空")
    @Size(max=255, message="位号长度不能超过255个字符")
    private String pressureTag;

    @Schema(description = "安装位置以及用途")
    @Size(max=65535, message="安装位置以及用途长度不能超过65535个字符")
    private String pressureLocation;

    @Schema(description = "设备名称")
    @NotBlank(message = "设备名称不能为空")
    @Size(max=255, message="设备名称长度不能超过255个字符")
    private String pressureEquip;


    @Schema(description = "规格型号")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String pressureModel;

    @Schema(description = "生产厂家")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String pressureManu;

    @Schema(description = "测量范围")
    @Size(max=255, message="测量范围长度不能超过255个字符")
    private String pressureRange;


    @Schema(description = "连接方式及规格")
    @Size(max=255, message="连接方式及规格长度不能超过255个字符")
    private String pressureConnection;

    @Schema(description = "精度")
    @Size(max=255, message="精度长度不能超过255个字符")
    private String pressureAccuracy;

    @Schema(description = "电源（如 24V DC）")
    @Size(max=255, message="电源（如 24V DC）长度不能超过255个字符")
    private String pressurePower;

    @Schema(description = "输出信号（如 4-20mA）")
    @Size(max=255, message="输出信号（如 4-20mA）长度不能超过255个字符")
    private String pressureOutput;

    @Schema(description = "是否伴热（是 / 否）")
    @Size(max=255, message="输出信号（如 4-20mA）长度不能超过255个字符")
    private String pressureHeat;

    @Schema(description = "是否带连锁")
    @Size(max=255, message="是否带连锁不能超过255个字符")
    private String pressureInterlock;

    @Schema(description = "联锁设定值")
    @Size(max=255, message="联锁设定值长度不能超过255个字符")
    private String pressureInterlockVal;

    @Schema(description = "备注")
    @Size(max=255, message="备注长度不能超过255个字符")
    private String pressureRemark;
}

