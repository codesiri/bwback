package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 温度分页查询对象
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
@Schema(description ="温度查询对象")
@Getter
@Setter
//导出xlsx的查询条件
public class DvTemperatureGaugeQuery {
    String tagNumber;
    String status;
    String dvName;
}
