package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 开关阀视图对象
 *
 * @author dazao
 * @since 2026-01-27 08:43
 */
@Getter
@Setter
@Schema( description = "开关阀视图对象")
public class SwitchValveVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "装置名称")
    private String switchValveDevice;
    @Schema(description = "位号")
    private String switchValveTag;
    @Schema(description = "设备状态")
    private String status;
    @Schema(description = "名称")
    private String switchValveName;
    @Schema(description = "型号规格")
    private String switchValveModel;
    @Schema(description = "生产厂家")
    private String switchValveManu;
    @Schema(description = "安装位置及用途")
    private String switchValveLocation;
    @Schema(description = "介质名称")
    private String switchValveMedName;
    @Schema(description = "工艺条件 - 设计温度")
    private String switchValveMedTemp;
    @Schema(description = "工艺条件 - 阀前压力（MPa）")
    private String switchValveMedPress;
    @Schema(description = "工艺条件 - 阀后压力（MPa）")
    private String switchValvePressAfter;
    @Schema(description = "工艺条件 - 公称通径及材质")
    private String switchValveMaterial;
    @Schema(description = "阀体 - 阀体材质")
    private String switchValveBodyMaterial;
    @Schema(description = "阀座 - 序号")
    private String switchValveSeatSn;
    @Schema(description = "阀座 - 材质")
    private String switchValveSeatMaterial;
    @Schema(description = "阀芯 - 材质")
    private String switchValveCoreMaterial;
    @Schema(description = "阀杆 - 材质")
    private String switchValveStemMaterial;
    @Schema(description = "阀内件 - 流量特性")
    private String switchValveFlowChar;
    @Schema(description = "阀内件 - 泄漏等级")
    private String switchValveLeakClass;
    @Schema(description = "执行机构 - 类型")
    private String switchValveActuatorType;
    @Schema(description = "执行机构 - 形式规格")
    private String switchValveActuatorModel;
    @Schema(description = "执行机构 - 厂家")
    private String switchValveActuatorManu;
    @Schema(description = "执行机构 - 作用形式")
    private String switchValveActuatorAction;
    @Schema(description = "执行机构 - 行程")
    private String switchValveActuatorStroke;
    @Schema(description = "执行机构 - 弹簧范围")
    private String switchValveSpringRange;
    @Schema(description = "执行机构 - 气源压力")
    private String switchValveAirPress;
    @Schema(description = "执行机构 - 故障位置")
    private String switchValveFaultPos;
    @Schema(description = "执行机构 - 关闭时间")
    private LocalDateTime switchValveCloseTime;
    @Schema(description = "执行机构 - 开启时间")
    private LocalDateTime switchValveOpenTime;
    @Schema(description = "备注")
    private String switchValveRemark;
    @Schema(description = "s设备类型")
    private String dvType;
    @Schema(description = "所属工厂")
    private String factory;
}
