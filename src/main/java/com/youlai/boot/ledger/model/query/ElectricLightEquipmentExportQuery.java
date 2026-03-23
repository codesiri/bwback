package com.youlai.boot.ledger.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Schema(description ="电气照明设备导出对象")
@Getter
@Setter
public class ElectricLightEquipmentExportQuery {
    @Schema(description = "设备名称")
    private String eleLightName;
    @Schema(description = "生产厂家")
    private String eleManufacturer;
    @Schema(description = "投运日期")
    private List<String> eleCommissioningDate;
    @Schema(description = "上次维护日期")
    private List<String> eleLastMaintainDate;
    @Schema(description = "下次维护日期")
    private List<String> eleNextMaintainDate;
    @Schema(description = "	设备状态")
    private Integer eleStatus;
    @Schema(description = "所属工厂")
    private String eleFactory;
}
