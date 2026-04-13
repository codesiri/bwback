package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.time.LocalDate;

/**
 * 抽屉柜主要元器件信息实体对象
 *
 * @author youlaitech
 * @since 2026-03-17 09:38
 */
@Getter
@Setter
@TableName("electric_cabinet_main_component")
public class ElectricCabinetMainComponent {

    private static final long serialVersionUID = 1L;

    @TableId
    private long id;

    /**
     * 元器件名称
     */
    private String ecmComponentName;
    /**
     * 规格型号
     */
    private String ecmSpecModel;
    /**
     * 生产厂家
     */
    private String ecmManufacturer;
    /**
     * 	出厂编号
     */
    private String ecmFactoryNo;
    /**
     * 安装位置
     */
    private String ecmInstallLocation;
    /**
     * 投运日期
     */
    private LocalDate ecmCommissioningDate;
    /**
     * 额定参数
     */
    private String ecmRatedParameters;
    /**
     * 所属工厂
     */
    private String ecmFactory;
    /**
     * 备用1
     */
    @TableField("ecm_reserve_1")
    private String ecmReserve1;
    /**
     * 备用2
     */
    @TableField("ecm_reserve_2")
    private String ecmReserve2;
    /**
     * 备用3
     */
    @TableField("ecm_reserve_3")
    private String ecmReserve3;
}
