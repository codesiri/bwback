package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 电器电动机分页查询对象
 *
 * @author dazao
 * @since 2026-01-13 10:10
 */
@Schema(description ="电器电动机查询对象")
@Getter
@Setter
public class ElecMotorQuery extends BasePageQuery {

    @Schema(description = "位号")
    private String elecMotorTag;
    @Schema(description = "生产日期")
    private List<String> elecMotorProdDate;
    @Schema(description = "生产厂家")
    private String elecMotorManufacturer;
}
