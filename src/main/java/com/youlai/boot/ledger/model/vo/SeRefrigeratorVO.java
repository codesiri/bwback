package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
/**
 * 特种设备制冷机台账视图对象
 *
 * @author baiwei
 * @since 2026-02-14 08:38
 */
@Getter
@Setter
@Schema( description = "特种设备制冷机台账视图对象")
public class SeRefrigeratorVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "制冷机设备编号")
    private String seRefrigeratorEquipCode;
    @Schema(description = "制冷机设备名称")
    private String seRefrigeratorName;
    @Schema(description = "制冷机类型")
    private String seRefrigeratorType;
    @Schema(description = "规格型号")
    private String seRefrigeratorSpec;
    @Schema(description = "额定制冷量（kW）")
    private String seRefrigeratorCoolingCapacity;
    @Schema(description = "额定输入功率（kW）")
    private String seRefrigeratorRatedPower;
    @Schema(description = "蒸发温度（℃）")
    private String seRefrigeratorEvapTemp;
    @Schema(description = "冷凝温度（℃）")
    private String seRefrigeratorCondTemp;
    @Schema(description = "制冷剂类型")
    private String seRefrigeratorRefrigerant;
    @Schema(description = "冷冻油型号及类型")
    private String seRefrigeratorOilType;
    @Schema(description = "主体材质")
    private String seRefrigeratorMaterial;
    @Schema(description = "防爆等级")
    private String seRefrigeratorExplosionProof;
    @Schema(description = "配套电机型号")
    private String seRefrigeratorMotorModel;
    @Schema(description = "冷却方式")
    private String seRefrigeratorCoolingType;
    @Schema(description = "安装位置")
    private String seRefrigeratorInstallPos;
    @Schema(description = "投用日期")
    private LocalDate seRefrigeratorInService;
    @Schema(description = "定期检验周期")
    private String seRefrigeratorInspectCycle;
    @Schema(description = "上次检验日期")
    private LocalDate seRefrigeratorLastInspect;
    @Schema(description = "下次检验日期")
    private LocalDate seRefrigeratorNextInspect;
    @Schema(description = "检验结果")
    private String seRefrigeratorInspectResult;
    @Schema(description = "上次维保日期")
    private LocalDate seRefrigeratorLastMaintain;
    @Schema(description = "下次维保日期")
    private LocalDate seRefrigeratorNextMaintain;
    @Schema(description = "上次气密性 / 泄漏检测日期")
    private LocalDate seRefrigeratorLeakTest;
    @Schema(description = "制冷系数（COP 值）")
    private String seRefrigeratorCoeff;
    @Schema(description = "维保维修记录")
    private String seRefrigeratorMaintainRecord;
    @Schema(description = "故障及异常记录")
    private String seRefrigeratorFaultRecord;
    @Schema(description = "录入 / 维护人员")
    private String seRefrigeratorOperator;
    @Schema(description = "创建时间")
    private LocalDate seRefrigeratorCreateTime;
    @Schema(description = "最后更新时间")
    private LocalDate seRefrigeratorUpdateTime;
    @Schema(description = "所属工厂")
    private String seRefrigeratorFactory;
    @Schema(description = "设备状态")
    private String seRefrigeratorStatus;
    @Schema(description = "备用1")
    private String seRefrigeratorReserve1;
    @Schema(description = "备用2")
    private String seRefrigeratorReserve2;
    @Schema(description = "备用3")
    private String seRefrigeratorReserve3;
}
