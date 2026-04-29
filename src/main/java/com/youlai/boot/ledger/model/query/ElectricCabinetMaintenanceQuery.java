package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 抽屉柜维护保养记录分页查询对象
 *
 * @author c
 * @since 2026-04-16 14:43
 */
@Schema(description ="抽屉柜维护保养记录查询对象")
@Getter
@Setter
public class ElectricCabinetMaintenanceQuery extends BasePageQuery {

}
