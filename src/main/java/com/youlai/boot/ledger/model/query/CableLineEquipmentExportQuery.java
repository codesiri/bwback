package com.youlai.boot.ledger.model.query;

import io.swagger.v3.oas.annotations.media.Schema;

public class CableLineEquipmentExportQuery {    @Schema(description = "电缆编号")
private String cleCableCode;
    @Schema(description = "电缆名称")
    private String cleCableName;
    @Schema(description = "规格型号")
    private String cleSpecModel;
    @Schema(description = "生产厂家")
    private String cleManufacturer;
    @Schema(description = "所属工厂")
    private String cleFactory;
}
