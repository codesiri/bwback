package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 汽轮机分页查询对象
 *
 * @author baiwei
 * @since 2026-02-03 09:38
 */
@Schema(description ="汽轮机查询对象")
@Getter
@Setter
public class SpecEqpSteamTurbineAccountQuery extends BasePageQuery {
    @Schema(description = "设备名称")
    private String specEqpStName;
    @Schema(description = "设备类型")
    private String specEqpStStatus;
    @Schema(description = "设备状态")
    private Integer specEqpStFactory;
}
