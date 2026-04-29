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
 * 抽屉柜变更记录实体对象
 *
 * @author dazao
 * @since 2026-03-13 11:16
 */
@Getter
@Setter
@TableName("electric_cabinet_change")
public class ElectricCabinetChange {

    private static final long serialVersionUID = 1L;
    @TableId
    private long id;
    /**
     * 变更日期
     */
    private LocalDate eccChangeDate;
    /**
     * 变更申请人
     */
    private String eccApplicant;
    /**
     * 变更原因
     */
    private String eccChangeReason;
    /**
     * 变更内容
     */
    private String eccChangeContent;
    /**
     * 变更实施人
     */
    private String eccImplementer;
    /**
     * 验收人
     */
    private String eccChecker;
    /**
     * 变更后状态
     */
    private String eccAfterStatus;
    /**
     * 相关资料更新情况
     */
    private LocalDateTime eccDataUpdate;
    /**
     * 所属工厂
     */
    private String eccFactory;
    /**
     * 备用1
     */
    @TableField("ecc_reserve_1")
    private String eccReserve1;
    /**
     * 备用2
     */
    @TableField("ecc_reserve_1")
    private String eccReserve2;
    /**
     * 备用3
     */
    @TableField("ecc_reserve_1")
    private String eccReserve3;
}
