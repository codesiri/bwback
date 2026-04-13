package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 电器电缆线路分页查询对象
 *
 * @author dazao
 * @since 2026-03-05 08:45
 */
@Schema(description ="电器电缆线路查询对象")
@Getter
@Setter
public class CableLineEquipmentQuery extends BasePageQuery {

    @Schema(description = "电缆编号")
    private String cleCableCode;
    @Schema(description = "电缆名称")
    private String cleCableName;
    @Schema(description = "规格型号")
    private String cleSpecModel;
    @Schema(description = "生产厂家")
    private String cleManufacturer;
    @Schema(description = "所属工厂")
    private String cleFactory;
}
