package com.youlai.boot.ledger.model.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 汽轮机实体对象
 *
 * @author baiwei
 * @since 2026-02-03 09:38
 */
@Getter
@Setter
@TableName("spec_eqp_steam_turbine_account")
public class SpecEqpSteamTurbineAccount implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 汽轮机设备编码
     */
    private String specEqpStCode;
    /**
     * 汽轮机名称
     */
    private String specEqpStName;
    /**
     * 所在区域
     */
    private String specEqpStArea;
    /**
     * 汽轮机型号
     */
    private String specEqpStModel;
    /**
     * 生产厂家
     */
    private String specEqpStManufacturer;
    /**
     * 出厂编号
     */
    private String specEqpStFactoryNo;
    /**
     * 制造日期
     */
    private LocalDate specEqpStProduceDate;
    /**
     * 安装单位
     */
    private String specEqpStInstallCompany;
    /**
     * 安装日期
     */
    private LocalDate specEqpStInstallDate;
    /**
     * 验收日期
     */
    private LocalDate specEqpStAcceptanceDate;
    /**
     * 投用日期
     */
    private LocalDate specEqpStUsageDate;
    /**
     * 	特种设备使用登记
     */
    private String specEqpStLicenseNo;
    /**
     * 	额定功率（MW）
     */
    private String specEqpStPowerRating;
    /**
     * 	额定转速（r/min）
     */
    private String specEqpStSpeedRating;
    /**
     * 进汽设计压力（MPa）
     */
    private String specEqpStSteamPressure;
    /**
     * 进汽设计温度（℃）
     */
    private String specEqpStSteamTemp;
    /**
     * 排汽压力（MPa）
     */
    private String specEqpStExhaustPressure;
    /**
     * 	转子材质
     */
    private String specEqpStRotorMaterial;
    /**
     * 	汽缸材质
     */
    private String specEqpStCasingMaterial;
    /**
     * 工作介质（蒸汽 / 过热蒸汽等）
     */
    private String specEqpStMedia;
    /**
     * 介质特性（高温、高压等）
     */
    private String specEqpStMediaProperty;
    /**
     * 设备状态
     */
    private String specEqpStStatus;
    /**
     * 	上次检验日期
     */
    private LocalDate specEqpStLastInspectDate;
    /**
     * 	下次检验日期
     */
    private LocalDate specEqpStNextInspectDate;
    /**
     * 	检验机构
     */
    private String specEqpStInspectCompany;
    /**
     * 	运维责任人
     */
    private String specEqpStMaintainResponsible;
    /**
     * 维护检修记录
     */
    private String specEqpStMaintainRecord;
    /**
     * 	异常及事故记录
     */
    private String specEqpStAccidentRecord;
    /**
     * 	台账创建时间
     */
    private LocalDate specEqpStCreateTime;
    /**
     * 	台账更新时间
     */
    private LocalDate specEqpStUpLocalDate;
    /**
     * 所属工厂
     */
    private String specEqpStFactory;
    /**
     * 备用1
     */
    private String specEqpStBackup1;
    /**
     * 备用2
     */
    private String specEqpStBackup2;
    /**
     * 备用3
     */
    private String specEqpStBackup3;
}
