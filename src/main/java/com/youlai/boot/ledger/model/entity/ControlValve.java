package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 调节阀实体对象
 *
 * @author cc
 * @since 2026-01-28 11:03
 */
@Getter
@Setter
@TableName("control_valve")
public class ControlValve  {

    private static final long serialVersionUID = 1L;
    @TableId
    private long id;
    /**
     * 装置名称
     */
    private String dveName;
    /**
     * 	位号
     */
    private String tagNo;
    /**
     * 名称
     */
    private String name;
    /**
     * 型号规格
     */
    private String modelSpecification;
    /**
     * 生产厂家
     */
    private String manufacturer;
    /**
     * 安装位置及用途
     */
    private String installationLocationAndPurpose;
    /**
     * 介质名称
     */
    private String mediumName;
    /**
     * 设计温度
     */
    private String designTemperature;
    /**
     * 阀前压
     */
    private String pressureBeforeValve;
    /**
     * 阀后压
     */
    private String pressureAfterValve;
    /**
     * 阀座直径
     */
    private String valveSeatDiameter;
    /**
     * 阀体材质
     */
    private String valveBodyMaterial;
    /**
     * 阀座序列号
     */
    private Integer valveSeatSerialNumber;
    /**
     * 阀座材质
     */
    private String valveSeatMaterial;
    /**
     * 阀芯材质
     */
    private String valveCoreMaterial;
    /**
     * 阀杆材质
     */
    private String valveStemMaterial;
    /**
     * 流量特性
     */
    private String flowCharacteristics;
    /**
     * 泄露等级
     */
    private String leakageClass;
    /**
     * Cv值
     */
    private String cvValue;
    /**
     * 规格
     */
    private String actuatorModelSpecification;
    /**
     * 作用形式
     */
    private String actuatorActionForm;
    /**
     * 行程
     */
    private String actuatorStroke;
    /**
     * 弹簧范围
     */
    private String springRange;
    /**
     * 气源压力
     */
    private String airSourcePressure;
    /**
     * 故障位置
     */
    private String faultPosition;
    /**
     * 关阀时间
     */
    private LocalDateTime valveCloseTime;
    /**
     * 开阀时间
     */
    private LocalDateTime valveOpenTime;
    /**
     * 手轮机构
     */
    private String handwheelMechanism;
    /**
     * 设备类型
     */
    private String dvType;
    /**
     * 设备状态
     */
    private Integer status;
    /**
     * 所属工厂
     */
    private String factory;
}

