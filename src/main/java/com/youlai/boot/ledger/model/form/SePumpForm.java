package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

/**
 * 泵表单对象
 *
 * @author baiwei
 * @since 2026-02-05 14:46
 */
@Getter
@Setter
@Schema(description = "泵表单对象")
public class SePumpForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "泵设备编号")
    @NotBlank(message = "泵设备编号(位号)不能为空")
    @Size(max=255, message="泵设备编号长度不能超过255个字符")
    private String sePumpEquipCode;

    @Schema(description = "设备名称")
    @NotBlank(message = "设备名称不能为空")
    @Size(max=255, message="设备名称长度不能超过255个字符")
    private String sePumpName;

    @Schema(description = "泵类型")
    @NotBlank(message = "泵类型不能为空")
    @Size(max=255, message="泵类型长度不能超过255个字符")
    private String sePumpType;

    @Schema(description = "设备状态")
    @Size(max=255, message="设备状态长度不能超过255个字符")
    private String sePumpStatus;

    @Schema(description = "规格型号")
    @NotBlank(message = "规格型号不能为空")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String sePumpSpec;

    @Schema(description = "额定流量")
    @NotBlank(message = "额定流量不能为空")
    @Size(max=255, message="额定流量长度不能超过255个字符")
    private String sePumpFlow;

    @Schema(description = "额定量程")
    @NotBlank(message = "额定量程不能为空")
    @Size(max=255, message="额定量程长度不能超过255个字符")
    private String sePumpHead;

    @Schema(description = "额定功率")
    @NotBlank(message = "额定功率不能为空")
    @Size(max=255, message="额定功率长度不能超过255个字符")
    private String sePumpRatedPower;

    @Schema(description = "额定转速")
    @NotBlank(message = "额定转速不能为空")
    @Size(max=255, message="额定转速长度不能超过255个字符")
    private String sePumpRatedSpeed;

    @Schema(description = "输送介质")
    @NotBlank(message = "输送介质不能为空")
    @Size(max=255, message="输送介质长度不能超过255个字符")
    private String sePumpMedium;

    @Schema(description = "介质温度")
    @NotBlank(message = "介质温度不能为空")
    @Size(max=255, message="介质温度长度不能超过255个字符")
    private String sePumpMediumTemp;

    @Schema(description = "设计压力")
    @NotBlank(message = "设计压力不能为空")
    @Size(max=255, message="设计压力长度不能超过255个字符")
    private String sePumpDesignP;

    @Schema(description = "过流部件材质")
    @NotBlank(message = "过流部件材质不能为空")
    @Size(max=255, message="过流部件材质长度不能超过255个字符")
    private String sePumpMaterial;

    @Schema(description = "密封形式")
    @NotBlank(message = "密封形式不能为空")
    @Size(max=255, message="密封形式长度不能超过255个字符")
    private String sePumpSealType;

    @Schema(description = "防爆等级")
    @NotBlank(message = "防爆等级不能为空")
    @Size(max=255, message="防爆等级长度不能超过255个字符")
    private String sePumpExplosionProof;

    @Schema(description = "配套电机型号")
    @NotBlank(message = "配套电机型号不能为空")
    @Size(max=255, message="配套电机型号长度不能超过255个字符")
    private String sePumpMotorModel;

    @Schema(description = "安装位置")
    @NotBlank(message = "安装位置不能为空")
    @Size(max=255, message="安装位置长度不能超过255个字符")
    private String sePumpInstallPos;

    @Schema(description = "投用日期")
    @NotBlank(message = "投用日期不能为空")
    @Size(max=255, message="投用日期长度不能超过255个字符")
    private String sePumpInService;

    @Schema(description = "定期检验周期")
    @NotBlank(message = "定期检验周期不能为空")
    @Size(max=255, message="定期检验周期长度不能超过255个字符")
    private String sePumpInspectCycle;

    @Schema(description = "上次检验日期")
    @NotNull(message = "上次检验日期不能为空")
    private LocalDate sePumpLastInspect;

    @Schema(description = "下次检验日期")
    @NotNull(message = "下次检验日期不能为空")
    private LocalDate sePumpNextInspect;

    @Schema(description = "检验结果")
    @NotBlank(message = "检验结果不能为空")
    @Size(max=255, message="检验结果长度不能超过255个字符")
    private String sePumpInspectResult;

    @Schema(description = "上次维保日期")
    private LocalDate sePumpLastMaintain;

    @Schema(description = "下次维保日期")
    private LocalDate sePumpNextMaintain;

    @Schema(description = "运行振动值")
    @Size(max=255, message="运行振动值长度不能超过255个字符")
    private String sePumpVibration;

    @Schema(description = "密封泄漏状态")
    @Size(max=255, message="密封泄漏状态长度不能超过255个字符")
    private String sePumpLeakStatus;

    @Schema(description = "维保维修记录")
    @Size(max=255, message="维保维修记录长度不能超过255个字符")
    private String sePumpMaintainRecord;

    @Schema(description = "故障及异常记录")
    @Size(max=255, message="故障及异常记录长度不能超过255个字符")
    private String sePumpFaultRecord;

    @Schema(description = "录入维护人员")
    @NotBlank(message = "录入维护人员不能为空")
    @Size(max=255, message="录入维护人员长度不能超过255个字符")
    private String sePumpOperator;

    @Schema(description = "记录创建时间")
    private LocalDate sePumpCreateTime;

    @Schema(description = "最后更新时间")
    private LocalDate sePumpUpdateTime;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String sePumpFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String sePumpReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String sePumpReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String sePumpReserve3;


}
