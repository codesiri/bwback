package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * 电气照明设备表单对象
 *
 * @author dazao
 * @since 2026-02-04 09:24
 */
@Getter
@Setter
@Schema(description = "电气照明设备表单对象")
public class ElectricLightEquipmentForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "照明设备编号")
    @NotBlank(message = "照明设备编号不能为空")
    @Size(max=255, message="照明设备编号长度不能超过255个字符")
    private String eleLightCode;

    @Schema(description = "设备名称")
    @NotBlank(message = "设备名称不能为空")
    @Size(max=255, message="设备名称长度不能超过255个字符")
    private String eleLightName;

    @Schema(description = "规格型号")
    @NotBlank(message = "规格型号不能为空")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String eleSpecModel;

    @Schema(description = "防爆标志")
    @Size(max=255, message="防爆标志长度不能超过255个字符")
    private String eleExMark;

    @Schema(description = "防爆合格证号（仅防爆区域照明设备填写）")
    private Integer eleExCertNo;

    @Schema(description = "防爆合格证有效期（仅防爆区域照明设备填写）")
    @Size(max=255, message="防爆合格证有效期（仅防爆区域照明设备填写）长度不能超过255个字符")
    private String eleExCertExpire;

    @Schema(description = "额定功率（W）")
    @NotBlank(message = "额定功率（W）不能为空")
    @Size(max=255, message="额定功率（W）长度不能超过255个字符")
    private String eleRatedPower;

    @Schema(description = "额定电压（如 AC220V、DC36V、AC380V）")
    @NotBlank(message = "额定电压（如 AC220V、DC36V、AC380V）不能为空")
    @Size(max=255, message="额定电压（如 AC220V、DC36V、AC380V）长度不能超过255个字符")
    private String eleRatedVoltage;

    @Schema(description = "安装位置及危险区域等级")
    @NotBlank(message = "安装位置及危险区域等级不能为空")
    @Size(max=255, message="安装位置及危险区域等级长度不能超过255个字符")
    private String eleInstallArea;

    @Schema(description = "安装高度（m）")
    private Double eleInstallHeight;

    @Schema(description = "生产厂家")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String eleManufacturer;

    @Schema(description = "投运日期")
    @NotNull(message = "投运日期不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eleCommissioningDate;

    @Schema(description = "上次维护日期")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eleLastMaintainDate;

    @Schema(description = "下次维护日期")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eleNextMaintainDate;

    @Schema(description = "是否为应急照明（0 = 否，1 = 是）")
    @NotBlank(message = "是否为应急照明（0 = 否，1 = 是）不能为空")
    @Size(max=255, message="是否为应急照明（0 = 否，1 = 是）长度不能超过255个字符")
    private String eleIsEmergency;

    @Schema(description = "	设备状态")
    @NotNull(message = "	设备状态不能为空")
    private Integer eleStatus;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String eleFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String eleReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String eleReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String eleReserve3;


}
