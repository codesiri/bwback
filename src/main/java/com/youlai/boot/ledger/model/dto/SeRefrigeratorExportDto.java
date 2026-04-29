package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 特种设备制冷机台账视图对象
 *
 * @author baiwei
 * @since 2026-02-14 08:38
 */
@Getter
@Setter
@Schema( description = "特种设备制冷机台账视图对象")
public class SeRefrigeratorExportDto {

    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "制冷机设备编号")
    private String seRefrigeratorEquipCode;
    @ExcelProperty(value = "制冷机设备名称")
    private String seRefrigeratorName;
    @ExcelProperty(value = "制冷机类型")
    private String seRefrigeratorType;
    @ExcelProperty(value = "规格型号")
    private String seRefrigeratorSpec;
    @ExcelProperty(value = "额定制冷量（kW）")
    private String seRefrigeratorCoolingCapacity;
    @ExcelProperty(value = "额定输入功率（kW）")
    private String seRefrigeratorRatedPower;
    @ExcelProperty(value = "蒸发温度（℃）")
    private String seRefrigeratorEvapTemp;
    @ExcelProperty(value = "冷凝温度（℃）")
    private String seRefrigeratorCondTemp;
    @ExcelProperty(value = "制冷剂类型")
    private String seRefrigeratorRefrigerant;
    @ExcelProperty(value = "冷冻油型号及类型")
    private String seRefrigeratorOilType;
    @ExcelProperty(value = "主体材质")
    private String seRefrigeratorMaterial;
    @ExcelProperty(value = "防爆等级")
    private String seRefrigeratorExplosionProof;
    @ExcelProperty(value = "配套电机型号")
    private String seRefrigeratorMotorModel;
    @ExcelProperty(value = "冷却方式")
    private String seRefrigeratorCoolingType;
    @ExcelProperty(value = "安装位置")
    private String seRefrigeratorInstallPos;
    @ExcelProperty(value = "投用日期")
    private LocalDate seRefrigeratorInService;
    @ExcelProperty(value = "定期检验周期")
    private String seRefrigeratorInspectCycle;
    @ExcelProperty(value = "上次检验日期")
    private LocalDate seRefrigeratorLastInspect;
    @ExcelProperty(value = "下次检验日期")
    private LocalDate seRefrigeratorNextInspect;
    @ExcelProperty(value = "检验结果")
    private String seRefrigeratorInspectResult;
    @ExcelProperty(value = "上次维保日期")
    private LocalDate seRefrigeratorLastMaintain;
    @ExcelProperty(value = "下次维保日期")
    private LocalDate seRefrigeratorNextMaintain;
    @ExcelProperty(value = "上次气密性 / 泄漏检测日期")
    private LocalDate seRefrigeratorLeakTest;
    @ExcelProperty(value = "制冷系数（COP 值）")
    private String seRefrigeratorCoeff;
    @ExcelProperty(value = "维保维修记录")
    private String seRefrigeratorMaintainRecord;
    @ExcelProperty(value = "故障及异常记录")
    private String seRefrigeratorFaultRecord;
    @ExcelProperty(value = "录入 / 维护人员")
    private String seRefrigeratorOperator;
    @ExcelProperty(value = "创建时间")
    private LocalDate seRefrigeratorCreateTime;
    @ExcelProperty(value = "最后更新时间")
    private LocalDate seRefrigeratorUpdateTime;
    @ExcelProperty(value = "所属工厂")
    private String seRefrigeratorFactory;
    @ExcelProperty(value = "设备状态")
    private String seRefrigeratorStatus;
    @ExcelProperty(value = "备用1")
    private String seRefrigeratorReserve1;
    @ExcelProperty(value = "备用2")
    private String seRefrigeratorReserve2;
    @ExcelProperty(value = "备用3")
    private String seRefrigeratorReserve3;
}
