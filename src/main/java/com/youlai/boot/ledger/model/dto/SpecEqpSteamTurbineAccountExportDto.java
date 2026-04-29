package com.youlai.boot.ledger.model.dto;

import java.time.LocalDate;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 汽轮机视图对象
 *
 * @author baiwei
 * @since 2026-02-03 09:38
 */
@Getter
@Setter
@Schema( description = "汽轮机导入导出视图对象")
public class SpecEqpSteamTurbineAccountExportDto {

    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "汽轮机设备编码")
    private String specEqpStCode;
    @ExcelProperty(value = "汽轮机名称")
    private String specEqpStName;
    @ExcelProperty(value = "所在区域")
    private String specEqpStArea;
    @ExcelProperty(value = "汽轮机型号")
    private String specEqpStModel;
    @ExcelProperty(value = "生产厂家")
    private String specEqpStManufacturer;
    @ExcelProperty(value = "出厂编号")
    private String specEqpStFactoryNo;
    @ExcelProperty(value = "制造日期")
    private LocalDate specEqpStProduceDate;
    @ExcelProperty(value = "安装单位")
    private String specEqpStInstallCompany;
    @ExcelProperty(value = "安装日期")
    private LocalDate specEqpStInstallDate;
    @ExcelProperty(value = "验收日期")
    private LocalDate specEqpStAcceptanceDate;
    @ExcelProperty(value = "投用日期")
    private LocalDate specEqpStUsageDate;
    @ExcelProperty(value = "	特种设备使用登记")
    private String specEqpStLicenseNo;
    @ExcelProperty(value = "	额定功率（MW）")
    private String specEqpStPowerRating;
    @ExcelProperty(value = "	额定转速（r/min）")
    private String specEqpStSpeedRating;
    @ExcelProperty(value = "进汽设计压力（MPa）")
    private String specEqpStSteamPressure;
    @ExcelProperty(value = "进汽设计温度（℃）")
    private String specEqpStSteamTemp;
    @ExcelProperty(value = "排汽压力（MPa）")
    private String specEqpStExhaustPressure;
    @ExcelProperty(value = "	转子材质")
    private String specEqpStRotorMaterial;
    @ExcelProperty(value = "	汽缸材质")
    private String specEqpStCasingMaterial;
    @ExcelProperty(value = "工作介质（蒸汽 / 过热蒸汽等）")
    private String specEqpStMedia;
    @ExcelProperty(value = "介质特性（高温、高压等）")
    private String specEqpStMediaProperty;
    @ExcelProperty(value = "设备状态")
    private String specEqpStStatus;
    @ExcelProperty(value = "	上次检验日期")
    private LocalDate specEqpStLastInspectDate;
    @ExcelProperty(value = "	下次检验日期")
    private LocalDate specEqpStNextInspectDate;
    @ExcelProperty(value = "	检验机构")
    private String specEqpStInspectCompany;
    @ExcelProperty(value = "	运维责任人")
    private String specEqpStMaintainResponsible;
    @ExcelProperty(value = "维护检修记录")
    private String specEqpStMaintainRecord;
    @ExcelProperty(value = "	异常及事故记录")
    private String specEqpStAccidentRecord;
    @ExcelProperty(value = "	台账创建时间")
    private LocalDate specEqpStCreateTime;
    @ExcelProperty(value = "	台账更新时间")
    private LocalDate specEqpStUpLocalDate;
    @ExcelProperty(value = "所属工厂")
    private String specEqpStFactory;
    @ExcelProperty(value = "备用1")
    private String specEqpStBackup1;
    @ExcelProperty(value = "备用2")
    private String specEqpStBackup2;
    @ExcelProperty(value = "备用3")
    private String specEqpStBackup3;
}
