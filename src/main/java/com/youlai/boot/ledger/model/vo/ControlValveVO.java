package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 调节阀视图对象
 *
 * @author cc
 * @since 2026-01-28 11:03
 */
@Getter
@Setter
@Schema( description = "调节阀视图对象")
public class ControlValveVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "装置名称")
    private String dveName;
    @Schema(description = "	位号")
    private String tagNo;
    @Schema(description = "名称")
    private String name;
    @Schema(description = "型号规格")
    private String modelSpecification;
    @Schema(description = "生产厂家")
    private String manufacturer;
    @Schema(description = "安装位置及用途")
    private String installationLocationAndPurpose;
    @Schema(description = "介质名称")
    private String mediumName;
    @Schema(description = "设计温度")
    private String designTemperature;
    @Schema(description = "阀前压")
    private String pressureBeforeValve;
    @Schema(description = "阀后压")
    private String pressureAfterValve;
    @Schema(description = "阀座直径")
    private String valveSeatDiameter;
    @Schema(description = "阀体材质")
    private String valveBodyMaterial;
    @Schema(description = "阀座序列号")
    private Integer valveSeatSerialNumber;
    @Schema(description = "阀座材质")
    private String valveSeatMaterial;
    @Schema(description = "阀芯材质")
    private String valveCoreMaterial;
    @Schema(description = "阀杆材质")
    private String valveStemMaterial;
    @Schema(description = "流量特性")
    private String flowCharacteristics;
    @Schema(description = "泄露等级")
    private String leakageClass;
    @Schema(description = "Cv值")
    private String cvValue;
    @Schema(description = "规格")
    private String actuatorModelSpecification;
    @Schema(description = "作用形式")
    private String actuatorActionForm;
    @Schema(description = "行程")
    private String actuatorStroke;
    @Schema(description = "弹簧范围")
    private String springRange;
    @Schema(description = "气源压力")
    private String airSourcePressure;
    @Schema(description = "故障位置")
    private String faultPosition;
    @Schema(description = "关阀时间")
    private LocalDateTime valveCloseTime;
    @Schema(description = "开阀时间")
    private LocalDateTime valveOpenTime;
    @Schema(description = "手轮机构")
    private String handwheelMechanism;
    @Schema(description = "设备类型")
    private String dvType;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "所属工厂")
    private String factory;
}

