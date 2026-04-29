package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 起重运输类分页查询对象
 *
 * @author baiwei
 * @since 2026-02-03 09:22
 */
@Schema(description ="起重运输类查询对象")
@Getter
@Setter
public class SpecEqpCraneTransAccountQuery extends BasePageQuery {

    @Schema(description = "设备名称")
    private String specEqpCtName;
    @Schema(description = "设备类型")
    private String specEqpCtType;
    @Schema(description = "设备状态")
    private Integer specEqpCtStatus;

}
