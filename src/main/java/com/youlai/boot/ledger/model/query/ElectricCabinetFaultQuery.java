package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 抽屉柜故障维修记录分页查询对象
 *
 * @author youlaitech
 * @since 2026-03-23 17:05
 */
@Schema(description ="抽屉柜故障维修记录查询对象")
@Getter
@Setter
public class ElectricCabinetFaultQuery extends BasePageQuery {

    @Schema(description = "故障日期")
    private List<String> ecfFaultDate;
    @Schema(description = "故障发生时间")
    private List<String> ecfFaultTime;
    @Schema(description = "故障柜体 / 抽屉编号")
    private String ecfFaultCabinet;
    @Schema(description = "维修人员")
    private String ecfRepairPerson;
    @Schema(description = "维修完成时间")
    private List<String> ecfRepairCompleteTime;
    @Schema(description = "	恢复运行时间")
    private List<String> ecfRecoverTime;
    @Schema(description = "验收人")
    private String ecfChecker;
    @Schema(description = "故障分类")
    private String ecfFaultType;
    @Schema(description = "所属工厂")
    private String ecfFactory;
}
