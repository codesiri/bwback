package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 抽屉柜变更记录分页查询对象
 *
 * @author dazao
 * @since 2026-03-13 11:16
 */
@Schema(description ="抽屉柜变更记录查询对象")
@Getter
@Setter
public class ElectricCabinetChangeQuery extends BasePageQuery {

    @Schema(description = "变更内容")
    private String eccChangeContent;
    @Schema(description = "变更实施人")
    private String eccImplementer;
    @Schema(description = "验收人")
    private String eccChecker;
    @Schema(description = "变更后状态")
    private String eccAfterStatus;
    @Schema(description = "所属工厂")
    private String eccFactory;
}
