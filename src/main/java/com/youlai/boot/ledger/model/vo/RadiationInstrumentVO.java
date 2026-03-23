package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 放射仪视图对象
 *
 * @author baiwei
 * @since 2026-01-28 09:50
 */
@Getter
@Setter
@Schema( description = "放射仪视图对象")
public class RadiationInstrumentVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "装置名称")
    private String unitName;
    @Schema(description = "位号")
    private String tagNumber;
    @Schema(description = "仪表名称")
    private String instrumentName;
    @Schema(description = "射源位号")
    private String sourceTagNumber;
    @Schema(description = "射源形式")
    private String sourceForm;
    @Schema(description = "材质")
    private String material;
    @Schema(description = "强度")
    private String strength;
    @Schema(description = "供电")
    private String powerSupply;
    @Schema(description = "输出信号")
    private String outputSignal;
    @Schema(description = "测量范围")
    private String measuringRange;
    @Schema(description = "精度")
    private String accuracy;
    @Schema(description = "是否联锁（是 / 否）")
    private Integer whetherInterlocked;
    @Schema(description = "联锁设定值")
    private String interlockSetpoint;
    @Schema(description = "安装位置及用途")
    private String installationLocationAndPurpose;
    @Schema(description = "规格型号")
    private String specificationModel;
    @Schema(description = "生产厂家")
    private String manufacturer;
    @Schema(description = "状态")
    private Integer radioactiveStatus;
    @Schema(description = "所属工厂")
    private String factory;
}

