package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 机组特殊仪实体对象
 *
 * @author dazao
 * @since 2026-01-21 09:01
 */
@Getter
@Setter
@TableName("unit_special_instruments")
public class UnitSpecialInstruments {

    private static final long serialVersionUID = 1L;

    @TableId
    private long id;
    /**
     * 位号
     */
    private String tagNumber;
    /**
     * 仪表名称
     */
    private String instrumentName;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 装置
     */
    private String device;
    /**
     * 安装位置及用途
     */
    private String installationLocation;
    /**
     * 规格型号
     */
    private String specificationModel;
    /**
     * 量程
     */
    private String measurementRange;
    /**
     * 数量
     */
    private String quantity;
    /**
     * 厂家
     */
    private String manufacturer;

    /**
     * 编号
     */
    private String unitSpecialCode;
    /**
     * 设备状态
     */
    private Integer status;
    /**
     * 设备类型
     */
    private String dvType;
}
