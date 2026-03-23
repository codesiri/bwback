package com.youlai.boot.ledger.model.query;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class ElecMotorExportQuery {
    @Schema(description = "位号")
    private String elecMotorTag;
    @Schema(description = "生产日期")
    private List<String> elecMotorProdDate;
    @Schema(description = "生产厂家")
    private String elecMotorManufacturer;
}
