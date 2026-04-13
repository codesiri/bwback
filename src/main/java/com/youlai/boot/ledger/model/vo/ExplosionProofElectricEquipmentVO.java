package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 防爆电气设备视图对象
 *
 * @author dazao
 * @since 2026-02-06 15:59
 */
@Getter
@Setter
@Schema( description = "防爆电气设备视图对象")
public class ExplosionProofElectricEquipmentVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "设备编号")
    private String equipmentCode;
    @Schema(description = "设备名称")
    private String equipmentName;
    @Schema(description = "规格型号")
    private String specModel;
    @Schema(description = "防爆标志（如 Ex d IIB T4 Gb）")
    private String exMark;
    @Schema(description = "防爆合格证号")
    private String exCertNo;
    @Schema(description = "防爆合格证有效期")
    private String exCertExpire;
    @Schema(description = "温度组别")
    private String tempClass;
    @Schema(description = "适用爆炸性介质")
    private String applicableMedium;
    @Schema(description = "安装位置及危险区域等级")
    private String installArea;
    @Schema(description = "生产厂家")
    private String manufacturer;
    @Schema(description = "投运日期")
    private LocalDate commissioningDate;
    @Schema(description = "接地电阻测试值（Ω）")
    private String groundResistance;
    @Schema(description = "上次防爆检查日期")
    private LocalDate lastExCheckDate;
    @Schema(description = "下次防爆检查日期")
    private LocalDate nextExCheckDate;
    @Schema(description = "设备状态（在用 / 备用 / 停用 / 报废）")
    private String status;
    @Schema(description = "所属工厂")
    private String factory;
    @Schema(description = "备用1")
    private String reserve1;
    @Schema(description = "备用2")
    private String reserve2;
    @Schema(description = "备用3")
    private String reserve3;
}
