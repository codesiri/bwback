package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 抽屉柜故障维修记录视图对象
 *
 * @author youlaitech
 * @since 2026-03-23 17:05
 */
@Getter
@Setter
@Schema( description = "抽屉柜故障维修记录视图对象")
public class ElectricCabinetFaultVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "故障日期")
    private LocalDate ecfFaultDate;
    @Schema(description = "故障发生时间")
    private LocalDate ecfFaultTime;
    @Schema(description = "故障柜体 / 抽屉编号")
    private String ecfFaultCabinet;
    @Schema(description = "故障现象")
    private String ecfFaultPhenomenon;
    @Schema(description = "故障原因分析")
    private String ecfFaultReason;
    @Schema(description = "维修人员")
    private String ecfRepairPerson;
    @Schema(description = "维修方案")
    private String ecfRepairScheme;
    @Schema(description = "更换元器件")
    private String ecfReplaceComponent;
    @Schema(description = "维修完成时间")
    private LocalDateTime ecfRepairCompleteTime;
    @Schema(description = "	恢复运行时间")
    private LocalDateTime ecfRecoverTime;
    @Schema(description = "维修结果")
    private String ecfRepairResult;
    @Schema(description = "验收人")
    private String ecfChecker;
    @Schema(description = "故障分类")
    private String ecfFaultType;
    @Schema(description = "所属工厂")
    private String ecfFactory;
    @Schema(description = "备用1")
    private String ecfReserve1;
    @Schema(description = "备用2")
    private String ecfReserve2;
    @Schema(description = "备用3")
    private String ecfReserve3;
}
