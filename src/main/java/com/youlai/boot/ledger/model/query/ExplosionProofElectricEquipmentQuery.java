package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 防爆电气设备分页查询对象
 *
 * @author dazao
 * @since 2026-02-06 15:59
 */
@Schema(description ="防爆电气设备查询对象")
@Getter
@Setter
public class ExplosionProofElectricEquipmentQuery extends BasePageQuery {

    @Schema(description = "设备编号")
    private String equipmentCode;
    @Schema(description = "设备名称")
    private String equipmentName;
    @Schema(description = "投运日期")
    private List<String> commissioningDate;
    @Schema(description = "设备状态（在用 / 备用 / 停用 / 报废）")
    private String status;
    @Schema(description = "所属工厂")
    private String factory;
}
