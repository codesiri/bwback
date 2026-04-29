package com.youlai.boot.ledger.model.entity;

import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.time.LocalDate;

/**
 * 抽屉柜维护保养记录实体对象
 *
 * @author c
 * @since 2026-04-16 14:43
 */
@Getter
@Setter
@TableName("electric_cabinet_maintenance")
public class ElectricCabinetMaintenance extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 保养日期
     */
    private LocalDate ecmMaintainDate;
    /**
     * 保养人员
     */
    private String ecmMaintainPerson;
    /**
     * 保养级别
     */
    private String ecmMaintainLevel;
    /**
     * 保养项目
     */
    private String ecmMaintainItem;
    /**
     * 保养内容
     */
    private String ecmMaintainContent;
    /**
     * 更换元器件
     */
    private String ecmReplaceComponent;
    /**
     * 保养结果
     */
    private String ecmMaintainResult;
    /**
     * 验收人
     */
    private String ecmChecker;
    /**
     * 下次保养日期
     */
    private LocalDate ecmNextMaintainDate;
    /**
     * 所属工厂
     */
    private String ecmFactory;
    /**
     * 备用1
     */
    private String ecmReserve1;
    /**
     * 备用2
     */
    private String ecmReserve2;
    /**
     * 备用3
     */
    private String ecmReserve3;
}
