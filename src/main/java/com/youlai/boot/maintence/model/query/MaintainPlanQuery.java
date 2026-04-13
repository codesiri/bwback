package com.youlai.boot.maintence.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

/**
 * 维修计划分页查询对象
 *
 * @author youlaitech
 * @since 2026-04-10 08:37
 */
@Schema(description ="维修计划查询对象")
@Getter
@Setter
public class MaintainPlanQuery extends BasePageQuery {

    @Schema(description = "计划类型")
    private String maintainPlanType;
    @Schema(description = "计划年度")
    private Integer maintainPlanYear;
    @Schema(description = "计划月份")
    private Integer maintainPlanMonth;
    @Schema(description = "设备编号")
    private String maintainPlanEquipCode;
    @Schema(description = "设备名称")
    private String maintainPlanEquipName;
    @Schema(description = "设备类型")
    private String maintainPlanEquipType;
    @Schema(description = "维修/检修内容")
    private String maintainPlanContent;
    @Schema(description = "计划执行日期")
    private List<String> maintainPlanScheduleDate;
    @Schema(description = "计划时长")
    private BigDecimal maintainPlanDuration;
    @Schema(description = "负责部门")
    private String maintainPlanDept;
    @Schema(description = "负责人")
    private String maintainPlanPerson;
    @Schema(description = "安全风险等级")
    private String maintainPlanSafetyLevel;
    @Schema(description = "安全防护措施")
    private String maintainPlanSafetyMeasure;
    @Schema(description = "计划状态")
    private String maintainPlanStatus;
    @Schema(description = "实际执行日期")
    private List<String> maintainPlanActualDate;
}
