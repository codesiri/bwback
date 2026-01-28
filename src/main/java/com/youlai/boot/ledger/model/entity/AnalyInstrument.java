package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 分析仪实体对象
 *
 * @author dazao
 * @since 2026-01-23 14:48
 */
@Getter
@Setter
@TableName("analy_instrument")
public class AnalyInstrument {

    private static final long serialVersionUID = 1L;

    @TableId
    private long id;

    /**
     * 设备位号
     */
    private String analyInstrumentCode;
    /**
     * 用途(原设备用途)
     */
    private String analyInstrumentPurpose;
    /**
     * 所属部门
     */
    private String analyInstrumentDept;
    /**
     * 设备类型
     */
    private String analyInstrumentType;
    /**
     * 设备大类
     */
    private String analyInstrumentBig;
    /**
     * 设备状态
     */
    private Integer analyInstrumentStatus;
    /**
     * 装置
     */
    private String analyInstrumentPlant;
    /**
     * 单元
     */
    private String analyInstrumentUnit;
    /**
     * 是否参与检测
     */
    private Integer analyInstrumentMonitor;
    /**
     * 是否参与联锁
     */
    private String analyInstrumentLock;
    /**
     * 联锁值
     */
    private String analyInstrumentLinkVal;
    /**
     * 报警值
     */
    private String analyInstrumentAlarmVal;
    /**
     * 设备名称
     */
    private String analyInstrumentName;
    /**
     * 工艺介质
     */
    private String analyInstrumentProcess;
    /**
     * 操作温度
     */
    private String analyInstrumentOpTemp;
    /**
     * 操作压力
     */
    private String analyInstrumentOpPress;
    /**
     * 测量范围
     */
    private String analyInstrumentRange;
    /**
     * 单位
     */
    private String analyInstrumentMeasUnit;
    /**
     * 台件数
     */
    private String analyInstrumentSet;
    /**
     * 回路数
     */
    private String analyInstrumentCircuit;
    /**
     * 供应商
     */
    private String analyInstrumentSupplier;
    /**
     * 生产日期
     */
    private LocalDateTime analyInstrumentProdDate;
    /**
     * 投用日期
     */
    private LocalDateTime analyInstrumentUseDate;
    /**
     * 质保日期
     */
    private LocalDateTime analyInstrumentGuaranteeDate;
    /**
     * 是否质保期内(0/1)
     */
    private Integer analyInstrumentMaintainFlag;
    /**
     * 润滑周期
     */
    private String analyInstrumentLubePeriod;
    /**
     * 润滑日期
     */
    private LocalDateTime analyInstrumentLubeDate;
    /**
     * 供电电压
     */
    private String analyInstrumentVoltage;
    /**
     * 防爆等级
     */
    private String analyInstrumentExplosion;
    /**
     * 防护等级
     */
    private String analyInstrumentProtection;
    /**
     * 生产厂家
     */
    private String analyInstrumentManufacturer;
    /**
     * 规格型号
     */
    private String analyInstrumentSpec;
    /**
     * 定修时间
     */
    private LocalDateTime analyInstrumentCalibDate;
}
