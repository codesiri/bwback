package com.youlai.boot.ledger.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwitchValveExportQuery {
    @Schema(description = "位号")
    private String switchValveTag;
    @Schema(description = "设备状态")
    private String status;
    @Schema(description = "s设备类型")
    private String dvType;
    @Schema(description = "所属工厂")
    private String factory;
}
