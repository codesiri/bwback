package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

/**
 * 特种设备压缩机台账表单对象
 *
 * @author baiwei
 * @since 2026-02-09 09:07
 */
@Getter
@Setter
@Schema(description = "特种设备压缩机台账表单对象")
public class SeCompressorForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "压缩机设备编号")
    @NotBlank(message = "压缩机设备编号不能为空")
    @Size(max=255, message="压缩机设备编号长度不能超过255个字符")
    private String seCompressorEquipCode;

    @Schema(description = "设备名称")
    @NotBlank(message = "设备名称不能为空")
    @Size(max=255, message="设备名称长度不能超过255个字符")
    private String seCompressorName;

    @Schema(description = "压缩机类型")
    @NotBlank(message = "压缩机类型不能为空")
    @Size(max=255, message="压缩机类型长度不能超过255个字符")
    private String seCompressorType;

    @Schema(description = "规格型号")
    @NotBlank(message = "规格型号不能为空")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String seCompressorSpec;

    @Schema(description = "额定排气量（m³/min）")
    @NotBlank(message = "额定排气量（m³/min）不能为空")
    @Size(max=255, message="额定排气量（m³/min）长度不能超过255个字符")
    private String seCompressorRatedFlow;

    @Schema(description = "额定排气压力（MPa）")
    @NotBlank(message = "额定排气压力（MPa）不能为空")
    @Size(max=255, message="额定排气压力（MPa）长度不能超过255个字符")
    private String seCompressorRatedPressure;

    @Schema(description = "额定输入功率（kW）")
    @NotBlank(message = "额定输入功率（kW）不能为空")
    @Size(max=255, message="额定输入功率（kW）长度不能超过255个字符")
    private String seCompressorRatedPower;

    @Schema(description = "额定转速（r/min）")
    @NotBlank(message = "额定转速（r/min）不能为空")
    @Size(max=255, message="额定转速（r/min）长度不能超过255个字符")
    private String seCompressorRatedSpeed;

    @Schema(description = "输送介质")
    @NotBlank(message = "输送介质不能为空")
    @Size(max=255, message="输送介质长度不能超过255个字符")
    private String seCompressorMedia;

    @Schema(description = "进气温度（℃）")
    @NotBlank(message = "进气温度（℃）不能为空")
    @Size(max=255, message="进气温度（℃）长度不能超过255个字符")
    private String seCompressorInletTemp;

    @Schema(description = "排气温度（℃）")
    @NotBlank(message = "排气温度（℃）不能为空")
    @Size(max=255, message="排气温度（℃）长度不能超过255个字符")
    private String seCompressorOutletTemp;

    @Schema(description = "设计压力（MPa）")
    @NotBlank(message = "设计压力（MPa）不能为空")
    @Size(max=255, message="设计压力（MPa）长度不能超过255个字符")
    private String seCompressorDesignP;

    @Schema(description = "主体 / 过流部件材质")
    @NotBlank(message = "主体 / 过流部件材质不能为空")
    @Size(max=255, message="主体 / 过流部件材质长度不能超过255个字符")
    private String seCompressorMaterial;

    @Schema(description = "防爆等级")
    @NotBlank(message = "防爆等级不能为空")
    @Size(max=255, message="防爆等级长度不能超过255个字符")
    private String seCompressorExplosionProof;

    @Schema(description = "配套电机型号")
    @NotBlank(message = "配套电机型号不能为空")
    @Size(max=255, message="配套电机型号长度不能超过255个字符")
    private String seCompressorMotorModel;

    @Schema(description = "润滑方式及油品")
    @NotBlank(message = "润滑方式及油品不能为空")
    @Size(max=255, message="润滑方式及油品长度不能超过255个字符")
    private String seCompressorLubrication;

    @Schema(description = "冷却方式（水冷 / 风冷）")
    @NotBlank(message = "冷却方式（水冷 / 风冷）不能为空")
    @Size(max=255, message="冷却方式（水冷 / 风冷）长度不能超过255个字符")
    private String seCompressorCoolingType;

    @Schema(description = "安装位置")
    @NotBlank(message = "安装位置不能为空")
    @Size(max=255, message="安装位置长度不能超过255个字符")
    private String seCompressorInstallPos;

    @Schema(description = "投用日期")
    @NotNull(message = "投用日期不能为空")
    private LocalDate seCompressorInService;

    @Schema(description = "定期检验周期")
    @NotBlank(message = "定期检验周期不能为空")
    @Size(max=255, message="定期检验周期长度不能超过255个字符")
    private String seCompressorInspectCycle;

    @Schema(description = "上次检验日期")
    @NotNull(message = "上次检验日期不能为空")
    private LocalDate seCompressorLastInspect;

    @Schema(description = "下次检验日期")
    @NotNull(message = "下次检验日期不能为空")
    private LocalDate seCompressorNextInspect;

    @Schema(description = "检验结果")
    @NotBlank(message = "检验结果不能为空")
    @Size(max=255, message="检验结果长度不能超过255个字符")
    private String seCompressorInspectResult;

    @Schema(description = "上次维保日期")
    @Size(max=255, message="上次维保日期长度不能超过255个字符")
    private String seCompressorLastMaintain;

    @Schema(description = "下次维保日期")
    @Size(max=255, message="下次维保日期长度不能超过255个字符")
    private String seCompressorNextMaintain;

    @Schema(description = "运行振动值（mm/s）")
    @Size(max=255, message="运行振动值（mm/s）长度不能超过255个字符")
    private String seCompressorVibration;

    @Schema(description = "压缩比")
    @Size(max=255, message="压缩比长度不能超过255个字符")
    private String seCompressorPressureRatio;

    @Schema(description = "维保维修记录")
    @Size(max=255, message="维保维修记录长度不能超过255个字符")
    private String seCompressorMaintainRecord;

    @Schema(description = "故障及异常记录")
    @Size(max=255, message="故障及异常记录长度不能超过255个字符")
    private String seCompressorFaultRecord;

    @Schema(description = "录入维护人员")
    @NotBlank(message = "录入维护人员不能为空")
    @Size(max=255, message="录入维护人员长度不能超过255个字符")
    private String seCompressorOperator;

    @Schema(description = "记录创建时间")
    @NotNull(message = "记录创建时间不能为空")
    private LocalDate seCompressorCreateTime;

    @Schema(description = "最后更新时间")
    @NotNull(message = "最后更新时间不能为空")
    private LocalDate seCompressorUpdateTime;

    @Schema(description = "设备状态")
    @Size(max=255, message="设备状态长度不能超过255个字符")
    private String seCompressorStatus;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String seCompressorFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String seCompressorReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String seCompressorReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String seCompressorReserve3;


}
