package com.youlai.boot.ledger.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectricCabinetMainComponentExportQuery {
    @Schema(description = "元器件名称")
    private String ecmComponentName;
    @Schema(description = "规格型号")
    private String ecmSpecModel;
    @Schema(description = "生产厂家")
    private String ecmManufacturer;
    @Schema(description = "出厂编号")
    private String ecmFactoryNo;
    @Schema(description = "所属工厂")
    private String ecmFactory;
}
