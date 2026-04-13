package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 抽屉柜抽屉单元明细分页查询对象
 *
 * @author youlaitech
 * @since 2026-03-17 09:40
 */
@Schema(description ="抽屉柜抽屉单元明细查询对象")
@Getter
@Setter
public class ElectricCabinetDrawerUnitQuery extends BasePageQuery {

    @Schema(description = "单元名称")
    private String ecduUnitName;
    @Schema(description = "开关型号")
    private String ecduSwitchModel;
    @Schema(description = "单元状态")
    private String ecduUnitStatus;
    @Schema(description = "所属工厂")
    private String ecduFactory;
}
