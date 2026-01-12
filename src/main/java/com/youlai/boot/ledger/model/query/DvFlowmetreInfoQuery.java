package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 流量计分页查询对象
 *
 * @author dazao
 * @since 2026-01-09 09:04
 */
@Schema(description ="流量计查询对象")
@Getter
@Setter
public class DvFlowmetreInfoQuery extends BasePageQuery {

    @Schema(description = "仪表位号")
    private String tagNumber;
    @Schema(description = "仪表名称")
    private String instrumentName;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "设备类型")
    private String dvType;
}
