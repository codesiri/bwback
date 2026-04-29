package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
/**
 * 特种设备制冷机台账表单对象
 *
 * @author baiwei
 * @since 2026-02-14 08:38
 */
@Getter
@Setter
@Schema(description = "特种设备制冷机台账表单对象")
public class SeRefrigeratorForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "制冷机设备编号")
    @NotBlank(message = "制冷机设备编号不能为空")
    @Size(max=255, message="制冷机设备编号长度不能超过255个字符")
    private String seRefrigeratorEquipCode;

    @Schema(description = "制冷机设备名称")
    @NotBlank(message = "制冷机设备名称不能为空")
    @Size(max=255, message="制冷机设备名称长度不能超过255个字符")
    private String seRefrigeratorName;

    @Schema(description = "制冷机类型")
    @NotBlank(message = "制冷机类型不能为空")
    @Size(max=255, message="制冷机类型长度不能超过255个字符")
    private String seRefrigeratorType;

    @Schema(description = "规格型号")
    @NotBlank(message = "规格型号不能为空")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String seRefrigeratorSpec;

    @Schema(description = "额定制冷量（kW）")
    @NotBlank(message = "额定制冷量（kW）不能为空")
    @Size(max=255, message="额定制冷量（kW）长度不能超过255个字符")
    private String seRefrigeratorCoolingCapacity;

    @Schema(description = "额定输入功率（kW）")
    @NotBlank(message = "额定输入功率（kW）不能为空")
    @Size(max=255, message="额定输入功率（kW）长度不能超过255个字符")
    private String seRefrigeratorRatedPower;

    @Schema(description = "蒸发温度（℃）")
    @NotBlank(message = "蒸发温度（℃）不能为空")
    @Size(max=255, message="蒸发温度（℃）长度不能超过255个字符")
    private String seRefrigeratorEvapTemp;

    @Schema(description = "冷凝温度（℃）")
    @NotBlank(message = "冷凝温度（℃）不能为空")
    @Size(max=255, message="冷凝温度（℃）长度不能超过255个字符")
    private String seRefrigeratorCondTemp;

    @Schema(description = "制冷剂类型")
    @NotBlank(message = "制冷剂类型不能为空")
    @Size(max=255, message="制冷剂类型长度不能超过255个字符")
    private String seRefrigeratorRefrigerant;

    @Schema(description = "冷冻油型号及类型")
    @NotBlank(message = "冷冻油型号及类型不能为空")
    @Size(max=255, message="冷冻油型号及类型长度不能超过255个字符")
    private String seRefrigeratorOilType;

    @Schema(description = "主体材质")
    @NotBlank(message = "主体材质不能为空")
    @Size(max=255, message="主体材质长度不能超过255个字符")
    private String seRefrigeratorMaterial;

    @Schema(description = "防爆等级")
    @NotBlank(message = "防爆等级不能为空")
    @Size(max=255, message="防爆等级长度不能超过255个字符")
    private String seRefrigeratorExplosionProof;

    @Schema(description = "配套电机型号")
    @NotBlank(message = "配套电机型号不能为空")
    @Size(max=255, message="配套电机型号长度不能超过255个字符")
    private String seRefrigeratorMotorModel;

    @Schema(description = "冷却方式")
    @NotBlank(message = "冷却方式不能为空")
    @Size(max=255, message="冷却方式长度不能超过255个字符")
    private String seRefrigeratorCoolingType;

    @Schema(description = "安装位置")
    @NotBlank(message = "安装位置不能为空")
    @Size(max=255, message="安装位置长度不能超过255个字符")
    private String seRefrigeratorInstallPos;

    @Schema(description = "投用日期")
    @NotNull(message = "投用日期不能为空")
    private LocalDate seRefrigeratorInService;

    @Schema(description = "定期检验周期")
    @NotBlank(message = "定期检验周期不能为空")
    @Size(max=255, message="定期检验周期长度不能超过255个字符")
    private String seRefrigeratorInspectCycle;

    @Schema(description = "上次检验日期")
    @NotNull(message = "上次检验日期不能为空")
    private LocalDate seRefrigeratorLastInspect;

    @Schema(description = "下次检验日期")
    @NotNull(message = "下次检验日期不能为空")
    private LocalDate seRefrigeratorNextInspect;

    @Schema(description = "检验结果")
    @NotBlank(message = "检验结果不能为空")
    @Size(max=255, message="检验结果长度不能超过255个字符")
    private String seRefrigeratorInspectResult;

    @Schema(description = "上次维保日期")
    private LocalDate seRefrigeratorLastMaintain;

    @Schema(description = "下次维保日期")
    private LocalDate seRefrigeratorNextMaintain;

    @Schema(description = "上次气密性 / 泄漏检测日期")
    private LocalDate seRefrigeratorLeakTest;

    @Schema(description = "制冷系数（COP 值）")
    @Size(max=255, message="制冷系数（COP 值）长度不能超过255个字符")
    private String seRefrigeratorCoeff;

    @Schema(description = "维保维修记录")
    @Size(max=255, message="维保维修记录长度不能超过255个字符")
    private String seRefrigeratorMaintainRecord;

    @Schema(description = "故障及异常记录")
    @Size(max=255, message="故障及异常记录长度不能超过255个字符")
    private String seRefrigeratorFaultRecord;

    @Schema(description = "录入 / 维护人员")
    @NotBlank(message = "录入 / 维护人员不能为空")
    @Size(max=255, message="录入 / 维护人员长度不能超过255个字符")
    private String seRefrigeratorOperator;

    @Schema(description = "创建时间")
    @NotNull(message = "创建时间不能为空")
    private LocalDate seRefrigeratorCreateTime;

    @Schema(description = "最后更新时间")
    @NotNull(message = "最后更新时间不能为空")
    private LocalDate seRefrigeratorUpdateTime;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String seRefrigeratorFactory;

    @Schema(description = "设备状态")
    @Size(max=255, message="设备状态长度不能超过255个字符")
    private String seRefrigeratorStatus;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String seRefrigeratorReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String seRefrigeratorReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String seRefrigeratorReserve3;


}
