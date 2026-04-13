package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 抽屉柜主要元器件信息分页查询对象
 *
 * @author youlaitech
 * @since 2026-03-17 09:38
 */
@Schema(description ="抽屉柜主要元器件信息查询对象")
@Getter
@Setter
public class ElectricCabinetMainComponentQuery extends BasePageQuery {

    @Schema(description = "元器件名称")
    private String ecmComponentName;
    @Schema(description = "生产厂家")
    private String ecmManufacturer;
    @Schema(description = "	出厂编号")
    private String ecmFactoryNo;
}
