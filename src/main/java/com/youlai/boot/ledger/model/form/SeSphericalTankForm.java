package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
/**
 * 球罐表单对象
 *
 * @author baiwei
 * @since 2026-03-06 09:49
 */
@Getter
@Setter
@Schema(description = "球罐表单对象")
public class SeSphericalTankForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "球罐设备编号")
    @NotBlank(message = "球罐设备编号不能为空")
    @Size(max=255, message="球罐设备编号长度不能超过255个字符")
    private String seTankEquipCode;

    @Schema(description = "球罐名称")
    @NotBlank(message = "球罐名称不能为空")
    @Size(max=255, message="球罐名称长度不能超过255个字符")
    private String seTankName;

    @Schema(description = "规格型号")
    @NotBlank(message = "规格型号不能为空")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String seTankSpec;

    @Schema(description = "设计容积（m³）")
    @NotBlank(message = "设计容积（m³）不能为空")
    @Size(max=255, message="设计容积（m³）长度不能超过255个字符")
    private String seTankDesignVolume;

    @Schema(description = "工作容积（m³）")
    @NotBlank(message = "工作容积（m³）不能为空")
    @Size(max=255, message="工作容积（m³）长度不能超过255个字符")
    private String seTankOperatingVolume;

    @Schema(description = "设计压力（MPa）")
    @NotBlank(message = "设计压力（MPa）不能为空")
    @Size(max=255, message="设计压力（MPa）长度不能超过255个字符")
    private String seTankDesignP;

    @Schema(description = "工作压力（MPa）")
    @NotBlank(message = "工作压力（MPa）不能为空")
    @Size(max=255, message="工作压力（MPa）长度不能超过255个字符")
    private String seTankOperatingP;

    @Schema(description = "设计温度（℃）")
    @NotBlank(message = "设计温度（℃）不能为空")
    @Size(max=255, message="设计温度（℃）长度不能超过255个字符")
    private String seTankDesignT;

    @Schema(description = "工作温度（℃）")
    @NotBlank(message = "工作温度（℃）不能为空")
    @Size(max=255, message="工作温度（℃）长度不能超过255个字符")
    private String seTankOperatingT;

    @Schema(description = "储存介质")
    @NotBlank(message = "储存介质不能为空")
    @Size(max=255, message="储存介质长度不能超过255个字符")
    private String seTankMedia;

    @Schema(description = "主体材质")
    @NotBlank(message = "主体材质不能为空")
    @Size(max=255, message="主体材质长度不能超过255个字符")
    private String seTankMaterial;

    @Schema(description = "罐体壁厚（mm）")
    @NotBlank(message = "罐体壁厚（mm）不能为空")
    @Size(max=255, message="罐体壁厚（mm）长度不能超过255个字符")
    private String seTankThickness;

    @Schema(description = "密封形式")
    @NotBlank(message = "密封形式不能为空")
    @Size(max=255, message="密封形式长度不能超过255个字符")
    private String seTankSealType;

    @Schema(description = "防腐措施")
    @NotBlank(message = "防腐措施不能为空")
    @Size(max=255, message="防腐措施长度不能超过255个字符")
    private String seTankAntiCorrosion;

    @Schema(description = "安全阀型号规格")
    @NotBlank(message = "安全阀型号规格不能为空")
    @Size(max=255, message="安全阀型号规格长度不能超过255个字符")
    private String seTankSafetyValveModel;

    @Schema(description = "安装位置")
    @NotBlank(message = "安装位置不能为空")
    @Size(max=255, message="安装位置长度不能超过255个字符")
    private String seTankInstallPos;

    @Schema(description = "投用日期")
    @NotBlank(message = "投用日期不能为空")
    @Size(max=255, message="投用日期长度不能超过255个字符")
    private String seTankInService;

    @Schema(description = "定期检验周期")
    @NotBlank(message = "定期检验周期不能为空")
    @Size(max=255, message="定期检验周期长度不能超过255个字符")
    private String seTankInspectCycle;

    @Schema(description = "上次检验日期")
    @NotNull(message = "上次检验日期不能为空")
    private LocalDate seTankLastInspect;

    @Schema(description = "下次检验日期")
    @NotNull(message = "下次检验日期不能为空")
    private LocalDate seTankNextInspect;

    @Schema(description = "检验结果")
    @NotBlank(message = "检验结果不能为空")
    @Size(max=255, message="检验结果长度不能超过255个字符")
    private String seTankInspectResult;

    @Schema(description = "上次水压 / 气压试验日期")
    private LocalDate seTankLastPressureTest;

    @Schema(description = "液位计型号")
    @Size(max=255, message="液位计型号长度不能超过255个字符")
    private String seTankLevelGaugeModel;

    @Schema(description = "腐蚀状况")
    @Size(max=255, message="腐蚀状况长度不能超过255个字符")
    private String seTankCorrosionStatus;

    @Schema(description = "维保维修记录")
    @Size(max=255, message="维保维修记录长度不能超过255个字符")
    private String seTankMaintainRecord;

    @Schema(description = "故障及异常记录")
    @Size(max=255, message="故障及异常记录长度不能超过255个字符")
    private String seTankFaultRecord;

    @Schema(description = "录入维护人员")
    @NotBlank(message = "录入维护人员不能为空")
    @Size(max=255, message="录入维护人员长度不能超过255个字符")
    private String seTankOperator;

    @Schema(description = "记录创建时间")
    @NotNull(message = "记录创建时间不能为空")
    private LocalDate seTankCreateTime;

    @Schema(description = "最后更新时间")
    @NotNull(message = "最后更新时间不能为空")
    private LocalDate seTankUpdateTime;

    @Schema(description = "设备状态")
    @Size(max=255, message="设备状态长度不能超过255个字符")
    private String seTankStatus;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String seTankFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String seTankReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String seTankReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String seTankReserve3;


}
