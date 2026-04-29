package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.io.Serial;

/**
 * 温度实体对象
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
@Getter
@Setter
@TableName("dv_temperature_gauge")
public class DvTemperatureGauge {

    @Serial
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    /**
     * 装置名称
     */
    private String deviceName;
    /**
     * 位号
     */
    private String tagNumber;
    /**
     * 安装位置以及用途
     */
    private String installationLocationAndPurpose;
    /**
     * 装置名称
     */
    private String deviceNameSuffix;
    /**
     * 分度号
     */
    private String indexNumber;
    /**
     * 规格型号
     */
    private String specificationModel;
    /**
     * 生产厂家
     */
    private String manufacturer;
    /**
     * 测量范围
     */
    private String measurementRange;
    /**
     * 插入深度
     */
    private String insertionDepth;
    /**
     * 连接方式及规格
     */
    private String connectionMethodAndSpecifications;
    /**
     * 精度
     */
    @TableField("`precision`")
    private String precision;
    /**
     * 套管规格和及材质
     */
    private String casingSpecificationsAndMaterial;
    /**
     * 是否带连锁
     */
    private int interlocked;
    /**
     * 联锁设定值
     */
    private String interlockSetValue;
    /**
     * 备注
     */
    private String remark;
    private String dvType;
    private int status;
    //所属工厂
    private String factory;

}
