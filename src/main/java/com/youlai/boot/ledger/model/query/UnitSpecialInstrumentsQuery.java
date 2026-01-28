package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 机组特殊仪分页查询对象
 *
 * @author dazao
 * @since 2026-01-21 09:01
 */
@Schema(description ="机组特殊仪查询对象")
@Getter
@Setter
public class UnitSpecialInstrumentsQuery extends BasePageQuery {

    @Schema(description = "位号")
    private String tagNumber;
    @Schema(description = "仪表名称")
    private String instrumentName;
    @Schema(description = "设备状态")
    private Integer status;
}
