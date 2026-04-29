package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 塔类分页查询对象
 *
 * @author baiwei
 * @since 2026-03-06 09:57
 */
@Schema(description ="塔类查询对象")
@Getter
@Setter
public class SpecEqpTowerAccountQuery extends BasePageQuery {

    @Schema(description = "塔类设备名称")
    private String specEqpTowerName;
    @Schema(description = "塔器类型")
    private String specEqpTowerType;
    @Schema(description = "设备状态")
    private Integer specEqpTowerStatus;
    @Schema(description = "所属工厂")
    private Integer specEqpTowerFactory;


}
