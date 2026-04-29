package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
/**
 * 特种设备膨胀机台账表单对象
 *
 * @author baiwei
 * @since 2026-02-09 09:15
 */
@Getter
@Setter
@Schema(description = "特种设备膨胀机台账表单对象")
public class SeExpanderForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "膨胀机设备编号")
    @NotBlank(message = "膨胀机设备编号不能为空")
    @Size(max=255, message="膨胀机设备编号长度不能超过255个字符")
    private String seExpanderEquipCode;

    @Schema(description = "设备名称")
    @NotBlank(message = "设备名称不能为空")
    @Size(max=255, message="设备名称长度不能超过255个字符")
    private String seExpanderName;

    @Schema(description = "设备类型")
    @NotBlank(message = "设备类型不能为空")
    @Size(max=255, message="设备类型长度不能超过255个字符")
    private String seExpanderType;

    @Schema(description = "规格型号")
    @NotBlank(message = "规格型号不能为空")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String seExpanderSpec;

    @Schema(description = "额定功率")
    @NotBlank(message = "额定功率不能为空")
    @Size(max=255, message="额定功率长度不能超过255个字符")
    private String seExpanderRatedPower;

    @Schema(description = "额定转速")
    @NotBlank(message = "额定转速不能为空")
    @Size(max=255, message="额定转速长度不能超过255个字符")
    private String seExpanderRatedSpeed;

    @Schema(description = "进口压力")
    @NotBlank(message = "进口压力不能为空")
    @Size(max=255, message="进口压力长度不能超过255个字符")
    private String seExpanderInletP;

    @Schema(description = "进口温度")
    @NotBlank(message = "进口温度不能为空")
    @Size(max=255, message="进口温度长度不能超过255个字符")
    private String seExpanderInletT;

    @Schema(description = "出口压力")
    @NotBlank(message = "出口压力不能为空")
    @Size(max=255, message="出口压力长度不能超过255个字符")
    private String seExpanderOutletP;

    @Schema(description = "出口温度")
    @NotBlank(message = "出口温度不能为空")
    @Size(max=255, message="出口温度长度不能超过255个字符")
    private String seExpanderOutletT;

    @Schema(description = "工作介质")
    @NotBlank(message = "工作介质不能为空")
    @Size(max=255, message="工作介质长度不能超过255个字符")
    private String seExpanderMedia;

    @Schema(description = "主体材质")
    @NotBlank(message = "主体材质不能为空")
    @Size(max=255, message="主体材质长度不能超过255个字符")
    private String seExpanderMaterial;

    @Schema(description = "防爆等级")
    @NotBlank(message = "防爆等级不能为空")
    @Size(max=255, message="防爆等级长度不能超过255个字符")
    private String seExpanderExplosionProof;

    @Schema(description = "联轴器类型")
    @NotBlank(message = "联轴器类型不能为空")
    @Size(max=255, message="联轴器类型长度不能超过255个字符")
    private String seExpanderCouplingType;

    @Schema(description = "轴承类型")
    @NotBlank(message = "轴承类型不能为空")
    @Size(max=255, message="轴承类型长度不能超过255个字符")
    private String seExpanderBearingType;

    @Schema(description = "润滑方式及油品")
    @NotBlank(message = "润滑方式及油品不能为空")
    @Size(max=255, message="润滑方式及油品长度不能超过255个字符")
    private String seExpanderLubrication;

    @Schema(description = "安装位置")
    @NotBlank(message = "安装位置不能为空")
    @Size(max=255, message="安装位置长度不能超过255个字符")
    private String seExpanderInstallPos;

    @Schema(description = "投用日期")
    @NotBlank(message = "投用日期不能为空")
    @Size(max=255, message="投用日期长度不能超过255个字符")
    private String seExpanderInService;

    @Schema(description = "定期检验周期")
    @NotBlank(message = "定期检验周期不能为空")
    @Size(max=255, message="定期检验周期长度不能超过255个字符")
    private String seExpanderInspectCycle;

    @Schema(description = "上次检验日期")
    @NotBlank(message = "上次检验日期不能为空")
    @Size(max=255, message="上次检验日期长度不能超过255个字符")
    private String seExpanderLastInspect;

    @Schema(description = "下次检验日期")
    @NotBlank(message = "下次检验日期不能为空")
    @Size(max=255, message="下次检验日期长度不能超过255个字符")
    private String seExpanderNextInspect;

    @Schema(description = "检验结果")
    @NotBlank(message = "检验结果不能为空")
    @Size(max=255, message="检验结果长度不能超过255个字符")
    private String seExpanderInspectResult;

    @Schema(description = "上次润滑日期")
    @Size(max=255, message="上次润滑日期长度不能超过255个字符")
    private String seExpanderLastLubricate;

    @Schema(description = "下次润滑日期")
    @Size(max=255, message="下次润滑日期长度不能超过255个字符")
    private String seExpanderNextLubricate;

    @Schema(description = "运行振动值")
    @Size(max=255, message="运行振动值长度不能超过255个字符")
    private String seExpanderVibration;

    @Schema(description = "膨胀机运行效率")
    @Size(max=255, message="膨胀机运行效率长度不能超过255个字符")
    private String seExpanderEfficiency;

    @Schema(description = "维保维修记录")
    @Size(max=255, message="维保维修记录长度不能超过255个字符")
    private String seExpanderMaintainRecord;

    @Schema(description = "故障及异常记录")
    @Size(max=255, message="故障及异常记录长度不能超过255个字符")
    private String seExpanderFaultRecord;

    @Schema(description = "录入 / 维护人员")
    @Size(max=255, message="录入 / 维护人员长度不能超过255个字符")
    private String seExpanderOperator;

    @Schema(description = "创建时间")
    @NotNull(message = "创建时间不能为空")
    private LocalDate seExpanderCreateTime;

    @Schema(description = "最后更新时间")
    @NotNull(message = "最后更新时间不能为空")
    private LocalDate seExpanderUpdateTime;

    @Schema(description = "设备状态")
    @Size(max=255, message="设备状态长度不能超过255个字符")
    private String seExpanderStatus;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String seExpanderFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String seExpanderReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String seExpanderReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String seExpanderReserve3;


}
