package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 防爆电气设备表单对象
 *
 * @author dazao
 * @since 2026-02-06 15:59
 */
@Getter
@Setter
@Schema(description = "防爆电气设备表单对象")
public class ExplosionProofElectricEquipmentForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "设备编号")
    @NotBlank(message = "设备编号不能为空")
    @Size(max=255, message="设备编号长度不能超过255个字符")
    private String equipmentCode;

    @Schema(description = "设备名称")
    @NotBlank(message = "设备名称不能为空")
    @Size(max=255, message="设备名称长度不能超过255个字符")
    private String equipmentName;

    @Schema(description = "规格型号")
    @NotBlank(message = "规格型号不能为空")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String specModel;

    @Schema(description = "防爆标志（如 Ex d IIB T4 Gb）")
    @NotBlank(message = "防爆标志（如 Ex d IIB T4 Gb）不能为空")
    @Size(max=255, message="防爆标志（如 Ex d IIB T4 Gb）长度不能超过255个字符")
    private String exMark;

    @Schema(description = "防爆合格证号")
    @NotBlank(message = "防爆合格证号不能为空")
    @Size(max=255, message="防爆合格证号长度不能超过255个字符")
    private String exCertNo;

    @Schema(description = "防爆合格证有效期")
    @NotBlank(message = "防爆合格证有效期不能为空")
    @Size(max=255, message="防爆合格证有效期长度不能超过255个字符")
    private String exCertExpire;

    @Schema(description = "温度组别")
    @Size(max=255, message="温度组别长度不能超过255个字符")
    private String tempClass;

    @Schema(description = "适用爆炸性介质")
    @Size(max=255, message="适用爆炸性介质长度不能超过255个字符")
    private String applicableMedium;

    @Schema(description = "安装位置及危险区域等级")
    @NotBlank(message = "安装位置及危险区域等级不能为空")
    @Size(max=255, message="安装位置及危险区域等级长度不能超过255个字符")
    private String installArea;

    @Schema(description = "生产厂家")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String manufacturer;

    @Schema(description = "投运日期")
    @NotNull(message = "投运日期不能为空")
    private LocalDate commissioningDate;

    @Schema(description = "接地电阻测试值（Ω）")
    @Size(max=255, message="接地电阻测试值（Ω）长度不能超过255个字符")
    private String groundResistance;

    @Schema(description = "上次防爆检查日期")
    private LocalDate lastExCheckDate;

    @Schema(description = "下次防爆检查日期")
    private LocalDate nextExCheckDate;

    @Schema(description = "设备状态（在用 / 备用 / 停用 / 报废）")
    @NotBlank(message = "设备状态（在用 / 备用 / 停用 / 报废）不能为空")
    @Size(max=255, message="设备状态（在用 / 备用 / 停用 / 报废）长度不能超过255个字符")
    private String status;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String factory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String reserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String reserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String reserve3;


}
