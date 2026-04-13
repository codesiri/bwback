package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 抽屉柜检修试验记录分页查询对象
 *
 * @author youlaitech
 * @since 2026-03-18 16:19
 */
@Schema(description ="抽屉柜检修试验记录查询对象")
@Getter
@Setter
public class ElectricCabinetInspectionQuery extends BasePageQuery {

    @Schema(description = "报告编号")
    private String eciReportNo;
    @Schema(description = "检修 / 试验日期")
    private List<String> eciInspectDate;
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
    @Schema(description = "所属工厂")
    private String eciFactory;
}
