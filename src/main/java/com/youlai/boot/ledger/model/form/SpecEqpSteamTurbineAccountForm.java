package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;

import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 汽轮机表单对象
 *
 * @author baiwei
 * @since 2026-02-03 09:38
 */
@Getter
@Setter
@Schema(description = "汽轮机表单对象")
public class SpecEqpSteamTurbineAccountForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "汽轮机设备编码")
    @NotBlank(message = "汽轮机设备编码不能为空")
    @Size(max=255, message="汽轮机设备编码长度不能超过255个字符")
    private String specEqpStCode;

    @Schema(description = "汽轮机名称")
    @NotBlank(message = "汽轮机名称不能为空")
    @Size(max=255, message="汽轮机名称长度不能超过255个字符")
    private String specEqpStName;

    @Schema(description = "所在区域")
    @NotBlank(message = "所在区域不能为空")
    @Size(max=255, message="所在区域长度不能超过255个字符")
    private String specEqpStArea;

    @Schema(description = "汽轮机型号")
    @NotBlank(message = "汽轮机型号不能为空")
    @Size(max=255, message="汽轮机型号长度不能超过255个字符")
    private String specEqpStModel;

    @Schema(description = "生产厂家")
    @NotBlank(message = "生产厂家不能为空")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String specEqpStManufacturer;

    @Schema(description = "出厂编号")
    @NotBlank(message = "出厂编号不能为空")
    @Size(max=255, message="出厂编号长度不能超过255个字符")
    private String specEqpStFactoryNo;

    @Schema(description = "制造日期")
    @NotNull(message = "制造日期不能为空")
    private LocalDate specEqpStProduceDate;

    @Schema(description = "安装单位")
    @NotBlank(message = "安装单位不能为空")
    @Size(max=255, message="安装单位长度不能超过255个字符")
    private String specEqpStInstallCompany;

    @Schema(description = "安装日期")
    @NotNull(message = "安装日期不能为空")
    private LocalDate specEqpStInstallDate;

    @Schema(description = "验收日期")
    @NotNull(message = "验收日期不能为空")
    private LocalDate specEqpStAcceptanceDate;

    @Schema(description = "投用日期")
    @NotNull(message = "投用日期不能为空")
    private LocalDate specEqpStUsageDate;

    @Schema(description = "	特种设备使用登记")
    @NotBlank(message = "	特种设备使用登记不能为空")
    @Size(max=255, message="	特种设备使用登记长度不能超过255个字符")
    private String specEqpStLicenseNo;

    @Schema(description = "	额定功率（MW）")
    @NotBlank(message = "	额定功率（MW）不能为空")
    @Size(max=255, message="	额定功率（MW）长度不能超过255个字符")
    private String specEqpStPowerRating;

    @Schema(description = "	额定转速（r/min）")
    @NotBlank(message = "	额定转速（r/min）不能为空")
    @Size(max=255, message="	额定转速（r/min）长度不能超过255个字符")
    private String specEqpStSpeedRating;

    @Schema(description = "进汽设计压力（MPa）")
    @NotBlank(message = "进汽设计压力（MPa）不能为空")
    @Size(max=255, message="进汽设计压力（MPa）长度不能超过255个字符")
    private String specEqpStSteamPressure;

    @Schema(description = "进汽设计温度（℃）")
    @NotBlank(message = "进汽设计温度（℃）不能为空")
    @Size(max=255, message="进汽设计温度（℃）长度不能超过255个字符")
    private String specEqpStSteamTemp;

    @Schema(description = "排汽压力（MPa）")
    @Size(max=255, message="排汽压力（MPa）长度不能超过255个字符")
    private String specEqpStExhaustPressure;

    @Schema(description = "	转子材质")
    @NotBlank(message = "	转子材质不能为空")
    @Size(max=255, message="	转子材质长度不能超过255个字符")
    private String specEqpStRotorMaterial;

    @Schema(description = "	汽缸材质")
    @NotBlank(message = "	汽缸材质不能为空")
    @Size(max=255, message="	汽缸材质长度不能超过255个字符")
    private String specEqpStCasingMaterial;

    @Schema(description = "工作介质（蒸汽 / 过热蒸汽等）")
    @NotBlank(message = "工作介质（蒸汽 / 过热蒸汽等）不能为空")
    @Size(max=255, message="工作介质（蒸汽 / 过热蒸汽等）长度不能超过255个字符")
    private String specEqpStMedia;

    @Schema(description = "介质特性（高温、高压等）")
    @NotBlank(message = "介质特性（高温、高压等）不能为空")
    @Size(max=255, message="介质特性（高温、高压等）长度不能超过255个字符")
    private String specEqpStMediaProperty;

    @Schema(description = "设备状态")
    @NotBlank(message = "设备状态不能为空")
    @Size(max=255, message="设备状态长度不能超过255个字符")
    private String specEqpStStatus;

    @Schema(description = "	上次检验日期")
    private LocalDate specEqpStLastInspectDate;

    @Schema(description = "	下次检验日期")
    @NotNull(message = "	下次检验日期不能为空")
    private LocalDate specEqpStNextInspectDate;

    @Schema(description = "	检验机构")
    @Size(max=255, message="	检验机构长度不能超过255个字符")
    private String specEqpStInspectCompany;

    @Schema(description = "	运维责任人")
    @NotBlank(message = "	运维责任人不能为空")
    @Size(max=255, message="	运维责任人长度不能超过255个字符")
    private String specEqpStMaintainResponsible;

    @Schema(description = "维护检修记录")
    @Size(max=255, message="维护检修记录长度不能超过255个字符")
    private String specEqpStMaintainRecord;

    @Schema(description = "	异常及事故记录")
    @Size(max=255, message="	异常及事故记录长度不能超过255个字符")
    private String specEqpStAccidentRecord;

    @Schema(description = "	台账创建时间")
    @NotNull(message = "	台账创建时间不能为空")
    private LocalDate specEqpStCreateTime;

    @Schema(description = "	台账更新时间")
    @NotNull(message = "	台账更新时间不能为空")
    private LocalDate specEqpStUpLocalDate;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String specEqpStFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String specEqpStBackup1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String specEqpStBackup2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String specEqpStBackup3;


}
