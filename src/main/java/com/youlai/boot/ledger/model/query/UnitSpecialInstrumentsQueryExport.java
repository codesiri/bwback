package com.youlai.boot.ledger.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description ="机组特殊仪导出查询对象")
@Getter
@Setter
public class UnitSpecialInstrumentsQueryExport {
    @Schema(description = "位号")
    private String tagNumber;
    @Schema(description = "仪表名称")
    private String instrumentName;
    @Schema(description = "设备状态")
    private Integer status;
}
