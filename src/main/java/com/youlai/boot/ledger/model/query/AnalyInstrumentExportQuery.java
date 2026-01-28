package com.youlai.boot.ledger.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnalyInstrumentExportQuery {
    @Schema(description = "设备位号")
    private String analyInstrumentCode;
    @Schema(description = "设备类型")
    private String analyInstrumentType;
    @Schema(description = "设备大类")
    private String analyInstrumentBig;
    @Schema(description = "设备状态")
    private Integer analyInstrumentStatus;
    @Schema(description = "是否参与检测")
    private Integer analyInstrumentMonitor;
    @Schema(description = "是否参与联锁")
    private String analyInstrumentLock;
}
