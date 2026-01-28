package com.youlai.boot.ledger.model.dto;


import cn.idev.excel.annotation.ExcelProperty;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class SwitchValveExportDto {
    /**
     * 装置名称
     */
    @ExcelProperty(value = "装置名称")
    private String switchValveDevice;
    /**
     * 位号
     */
    @ExcelProperty(value = "位号")
    private String switchValveTag;
    /**
     * 设备状态
     */
    @ExcelProperty(value = "设备状态")
    private String status;
    /**
     * 名称
     */
    @ExcelProperty(value = "名称")
    private String switchValveName;
    /**
     * 型号规格
     */
    @ExcelProperty(value = "型号规格")
    private String switchValveModel;
    /**
     * 生产厂家
     */
    @ExcelProperty(value = "生产厂家")
    private String switchValveManu;
    /**
     * 安装位置及用途
     */
    @ExcelProperty(value = "安装位置及用途")
    private String switchValveLocation;
    /**
     * 介质名称
     */
    @ExcelProperty(value = "介质名称")
    private String switchValveMedName;
    /**
     * 工艺条件 - 设计温度
     */
    @ExcelProperty(value = "工艺条件 - 设计温度")
    private String switchValveMedTemp;
    /**
     * 工艺条件 - 阀前压力（MPa）
     */
    @ExcelProperty(value = "工艺条件 - 阀前压力（MPa）")
    private String switchValveMedPress;
    /**
     * 工艺条件 - 阀后压力（MPa）
     */
    @ExcelProperty(value = "工艺条件 - 阀后压力（MPa）")
    private String switchValvePressAfter;
    /**
     * 工艺条件 - 公称通径及材质
     */
    @ExcelProperty(value = "工艺条件 - 公称通径及材质")
    private String switchValveMaterial;
    /**
     * 阀体 - 阀体材质
     */
    @ExcelProperty(value = "阀体 - 阀体材质")
    private String switchValveBodyMaterial;
    /**
     * 阀座 - 序号
     */
    @ExcelProperty(value = "阀座 - 序号")
    private String switchValveSeatSn;
    /**
     * 阀座 - 材质
     */
    @ExcelProperty(value = "阀座 - 材质")
    private String switchValveSeatMaterial;
    /**
     * 阀芯 - 材质
     */
    @ExcelProperty(value = "阀芯 - 材质")
    private String switchValveCoreMaterial;
    /**
     * 阀杆 - 材质
     */
    @ExcelProperty(value = "阀杆 - 材质")
    private String switchValveStemMaterial;
    /**
     * 阀内件 - 流量特性
     */
    @ExcelProperty(value = "阀内件 - 流量特性")
    private String switchValveFlowChar;
    /**
     * 阀内件 - 泄漏等级
     */
    @ExcelProperty(value = "阀内件 - 泄漏等级")
    private String switchValveLeakClass;
    /**
     * 执行机构 - 类型
     */
    @ExcelProperty(value = "执行机构 - 类型")
    private String switchValveActuatorType;
    /**
     * 执行机构 - 形式规格
     */
    @ExcelProperty(value = "执行机构 - 形式规格")
    private String switchValveActuatorModel;
    /**
     * 执行机构 - 厂家
     */
    @ExcelProperty(value = "执行机构 - 厂家")
    private String switchValveActuatorManu;
    /**
     * 执行机构 - 作用形式
     */
    @ExcelProperty(value = "执行机构 - 作用形式")
    private String switchValveActuatorAction;
    /**
     * 执行机构 - 行程
     */
    @ExcelProperty(value = "执行机构 - 行程")
    private String switchValveActuatorStroke;
    /**
     * 执行机构 - 弹簧范围
     */
    @ExcelProperty(value = "执行机构 - 弹簧范围")
    private String switchValveSpringRange;
    /**
     * 执行机构 - 气源压力
     */
    @ExcelProperty(value = "执行机构 - 气源压力")
    private String switchValveAirPress;
    /**
     * 执行机构 - 故障位置
     */
    @ExcelProperty(value = "执行机构 - 故障位置")
    private String switchValveFaultPos;
    /**
     * 执行机构 - 关闭时间
     */
    @ExcelProperty(value = "执行机构 - 关闭时间")
    private LocalDateTime switchValveCloseTime;
    /**
     * 执行机构 - 开启时间
     */
    @ExcelProperty(value = "执行机构 - 开启时间")
    private LocalDateTime switchValveOpenTime;
    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String switchValveRemark;
    /**
     * s设备类型
     */
    @ExcelProperty(value = "设备类型")
    private String dvType;
    /**
     * 所属工厂
     */
    @ExcelProperty(value = "所属工厂")
    private String factory;

}
