package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 罐区仪实体对象
 *
 * @author dazao
 * @since 2026-01-20 08:17
 */
@Getter
@Setter
@TableName("tnk_meter")
public class TnkMeter implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    long id;

    /**
     * 仪表位号
     */
    private String tnkMeterTag;
    /**
     * 装置
     */
    private String tnkMeterDev;
    /**
     * 用途
     */
    private String tnkMeterPurp;
    /**
     * 回路分类
     */
    private String tnkMeterLoop;
    /**
     * 仪表名称
     */
    private String tnkMeterName;
    /**
     * 型号
     */
    private String tnkMeterModel;
    /**
     * 规格
     */
    private String tnkMeterSpec;
    /**
     * 量程
     */
    private String tnkMeterRange;
    /**
     * 厂家
     */
    private String tnkMeterManu;
    /**
     * 测量值
     */
    private String tnkMeterMeas;
    /**
     * 工艺介质
     */
    private String tnkMeterMedProc;
    /**
     * 介质状态
     */
    private Integer tnkMeterMedStat;
    /**
     * 压力（Kpa）
     */
    private String tnkMeterPress;
    /**
     * 温度（℃）
     */
    private String tnkMeterTemp;
    /**
     * 公称通径
     */
    private String tnkMeterNomDia;
    /**
     * 故障压力
     */
    private String tnkMeterFaultPress;
    /**
     * 泄露状态
     */
    private Integer tnkMeterLeakStat;
    /**
     * 等级
     */
    private String tnkMeterLeakLv;
    /**
     * 检查时间
     */
    private LocalDateTime tnkMeterChkTime;
    /**
     * 检查周期
     */
    private String tnkMeterChkCycle;
    /**
     * 出厂编号
     */
    private String tnkMeterFactoryNo;
    /**
     * 备注
     */
    private String tnkMeterRemark;
    /**
     * 设备状态
     */
    private Integer status;
    /**
     * 设备类型
     */
    private String dvType;
}
