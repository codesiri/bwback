package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 电器日常巡检记录视图对象
 *
 * @author cc
 * @since 2026-03-03 09:40
 */
@Getter
@Setter
@Schema( description = "电器日常巡检记录视图对象")
public class ElectricCabinetRecordVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "巡检日期")
    private LocalDate ecrInspectDate;
    @Schema(description = "巡检人")
    private String ecrInspectPerson;
    @Schema(description = "巡检项目")
    private String ecrInspectItem;
    @Schema(description = "巡检结果")
    private String ecrInspectResult;
    @Schema(description = "问题描述")
    private String ecrProblemDesc;
    @Schema(description = "处理措施")
    private String ecrMeasure;
    @Schema(description = "处理人")
    private String ecrHandler;
    @Schema(description = "所属工厂")
    private String ecrFactory;
    @Schema(description = "备用1")
    private String ecrReserve1;
    @Schema(description = "备用2")
    private String ecrReserve2;
    @Schema(description = "备用3")
    private String ecrReserve3;
}
