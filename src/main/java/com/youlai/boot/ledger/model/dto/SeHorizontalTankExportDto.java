package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
/**
 * 卧罐视图对象
 *
 * @author baiwei
 * @since 2026-03-06 09:33
 */
@Getter
@Setter
@Schema( description = "卧罐视图对象")
public class SeHorizontalTankExportDto  {

    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "卧罐设备编号")
    private String seHtankEquipCode;
    @ExcelProperty(value = "卧罐名称")
    private String seHtankName;
    @ExcelProperty(value = "规格型号")
    private String seHtankSpec;
    @ExcelProperty(value = "设计容积（m³）")
    private String seHtankDesignVolume;
    @ExcelProperty(value = "工作容积（m³）")
    private String seHtankOperatingVolume;
    @ExcelProperty(value = "设计压力（MPa）")
    private String seHtankDesignP;
    @ExcelProperty(value = "工作压力（MPa）")
    private String seHtankOperatingP;
    @ExcelProperty(value = "设计温度（℃）")
    private String seHtankDesignT;
    @ExcelProperty(value = "工作温度（℃）")
    private String seHtankOperatingT;
    @ExcelProperty(value = "储存介质")
    private String seHtankMedia;
    @ExcelProperty(value = "主体材质")
    private String seHtankMaterial;
    @ExcelProperty(value = "罐体壁厚（mm）")
    private String seHtankThickness;
    @ExcelProperty(value = "密封形式")
    private String seHtankSealType;
    @ExcelProperty(value = "防腐措施")
    private String seHtankAntiCorrosion;
    @ExcelProperty(value = "支撑形式")
    private String seHtankSupportType;
    @ExcelProperty(value = "安全阀型号规格（核心安全附件，需定期校验）")
    private String seHtankSafetyValveModel;
    @ExcelProperty(value = "安装位置")
    private String seHtankInstallPos;
    @ExcelProperty(value = "投用日期")
    private LocalDate seHtankInService;
    @ExcelProperty(value = "定期检验周期（全面检验每 3 年，年度检查每年，按规范执行）")
    private String seHtankInspectCycle;
    @ExcelProperty(value = "上次检验日期（含无损检测、压力试验、密封校验）")
    private LocalDate seHtankLastInspect;
    @ExcelProperty(value = "下次检验日期（系统预警用，同步安全附件校验周期）")
    private LocalDate seHtankNextInspect;
    @ExcelProperty(value = "检验结果")
    private String seHtankInspectResult;
    @ExcelProperty(value = "上次水压 / 气压试验日期")
    private String seHtankLastPressureTest;
    @ExcelProperty(value = "液位计型号")
    private String seHtankLevelGaugeModel;
    @ExcelProperty(value = "腐蚀状况")
    private String seHtankCorrosionStatus;
    @ExcelProperty(value = "维保维修记录")
    private String seHtankMaintainRecord;
    @ExcelProperty(value = "故障及异常记录")
    private String seHtankFaultRecord;
    @ExcelProperty(value = "录入维护人员")
    private String seHtankOperator;
    @ExcelProperty(value = "记录创建时间")
    private LocalDate seHtankCreateTime;
    @ExcelProperty(value = "最后更新时间")
    private LocalDate seHtankUpdateTime;
    @ExcelProperty(value = "设备状态")
    private String seHtankStatus;
    @ExcelProperty(value = "所属工厂")
    private String seHtankFactory;
    @ExcelProperty(value = "备用1")
    private String seHtankReserve1;
    @ExcelProperty(value = "备用2")
    private String seHtankReserve2;
    @ExcelProperty(value = "备用3")
    private String seHtankReserve3;
}
