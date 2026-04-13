package com.youlai.boot.ledger.model.entity;

import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.time.LocalDate;

/**
 * 电器电缆线路实体对象
 *
 * @author dazao
 * @since 2026-03-05 08:45
 */
@Getter
@Setter
@TableName("cable_line_equipment")
public class CableLineEquipment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 电缆编号
     */
    private String cleCableCode;
    /**
     * 电缆名称
     */
    private String cleCableName;
    /**
     * 规格型号
     */
    private String cleSpecModel;
    /**
     * 绝缘等级
     */
    private String cleInsulationLevel;
    /**
     * 电缆长度（m）
     */
    private String cleCableLength;
    /**
     * 敷设方式
     */
    private String cleLayingMethod;
    /**
     * 敷设路径
     */
    private String cleLayingPath;
    /**
     * 安装区域及危险等级
     */
    private String cleInstallArea;
    /**
     * 电缆芯数
     */
    private String cleCoreNumber;
    /**
     * 芯线截面（mm²）
     */
    private String cleCoreSection;
    /**
     * 生产厂家
     */
    private String cleManufacturer;
    /**
     * 生产日期
     */
    private LocalDate cleProductionDate;
    /**
     * 敷设安装日期
     */
    private LocalDate cleInstallDate;
    /**
     * 上次耐压 / 绝缘测试日期
     */
    private LocalDate cleLastTestDate;
    /**
     * 上次测试数据（MΩ/kV）
     */
    private String cleLastTestData;
    /**
     * 中间接头数量
     */
    private String cleJointCount;
    /**
     * 电缆状态（在用 / 备用 / 停用）
     */
    private String cleStatus;
    /**
     * 所属工厂
     */
    private String cleFactory;
    /**
     * 备用1
     */
    private String cleReserve1;
    /**
     * 备用2
     */
    private String cleReserve2;
    /**
     * 备用3
     */
    private String cleReserve3;
}
