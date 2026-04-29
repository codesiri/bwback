package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;

import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 起重运输类表单对象
 *
 * @author baiwei
 * @since 2026-02-03 09:22
 */
@Getter
@Setter
@Schema(description = "起重运输类表单对象")
public class SpecEqpCraneTransAccountForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "设备编码")
    @NotBlank(message = "设备编码不能为空")
    @Size(max=255, message="设备编码长度不能超过255个字符")
    private String specEqpCtCode;

    @Schema(description = "设备名称")
    @NotBlank(message = "设备名称不能为空")
    @Size(max=255, message="设备名称长度不能超过255个字符")
    private String specEqpCtName;

    @Schema(description = "安装 / 使用区域、工段")
    @NotBlank(message = "安装 / 使用区域、工段不能为空")
    @Size(max=255, message="安装 / 使用区域、工段长度不能超过255个字符")
    private String specEqpCtArea;

    @Schema(description = "设备型号")
    @NotBlank(message = "设备型号不能为空")
    @Size(max=255, message="设备型号长度不能超过255个字符")
    private String specEqpCtModel;

    @Schema(description = "设备类型")
    @NotBlank(message = "设备类型不能为空")
    @Size(max=255, message="设备类型长度不能超过255个字符")
    private String specEqpCtType;

    @Schema(description = "额定起重量（t）")
    @NotBlank(message = "额定起重量（t）不能为空")
    @Size(max=255, message="额定起重量（t）长度不能超过255个字符")
    private String specEqpCtLiftingCapacity;

    @Schema(description = "额定起升高度（m）")
    @NotBlank(message = "额定起升高度（m）不能为空")
    @Size(max=255, message="额定起升高度（m）长度不能超过255个字符")
    private String specEqpCtLiftingHeight;

    @Schema(description = "起重机跨度（m）")
    @Size(max=255, message="起重机跨度（m）长度不能超过255个字符")
    private String specEqpCtSpan;

    @Schema(description = "设计压力")
    @Size(max=255, message="设计压力长度不能超过255个字符")
    private String specEqpCtDesignPressure;

    @Schema(description = "制造厂家")
    @NotBlank(message = "制造厂家不能为空")
    @Size(max=255, message="制造厂家长度不能超过255个字符")
    private String specEqpCtManufacturer;

    @Schema(description = "出厂编号")
    @NotBlank(message = "出厂编号不能为空")
    @Size(max=255, message="出厂编号长度不能超过255个字符")
    private String specEqpCtFactoryNo;

    @Schema(description = "制造日期")
    @NotNull(message = "制造日期不能为空")
    private LocalDate specEqpCtProduceDate;

    @Schema(description = "安装单位")
    @NotBlank(message = "安装单位不能为空")
    @Size(max=255, message="安装单位长度不能超过255个字符")
    private String specEqpCtInstallCompany;

    @Schema(description = "安装日期")
    @NotNull(message = "安装日期不能为空")
    private LocalDate specEqpCtInstallDate;

    @Schema(description = "验收日期")
    @NotNull(message = "验收日期不能为空")
    private LocalDate specEqpCtAcceptanceDate;

    @Schema(description = "投用日期")
    @NotNull(message = "投用日期不能为空")
    private LocalDate specEqpCtUsageDate;

    @Schema(description = "特种设备使用登记")
    @NotBlank(message = "特种设备使用登记不能为空")
    @Size(max=255, message="特种设备使用登记长度不能超过255个字符")
    private String specEqpCtLicenseNo;

    @Schema(description = "设备状态")
    @NotBlank(message = "设备状态不能为空")
    @Size(max=255, message="设备状态长度不能超过255个字符")
    private String specEqpCtStatus;

    @Schema(description = "上次检验日期")
    private LocalDate specEqpCtLastInspectDate;

    @Schema(description = "下次检验日期")
    @NotNull(message = "下次检验日期不能为空")
    private LocalDate specEqpCtNextInspectDate;

    @Schema(description = "检验机构")
    @Size(max=255, message="检验机构长度不能超过255个字符")
    private String specEqpCtInspectCompany;

    @Schema(description = "运维责任人")
    @NotBlank(message = "运维责任人不能为空")
    @Size(max=255, message="运维责任人长度不能超过255个字符")
    private String specEqpCtMaintainResponsible;

    @Schema(description = "维护检修记录")
    @Size(max=255, message="维护检修记录长度不能超过255个字符")
    private String specEqpCtMaintainRecord;

    @Schema(description = "异常及事故记录")
    @Size(max=255, message="异常及事故记录长度不能超过255个字符")
    private String specEqpCtAccidentRecord;

    @Schema(description = "台账创建时间")
    @NotNull(message = "台账创建时间不能为空")
    private LocalDate specEqpCtCreateTime;

    @Schema(description = "台账更新时间")
    @NotNull(message = "台账更新时间不能为空")
    private LocalDate specEqpCtUpLocalDate;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String specEqpCtFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String specEqpCtBackup1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String specEqpCtBackup2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String specEqpCtBackup3;


}
