package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 温度表单对象
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
@Getter
@Setter
@Schema(description = "温度表单对象")
public class DvTemperatureGaugeForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键id")
    private Long id;

    @Schema(description = "装置名称")
    @NotBlank(message = "装置名称不能为空")
    @Size(max=255, message="装置名称长度不能超过255个字符")
    private String deviceName;

    @Schema(description = "位号")
    @NotBlank(message = "位号不能为空")
    @Size(max=255, message="位号长度不能超过255个字符")
    private String tagNumber;

    @Schema(description = "安装位置以及用途")
    @Size(max=65535, message="安装位置以及用途长度不能超过65535个字符")
    private String installationLocationAndPurpose;

    @Schema(description = "设备名称")
    @NotBlank(message = "设备名称不能为空")
    @Size(max=255, message="设备名称长度不能超过255个字符")
    private String deviceNameSuffix;

    @Schema(description = "分度号")
    @Size(max=255, message="分度号长度不能超过255个字符")
    private String indexNumber;

    @Schema(description = "规格型号")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String specificationModel;

    @Schema(description = "生产厂家")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String manufacturer;

    @Schema(description = "测量范围")
    @Size(max=255, message="测量范围长度不能超过255个字符")
    private String measurementRange;

    @Schema(description = "插入深度")
    @Size(max=255, message="插入深度长度不能超过255个字符")
    private String insertionDepth;

    @Schema(description = "连接方式及规格")
    @Size(max=255, message="连接方式及规格长度不能超过255个字符")
    private String connectionMethodAndSpecifications;

    @Schema(description = "精度")
    @Size(max=255, message="精度长度不能超过255个字符")
    private String precision;

    @Schema(description = "套管规格和及材质")
    @Size(max=255, message="套管规格和及材质长度不能超过255个字符")
    private String casingSpecificationsAndMaterial;

    @Schema(description = "是否带连锁")
    private int interlocked;

    @Schema(description = "联锁设定值")
    @Size(max=255, message="联锁设定值长度不能超过255个字符")
    private String interlockSetValue;

    @Schema(description = "备注")
    @Size(max=255, message="备注长度不能超过255个字符")
    private String remark;

    private int dvType;
    private int status;

    private String factory;
}
