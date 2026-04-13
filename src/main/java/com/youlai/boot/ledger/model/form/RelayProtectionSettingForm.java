package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 继电保护定值台账表单对象
 *
 * @author dazao
 * @since 2026-02-11 09:41
 */
@Getter
@Setter
@Schema(description = "继电保护定值台账表单对象")
public class RelayProtectionSettingForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "继电器编号")
    @NotBlank(message = "继电器编号不能为空")
    @Size(max=255, message="继电器编号长度不能超过255个字符")
    private String rpsRelayCode;

    @Schema(description = "继电器类型")
    @NotBlank(message = "继电器类型不能为空")
    @Size(max=255, message="继电器类型长度不能超过255个字符")
    private String rpsRelayType;

    @Schema(description = "继电器型号")
    @NotBlank(message = "继电器型号不能为空")
    @Size(max=255, message="继电器型号长度不能超过255个字符")
    private String rpsRelayModel;

    @Schema(description = "过流保护定值（A）")
    @Size(max=255, message="过流保护定值（A）长度不能超过255个字符")
    private String rpsOvercurrentSetting;

    @Schema(description = "过流保护延时（s）")
    @Size(max=255, message="过流保护延时（s）长度不能超过255个字符")
    private String rpsOvercurrentDelay;

    @Schema(description = "速断保护定值（A）")
    @Size(max=255, message="速断保护定值（A）长度不能超过255个字符")
    private String rpsInstantaneousSetting;

    @Schema(description = "接地故障定值（A）")
    @Size(max=255, message="接地故障定值（A）长度不能超过255个字符")
    private String rpsEarthFaultSetting;

    @Schema(description = "过载保护定值（%）")
    @Size(max=255, message="过载保护定值（%）长度不能超过255个字符")
    private String rpsOverloadSetting;

    @Schema(description = "定值整定日期")
    @NotNull(message = "定值整定日期不能为空")
    private LocalDate rpsSettingDate;

    @Schema(description = "整定人员")
    @NotBlank(message = "整定人员不能为空")
    @Size(max=255, message="整定人员长度不能超过255个字符")
    private String rpsSettingPerson;

    @Schema(description = "上次校验日期")
    private LocalDate rpsLastCheckDate;

    @Schema(description = "下次校验日期")
    private LocalDate rpsNextCheckDate;

    @Schema(description = "定值变更记录")
    @Size(max=255, message="定值变更记录长度不能超过255个字符")
    private String rpsChangeRecord;

    @Schema(description = "安装位置")
    @NotBlank(message = "安装位置不能为空")
    @Size(max=255, message="安装位置长度不能超过255个字符")
    private String rpsInstallPosition;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String rpsFactory;


}
