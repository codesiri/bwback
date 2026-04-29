package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 塔类视图对象
 *
 * @author baiwei
 * @since 2026-03-06 09:57
 */
@Getter
@Setter
@Schema( description = "塔类视图对象")
public class SpecEqpTowerAccountExportDto {

    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "塔类设备编码")
    private String specEqpTowerCode;
    @ExcelProperty(value = "塔类设备名称")
    private String specEqpTowerName;
    @ExcelProperty(value = "所在区域")
    private String specEqpTowerArea;
    @ExcelProperty(value = "塔类设备型号")
    private String specEqpTowerModel;
    @ExcelProperty(value = "塔器类型")
    private String specEqpTowerType;
    @ExcelProperty(value = "塔体材质")
    private String specEqpTowerMaterial;
    @ExcelProperty(value = "塔体总高度（m）")
    private String specEqpTowerHeight;
    @ExcelProperty(value = "塔体公称直径（m）")
    private String specEqpTowerDiameter;
    @ExcelProperty(value = "塔板层数 / 填料高度（层 /m）")
    private String specEqpTowerLayer;
    @ExcelProperty(value = "设计压力（MPa）")
    private String specEqpTowerDesignPressure;
    @ExcelProperty(value = "设计温度（℃）")
    private String specEqpTowerDesignTemp;
    @ExcelProperty(value = "处理介质")
    private String specEqpTowerMedia;
    @ExcelProperty(value = "介质特性")
    private String specEqpTowerMediaProperty;
    @ExcelProperty(value = "制造厂家")
    private String specEqpTowerManufacturer;
    @ExcelProperty(value = "出厂编号")
    private String specEqpTowerFactoryNo;
    @ExcelProperty(value = "制造日期")
    private LocalDate specEqpTowerProduceDate;
    @ExcelProperty(value = "安装单位")
    private String specEqpTowerInstallCompany;
    @ExcelProperty(value = "安装日期")
    private LocalDate specEqpTowerInstallDate;
    @ExcelProperty(value = "验收日期")
    private LocalDate specEqpTowerAcceptanceDate;
    @ExcelProperty(value = "投用日期")
    private LocalDate specEqpTowerUsageDate;
    @ExcelProperty(value = "特种设备使用登记")
    private String specEqpTowerLicenseNo;
    @ExcelProperty(value = "设备状态")
    private String specEqpTowerStatus;
    @ExcelProperty(value = "上次检验日期")
    private LocalDate specEqpTowerLastInspectDate;
    @ExcelProperty(value = "下次检验日期")
    private LocalDate specEqpTowerNextInspectDate;
    @ExcelProperty(value = "检验机构")
    private String specEqpTowerInspectCompany;
    @ExcelProperty(value = "运维负责人")
    private String specEqpTowerMaintainResponsible;
    @ExcelProperty(value = "最后一次维护记录")
    private String specEqpTowerMaintainRecord;
    @ExcelProperty(value = "事故记录")
    private String specEqpTowerAccidentRecord;
    @ExcelProperty(value = "创建时间")
    private LocalDate specEqpTowerCreateTime;
    @ExcelProperty(value = "更新时间")
    private LocalDate specEqpTowerUpdateTime;
    @ExcelProperty(value = "所属工厂")
    private String specEqpTowerFactory;
    @ExcelProperty(value = "备用1")
    private String specEqpTowerBackup1;
    @ExcelProperty(value = "备用2")
    private String specEqpTowerBackup2;
    @ExcelProperty(value = "备用3")
    private String specEqpTowerBackup3;
}
