package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 球罐实体对象
 *
 * @author baiwei
 * @since 2026-03-06 09:49
 */
@Getter
@Setter
@Schema(description = "球罐视图对象")
public class SeSphericalTankExportDto {

    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "球罐设备编号")
    private String seTankEquipCode;
    @ExcelProperty(value = "球罐名称")
    private String seTankName;
    @ExcelProperty(value = "规格型号")
    private String seTankSpec;
    @ExcelProperty(value = "设计容积（m³）")
    private String seTankDesignVolume;
    @ExcelProperty(value = "工作容积（m³）")
    private String seTankOperatingVolume;
    @ExcelProperty(value = "设计压力（MPa）")
    private String seTankDesignP;
    @ExcelProperty(value = "工作压力（MPa）")
    private String seTankOperatingP;
    @ExcelProperty(value = "设计温度（℃）")
    private String seTankDesignT;
    @ExcelProperty(value = "工作温度（℃）")
    private String seTankOperatingT;
    @ExcelProperty(value = "储存介质")
    private String seTankMedia;
    @ExcelProperty(value = "主体材质")
    private String seTankMaterial;
    @ExcelProperty(value = "罐体壁厚（mm）")
    private String seTankThickness;
    @ExcelProperty(value = "密封形式")
    private String seTankSealType;
    @ExcelProperty(value = "防腐措施")
    private String seTankAntiCorrosion;
    @ExcelProperty(value = "安全阀型号规格")
    private String seTankSafetyValveModel;
    @ExcelProperty(value = "安装位置")
    private String seTankInstallPos;
    @ExcelProperty(value = "投用日期")
    private String seTankInService;
    @ExcelProperty(value = "定期检验周期")
    private String seTankInspectCycle;
    @ExcelProperty(value = "上次检验日期")
    private LocalDate seTankLastInspect;
    @ExcelProperty(value = "下次检验日期")
    private LocalDate seTankNextInspect;
    @ExcelProperty(value = "检验结果")
    private String seTankInspectResult;
    @ExcelProperty(value = "上次水压 / 气压试验日期")
    private LocalDate seTankLastPressureTest;
    @ExcelProperty(value = "液位计型号")
    private String seTankLevelGaugeModel;
    @ExcelProperty(value = "腐蚀状况")
    private String seTankCorrosionStatus;
    @ExcelProperty(value = "维保维修记录")
    private String seTankMaintainRecord;
    @ExcelProperty(value = "故障及异常记录")
    private String seTankFaultRecord;
    @ExcelProperty(value = "录入维护人员")
    private String seTankOperator;
    @ExcelProperty(value = "记录创建时间")
    private LocalDate seTankCreateTime;
    @ExcelProperty(value = "最后更新时间")
    private LocalDate seTankUpdateTime;
    @ExcelProperty(value = "设备状态")
    private String seTankStatus;
    @ExcelProperty(value = "所属工厂")
    private String seTankFactory;
    @ExcelProperty(value = "备用1")
    private String seTankReserve1;
    @ExcelProperty(value = "备用2")
    private String seTankReserve2;
    @ExcelProperty(value = "备用3")
    private String seTankReserve3;
}
