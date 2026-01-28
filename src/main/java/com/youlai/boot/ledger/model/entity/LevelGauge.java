package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.io.Serializable;

/**
 * 液位计实体对象
 *
 * @author dazao
 * @since 2026-01-20 15:40
 */
@Getter
@Setter
@TableName("level_gauge")
public class LevelGauge implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private long id;
    /**
     * 装置名称
     */
    private String levelDevice;
    /**
     * 位号
     */
    private String levelTag;
    /**
     * 安装位置及用途
     */
    private String levelLocation;
    /**
     * 设备名称（液位计）
     */
    private String levelEquip;
    /**
     * 规格型号
     */
    private String levelModel;
    /**
     * 生产厂家
     */
    private String levelManu;
    /**
     * 介质
     */
    private String levelMedium;
    /**
     * 测量范围
     */
    private String levelRange;
    /**
     * 精度
     */
    private String levelAccuracy;
    /**
     * 电源
     */
    private String levelPower;
    /**
     * 输出信号
     */
    private String levelOutput;
    /**
     * 连接方式及规格
     */
    private String levelConnection;
    /**
     * 是否联锁（是 / 否）
     */
    private Integer levelInterlock;
    /**
     * 联锁设定值
     */
    private String levelInterlockVal;
    /**
     * 备注
     */
    private String levelRemark;
    /**
     * 设备状态
     */
    private Integer status;
    /**
     * 设备类型
     */
    private String dvType;
}
