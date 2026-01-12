package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 静设备分页查询对象
 *
 * @author dazao
 * @since 2026-01-08 08:37
 */
@Schema(description ="静设备查询对象")
@Getter
@Setter
public class StaticEquipQuery extends BasePageQuery {

    @Schema(description = "设备名称")
    private String staticEquipName;
    @Schema(description = "位号")
    private String staticEquipTag;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "设备编码")
    private String dvCode;
}
