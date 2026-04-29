package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 特种设备风机台账视图对象
 *
 * @author youlaitech
 * @since 2026-02-09 09:18
 */
@Getter
@Setter
@Schema( description = "特种设备风机台账视图对象")
public class SeFanExportDto {

   
    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "风机设备编号")
    private String seFanEquipCode;
    @ExcelProperty(value = "风机名称")
    private String seFanName;
    @ExcelProperty(value = "风机类型")
    private String seFanType;
    @ExcelProperty(value = "设备规格")
    private String seFanSpec;
    @ExcelProperty(value = "额定功率（kW）")
    private String seFanRatedPower;
    @ExcelProperty(value = "额定转速（r/min）")
    private String seFanRatedSpeed;
    @ExcelProperty(value = "额定压力（kPa，正压 / 负压标注在备注）")
    private String seFanRatedPressure;
    @ExcelProperty(value = "额定风量（m³/h）")
    private String seFanRatedFlow;
    @ExcelProperty(value = "输送介质")
    private String seFanMedium;
    @ExcelProperty(value = "主体材质")
    private String seFanMaterial;
    @ExcelProperty(value = "防爆等级")
    private String seFanExplosionProof;
    @ExcelProperty(value = "配套电机型号")
    private String seFanMotorModel;
    @ExcelProperty(value = "安装位置")
    private String seFanInstallPos;
    @ExcelProperty(value = "投用日期")
    private String seFanInService;
    @ExcelProperty(value = "法定检验周期")
    private String seFanInspectCycle;
    @ExcelProperty(value = "上次检验日期")
    private LocalDate seFanLastInspect;
    @ExcelProperty(value = "下次检验日期")
    private LocalDate seFanNextInspect;
    @ExcelProperty(value = "检验结果")
    private String seFanInspectResult;
    @ExcelProperty(value = "润滑方式")
    private String seFanLubrication;
    @ExcelProperty(value = "上次润滑日期")
    private LocalDate seFanLastLubricate;
    @ExcelProperty(value = "下次润滑日期")
    private LocalDate seFanNextLubricate;
    @ExcelProperty(value = "运行振动值（mm/s，标准≤4.5mm/s）")
    private String seFanVibration;
    @ExcelProperty(value = "维保记录")
    private String seFanMaintainRecord;
    @ExcelProperty(value = "故障记录")
    private String seFanFaultRecord;
    @ExcelProperty(value = "台账录入 / 维护人员")
    private String seFanOperator;
    @ExcelProperty(value = "台账记录创建时间")
    private LocalDateTime seFanCreateTime;
    @ExcelProperty(value = "台账记录最后修改时间")
    private LocalDateTime seFanUpdateTime;
    @ExcelProperty(value = "设备状态")
    private String seFanStatus;
    @ExcelProperty(value = "所属工厂")
    private String seFanFactory;
    @ExcelProperty(value = "备用1")
    private String seFanReserve1;
    @ExcelProperty(value = "备用2")
    private String seFanReserve2;
    @ExcelProperty(value = "备用3")
    private String seFanReserve3;
}
