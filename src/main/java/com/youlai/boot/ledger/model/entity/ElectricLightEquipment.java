package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 电气照明设备实体对象
 *
 * @author dazao
 * @since 2026-02-04 09:24
 */
@Getter
@Setter
@TableName("electric_light_equipment")
public class ElectricLightEquipment {

    private static final long serialVersionUID = 1L;
    @TableId
    private long id;
    /**
     * 照明设备编号
     */
    private String eleLightCode;
    /**
     * 设备名称
     */
    private String eleLightName;
    /**
     * 规格型号
     */
    private String eleSpecModel;
    /**
     * 防爆标志
     */
    private String eleExMark;
    /**
     * 防爆合格证号（仅防爆区域照明设备填写）
     */
    private Integer eleExCertNo;
    /**
     * 防爆合格证有效期（仅防爆区域照明设备填写）
     */
    private String eleExCertExpire;
    /**
     * 额定功率（W）
     */
    private String eleRatedPower;
    /**
     * 额定电压（如 AC220V、DC36V、AC380V）
     */
    private String eleRatedVoltage;
    /**
     * 安装位置及危险区域等级
     */
    private String eleInstallArea;
    /**
     * 安装高度（m）
     */
    private Double eleInstallHeight;
    /**
     * 生产厂家
     */
    private String eleManufacturer;
    /**
     * 投运日期
     */
    private LocalDateTime eleCommissioningDate;
    /**
     * 上次维护日期
     */
    private LocalDateTime eleLastMaintainDate;
    /**
     * 下次维护日期
     */
    private LocalDateTime eleNextMaintainDate;
    /**
     * 是否为应急照明（0 = 否，1 = 是）
     */
    private String eleIsEmergency;
    /**
     * 	设备状态
     */
    private Integer eleStatus;
    /**
     * 所属工厂
     */
    private String eleFactory;
    /**
     * 备用1
     */
    private String eleReserve1;
    /**
     * 备用2
     */
    private String eleReserve2;
    /**
     * 备用3
     */
    private String eleReserve3;
}
