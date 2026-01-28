package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 液位计分页查询对象
 *
 * @author dazao
 * @since 2026-01-20 15:40
 */
@Schema(description ="液位计查询对象")
@Getter
@Setter
public class LevelGaugeQuery extends BasePageQuery {

    @Schema(description = "位号")
    private String levelTag;
    @Schema(description = "设备名称（液位计）")
    private String levelEquip;
    @Schema(description = "是否联锁（是 / 否）")
    private Integer levelInterlock;
    @Schema(description = "设备类型")
    private String dvType;
}
