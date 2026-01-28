package com.youlai.boot.ledger.model.query;


import io.swagger.v3.oas.annotations.media.Schema;

public class DvFlowmetreInfoQueryExport {
    @Schema(description = "仪表位号")
    private String tagNumber;
    @Schema(description = "仪表名称")
    private String instrumentName;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "设备类型")
    private String dvType;

}
