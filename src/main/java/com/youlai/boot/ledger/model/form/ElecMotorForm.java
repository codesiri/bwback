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
 * 电器电动机表单对象
 *
 * @author dazao
 * @since 2026-01-13 10:10
 */
@Getter
@Setter
@Schema(description = "电器电动机表单对象")
public class ElecMotorForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private long elecMotorId;
    @Schema(description = "位号")
    @NotBlank(message = "位号不能为空")
    @Size(max=255, message="位号长度不能超过255个字符")
    private String elecMotorTag;

    @Schema(description = "工艺名称")
    @NotBlank(message = "工艺名称不能为空")
    @Size(max=255, message="工艺名称长度不能超过255个字符")
    private String elecMotorProcess;

    @Schema(description = "型号")
    @NotBlank(message = "型号不能为空")
    @Size(max=255, message="型号长度不能超过255个字符")
    private String elecMotorModel;

    @Schema(description = "额定功率")
    @Size(max=255, message="额定功率长度不能超过255个字符")
    private String elecMotorRatedPower;

    @Schema(description = "额定电压")
    @Size(max=255, message="额定电压长度不能超过255个字符")
    private String elecMotorRatedVoltage;

    @Schema(description = "额定电流")
    @Size(max=255, message="额定电流长度不能超过255个字符")
    private String elecMotorRatedCurrent;

    @Schema(description = "额定频率")
    @Size(max=255, message="额定频率长度不能超过255个字符")
    private String elecMotorRatedFreq;

    @Schema(description = "转速")
    @Size(max=255, message="转速长度不能超过255个字符")
    private String elecMotorSpeed;

    @Schema(description = "功率因数")
    @Size(max=255, message="功率因数长度不能超过255个字符")
    private String elecMotorPowerFactor;

    @Schema(description = "工作效率")
    @Size(max=255, message="工作效率长度不能超过255个字符")
    private String elecMotorEfficiency;

    @Schema(description = "接线方式")
    @Size(max=255, message="接线方式长度不能超过255个字符")
    private String elecMotorWiringMode;

    @Schema(description = "轴承型号")
    @Size(max=255, message="轴承型号长度不能超过255个字符")
    private String elecMotorBearingModel;

    @Schema(description = "防爆标志")
    @Size(max=255, message="防爆标志长度不能超过255个字符")
    private String elecMotorExplosionMark;

    @Schema(description = "绝缘等级")
    @Size(max=255, message="绝缘等级长度不能超过255个字符")
    private String elecMotorInsulation;

    @Schema(description = "防护等级")
    @Size(max=255, message="防护等级长度不能超过255个字符")
    private String elecMotorProtection;

    @Schema(description = "工作制")
    @Size(max=255, message="工作制长度不能超过255个字符")
    private String elecMotorWorkSystem;

    @Schema(description = "出厂编号")
    @NotBlank(message = "出厂编号不能为空")
    @Size(max=255, message="出厂编号长度不能超过255个字符")
    private String elecMotorFactoryNo;

    @Schema(description = "重量（KG）")
    @Size(max=255, message="重量（KG）长度不能超过255个字符")
    private String elecMotorWeight;

    @Schema(description = "生产日期")
    @NotNull(message = "生产日期不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime elecMotorProdDate;

    @Schema(description = "生产厂家")
    @NotBlank(message = "生产厂家不能为空")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String elecMotorManufacturer;


}
