package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 电气照明设备视图对象
 *
 * @author dazao
 * @since 2026-02-04 09:24
 */
@Getter
@Setter
@Schema( description = "电气照明设备视图对象")
public class ElectricLightEquipmentVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "照明设备编号")
    private String eleLightCode;
    @Schema(description = "设备名称")
    private String eleLightName;
    @Schema(description = "规格型号")
    private String eleSpecModel;
    @Schema(description = "防爆标志")
    private String eleExMark;
    @Schema(description = "防爆合格证号（仅防爆区域照明设备填写）")
    private Integer eleExCertNo;
    @Schema(description = "防爆合格证有效期（仅防爆区域照明设备填写）")
    private String eleExCertExpire;
    @Schema(description = "额定功率（W）")
    private String eleRatedPower;
    @Schema(description = "额定电压（如 AC220V、DC36V、AC380V）")
    private String eleRatedVoltage;
    @Schema(description = "安装位置及危险区域等级")
    private String eleInstallArea;
    @Schema(description = "安装高度（m）")
    private Double eleInstallHeight;
    @Schema(description = "生产厂家")
    private String eleManufacturer;
    @Schema(description = "投运日期")
    private LocalDateTime eleCommissioningDate;
    @Schema(description = "上次维护日期")
    private LocalDateTime eleLastMaintainDate;
    @Schema(description = "下次维护日期")
    private LocalDateTime eleNextMaintainDate;
    @Schema(description = "是否为应急照明（0 = 否，1 = 是）")
    private String eleIsEmergency;
    @Schema(description = "	设备状态")
    private Integer eleStatus;
    @Schema(description = "所属工厂")
    private String eleFactory;
    @Schema(description = "备用1")
    private String eleReserve1;
    @Schema(description = "备用2")
    private String eleReserve2;
    @Schema(description = "备用3")
    private String eleReserve3;
}
