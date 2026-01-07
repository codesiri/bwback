package com.youlai.boot.ledger.model.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Schema(description ="温度查询对象修改")
@Getter
@Setter
public class DvTemperatureGaugeQueryPlus {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "页码", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private int pageNum = 1;

    @Schema(description = "每页记录数", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private int pageSize = 10;

}
