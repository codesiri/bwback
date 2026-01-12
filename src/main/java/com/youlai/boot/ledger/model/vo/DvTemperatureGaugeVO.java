package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 温度视图对象
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
@Getter
@Setter
@Schema( description = "温度视图对象")
public class DvTemperatureGaugeVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键id")
    private Long id;
    @Schema(description = "装置名称")
    private String deviceName;
    @Schema(description = "位号")
    private String tagNumber;
    @Schema(description = "安装位置以及用途")
    private String installationLocationAndPurpose;
    @Schema(description = "设备名称")
    private String deviceNameSuffix;
    @Schema(description = "分度号")
    private String indexNumber;
    @Schema(description = "规格型号")
    private String specificationModel;
    @Schema(description = "生产厂家")
    private String manufacturer;
    @Schema(description = "测量范围")
    private String measurementRange;
    @Schema(description = "插入深度")
    private String insertionDepth;
    @Schema(description = "连接方式及规格")
    private String connectionMethodAndSpecifications;
    @Schema(description = "精度")
    private String precision;
    @Schema(description = "套管规格和及材质")
    private String casingSpecificationsAndMaterial;
    @Schema(description = "是否带连锁")
    private int interlocked;
    @Schema(description = "联锁设定值")
    private String interlockSetValue;
    @Schema(description = "备注")
    private String remark;
    @Schema(description = "设备类型")
    private String dvType;
    @Schema(description = "设备状态")
    private int status;
    @Schema(description = "所属工厂")
    private String factory;
}
