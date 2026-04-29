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
 * 立罐视图对象
 *
 * @author baiwei
 * @since 2026-03-06 10:04
 */
@Getter
@Setter
@Schema( description = "立罐视图对象")
public class SpecEqpVerticalTankAccountExportDto {
    
    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "立罐设备编码")
    private String specEqpVtCode;
    @ExcelProperty(value = "立罐名称")
    private String specEqpVtName;
    @ExcelProperty(value = "所在区域")
    private String specEqpVtArea;
    @ExcelProperty(value = "立罐型号")
    private String specEqpVtModel;
    @ExcelProperty(value = "罐体材质")
    private String specEqpVtMaterial;
    @ExcelProperty(value = "设计容积（m³）")
    private String specEqpVtVolume;
    @ExcelProperty(value = "设计压力（MPa）")
    private String specEqpVtDesignPressure;
    @ExcelProperty(value = "设计温度（℃）")
    private String specEqpVtDesignTemp;
    @ExcelProperty(value = "储存介质")
    private String specEqpVtMedia;
    @ExcelProperty(value = "介质特性")
    private String specEqpVtMediaProperty;
    @ExcelProperty(value = "制造厂家")
    private String specEqpVtManufacturer;
    @ExcelProperty(value = "出厂编号")
    private String specEqpVtFactoryNo;
    @ExcelProperty(value = "制造日期")
    private LocalDate specEqpVtProduceDate;
    @ExcelProperty(value = "安装单位")
    private String specEqpVtInstallCompany;
    @ExcelProperty(value = "安装日期")
    private LocalDate specEqpVtInstallDate;
    @ExcelProperty(value = "验收日期")
    private LocalDate specEqpVtAcceptanceDate;
    @ExcelProperty(value = "投用日期")
    private LocalDateTime specEqpVtUsageDate;
    @ExcelProperty(value = "特种设备使用登记")
    private Integer specEqpVtLicenseNo;
    @ExcelProperty(value = "设备状态")
    private String specEqpVtStatus;
    @ExcelProperty(value = "上次检验日期")
    private LocalDate specEqpVtLastInspectDate;
    @ExcelProperty(value = "下次检验日期")
    private LocalDate specEqpVtNextInspectDate;
    @ExcelProperty(value = "检验机构")
    private String specEqpVtInspectCompany;
    @ExcelProperty(value = "运维责任人")
    private String specEqpVtMaintainResponsible;
    @ExcelProperty(value = "最后一次维护记录")
    private String specEqpVtMaintainRecord;
    @ExcelProperty(value = "事故记录")
    private String specEqpVtAccidentRecord;
    @ExcelProperty(value = "创建时间")
    private LocalDate specEqpVtCreateTime;
    @ExcelProperty(value = "更新时间")
    private LocalDate specEqpVtUpdateTime;
    @ExcelProperty(value = "所属工厂")
    private String specEqpVtFactory;
    @ExcelProperty(value = "备用1")
    private String specEqpVtBackup1;
    @ExcelProperty(value = "备用2")
    private String specEqpVtBackup2;
    @ExcelProperty(value = "备用3")
    private String specEqpVtBackup3;
}
