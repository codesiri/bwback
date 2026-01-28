package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 开关阀实体对象
 *
 * @author dazao
 * @since 2026-01-27 08:43
 */
@Getter
@Setter
@TableName("switch_valve")
public class SwitchValve implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private long id;
    /**
     * 装置名称
     */
    private String switchValveDevice;
    /**
     * 位号
     */
    private String switchValveTag;
    /**
     * 设备状态
     */
    private String status;
    /**
     * 名称
     */
    private String switchValveName;
    /**
     * 型号规格
     */
    private String switchValveModel;
    /**
     * 生产厂家
     */
    private String switchValveManu;
    /**
     * 安装位置及用途
     */
    private String switchValveLocation;
    /**
     * 介质名称
     */
    private String switchValveMedName;
    /**
     * 工艺条件 - 设计温度
     */
    private String switchValveMedTemp;
    /**
     * 工艺条件 - 阀前压力（MPa）
     */
    private String switchValveMedPress;
    /**
     * 工艺条件 - 阀后压力（MPa）
     */
    private String switchValvePressAfter;
    /**
     * 工艺条件 - 公称通径及材质
     */
    private String switchValveMaterial;
    /**
     * 阀体 - 阀体材质
     */
    private String switchValveBodyMaterial;
    /**
     * 阀座 - 序号
     */
    private String switchValveSeatSn;
    /**
     * 阀座 - 材质
     */
    private String switchValveSeatMaterial;
    /**
     * 阀芯 - 材质
     */
    private String switchValveCoreMaterial;
    /**
     * 阀杆 - 材质
     */
    private String switchValveStemMaterial;
    /**
     * 阀内件 - 流量特性
     */
    private String switchValveFlowChar;
    /**
     * 阀内件 - 泄漏等级
     */
    private String switchValveLeakClass;
    /**
     * 执行机构 - 类型
     */
    private String switchValveActuatorType;
    /**
     * 执行机构 - 形式规格
     */
    private String switchValveActuatorModel;
    /**
     * 执行机构 - 厂家
     */
    private String switchValveActuatorManu;
    /**
     * 执行机构 - 作用形式
     */
    private String switchValveActuatorAction;
    /**
     * 执行机构 - 行程
     */
    private String switchValveActuatorStroke;
    /**
     * 执行机构 - 弹簧范围
     */
    private String switchValveSpringRange;
    /**
     * 执行机构 - 气源压力
     */
    private String switchValveAirPress;
    /**
     * 执行机构 - 故障位置
     */
    private String switchValveFaultPos;
    /**
     * 执行机构 - 关闭时间
     */
    private LocalDateTime switchValveCloseTime;
    /**
     * 执行机构 - 开启时间
     */
    private LocalDateTime switchValveOpenTime;
    /**
     * 备注
     */
    private String switchValveRemark;
    /**
     * s设备类型
     */
    private String dvType;
    /**
     * 所属工厂
     */
    private String factory;
}
