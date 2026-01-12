package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 差压流量计视图对象
 *
 * @author dazao
 * @since 2026-01-08 16:41
 */
@Getter
@Setter
@Schema( description = "差压流量计视图对象")
public class DpFlowMeterVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "装置名称")
    private String dpFlowDevice;
    @Schema(description = "位号")
    private String dpFlowTag;
    @Schema(description = "安装位置及用途")
    private String dpFlowLocation;
    @Schema(description = "设备名称（差压流量计）")
    private String dpFlowEquip;
    @Schema(description = "规格型号")
    private String dpFlowModel;
    @Schema(description = "生产厂家")
    private String dpFlowManu;
    @Schema(description = "量程")
    private String dpFlowRange;
    @Schema(description = "测量范围")
    private String dpFlowMeasRange;
    @Schema(description = "介质名称")
    private String dpFlowMedName;
    @Schema(description = "介质设计温度")
    private String dpFlowMedTemp;
    @Schema(description = "介质设计力（MPa）")
    private String dpFlowMedPress;
    @Schema(description = "连接方式及规格")
    private String dpFlowConnection;
    @Schema(description = "精度")
    private String dpFlowAccuracy;
    @Schema(description = "是否伴热（是 / 否）")
    private Integer dpFlowHeat;
    @Schema(description = "是否联锁（是 / 否）")
    private Integer dpFlowInterlock;
    @Schema(description = "联锁设定值")
    private String dpFlowInterlockVal;
    @Schema(description = "备注")
    private String dpFlowRemark;
    @Schema(description = "设备编码")
    private String dvCode;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "设备类型")
    private String dvType;
}
