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
 * 调节阀表单对象
 *
 * @author cc
 * @since 2026-01-28 11:03
 */
@Getter
@Setter
@Schema(description = "调节阀表单对象")
public class ControlValveForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "装置名称")
    @NotBlank(message = "装置名称不能为空")
    @Size(max=255, message="装置名称长度不能超过255个字符")
    private String dveName;

    @Schema(description = "	位号")
    @NotBlank(message = "	位号不能为空")
    @Size(max=255, message="	位号长度不能超过255个字符")
    private String tagNo;

    @Schema(description = "名称")
    @NotBlank(message = "名称不能为空")
    @Size(max=255, message="名称长度不能超过255个字符")
    private String name;

    @Schema(description = "型号规格")
    @Size(max=255, message="型号规格长度不能超过255个字符")
    private String modelSpecification;

    @Schema(description = "生产厂家")
    @NotBlank(message = "生产厂家不能为空")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String manufacturer;

    @Schema(description = "安装位置及用途")
    @NotBlank(message = "安装位置及用途不能为空")
    @Size(max=255, message="安装位置及用途长度不能超过255个字符")
    private String installationLocationAndPurpose;

    @Schema(description = "介质名称")
    @NotBlank(message = "介质名称不能为空")
    @Size(max=255, message="介质名称长度不能超过255个字符")
    private String mediumName;

    @Schema(description = "设计温度")
    @Size(max=255, message="设计温度长度不能超过255个字符")
    private String designTemperature;

    @Schema(description = "阀前压")
    @Size(max=255, message="阀前压长度不能超过255个字符")
    private String pressureBeforeValve;

    @Schema(description = "阀后压")
    @Size(max=255, message="阀后压长度不能超过255个字符")
    private String pressureAfterValve;

    @Schema(description = "阀座直径")
    @Size(max=255, message="阀座直径长度不能超过255个字符")
    private String valveSeatDiameter;

    @Schema(description = "阀体材质")
    @Size(max=255, message="阀体材质长度不能超过255个字符")
    private String valveBodyMaterial;

    @Schema(description = "阀座序列号")
    private Integer valveSeatSerialNumber;

    @Schema(description = "阀座材质")
    @Size(max=255, message="阀座材质长度不能超过255个字符")
    private String valveSeatMaterial;

    @Schema(description = "阀芯材质")
    @Size(max=255, message="阀芯材质长度不能超过255个字符")
    private String valveCoreMaterial;

    @Schema(description = "阀杆材质")
    @Size(max=255, message="阀杆材质长度不能超过255个字符")
    private String valveStemMaterial;

    @Schema(description = "流量特性")
    @Size(max=255, message="流量特性长度不能超过255个字符")
    private String flowCharacteristics;

    @Schema(description = "泄露等级")
    @NotBlank(message = "泄露等级不能为空")
    @Size(max=255, message="泄露等级长度不能超过255个字符")
    private String leakageClass;

    @Schema(description = "Cv值")
    @Size(max=255, message="Cv值长度不能超过255个字符")
    private String cvValue;

    @Schema(description = "规格")
    @Size(max=255, message="规格长度不能超过255个字符")
    private String actuatorModelSpecification;

    @Schema(description = "作用形式")
    @NotBlank(message = "作用形式不能为空")
    @Size(max=255, message="作用形式长度不能超过255个字符")
    private String actuatorActionForm;

    @Schema(description = "行程")
    @NotBlank(message = "行程不能为空")
    @Size(max=255, message="行程长度不能超过255个字符")
    private String actuatorStroke;

    @Schema(description = "弹簧范围")
    @Size(max=255, message="弹簧范围长度不能超过255个字符")
    private String springRange;

    @Schema(description = "气源压力")
    @Size(max=255, message="气源压力长度不能超过255个字符")
    private String airSourcePressure;

    @Schema(description = "故障位置")
    @Size(max=255, message="故障位置长度不能超过255个字符")
    private String faultPosition;

    @Schema(description = "关阀时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime valveCloseTime;

    @Schema(description = "开阀时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime valveOpenTime;

    @Schema(description = "手轮机构")
    @Size(max=255, message="手轮机构长度不能超过255个字符")
    private String handwheelMechanism;

    @Schema(description = "设备类型")
    @NotBlank(message = "设备类型不能为空")
    @Size(max=255, message="设备类型长度不能超过255个字符")
    private String dvType;

    @Schema(description = "设备状态")
    @NotNull(message = "设备状态不能为空")
    private Integer status;
    @Schema(description = "所属工厂")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String factory;


}

