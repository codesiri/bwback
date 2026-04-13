package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.time.LocalDate;

/**
 * 电器日常巡检记录实体对象
 *
 * @author cc
 * @since 2026-03-03 09:40
 */
@Getter
@Setter
@TableName("electric_cabinet_record")
public class ElectricCabinetRecord  {

    private static final long serialVersionUID = 1L;

    @TableId
    private long id;
    /**
     * 巡检日期
     */
    private LocalDate ecrInspectDate;
    /**
     * 巡检人
     */
    private String ecrInspectPerson;
    /**
     * 巡检项目
     */
    private String ecrInspectItem;
    /**
     * 巡检结果
     */
    private String ecrInspectResult;
    /**
     * 问题描述
     */
    private String ecrProblemDesc;
    /**
     * 处理措施
     */
    private String ecrMeasure;
    /**
     * 处理人
     */
    private String ecrHandler;
    /**
     * 所属工厂
     */
    private String ecrFactory;
    /**
     * 备用1
     */
    @TableField("ecr_reserve_1")
    private String ecrReserve1;
    /**
     * 备用2
     */
    @TableField("ecr_reserve_2")
    private String ecrReserve2;
    /**
     * 备用3
     */
    @TableField("ecr_reserve_3")
    private String ecrReserve3;
}
