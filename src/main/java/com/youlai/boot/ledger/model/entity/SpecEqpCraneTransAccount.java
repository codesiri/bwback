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
 * 起重运输类实体对象
 *
 * @author baiwei
 * @since 2026-02-03 09:22
 */
@Getter
@Setter
@TableName("spec_eqp_crane_trans_account")
public class SpecEqpCraneTransAccount implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 设备编码
     */
    private String specEqpCtCode;
    /**
     * 设备名称
     */
    private String specEqpCtName;
    /**
     * 安装 / 使用区域、工段
     */
    private String specEqpCtArea;
    /**
     * 设备型号
     */
    private String specEqpCtModel;
    /**
     * 设备类型
     */
    private String specEqpCtType;
    /**
     * 额定起重量（t）
     */
    private String specEqpCtLiftingCapacity;
    /**
     * 额定起升高度（m）
     */
    private String specEqpCtLiftingHeight;
    /**
     * 起重机跨度（m）
     */
    private String specEqpCtSpan;
    /**
     * 设计压力
     */
    private String specEqpCtDesignPressure;
    /**
     * 制造厂家
     */
    private String specEqpCtManufacturer;
    /**
     * 出厂编号
     */
    private String specEqpCtFactoryNo;
    /**
     * 制造日期
     */
    private LocalDate specEqpCtProduceDate;
    /**
     * 安装单位
     */
    private String specEqpCtInstallCompany;
    /**
     * 安装日期
     */
    private LocalDate specEqpCtInstallDate;
    /**
     * 验收日期
     */
    private LocalDate specEqpCtAcceptanceDate;
    /**
     * 投用日期
     */
    private LocalDate specEqpCtUsageDate;
    /**
     * 特种设备使用登记
     */
    private String specEqpCtLicenseNo;
    /**
     * 设备状态
     */
    private String specEqpCtStatus;
    /**
     * 上次检验日期
     */
    private LocalDate specEqpCtLastInspectDate;
    /**
     * 下次检验日期
     */
    private LocalDate specEqpCtNextInspectDate;
    /**
     * 检验机构
     */
    private String specEqpCtInspectCompany;
    /**
     * 运维责任人
     */
    private String specEqpCtMaintainResponsible;
    /**
     * 维护检修记录
     */
    private String specEqpCtMaintainRecord;
    /**
     * 异常及事故记录
     */
    private String specEqpCtAccidentRecord;
    /**
     * 台账创建时间
     */
    private LocalDate specEqpCtCreateTime;
    /**
     * 台账更新时间
     */
    private LocalDate specEqpCtUpLocalDate;
    /**
     * 所属工厂
     */
    private String specEqpCtFactory;
    /**
     * 备用1
     */
    private String specEqpCtBackup1;
    /**
     * 备用2
     */
    private String specEqpCtBackup2;
    /**
     * 备用3
     */
    private String specEqpCtBackup3;
}
