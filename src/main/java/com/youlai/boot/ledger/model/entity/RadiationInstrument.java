package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 放射仪实体对象
 *
 * @author baiwei
 * @since 2026-01-28 09:50
 */
@Getter
@Setter
@TableName("radiation_instrument")
public class RadiationInstrument {

    private static final long serialVersionUID = 1L;

    @TableId
    private long id;

    /**
     * 装置名称
     */
    private String unitName;
    /**
     * 位号
     */
    private String tagNumber;
    /**
     * 仪表名称
     */
    private String instrumentName;
    /**
     * 射源位号
     */
    private String sourceTagNumber;
    /**
     * 射源形式
     */
    private String sourceForm;
    /**
     * 材质
     */
    private String material;
    /**
     * 强度
     */
    private String strength;
    /**
     * 供电
     */
    private String powerSupply;
    /**
     * 输出信号
     */
    private String outputSignal;
    /**
     * 测量范围
     */
    private String measuringRange;
    /**
     * 精度
     */
    private String accuracy;
    /**
     * 是否联锁（是 / 否）
     */
    private Integer whetherInterlocked;
    /**
     * 联锁设定值
     */
    private String interlockSetpoint;
    /**
     * 安装位置及用途
     */
    private String installationLocationAndPurpose;
    /**
     * 规格型号
     */
    private String specificationModel;
    /**
     * 生产厂家
     */
    private String manufacturer;
    /**
     * 状态
     */
    private Integer radioactiveStatus;
    /**
     * 所属工厂
     */
    private String factory;
}

