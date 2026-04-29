package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 抽屉柜维护保养记录视图对象
 *
 * @author c
 * @since 2026-04-16 14:43
 */
@Getter
@Setter
@Schema( description = "抽屉柜维护保养记录视图对象")
public class ElectricCabinetMaintenanceVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "保养日期")
    private LocalDate ecmMaintainDate;
    @Schema(description = "保养人员")
    private String ecmMaintainPerson;
    @Schema(description = "保养级别")
    private String ecmMaintainLevel;
    @Schema(description = "保养项目")
    private String ecmMaintainItem;
    @Schema(description = "保养内容")
    private String ecmMaintainContent;
    @Schema(description = "更换元器件")
    private String ecmReplaceComponent;
    @Schema(description = "保养结果")
    private String ecmMaintainResult;
    @Schema(description = "验收人")
    private String ecmChecker;
    @Schema(description = "下次保养日期")
    private LocalDate ecmNextMaintainDate;
    @Schema(description = "所属工厂")
    private String ecmFactory;
    @Schema(description = "备用1")
    private String ecmReserve1;
    @Schema(description = "备用2")
    private String ecmReserve2;
    @Schema(description = "备用3")
    private String ecmReserve3;
}
