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
 * 电器备品备件管理记录实体对象
 *
 * @author youlaitech
 * @since 2026-03-04 08:46
 */
@Getter
@Setter
@TableName("electric_cabinet_spare_part")
public class ElectricCabinetSparePart  {

    private static final long serialVersionUID = 1L;

    @TableId
    private long id;

    /**
     * 备件名称
     */
    private String ecspPartName;
    /**
     * 规格型号
     */
    private String ecspSpecModel;
    /**
     * 对应柜体 / 抽屉
     */
    private String ecspCorrespondingCabinet;
    /**
     * 额定参数
     */
    private String ecspRatedParameters;
    /**
     * 生产厂家
     */
    private String ecspManufacturer;
    /**
     * 库存数量
     */
    private String ecspStockQuantity;
    /**
     * 入库日期
     */
    private LocalDate ecspStockDate;
    /**
     * 领用数量
     */
    private String ecspUsedQuantity;
    /**
     * 领用日期
     */
    private LocalDateTime ecspUsedDate;
    /**
     * 领用原因
     */
    private String ecspUsedReason;
    /**
     * 领用人
     */
    private String ecspUser;
    /**
     * 补充日期
     */
    private LocalDate ecspSupplementDate;
    /**
     * 所属工厂
     */
    private String ecspFactory;
    /**
     * 备用1
     */
    @TableField("ecsp_reserve_1")
    private String ecspReserve1;
    /**
     * 备用2
     */
    @TableField("ecsp_reserve_2")
    private String ecspReserve2;
    /**
     * 备用3
     */
    @TableField("ecsp_reserve_3")
    private String ecspReserve3;
}
