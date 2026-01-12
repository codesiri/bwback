package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 差压流量计分页查询对象
 *
 * @author dazao
 * @since 2026-01-08 16:41
 */
@Schema(description ="差压流量计查询对象")
@Getter
@Setter
public class DpFlowMeterQuery extends BasePageQuery {

    @Schema(description = "位号")
    private String dpFlowTag;
    @Schema(description = "是否伴热（是 / 否）")
    private Integer dpFlowHeat;
    @Schema(description = "是否联锁（是 / 否）")
    private Integer dpFlowInterlock;
    @Schema(description = "设备编码")
    private String dvCode;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "设备类型")
    private String dvType;
}
