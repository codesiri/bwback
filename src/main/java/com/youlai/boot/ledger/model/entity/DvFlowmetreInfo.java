package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.io.Serializable;

/**
 * 流量计实体对象
 *
 * @author dazao
 * @since 2026-01-09 09:04
 */
@Getter
@Setter
@TableName("dv_flowmetre_info")
public class DvFlowmetreInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private long id;
    /**
     * 仪表位号
     */
    private String tagNumber;
    /**
     * 装置
     */
    private String device;
    /**
     * 用途
     */
    private String purpose;
    /**
     * 仪表名称
     */
    private String instrumentName;
    /**
     * 量程
     */
    private String measurementRange;
    /**
     * 厂家
     */
    private String manufacturer;
    /**
     * 工艺介质-介质
     */
    private String medium;
    /**
     * 工艺介质-状态
     */
    private Integer mediumStatus;
    /**
     * 工艺介质-压力
     */
    private String mediumPressure;
    /**
     * 工艺介质-温度
     */
    private String mediumTemperature;
    /**
     * 出厂编号
     */
    private String factoryNumber;
    /**
     * 备注
     */
    private String remark;
    /**
     * 设备状态
     */
    private Integer status;
    /**
     * 设备类型
     */
    private String dvType;
}
