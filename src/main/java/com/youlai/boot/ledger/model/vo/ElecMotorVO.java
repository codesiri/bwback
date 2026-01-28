package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 电器电动机视图对象
 *
 * @author dazao
 * @since 2026-01-13 10:10
 */
@Getter
@Setter
@Schema( description = "电器电动机视图对象")
public class ElecMotorVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "位号")
    private String elecMotorTag;
    @Schema(description = "工艺名称")
    private String elecMotorProcess;
    @Schema(description = "型号")
    private String elecMotorModel;
    @Schema(description = "额定功率")
    private String elecMotorRatedPower;
    @Schema(description = "额定电压")
    private String elecMotorRatedVoltage;
    @Schema(description = "额定电流")
    private String elecMotorRatedCurrent;
    @Schema(description = "额定频率")
    private String elecMotorRatedFreq;
    @Schema(description = "转速")
    private String elecMotorSpeed;
    @Schema(description = "功率因数")
    private String elecMotorPowerFactor;
    @Schema(description = "工作效率")
    private String elecMotorEfficiency;
    @Schema(description = "接线方式")
    private String elecMotorWiringMode;
    @Schema(description = "轴承型号")
    private String elecMotorBearingModel;
    @Schema(description = "防爆标志")
    private String elecMotorExplosionMark;
    @Schema(description = "绝缘等级")
    private String elecMotorInsulation;
    @Schema(description = "防护等级")
    private String elecMotorProtection;
    @Schema(description = "工作制")
    private String elecMotorWorkSystem;
    @Schema(description = "出厂编号")
    private String elecMotorFactoryNo;
    @Schema(description = "重量（KG）")
    private String elecMotorWeight;
    @Schema(description = "生产日期")
    private LocalDateTime elecMotorProdDate;
    @Schema(description = "生产厂家")
    private String elecMotorManufacturer;
}
