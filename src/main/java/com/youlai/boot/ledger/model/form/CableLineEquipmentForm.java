package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 电器电缆线路表单对象
 *
 * @author dazao
 * @since 2026-03-05 08:45
 */
@Getter
@Setter
@Schema(description = "电器电缆线路表单对象")
public class CableLineEquipmentForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "电缆编号")
    @NotBlank(message = "电缆编号不能为空")
    @Size(max=255, message="电缆编号长度不能超过255个字符")
    private String cleCableCode;

    @Schema(description = "电缆名称")
    @NotBlank(message = "电缆名称不能为空")
    @Size(max=255, message="电缆名称长度不能超过255个字符")
    private String cleCableName;

    @Schema(description = "规格型号")
    @NotBlank(message = "规格型号不能为空")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String cleSpecModel;

    @Schema(description = "绝缘等级")
    @NotBlank(message = "绝缘等级不能为空")
    @Size(max=255, message="绝缘等级长度不能超过255个字符")
    private String cleInsulationLevel;

    @Schema(description = "电缆长度（m）")
    @NotBlank(message = "电缆长度（m）不能为空")
    @Size(max=255, message="电缆长度（m）长度不能超过255个字符")
    private String cleCableLength;

    @Schema(description = "敷设方式")
    @NotBlank(message = "敷设方式不能为空")
    @Size(max=255, message="敷设方式长度不能超过255个字符")
    private String cleLayingMethod;

    @Schema(description = "敷设路径")
    @NotBlank(message = "敷设路径不能为空")
    @Size(max=255, message="敷设路径长度不能超过255个字符")
    private String cleLayingPath;

    @Schema(description = "安装区域及危险等级")
    @NotBlank(message = "安装区域及危险等级不能为空")
    @Size(max=255, message="安装区域及危险等级长度不能超过255个字符")
    private String cleInstallArea;

    @Schema(description = "电缆芯数")
    @Size(max=255, message="电缆芯数长度不能超过255个字符")
    private String cleCoreNumber;

    @Schema(description = "芯线截面（mm²）")
    @Size(max=255, message="芯线截面（mm²）长度不能超过255个字符")
    private String cleCoreSection;

    @Schema(description = "生产厂家")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String cleManufacturer;

    @Schema(description = "生产日期")
    private LocalDate cleProductionDate;

    @Schema(description = "敷设安装日期")
    private LocalDate cleInstallDate;

    @Schema(description = "上次耐压 / 绝缘测试日期")
    private LocalDate cleLastTestDate;

    @Schema(description = "上次测试数据（MΩ/kV）")
    @Size(max=255, message="上次测试数据（MΩ/kV）长度不能超过255个字符")
    private String cleLastTestData;

    @Schema(description = "中间接头数量")
    @Size(max=255, message="中间接头数量长度不能超过255个字符")
    private String cleJointCount;

    @Schema(description = "电缆状态（在用 / 备用 / 停用）")
    @Size(max=255, message="电缆状态（在用 / 备用 / 停用）长度不能超过255个字符")
    private String cleStatus;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String cleFactory;


}
