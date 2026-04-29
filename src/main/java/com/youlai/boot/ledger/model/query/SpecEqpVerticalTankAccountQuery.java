package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 立罐分页查询对象
 *
 * @author baiwei
 * @since 2026-03-06 10:04
 */
@Schema(description ="立罐查询对象")
@Getter
@Setter
public class SpecEqpVerticalTankAccountQuery extends BasePageQuery {
    @Schema(description = "立罐设备编码")
    private String specEqpVtCode;
    @Schema(description = "立罐名称")
    private String specEqpVtName;
    @Schema(description = "设备状态")
    private Integer specEqpVtStatus;
    @Schema(description = "所属工厂")
    private Integer specEqpVtFactory;
}
