package com.youlai.boot.ledger.model.dto;


import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ControlValveExportDto {

    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "装置名称")
    private String dveName;
    @ExcelProperty(value = "	位号")
    private String tagNo;
    @ExcelProperty(value = "名称")
    private String name;
    @ExcelProperty(value = "型号规格")
    private String modelSpecification;
    @ExcelProperty(value = "生产厂家")
    private String manufacturer;
    @ExcelProperty(value = "安装位置及用途")
    private String installationLocationAndPurpose;
    @ExcelProperty(value = "介质名称")
    private String mediumName;
    @ExcelProperty(value = "设计温度")
    private String designTemperature;
    @ExcelProperty(value = "阀前压")
    private String pressureBeforeValve;
    @ExcelProperty(value = "阀后压")
    private String pressureAfterValve;
    @ExcelProperty(value = "阀座直径")
    private String valveSeatDiameter;
    @ExcelProperty(value = "阀体材质")
    private String valveBodyMaterial;
    @ExcelProperty(value = "阀座序列号")
    private Integer valveSeatSerialNumber;
    @ExcelProperty(value = "阀座材质")
    private String valveSeatMaterial;
    @ExcelProperty(value = "阀芯材质")
    private String valveCoreMaterial;
    @ExcelProperty(value = "阀杆材质")
    private String valveStemMaterial;
    @ExcelProperty(value = "流量特性")
    private String flowCharacteristics;
    @ExcelProperty(value = "泄露等级")
    private String leakageClass;
    @ExcelProperty(value = "Cv值")
    private String cvValue;
    @ExcelProperty(value = "规格")
    private String actuatorModelSpecification;
    @ExcelProperty(value = "作用形式")
    private String actuatorActionForm;
    @ExcelProperty(value = "行程")
    private String actuatorStroke;
    @ExcelProperty(value = "弹簧范围")
    private String springRange;
    @ExcelProperty(value = "气源压力")
    private String airSourcePressure;
    @ExcelProperty(value = "故障位置")
    private String faultPosition;
    @ExcelProperty(value = "关阀时间")
    private LocalDateTime valveCloseTime;
    @ExcelProperty(value = "开阀时间")
    private LocalDateTime valveOpenTime;
    @ExcelProperty(value = "手轮机构")
    private String handwheelMechanism;
    @ExcelProperty(value = "设备类型")
    private String dvType;
    @ExcelProperty(value = "设备状态")
    private Integer status;
    @ExcelProperty(value = "所属工厂")
    private String factory;

}

