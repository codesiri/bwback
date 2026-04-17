package com.youlai.boot.maintence.model.form;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.*;

/**
 * 维修计划表单对象
 *
 * @author youlaitech
 * @since 2026-04-10 08:37
 */
@Getter
@Setter
@Schema(description = "维修计划表单对象")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MaintainPlanForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "计划类型")
    @NotBlank(message = "计划类型不能为空")
    @Size(max=20, message="计划类型长度不能超过20个字符")
    private String maintainPlanType;

    @Schema(description = "计划年度")
    @NotNull(message = "计划年度不能为空")
    private Integer maintainPlanYear;

    @Schema(description = "计划月份")
    private Integer maintainPlanMonth;

    @Schema(description = "设备编号")
    @NotBlank(message = "设备编号不能为空")
    @Size(max=255, message="设备编号长度不能超过255个字符")
    private String maintainPlanEquipCode;

    @Schema(description = "设备名称")
    @NotBlank(message = "设备名称不能为空")
    @Size(max=255, message="设备名称长度不能超过255个字符")
    private String maintainPlanEquipName;

    @Schema(description = "设备类型")
    @NotBlank(message = "设备类型不能为空")
    @Size(max=32, message="设备类型长度不能超过32个字符")
    private String maintainPlanEquipType;

    @Schema(description = "维修/检修内容")
    @NotBlank(message = "维修/检修内容不能为空")
    @Size(max=512, message="维修/检修内容长度不能超过512个字符")
    private String maintainPlanContent;

    @Schema(description = "计划执行日期")
    @NotNull(message = "计划执行日期不能为空")
    private LocalDate maintainPlanScheduleDate;

    @Schema(description = "计划时长")
    @NotNull(message = "计划时长不能为空")
    private BigDecimal maintainPlanDuration;

    @Schema(description = "负责部门")
    @NotBlank(message = "负责部门不能为空")
    @Size(max=64, message="负责部门长度不能超过64个字符")
    private String maintainPlanDept;

    @Schema(description = "负责人")
    @NotBlank(message = "负责人不能为空")
    @Size(max=32, message="负责人长度不能超过32个字符")
    private String maintainPlanPerson;

    @Schema(description = "安全风险等级")
    @NotBlank(message = "安全风险等级不能为空")
    @Size(max=20, message="安全风险等级长度不能超过20个字符")
    private String maintainPlanSafetyLevel;

    @Schema(description = "安全防护措施")
    @Size(max=255, message="安全防护措施长度不能超过255个字符")
    private String maintainPlanSafetyMeasure;

    @Schema(description = "计划状态")
    @NotBlank(message = "计划状态不能为空")
    @Size(max=20, message="计划状态长度不能超过20个字符")
    private String maintainPlanStatus;

    @Schema(description = "实际执行日期")
    private LocalDate maintainPlanActualDate;


}
