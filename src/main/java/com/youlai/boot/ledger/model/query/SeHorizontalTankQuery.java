package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 卧罐分页查询对象
 *
 * @author baiwei
 * @since 2026-03-06 09:33
 */
@Schema(description ="卧罐查询对象")
@Getter
@Setter
public class SeHorizontalTankQuery extends BasePageQuery {

    @Schema(description = "卧罐设备编号")
    private String seHtankEquipCode;
    @Schema(description = "卧罐名称")
    private String seHtankName;
    @Schema(description = "设备状态")
    private String seHtankStatus;
    @Schema(description = "所属工厂")
    private String seHtankFactory;

}
