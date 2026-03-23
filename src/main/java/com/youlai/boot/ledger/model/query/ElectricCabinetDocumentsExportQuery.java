package com.youlai.boot.ledger.model.query;

import io.swagger.v3.oas.annotations.media.Schema;

public class ElectricCabinetDocumentsExportQuery {
    @Schema(description = "资料名称")
    private String ecdDocName;
    @Schema(description = "资料类型")
    private String ecdDocType;
    @Schema(description = "	编号")
    private String ecdDocNo;
    @Schema(description = "所属工厂")
    private String ecdFactory;
}
