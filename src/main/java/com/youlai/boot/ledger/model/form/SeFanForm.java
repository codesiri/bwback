package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
/**
 * 特种设备风机台账表单对象
 *
 * @author youlaitech
 * @since 2026-02-09 09:18
 */
@Getter
@Setter
@Schema(description = "特种设备风机台账表单对象")
public class SeFanForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "风机设备编号")
    @NotBlank(message = "风机设备编号不能为空")
    @Size(max=255, message="风机设备编号长度不能超过255个字符")
    private String seFanEquipCode;

    @Schema(description = "风机名称")
    @NotBlank(message = "风机名称不能为空")
    @Size(max=255, message="风机名称长度不能超过255个字符")
    private String seFanName;

    @Schema(description = "风机类型")
    @NotBlank(message = "风机类型不能为空")
    @Size(max=255, message="风机类型长度不能超过255个字符")
    private String seFanType;

    @Schema(description = "设备规格")
    @NotBlank(message = "设备规格不能为空")
    @Size(max=255, message="设备规格长度不能超过255个字符")
    private String seFanSpec;

    @Schema(description = "额定功率（kW）")
    @NotBlank(message = "额定功率（kW）不能为空")
    @Size(max=255, message="额定功率（kW）长度不能超过255个字符")
    private String seFanRatedPower;

    @Schema(description = "额定转速（r/min）")
    @NotBlank(message = "额定转速（r/min）不能为空")
    @Size(max=255, message="额定转速（r/min）长度不能超过255个字符")
    private String seFanRatedSpeed;

    @Schema(description = "额定压力（kPa，正压 / 负压标注在备注）")
    @NotBlank(message = "额定压力（kPa，正压 / 负压标注在备注）不能为空")
    @Size(max=255, message="额定压力（kPa，正压 / 负压标注在备注）长度不能超过255个字符")
    private String seFanRatedPressure;

    @Schema(description = "额定风量（m³/h）")
    @NotBlank(message = "额定风量（m³/h）不能为空")
    @Size(max=255, message="额定风量（m³/h）长度不能超过255个字符")
    private String seFanRatedFlow;

    @Schema(description = "输送介质")
    @NotBlank(message = "输送介质不能为空")
    @Size(max=255, message="输送介质长度不能超过255个字符")
    private String seFanMedium;

    @Schema(description = "主体材质")
    @NotBlank(message = "主体材质不能为空")
    @Size(max=255, message="主体材质长度不能超过255个字符")
    private String seFanMaterial;

    @Schema(description = "防爆等级")
    @NotBlank(message = "防爆等级不能为空")
    @Size(max=255, message="防爆等级长度不能超过255个字符")
    private String seFanExplosionProof;

    @Schema(description = "配套电机型号")
    @NotBlank(message = "配套电机型号不能为空")
    @Size(max=255, message="配套电机型号长度不能超过255个字符")
    private String seFanMotorModel;

    @Schema(description = "安装位置")
    @NotBlank(message = "安装位置不能为空")
    @Size(max=255, message="安装位置长度不能超过255个字符")
    private String seFanInstallPos;

    @Schema(description = "投用日期")
    @Size(max=255, message="投用日期长度不能超过255个字符")
    private String seFanInService;

    @Schema(description = "法定检验周期")
    @NotBlank(message = "法定检验周期不能为空")
    @Size(max=255, message="法定检验周期长度不能超过255个字符")
    private String seFanInspectCycle;

    @Schema(description = "上次检验日期")
    private LocalDate seFanLastInspect;

    @Schema(description = "下次检验日期")
    private LocalDate seFanNextInspect;

    @Schema(description = "检验结果")
    @NotBlank(message = "检验结果不能为空")
    @Size(max=255, message="检验结果长度不能超过255个字符")
    private String seFanInspectResult;

    @Schema(description = "润滑方式")
    @NotBlank(message = "润滑方式不能为空")
    @Size(max=255, message="润滑方式长度不能超过255个字符")
    private String seFanLubrication;

    @Schema(description = "上次润滑日期")
    private LocalDate seFanLastLubricate;

    @Schema(description = "下次润滑日期")
    private LocalDate seFanNextLubricate;

    @Schema(description = "运行振动值（mm/s，标准≤4.5mm/s）")
    @Size(max=255, message="运行振动值（mm/s，标准≤4.5mm/s）长度不能超过255个字符")
    private String seFanVibration;

    @Schema(description = "维保记录")
    @Size(max=255, message="维保记录长度不能超过255个字符")
    private String seFanMaintainRecord;

    @Schema(description = "故障记录")
    @Size(max=255, message="故障记录长度不能超过255个字符")
    private String seFanFaultRecord;

    @Schema(description = "台账录入 / 维护人员")
    @NotBlank(message = "台账录入 / 维护人员不能为空")
    @Size(max=255, message="台账录入 / 维护人员长度不能超过255个字符")
    private String seFanOperator;

    @Schema(description = "台账记录创建时间")
    @NotNull(message = "台账记录创建时间不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime seFanCreateTime;

    @Schema(description = "台账记录最后修改时间")
    @NotNull(message = "台账记录最后修改时间不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime seFanUpdateTime;

    @Schema(description = "设备状态")
    @Size(max=255, message="设备状态长度不能超过255个字符")
    private String seFanStatus;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String seFanFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String seFanReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String seFanReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String seFanReserve3;


}
