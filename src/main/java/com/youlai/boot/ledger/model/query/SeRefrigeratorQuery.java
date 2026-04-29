package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 特种设备制冷机台账分页查询对象
 *
 * @author baiwei
 * @since 2026-02-14 08:38
 */
@Schema(description ="特种设备制冷机台账查询对象")
@Getter
@Setter
public class SeRefrigeratorQuery extends BasePageQuery {

    @Schema(description = "制冷机设备编号")
    private String seRefrigeratorEquipCode;
    @Schema(description = "制冷机设备名称")
    private String seRefrigeratorName;
    @Schema(description = "设备状态")
    private Integer seRefrigeratorStatus;
    @Schema(description = "所属工厂")
    private Integer seRefrigeratorFactory;

}
