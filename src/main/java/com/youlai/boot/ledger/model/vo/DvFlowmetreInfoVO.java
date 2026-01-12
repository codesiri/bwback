package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 流量计视图对象
 *
 * @author dazao
 * @since 2026-01-09 09:04
 */
@Getter
@Setter
@Schema( description = "流量计视图对象")
public class DvFlowmetreInfoVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Schema(description = "id")
    private long id;

    @Schema(description = "仪表位号")
    private String tagNumber;
    @Schema(description = "装置")
    private String device;
    @Schema(description = "用途")
    private String purpose;
    @Schema(description = "仪表名称")
    private String instrumentName;
    @Schema(description = "量程")
    private String measurementRange;
    @Schema(description = "厂家")
    private String manufacturer;
    @Schema(description = "工艺介质-介质")
    private String medium;
    @Schema(description = "工艺介质-状态")
    private Integer mediumStatus;
    @Schema(description = "工艺介质-压力")
    private String mediumPressure;
    @Schema(description = "工艺介质-温度")
    private String mediumTemperature;
    @Schema(description = "出厂编号")
    private String factoryNumber;
    @Schema(description = "备注")
    private String remark;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "设备类型")
    private String dvType;
}
