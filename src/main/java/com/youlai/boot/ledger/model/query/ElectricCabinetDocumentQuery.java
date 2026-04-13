package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 抽屉柜相关资料归档分页查询对象
 *
 * @author dazao
 * @since 2026-03-12 09:11
 */
@Schema(description ="抽屉柜相关资料归档查询对象")
@Getter
@Setter
public class ElectricCabinetDocumentQuery extends BasePageQuery {

    @Schema(description = "资料名称")
    private String ecdDocName;
    @Schema(description = "资料类型")
    private String ecdDocType;
    @Schema(description = "	编号")
    private String ecdDocNo;
    @Schema(description = "所属工厂")
    private String ecdFactory;
}
