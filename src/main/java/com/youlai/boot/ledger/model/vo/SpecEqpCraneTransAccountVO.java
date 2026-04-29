package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;

import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 起重运输类视图对象
 *
 * @author baiwei
 * @since 2026-02-03 09:22
 */
@Getter
@Setter
@Schema( description = "起重运输类视图对象")
public class SpecEqpCraneTransAccountVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "设备编码")
    private String specEqpCtCode;
    @Schema(description = "设备名称")
    private String specEqpCtName;
    @Schema(description = "安装 / 使用区域、工段")
    private String specEqpCtArea;
    @Schema(description = "设备型号")
    private String specEqpCtModel;
    @Schema(description = "设备类型")
    private String specEqpCtType;
    @Schema(description = "额定起重量（t）")
    private String specEqpCtLiftingCapacity;
    @Schema(description = "额定起升高度（m）")
    private String specEqpCtLiftingHeight;
    @Schema(description = "起重机跨度（m）")
    private String specEqpCtSpan;
    @Schema(description = "设计压力")
    private String specEqpCtDesignPressure;
    @Schema(description = "制造厂家")
    private String specEqpCtManufacturer;
    @Schema(description = "出厂编号")
    private String specEqpCtFactoryNo;
    @Schema(description = "制造日期")
    private LocalDate specEqpCtProduceDate;
    @Schema(description = "安装单位")
    private String specEqpCtInstallCompany;
    @Schema(description = "安装日期")
    private LocalDate specEqpCtInstallDate;
    @Schema(description = "验收日期")
    private LocalDate specEqpCtAcceptanceDate;
    @Schema(description = "投用日期")
    private LocalDate specEqpCtUsageDate;
    @Schema(description = "特种设备使用登记")
    private String specEqpCtLicenseNo;
    @Schema(description = "设备状态")
    private String specEqpCtStatus;
    @Schema(description = "上次检验日期")
    private LocalDate specEqpCtLastInspectDate;
    @Schema(description = "下次检验日期")
    private LocalDate specEqpCtNextInspectDate;
    @Schema(description = "检验机构")
    private String specEqpCtInspectCompany;
    @Schema(description = "运维责任人")
    private String specEqpCtMaintainResponsible;
    @Schema(description = "维护检修记录")
    private String specEqpCtMaintainRecord;
    @Schema(description = "异常及事故记录")
    private String specEqpCtAccidentRecord;
    @Schema(description = "台账创建时间")
    private LocalDate specEqpCtCreateTime;
    @Schema(description = "台账更新时间")
    private LocalDate specEqpCtUpLocalDate;
    @Schema(description = "所属工厂")
    private String specEqpCtFactory;
    @Schema(description = "备用1")
    private String specEqpCtBackup1;
    @Schema(description = "备用2")
    private String specEqpCtBackup2;
    @Schema(description = "备用3")
    private String specEqpCtBackup3;
}
