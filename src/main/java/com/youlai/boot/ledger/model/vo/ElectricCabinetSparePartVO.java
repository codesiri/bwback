package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 电器备品备件管理记录视图对象
 *
 * @author youlaitech
 * @since 2026-03-04 08:46
 */
@Getter
@Setter
@Schema( description = "电器备品备件管理记录视图对象")
public class ElectricCabinetSparePartVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "备件名称")
    private String ecspPartName;
    @Schema(description = "规格型号")
    private String ecspSpecModel;
    @Schema(description = "对应柜体 / 抽屉")
    private String ecspCorrespondingCabinet;
    @Schema(description = "额定参数")
    private String ecspRatedParameters;
    @Schema(description = "生产厂家")
    private String ecspManufacturer;
    @Schema(description = "库存数量")
    private String ecspStockQuantity;
    @Schema(description = "入库日期")
    private LocalDate ecspStockDate;
    @Schema(description = "领用数量")
    private String ecspUsedQuantity;
    @Schema(description = "领用日期")
    private LocalDateTime ecspUsedDate;
    @Schema(description = "领用原因")
    private String ecspUsedReason;
    @Schema(description = "领用人")
    private String ecspUser;
    @Schema(description = "补充日期")
    private LocalDate ecspSupplementDate;
    @Schema(description = "所属工厂")
    private String ecspFactory;
}
