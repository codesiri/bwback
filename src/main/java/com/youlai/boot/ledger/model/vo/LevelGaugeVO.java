package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 液位计视图对象
 *
 * @author dazao
 * @since 2026-01-20 15:40
 */
@Getter
@Setter
@Schema( description = "液位计视图对象")
public class LevelGaugeVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "装置名称")
    private String levelDevice;
    @Schema(description = "位号")
    private String levelTag;
    @Schema(description = "安装位置及用途")
    private String levelLocation;
    @Schema(description = "设备名称（液位计）")
    private String levelEquip;
    @Schema(description = "规格型号")
    private String levelModel;
    @Schema(description = "生产厂家")
    private String levelManu;
    @Schema(description = "介质")
    private String levelMedium;
    @Schema(description = "测量范围")
    private String levelRange;
    @Schema(description = "精度")
    private String levelAccuracy;
    @Schema(description = "电源")
    private String levelPower;
    @Schema(description = "输出信号")
    private String levelOutput;
    @Schema(description = "连接方式及规格")
    private String levelConnection;
    @Schema(description = "是否联锁（是 / 否）")
    private Integer levelInterlock;
    @Schema(description = "联锁设定值")
    private String levelInterlockVal;
    @Schema(description = "备注")
    private String levelRemark;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "设备类型")
    private String dvType;
}
