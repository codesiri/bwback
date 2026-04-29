package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 特种设备压缩机台账视图对象
 *
 * @author baiwei
 * @since 2026-02-09 09:07
 */
@Getter
@Setter
@Schema( description = "特种设备压缩机台账视图对象")
public class SeCompressorExportDto {

    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "压缩机设备编号")
    private String seCompressorEquipCode;
    @ExcelProperty(value = "设备名称")
    private String seCompressorName;
    @ExcelProperty(value = "压缩机类型")
    private String seCompressorType;
    @ExcelProperty(value = "规格型号")
    private String seCompressorSpec;
    @ExcelProperty(value = "额定排气量（m³/min）")
    private String seCompressorRatedFlow;
    @ExcelProperty(value = "额定排气压力（MPa）")
    private String seCompressorRatedPressure;
    @ExcelProperty(value = "额定输入功率（kW）")
    private String seCompressorRatedPower;
    @ExcelProperty(value = "额定转速（r/min）")
    private String seCompressorRatedSpeed;
    @ExcelProperty(value = "输送介质")
    private String seCompressorMedia;
    @ExcelProperty(value = "进气温度（℃）")
    private String seCompressorInletTemp;
    @ExcelProperty(value = "排气温度（℃）")
    private String seCompressorOutletTemp;
    @ExcelProperty(value = "设计压力（MPa）")
    private String seCompressorDesignP;
    @ExcelProperty(value = "主体 / 过流部件材质")
    private String seCompressorMaterial;
    @ExcelProperty(value = "防爆等级")
    private String seCompressorExplosionProof;
    @ExcelProperty(value = "配套电机型号")
    private String seCompressorMotorModel;
    @ExcelProperty(value = "润滑方式及油品")
    private String seCompressorLubrication;
    @ExcelProperty(value = "冷却方式（水冷 / 风冷）")
    private String seCompressorCoolingType;
    @ExcelProperty(value = "安装位置")
    private String seCompressorInstallPos;
    @ExcelProperty(value = "投用日期")
    private LocalDate seCompressorInService;
    @ExcelProperty(value = "定期检验周期")
    private String seCompressorInspectCycle;
    @ExcelProperty(value = "上次检验日期")
    private LocalDate seCompressorLastInspect;
    @ExcelProperty(value = "下次检验日期")
    private LocalDate seCompressorNextInspect;
    @ExcelProperty(value = "检验结果")
    private String seCompressorInspectResult;
    @ExcelProperty(value = "上次维保日期")
    private String seCompressorLastMaintain;
    @ExcelProperty(value = "下次维保日期")
    private String seCompressorNextMaintain;
    @ExcelProperty(value = "运行振动值（mm/s）")
    private String seCompressorVibration;
    @ExcelProperty(value = "压缩比")
    private String seCompressorPressureRatio;
    @ExcelProperty(value = "维保维修记录")
    private String seCompressorMaintainRecord;
    @ExcelProperty(value = "故障及异常记录")
    private String seCompressorFaultRecord;
    @ExcelProperty(value = "录入维护人员")
    private String seCompressorOperator;
    @ExcelProperty(value = "记录创建时间")
    private LocalDate seCompressorCreateTime;
    @ExcelProperty(value = "最后更新时间")
    private LocalDate seCompressorUpdateTime;
    @ExcelProperty(value = "设备状态")
    private String seCompressorStatus;
    @ExcelProperty(value = "所属工厂")
    private String seCompressorFactory;
    @ExcelProperty(value = "备用1")
    private String seCompressorReserve1;
    @ExcelProperty(value = "备用2")
    private String seCompressorReserve2;
    @ExcelProperty(value = "备用3")
    private String seCompressorReserve3;
}
