package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 抽屉柜故障维修记录实体对象
 *
 * @author youlaitech
 * @since 2026-03-23 17:05
 */
@Getter
@Setter
@TableName("electric_cabinet_fault")
public class ElectricCabinetFault {

    private static final long serialVersionUID = 1L;

    @TableId
    private  long id;
    /**
     * 故障日期
     */
    private LocalDate ecfFaultDate;
    /**
     * 故障发生时间
     */
    private LocalDate ecfFaultTime;
    /**
     * 故障柜体 / 抽屉编号
     */
    private String ecfFaultCabinet;
    /**
     * 故障现象
     */
    private String ecfFaultPhenomenon;
    /**
     * 故障原因分析
     */
    private String ecfFaultReason;
    /**
     * 维修人员
     */
    private String ecfRepairPerson;
    /**
     * 维修方案
     */
    private String ecfRepairScheme;
    /**
     * 更换元器件
     */
    private String ecfReplaceComponent;
    /**
     * 维修完成时间
     */
    private LocalDateTime ecfRepairCompleteTime;
    /**
     * 	恢复运行时间
     */
    private LocalDateTime ecfRecoverTime;
    /**
     * 维修结果
     */
    private String ecfRepairResult;
    /**
     * 验收人
     */
    private String ecfChecker;
    /**
     * 故障分类
     */
    private String ecfFaultType;
    /**
     * 所属工厂
     */
    private String ecfFactory;
    /**
     * 备用1
     */
    @TableField("ecf_reserve_1")
    private String ecfReserve1;
    /**
     * 备用2
     */
    @TableField("ecf_reserve_2")
    private String ecfReserve2;
    /**
     * 备用3
     */
    @TableField("ecf_reserve_3")
    private String ecfReserve3;
}
