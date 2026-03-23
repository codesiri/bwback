package com.youlai.boot.ledger.model.query;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class ElectricCabinetSparePartExportQuery {
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
