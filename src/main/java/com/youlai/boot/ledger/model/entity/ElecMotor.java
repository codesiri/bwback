package com.youlai.boot.ledger.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 电器电动机实体对象
 *
 * @author dazao
 * @since 2026-01-13 10:10
 */
@Getter
@Setter
@TableName("elec_motor")
public class ElecMotor extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    private Long elecMotorId;
    /**
     * 位号
     */
    private String elecMotorTag;
    /**
     * 工艺名称
     */
    private String elecMotorProcess;
    /**
     * 型号
     */
    private String elecMotorModel;
    /**
     * 额定功率
     */
    private String elecMotorRatedPower;
    /**
     * 额定电压
     */
    private String elecMotorRatedVoltage;
    /**
     * 额定电流
     */
    private String elecMotorRatedCurrent;
    /**
     * 额定频率
     */
    private String elecMotorRatedFreq;
    /**
     * 转速
     */
    private String elecMotorSpeed;
    /**
     * 功率因数
     */
    private String elecMotorPowerFactor;
    /**
     * 工作效率
     */
    private String elecMotorEfficiency;
    /**
     * 接线方式
     */
    private String elecMotorWiringMode;
    /**
     * 轴承型号
     */
    private String elecMotorBearingModel;
    /**
     * 防爆标志
     */
    private String elecMotorExplosionMark;
    /**
     * 绝缘等级
     */
    private String elecMotorInsulation;
    /**
     * 防护等级
     */
    private String elecMotorProtection;
    /**
     * 工作制
     */
    private String elecMotorWorkSystem;
    /**
     * 出厂编号
     */
    private String elecMotorFactoryNo;
    /**
     * 重量（KG）
     */
    private String elecMotorWeight;
    /**
     * 生产日期
     */
    private LocalDateTime elecMotorProdDate;
    /**
     * 生产厂家
     */
    private String elecMotorManufacturer;
}
