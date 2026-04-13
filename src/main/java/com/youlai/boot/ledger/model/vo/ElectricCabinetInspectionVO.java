package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 抽屉柜检修试验记录视图对象
 *
 * @author youlaitech
 * @since 2026-03-18 16:19
 */
@Getter
@Setter
@Schema( description = "抽屉柜检修试验记录视图对象")
public class ElectricCabinetInspectionVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "报告编号")
    private String eciReportNo;
    @Schema(description = "检修 / 试验日期")
    private LocalDate eciInspectDate;
    @Schema(description = "检修 / 试验单位")
    private String eciInspectUnit;
    @Schema(description = "检修 / 试验人员")
    private String eciInspectPerson;
    @Schema(description = "检修 / 试验类型")
    private String eciInspectType;
    @Schema(description = "检修 / 试验项目")
    private String eciInspectItem;
    @Schema(description = "试验数据")
    private String eciTestData;
    @Schema(description = "合格标准")
    private String eciStandard;
    @Schema(description = "结果判定")
    private String eciResult;
    @Schema(description = "整改内容")
    private String eciRectifyContent;
    @Schema(description = "复检结果")
    private String eciRecheckResult;
    @Schema(description = "所属工厂")
    private String eciFactory;
    @Schema(description = "备用1")
    private String eciReserve1;
    @Schema(description = "备用2")
    private String eciReserve2;
    @Schema(description = "备用3")
    private String eciReserve3;
}
