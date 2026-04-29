package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;
import java.time.LocalDate;
/**
 * 立罐实体对象
 *
 * @author baiwei
 * @since 2026-03-06 10:04
 */
@Getter
@Setter
@TableName("spec_eqp_vertical_tank_account")
public class SpecEqpVerticalTankAccount implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 立罐设备编码
     */
    private String specEqpVtCode;
    /**
     * 立罐名称
     */
    private String specEqpVtName;
    /**
     * 所在区域
     */
    private String specEqpVtArea;
    /**
     * 立罐型号
     */
    private String specEqpVtModel;
    /**
     * 罐体材质
     */
    private String specEqpVtMaterial;
    /**
     * 设计容积（m³）
     */
    private String specEqpVtVolume;
    /**
     * 设计压力（MPa）
     */
    private String specEqpVtDesignPressure;
    /**
     * 设计温度（℃）
     */
    private String specEqpVtDesignTemp;
    /**
     * 储存介质
     */
    private String specEqpVtMedia;
    /**
     * 介质特性
     */
    private String specEqpVtMediaProperty;
    /**
     * 制造厂家
     */
    private String specEqpVtManufacturer;
    /**
     * 出厂编号
     */
    private String specEqpVtFactoryNo;
    /**
     * 制造日期
     */
    private LocalDate specEqpVtProduceDate;
    /**
     * 安装单位
     */
    private String specEqpVtInstallCompany;
    /**
     * 安装日期
     */
    private LocalDate specEqpVtInstallDate;
    /**
     * 验收日期
     */
    private LocalDate specEqpVtAcceptanceDate;
    /**
     * 投用日期
     */
    private LocalDateTime specEqpVtUsageDate;
    /**
     * 特种设备使用登记
     */
    private Integer specEqpVtLicenseNo;
    /**
     * 设备状态
     */
    private String specEqpVtStatus;
    /**
     * 上次检验日期
     */
    private LocalDate specEqpVtLastInspectDate;
    /**
     * 下次检验日期
     */
    private LocalDate specEqpVtNextInspectDate;
    /**
     * 检验机构
     */
    private String specEqpVtInspectCompany;
    /**
     * 运维责任人
     */
    private String specEqpVtMaintainResponsible;
    /**
     * 最后一次维护记录
     */
    private String specEqpVtMaintainRecord;
    /**
     * 事故记录
     */
    private String specEqpVtAccidentRecord;
    /**
     * 创建时间
     */
    private LocalDate specEqpVtCreateTime;
    /**
     * 更新时间
     */
    private LocalDate specEqpVtUpdateTime;
    /**
     * 所属工厂
     */
    private String specEqpVtFactory;
    /**
     * 备用1
     */
    private String specEqpVtBackup1;
    /**
     * 备用2
     */
    private String specEqpVtBackup2;
    /**
     * 备用3
     */
    private String specEqpVtBackup3;
}
