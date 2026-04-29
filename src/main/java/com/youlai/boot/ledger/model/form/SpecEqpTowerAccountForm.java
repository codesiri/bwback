package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
/**
 * 塔类表单对象
 *
 * @author baiwei
 * @since 2026-03-06 09:57
 */
@Getter
@Setter
@Schema(description = "塔类表单对象")
public class SpecEqpTowerAccountForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "塔类设备编码")
    @NotBlank(message = "塔类设备编码不能为空")
    @Size(max=255, message="塔类设备编码长度不能超过255个字符")
    private String specEqpTowerCode;

    @Schema(description = "塔类设备名称")
    @NotBlank(message = "塔类设备名称不能为空")
    @Size(max=255, message="塔类设备名称长度不能超过255个字符")
    private String specEqpTowerName;

    @Schema(description = "所在区域")
    @NotBlank(message = "所在区域不能为空")
    @Size(max=255, message="所在区域长度不能超过255个字符")
    private String specEqpTowerArea;

    @Schema(description = "塔类设备型号")
    @NotBlank(message = "塔类设备型号不能为空")
    @Size(max=255, message="塔类设备型号长度不能超过255个字符")
    private String specEqpTowerModel;

    @Schema(description = "塔器类型")
    @NotBlank(message = "塔器类型不能为空")
    @Size(max=255, message="塔器类型长度不能超过255个字符")
    private String specEqpTowerType;

    @Schema(description = "塔体材质")
    @NotBlank(message = "塔体材质不能为空")
    @Size(max=255, message="塔体材质长度不能超过255个字符")
    private String specEqpTowerMaterial;

    @Schema(description = "塔体总高度（m）")
    @NotBlank(message = "塔体总高度（m）不能为空")
    @Size(max=255, message="塔体总高度（m）长度不能超过255个字符")
    private String specEqpTowerHeight;

    @Schema(description = "塔体公称直径（m）")
    @NotBlank(message = "塔体公称直径（m）不能为空")
    @Size(max=255, message="塔体公称直径（m）长度不能超过255个字符")
    private String specEqpTowerDiameter;

    @Schema(description = "塔板层数 / 填料高度（层 /m）")
    @NotBlank(message = "塔板层数 / 填料高度（层 /m）不能为空")
    @Size(max=255, message="塔板层数 / 填料高度（层 /m）长度不能超过255个字符")
    private String specEqpTowerLayer;

    @Schema(description = "设计压力（MPa）")
    @NotBlank(message = "设计压力（MPa）不能为空")
    @Size(max=255, message="设计压力（MPa）长度不能超过255个字符")
    private String specEqpTowerDesignPressure;

    @Schema(description = "设计温度（℃）")
    @NotBlank(message = "设计温度（℃）不能为空")
    @Size(max=255, message="设计温度（℃）长度不能超过255个字符")
    private String specEqpTowerDesignTemp;

    @Schema(description = "处理介质")
    @NotBlank(message = "处理介质不能为空")
    @Size(max=255, message="处理介质长度不能超过255个字符")
    private String specEqpTowerMedia;

    @Schema(description = "介质特性")
    @NotBlank(message = "介质特性不能为空")
    @Size(max=255, message="介质特性长度不能超过255个字符")
    private String specEqpTowerMediaProperty;

    @Schema(description = "制造厂家")
    @NotBlank(message = "制造厂家不能为空")
    @Size(max=255, message="制造厂家长度不能超过255个字符")
    private String specEqpTowerManufacturer;

    @Schema(description = "出厂编号")
    @NotBlank(message = "出厂编号不能为空")
    @Size(max=255, message="出厂编号长度不能超过255个字符")
    private String specEqpTowerFactoryNo;

    @Schema(description = "制造日期")
    @NotNull(message = "制造日期不能为空")
    private LocalDate specEqpTowerProduceDate;

    @Schema(description = "安装单位")
    @NotBlank(message = "安装单位不能为空")
    @Size(max=255, message="安装单位长度不能超过255个字符")
    private String specEqpTowerInstallCompany;

    @Schema(description = "安装日期")
    @NotNull(message = "安装日期不能为空")
    private LocalDate specEqpTowerInstallDate;

    @Schema(description = "验收日期")
    @NotNull(message = "验收日期不能为空")
    private LocalDate specEqpTowerAcceptanceDate;

    @Schema(description = "投用日期")
    @NotNull(message = "投用日期不能为空")
    private LocalDate specEqpTowerUsageDate;

    @Schema(description = "特种设备使用登记")
    @NotBlank(message = "特种设备使用登记不能为空")
    @Size(max=255, message="特种设备使用登记长度不能超过255个字符")
    private String specEqpTowerLicenseNo;

    @Schema(description = "设备状态")
    @NotBlank(message = "设备状态不能为空")
    @Size(max=255, message="设备状态长度不能超过255个字符")
    private String specEqpTowerStatus;

    @Schema(description = "上次检验日期")
    private LocalDate specEqpTowerLastInspectDate;

    @Schema(description = "下次检验日期")
    @NotNull(message = "下次检验日期不能为空")
    private LocalDate specEqpTowerNextInspectDate;

    @Schema(description = "检验机构")
    @Size(max=255, message="检验机构长度不能超过255个字符")
    private String specEqpTowerInspectCompany;

    @Schema(description = "运维负责人")
    @NotBlank(message = "运维负责人不能为空")
    @Size(max=255, message="运维负责人长度不能超过255个字符")
    private String specEqpTowerMaintainResponsible;

    @Schema(description = "最后一次维护记录")
    @Size(max=255, message="最后一次维护记录长度不能超过255个字符")
    private String specEqpTowerMaintainRecord;

    @Schema(description = "事故记录")
    @Size(max=255, message="事故记录长度不能超过255个字符")
    private String specEqpTowerAccidentRecord;

    @Schema(description = "创建时间")
    @NotNull(message = "创建时间不能为空")
    private LocalDate specEqpTowerCreateTime;

    @Schema(description = "更新时间")
    @NotNull(message = "更新时间不能为空")
    private LocalDate specEqpTowerUpdateTime;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String specEqpTowerFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String specEqpTowerBackup1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String specEqpTowerBackup2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String specEqpTowerBackup3;


}
