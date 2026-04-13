package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 电器接地系统表单对象
 *
 * @author dazao
 * @since 2026-03-09 08:51
 */
@Getter
@Setter
@Schema(description = "电器接地系统表单对象")
public class GroundSystemEquipmentForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "接地编号")
    @NotBlank(message = "接地编号不能为空")
    @Size(max=255, message="接地编号长度不能超过255个字符")
    private String gseGroundCode;

    @Schema(description = "接地类型")
    @NotBlank(message = "接地类型不能为空")
    @Size(max=255, message="接地类型长度不能超过255个字符")
    private String gseGroundType;

    @Schema(description = "接地结构")
    @NotBlank(message = "接地结构不能为空")
    @Size(max=255, message="接地结构长度不能超过255个字符")
    private String gseGroundStruct;

    @Schema(description = "材质")
    @NotBlank(message = "材质不能为空")
    @Size(max=255, message="材质长度不能超过255个字符")
    private String gseMaterial;

    @Schema(description = "安装位置")
    @NotBlank(message = "安装位置不能为空")
    @Size(max=255, message="安装位置长度不能超过255个字符")
    private String gseInstallArea;

    @Schema(description = "安装区域及危险等级")
    @NotBlank(message = "安装区域及危险等级不能为空")
    @Size(max=255, message="安装区域及危险等级长度不能超过255个字符")
    private String gseInstallPosition;

    @Schema(description = "设计接地电阻值（Ω）")
    @NotBlank(message = "设计接地电阻值（Ω）不能为空")
    @Size(max=255, message="设计接地电阻值（Ω）长度不能超过255个字符")
    private String gseDesignResistance;

    @Schema(description = "上次接地电阻测试日期")
    @NotNull(message = "上次接地电阻测试日期不能为空")
    private LocalDate gseLastTestDate;

    @Schema(description = "上次测试电阻值（Ω）")
    @NotBlank(message = "上次测试电阻值（Ω）不能为空")
    @Size(max=255, message="上次测试电阻值（Ω）长度不能超过255个字符")
    private String gseLastTestData;

    @Schema(description = "下次测试日期")
    private LocalDate gseNextTestDate;

    @Schema(description = "测试人员")
    @Size(max=255, message="测试人员长度不能超过255个字符")
    private String gseTestPerson;

    @Schema(description = "安装日期")
    @NotNull(message = "安装日期不能为空")
    private LocalDate gseInstallDate;

    @Schema(description = "接地状态")
    @NotBlank(message = "接地状态不能为空")
    @Size(max=255, message="接地状态长度不能超过255个字符")
    private String gseStatus;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String gseFactory;


}
