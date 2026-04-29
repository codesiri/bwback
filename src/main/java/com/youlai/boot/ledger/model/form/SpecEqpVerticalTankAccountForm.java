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
 * 立罐表单对象
 *
 * @author baiwei
 * @since 2026-03-06 10:04
 */
@Getter
@Setter
@Schema(description = "立罐表单对象")
public class SpecEqpVerticalTankAccountForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "立罐设备编码")
    @NotBlank(message = "立罐设备编码不能为空")
    @Size(max=255, message="立罐设备编码长度不能超过255个字符")
    private String specEqpVtCode;

    @Schema(description = "立罐名称")
    @NotBlank(message = "立罐名称不能为空")
    @Size(max=255, message="立罐名称长度不能超过255个字符")
    private String specEqpVtName;

    @Schema(description = "所在区域")
    @NotBlank(message = "所在区域不能为空")
    @Size(max=255, message="所在区域长度不能超过255个字符")
    private String specEqpVtArea;

    @Schema(description = "立罐型号")
    @NotBlank(message = "立罐型号不能为空")
    @Size(max=255, message="立罐型号长度不能超过255个字符")
    private String specEqpVtModel;

    @Schema(description = "罐体材质")
    @NotBlank(message = "罐体材质不能为空")
    @Size(max=255, message="罐体材质长度不能超过255个字符")
    private String specEqpVtMaterial;

    @Schema(description = "设计容积（m³）")
    @NotBlank(message = "设计容积（m³）不能为空")
    @Size(max=255, message="设计容积（m³）长度不能超过255个字符")
    private String specEqpVtVolume;

    @Schema(description = "设计压力（MPa）")
    @NotBlank(message = "设计压力（MPa）不能为空")
    @Size(max=255, message="设计压力（MPa）长度不能超过255个字符")
    private String specEqpVtDesignPressure;

    @Schema(description = "设计温度（℃）")
    @NotBlank(message = "设计温度（℃）不能为空")
    @Size(max=255, message="设计温度（℃）长度不能超过255个字符")
    private String specEqpVtDesignTemp;

    @Schema(description = "储存介质")
    @NotBlank(message = "储存介质不能为空")
    @Size(max=255, message="储存介质长度不能超过255个字符")
    private String specEqpVtMedia;

    @Schema(description = "介质特性")
    @NotBlank(message = "介质特性不能为空")
    @Size(max=255, message="介质特性长度不能超过255个字符")
    private String specEqpVtMediaProperty;

    @Schema(description = "制造厂家")
    @NotBlank(message = "制造厂家不能为空")
    @Size(max=255, message="制造厂家长度不能超过255个字符")
    private String specEqpVtManufacturer;

    @Schema(description = "出厂编号")
    @NotBlank(message = "出厂编号不能为空")
    @Size(max=255, message="出厂编号长度不能超过255个字符")
    private String specEqpVtFactoryNo;

    @Schema(description = "制造日期")
    @NotNull(message = "制造日期不能为空")
    private LocalDate specEqpVtProduceDate;

    @Schema(description = "安装单位")
    @NotBlank(message = "安装单位不能为空")
    @Size(max=255, message="安装单位长度不能超过255个字符")
    private String specEqpVtInstallCompany;

    @Schema(description = "安装日期")
    @NotNull(message = "安装日期不能为空")
    private LocalDate specEqpVtInstallDate;

    @Schema(description = "验收日期")
    @NotNull(message = "验收日期不能为空")
    private LocalDate specEqpVtAcceptanceDate;

    @Schema(description = "投用日期")
    @NotNull(message = "投用日期不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime specEqpVtUsageDate;

    @Schema(description = "特种设备使用登记")
    @NotNull(message = "特种设备使用登记不能为空")
    private Integer specEqpVtLicenseNo;

    @Schema(description = "设备状态")
    @NotBlank(message = "设备状态不能为空")
    @Size(max=255, message="设备状态长度不能超过255个字符")
    private String specEqpVtStatus;

    @Schema(description = "上次检验日期")
    private LocalDate specEqpVtLastInspectDate;

    @Schema(description = "下次检验日期")
    private LocalDate specEqpVtNextInspectDate;

    @Schema(description = "检验机构")
    @Size(max=255, message="检验机构长度不能超过255个字符")
    private String specEqpVtInspectCompany;

    @Schema(description = "运维责任人")
    @NotBlank(message = "运维责任人不能为空")
    @Size(max=255, message="运维责任人长度不能超过255个字符")
    private String specEqpVtMaintainResponsible;

    @Schema(description = "最后一次维护记录")
    @Size(max=255, message="最后一次维护记录长度不能超过255个字符")
    private String specEqpVtMaintainRecord;

    @Schema(description = "事故记录")
    @Size(max=255, message="事故记录长度不能超过255个字符")
    private String specEqpVtAccidentRecord;

    @Schema(description = "创建时间")
    @NotNull(message = "创建时间不能为空")
    private LocalDate specEqpVtCreateTime;

    @Schema(description = "更新时间")
    @NotNull(message = "更新时间不能为空")
    private LocalDate specEqpVtUpdateTime;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String specEqpVtFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String specEqpVtBackup1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String specEqpVtBackup2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String specEqpVtBackup3;


}
