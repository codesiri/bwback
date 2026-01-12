package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * 压力实体对象
 *
 * @author wy
 * @since 2025-12-29 11:00
 */
@Getter
@Setter
@TableName("pressure_instrument")
public class PressureInstrument {

    @Serial
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    /**
     * 装置名称
     */
    @TableField("pressure_device")
    private String pressureDevice;
    /**
     * 位号
     */
    private String pressureTag;
    /**
     * 安装位置以及用途
     */
    private String pressureLocation;
    /**
     * 设备名称
     */
    private String pressureEquip;
    /**
     * 规格型号
     */
    private String pressureModel;
    /**
     * 生产厂家
     */
    private String pressureManu;
    /**
     * 测量范围
     */
    private String pressureRange;
    /**
     * 连接方式及规格
     */
    private String pressureConnection;
    /**
     * 精度
     */
    private String pressureAccuracy;
    /**
     *  电源（如 24V DC）
     */
    private String pressurePower;
    /**
     *  输出信号（如 4-20mA）
     */
    private String pressureOutput;
    /**
     *  是否伴热（是 / 否）
     */
    private String pressureHeat;


    /**
     * 是否带连锁
     */
    private String pressureInterlock;
    /**
     * 联锁设定值
     */
    private String pressureInterlockVal;
    /**
     * 备注
     */
    private String pressureRemark;

}
