package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 球罐分页查询对象
 *
 * @author baiwei
 * @since 2026-03-06 09:49
 */
@Schema(description ="球罐查询对象")
@Getter
@Setter
public class SeSphericalTankQuery extends BasePageQuery {


    @Schema(description = "球罐名称")
    private String seTankName;
    @Schema(description = "设备状态")
    private Integer seTankStatus;
    @Schema(description = "所属工厂")
    private Integer seTankFactory;

}
