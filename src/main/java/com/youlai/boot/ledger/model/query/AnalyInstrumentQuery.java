package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 分析仪分页查询对象
 *
 * @author dazao
 * @since 2026-01-23 14:48
 */
@Schema(description ="分析仪查询对象")
@Getter
@Setter
public class AnalyInstrumentQuery extends BasePageQuery {

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
