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
 * 开关阀表单对象
 *
 * @author dazao
 * @since 2026-01-27 08:43
 */
@Getter
@Setter
@Schema(description = "开关阀表单对象")
public class SwitchValveForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "装置名称")
    @NotBlank(message = "装置名称不能为空")
    @Size(max=255, message="装置名称长度不能超过255个字符")
    private String switchValveDevice;

    @Schema(description = "位号")
    @NotBlank(message = "位号不能为空")
    @Size(max=255, message="位号长度不能超过255个字符")
    private String switchValveTag;

    @Schema(description = "设备状态")
    @Size(max=255, message="设备状态长度不能超过255个字符")
    private String status;

    @Schema(description = "名称")
    @NotBlank(message = "名称不能为空")
    @Size(max=255, message="名称长度不能超过255个字符")
    private String switchValveName;

    @Schema(description = "型号规格")
    @NotBlank(message = "型号规格不能为空")
    @Size(max=255, message="型号规格长度不能超过255个字符")
    private String switchValveModel;

    @Schema(description = "生产厂家")
    @NotBlank(message = "生产厂家不能为空")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String switchValveManu;

    @Schema(description = "安装位置及用途")
    @NotBlank(message = "安装位置及用途不能为空")
    @Size(max=255, message="安装位置及用途长度不能超过255个字符")
    private String switchValveLocation;

    @Schema(description = "介质名称")
    @NotBlank(message = "介质名称不能为空")
    @Size(max=255, message="介质名称长度不能超过255个字符")
    private String switchValveMedName;

    @Schema(description = "工艺条件 - 设计温度")
    @Size(max=255, message="工艺条件 - 设计温度长度不能超过255个字符")
    private String switchValveMedTemp;

    @Schema(description = "工艺条件 - 阀前压力（MPa）")
    @Size(max=255, message="工艺条件 - 阀前压力（MPa）长度不能超过255个字符")
    private String switchValveMedPress;

    @Schema(description = "工艺条件 - 阀后压力（MPa）")
    @Size(max=255, message="工艺条件 - 阀后压力（MPa）长度不能超过255个字符")
    private String switchValvePressAfter;

    @Schema(description = "工艺条件 - 公称通径及材质")
    @Size(max=255, message="工艺条件 - 公称通径及材质长度不能超过255个字符")
    private String switchValveMaterial;

    @Schema(description = "阀体 - 阀体材质")
    @Size(max=255, message="阀体 - 阀体材质长度不能超过255个字符")
    private String switchValveBodyMaterial;

    @Schema(description = "阀座 - 序号")
    @Size(max=255, message="阀座 - 序号长度不能超过255个字符")
    private String switchValveSeatSn;

    @Schema(description = "阀座 - 材质")
    @Size(max=255, message="阀座 - 材质长度不能超过255个字符")
    private String switchValveSeatMaterial;

    @Schema(description = "阀芯 - 材质")
    @Size(max=255, message="阀芯 - 材质长度不能超过255个字符")
    private String switchValveCoreMaterial;

    @Schema(description = "阀杆 - 材质")
    @Size(max=255, message="阀杆 - 材质长度不能超过255个字符")
    private String switchValveStemMaterial;

    @Schema(description = "阀内件 - 流量特性")
    @Size(max=255, message="阀内件 - 流量特性长度不能超过255个字符")
    private String switchValveFlowChar;

    @Schema(description = "阀内件 - 泄漏等级")
    @Size(max=255, message="阀内件 - 泄漏等级长度不能超过255个字符")
    private String switchValveLeakClass;

    @Schema(description = "执行机构 - 类型")
    @Size(max=255, message="执行机构 - 类型长度不能超过255个字符")
    private String switchValveActuatorType;

    @Schema(description = "执行机构 - 形式规格")
    @Size(max=255, message="执行机构 - 形式规格长度不能超过255个字符")
    private String switchValveActuatorModel;

    @Schema(description = "执行机构 - 厂家")
    @NotBlank(message = "执行机构 - 厂家不能为空")
    @Size(max=255, message="执行机构 - 厂家长度不能超过255个字符")
    private String switchValveActuatorManu;

    @Schema(description = "执行机构 - 作用形式")
    @Size(max=255, message="执行机构 - 作用形式长度不能超过255个字符")
    private String switchValveActuatorAction;

    @Schema(description = "执行机构 - 行程")
    @Size(max=255, message="执行机构 - 行程长度不能超过255个字符")
    private String switchValveActuatorStroke;

    @Schema(description = "执行机构 - 弹簧范围")
    @Size(max=255, message="执行机构 - 弹簧范围长度不能超过255个字符")
    private String switchValveSpringRange;

    @Schema(description = "执行机构 - 气源压力")
    @Size(max=255, message="执行机构 - 气源压力长度不能超过255个字符")
    private String switchValveAirPress;

    @Schema(description = "执行机构 - 故障位置")
    @Size(max=255, message="执行机构 - 故障位置长度不能超过255个字符")
    private String switchValveFaultPos;

    @Schema(description = "执行机构 - 关闭时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime switchValveCloseTime;

    @Schema(description = "执行机构 - 开启时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime switchValveOpenTime;

    @Schema(description = "备注")
    @Size(max=255, message="备注长度不能超过255个字符")
    private String switchValveRemark;

    @Schema(description = "s设备类型")
    @Size(max=255, message="s设备类型长度不能超过255个字符")
    private String dvType;

    @Schema(description = "所属工厂")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String factory;


}
