package com.youlai.boot.maintence.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 维修计划实体对象
 *
 * @author youlaitech
 * @since 2026-04-10 08:37
 */
@Getter
@Setter
@TableName("maintain_plan")
public class MaintainPlan {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    /**
     * 计划类型
     */
    private String maintainPlanType;
    /**
     * 计划年度
     */
    private Integer maintainPlanYear;
    /**
     * 计划月份
     */
    private Integer maintainPlanMonth;
    /**
     * 设备编号
     */
    private String maintainPlanEquipCode;
    /**
     * 设备名称
     */
    private String maintainPlanEquipName;
    /**
     * 设备类型
     */
    private String maintainPlanEquipType;
    /**
     * 维修/检修内容
     */
    private String maintainPlanContent;
    /**
     * 计划执行日期
     */
    private LocalDate maintainPlanScheduleDate;
    /**
     * 计划时长
     */
    private BigDecimal maintainPlanDuration;
    /**
     * 负责部门
     */
    private String maintainPlanDept;
    /**
     * 负责人
     */
    private String maintainPlanPerson;
    /**
     * 安全风险等级
     */
    private String maintainPlanSafetyLevel;
    /**
     * 安全防护措施
     */
    private String maintainPlanSafetyMeasure;
    /**
     * 计划状态
     */
    private String maintainPlanStatus;
    /**
     * 实际执行日期
     */
    private LocalDate maintainPlanActualDate;
}
