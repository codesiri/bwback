package com.youlai.boot.ledger.model.dto;


import java.time.LocalDate;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 放射仪导出视图对象
 *
 * @author baiwei
 * @since 2026-01-14 09:44
 */
@Getter
@Setter
@Schema( description = "视图对象")
public class SpecEqpCraneTransAccountsExportDto {

    /**
     * 设备编码
     */
    @ExcelProperty(value = "设备编码")
    private String specEqpCtCode;
    /**
     * 设备名称
     */
    @ExcelProperty(value = "设备名称")
    private String specEqpCtName;
    /**
     * 安装 / 使用区域、工段
     */
    @ExcelProperty(value = "安装 / 使用区域、工段")
    private String specEqpCtArea;
    /**
     * 设备型号
     */
    @ExcelProperty(value = "设备型号")
    private String specEqpCtModel;
    /**
     * 设备类型
     */
    @ExcelProperty(value = "设备类型")
    private String specEqpCtType;
    /**
     * 额定起重量（t）
     */
    @ExcelProperty(value = "额定起重量（t）")
    private String specEqpCtLiftingCapacity;
    /**
     * 额定起升高度（m）
     */
    @ExcelProperty(value = "额定起升高度（m）")
    private String specEqpCtLiftingHeight;
    /**
     * 起重机跨度（m）
     */
    @ExcelProperty(value = "起重机跨度（m）")
    private String specEqpCtSpan;
    /**
     * 设计压力
     */
    @ExcelProperty(value = "设计压力")
    private String specEqpCtDesignPressure;
    /**
     * 制造厂家
     */
    @ExcelProperty(value = "制造厂家")
    private String specEqpCtManufacturer;
    /**
     * 出厂编号
     */
    @ExcelProperty(value = "出厂编号")
    private String specEqpCtFactoryNo;
    /**
     * 制造日期
     */
    @ExcelProperty(value = "制造日期")
    private LocalDate specEqpCtProduceDate;
    /**
     * 安装单位
     */
    @ExcelProperty(value = "安装单位")
    private String specEqpCtInstallCompany;
    /**
     * 安装日期
     */
    @ExcelProperty(value = "安装日期")
    private LocalDate specEqpCtInstallDate;
    /**
     * 验收日期
     */
    @ExcelProperty(value = "验收日期")
    private LocalDate specEqpCtAcceptanceDate;
    /**
     * 投用日期
     */
    @ExcelProperty(value = "投用日期")
    private LocalDate specEqpCtUsageDate;
    /**
     * 特种设备使用登记
     */
    @ExcelProperty(value = "特种设备使用登记")
    private String specEqpCtLicenseNo;
    /**
     * 设备状态
     */
    @ExcelProperty(value = "设备状态")
    private String specEqpCtStatus;
    /**
     * 上次检验日期
     */
    @ExcelProperty(value = "上次检验日期")
    private LocalDate specEqpCtLastInspectDate;
    /**
     * 下次检验日期
     */
    @ExcelProperty(value = "下次检验日期")
    private LocalDate specEqpCtNextInspectDate;
    /**
     * 检验机构
     */
    @ExcelProperty(value = "检验机构")
    private String specEqpCtInspectCompany;
    /**
     * 运维责任人
     */
    @ExcelProperty(value = "运维责任人")
    private String specEqpCtMaintainResponsible;
    /**
     * 维护检修记录
     */
    @ExcelProperty(value = "维护检修记录")
    private String specEqpCtMaintainRecord;
    /**
     * 异常及事故记录
     */
    @ExcelProperty(value = "异常及事故记录")
    private String specEqpCtAccidentRecord;
    /**
     * 台账创建时间
     */
    @ExcelProperty(value = "台账创建时间")
    private LocalDate specEqpCtCreateTime;
    /**
     * 台账更新时间
     */
    @ExcelProperty(value = "台账更新时间")
    private LocalDate specEqpCtUpLocalDate;
    /**
     * 所属工厂
     */
    @ExcelProperty(value = "所属工厂")
    private String specEqpCtFactory;
    /**
     * 备用1
     */
    @ExcelProperty(value = "备用1")
    private String specEqpCtBackup1;
    /**
     * 备用2
     */
    @ExcelProperty(value = "备用2")
    private String specEqpCtBackup2;
    /**
     * 备用3
     */
    @ExcelProperty(value = "备用3")
    private String specEqpCtBackup3;
}
