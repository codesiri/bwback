package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
/**
 * 塔类实体对象
 *
 * @author baiwei
 * @since 2026-03-06 09:57
 */
@Getter
@Setter
@TableName("spec_eqp_tower_account")
public class SpecEqpTowerAccount implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 塔类设备编码
     */
    private String specEqpTowerCode;
    /**
     * 塔类设备名称
     */
    private String specEqpTowerName;
    /**
     * 所在区域
     */
    private String specEqpTowerArea;
    /**
     * 塔类设备型号
     */
    private String specEqpTowerModel;
    /**
     * 塔器类型
     */
    private String specEqpTowerType;
    /**
     * 塔体材质
     */
    private String specEqpTowerMaterial;
    /**
     * 塔体总高度（m）
     */
    private String specEqpTowerHeight;
    /**
     * 塔体公称直径（m）
     */
    private String specEqpTowerDiameter;
    /**
     * 塔板层数 / 填料高度（层 /m）
     */
    private String specEqpTowerLayer;
    /**
     * 设计压力（MPa）
     */
    private String specEqpTowerDesignPressure;
    /**
     * 设计温度（℃）
     */
    private String specEqpTowerDesignTemp;
    /**
     * 处理介质
     */
    private String specEqpTowerMedia;
    /**
     * 介质特性
     */
    private String specEqpTowerMediaProperty;
    /**
     * 制造厂家
     */
    private String specEqpTowerManufacturer;
    /**
     * 出厂编号
     */
    private String specEqpTowerFactoryNo;
    /**
     * 制造日期
     */
    private LocalDate specEqpTowerProduceDate;
    /**
     * 安装单位
     */
    private String specEqpTowerInstallCompany;
    /**
     * 安装日期
     */
    private LocalDate specEqpTowerInstallDate;
    /**
     * 验收日期
     */
    private LocalDate specEqpTowerAcceptanceDate;
    /**
     * 投用日期
     */
    private LocalDate specEqpTowerUsageDate;
    /**
     * 特种设备使用登记
     */
    private String specEqpTowerLicenseNo;
    /**
     * 设备状态
     */
    private String specEqpTowerStatus;
    /**
     * 上次检验日期
     */
    private LocalDate specEqpTowerLastInspectDate;
    /**
     * 下次检验日期
     */
    private LocalDate specEqpTowerNextInspectDate;
    /**
     * 检验机构
     */
    private String specEqpTowerInspectCompany;
    /**
     * 运维负责人
     */
    private String specEqpTowerMaintainResponsible;
    /**
     * 最后一次维护记录
     */
    private String specEqpTowerMaintainRecord;
    /**
     * 事故记录
     */
    private String specEqpTowerAccidentRecord;
    /**
     * 创建时间
     */
    private LocalDate specEqpTowerCreateTime;
    /**
     * 更新时间
     */
    private LocalDate specEqpTowerUpdateTime;
    /**
     * 所属工厂
     */
    private String specEqpTowerFactory;
    /**
     * 备用1
     */
    private String specEqpTowerBackup1;
    /**
     * 备用2
     */
    private String specEqpTowerBackup2;
    /**
     * 备用3
     */
    private String specEqpTowerBackup3;
}
