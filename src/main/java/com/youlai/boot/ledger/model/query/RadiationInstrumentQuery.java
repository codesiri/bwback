package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 放射仪分页查询对象
 *
 * @author baiwei
 * @since 2026-01-28 09:50
 */
@Schema(description ="放射仪查询对象")
@Getter
@Setter
public class RadiationInstrumentQuery extends BasePageQuery {
    @Schema(description = "设备名称")
    private String instrumentName;
    @Schema(description = "位号")
    private String tagNumber;
    @Schema(description = "设备状态")
    private Integer radioactiveStatus;
    @Schema(description = "所属工厂")
    private Integer factory;

}

