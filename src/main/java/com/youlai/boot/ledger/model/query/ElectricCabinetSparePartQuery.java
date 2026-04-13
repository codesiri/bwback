package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 电器备品备件管理记录分页查询对象
 *
 * @author youlaitech
 * @since 2026-03-04 08:46
 */
@Schema(description ="电器备品备件管理记录查询对象")
@Getter
@Setter
public class ElectricCabinetSparePartQuery extends BasePageQuery {

    @Schema(description = "备件名称")
    private String ecspPartName;
    @Schema(description = "规格型号")
    private String ecspSpecModel;
    @Schema(description = "生产厂家")
    private String ecspManufacturer;
    @Schema(description = "入库日期")
    private List<String> ecspStockDate;
    @Schema(description = "领用日期")
    private List<String> ecspUsedDate;
    @Schema(description = "领用人")
    private String ecspUser;
    @Schema(description = "所属工厂")
    private String ecspFactory;
}
