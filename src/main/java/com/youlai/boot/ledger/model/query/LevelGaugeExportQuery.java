package com.youlai.boot.ledger.model.query;

import io.swagger.v3.oas.annotations.media.Schema;

public class LevelGaugeExportQuery {
    @Schema(description = "位号")
    private String levelTag;
    @Schema(description = "设备名称（液位计）")
    private String levelEquip;
    @Schema(description = "是否联锁（是 / 否）")
    private Integer levelInterlock;
    @Schema(description = "设备类型")
    private String dvType;

}
