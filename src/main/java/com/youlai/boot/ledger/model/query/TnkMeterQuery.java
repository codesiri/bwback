package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 罐区仪分页查询对象
 *
 * @author dazao
 * @since 2026-01-20 08:17
 */
@Schema(description ="罐区仪查询对象")
@Getter
@Setter
public class TnkMeterQuery extends BasePageQuery {

    @Schema(description = "仪表位号")
    private String tnkMeterTag;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "设备类型")
    private String dvType;
}
