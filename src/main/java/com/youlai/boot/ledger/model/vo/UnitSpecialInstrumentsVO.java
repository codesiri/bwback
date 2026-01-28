package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 机组特殊仪视图对象
 *
 * @author dazao
 * @since 2026-01-21 09:01
 */
@Getter
@Setter
@Schema( description = "机组特殊仪视图对象")
public class UnitSpecialInstrumentsVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "位号")
    private String tagNumber;
    @Schema(description = "仪表名称")
    private String instrumentName;
    @Schema(description = "设备名称")
    private String deviceName;
    @Schema(description = "装置")
    private String device;
    @Schema(description = "安装位置及用途")
    private String installationLocation;
    @Schema(description = "规格型号")
    private String specificationModel;
    @Schema(description = "量程")
    private String measurementRange;
    @Schema(description = "数量")
    private String quantity;
    @Schema(description = "厂家")
    private String manufacturer;
    @Schema(description = "编号")
    private String unitSpecialCode;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "设备类型")
    private String dvType;
}
