package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.LocalDate;
/**
 * 立罐视图对象
 *
 * @author baiwei
 * @since 2026-03-06 10:04
 */
@Getter
@Setter
@Schema( description = "立罐视图对象")
public class SpecEqpVerticalTankAccountVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "立罐设备编码")
    private String specEqpVtCode;
    @Schema(description = "立罐名称")
    private String specEqpVtName;
    @Schema(description = "所在区域")
    private String specEqpVtArea;
    @Schema(description = "立罐型号")
    private String specEqpVtModel;
    @Schema(description = "罐体材质")
    private String specEqpVtMaterial;
    @Schema(description = "设计容积（m³）")
    private String specEqpVtVolume;
    @Schema(description = "设计压力（MPa）")
    private String specEqpVtDesignPressure;
    @Schema(description = "设计温度（℃）")
    private String specEqpVtDesignTemp;
    @Schema(description = "储存介质")
    private String specEqpVtMedia;
    @Schema(description = "介质特性")
    private String specEqpVtMediaProperty;
    @Schema(description = "制造厂家")
    private String specEqpVtManufacturer;
    @Schema(description = "出厂编号")
    private String specEqpVtFactoryNo;
    @Schema(description = "制造日期")
    private LocalDate specEqpVtProduceDate;
    @Schema(description = "安装单位")
    private String specEqpVtInstallCompany;
    @Schema(description = "安装日期")
    private LocalDate specEqpVtInstallDate;
    @Schema(description = "验收日期")
    private LocalDate specEqpVtAcceptanceDate;
    @Schema(description = "投用日期")
    private LocalDateTime specEqpVtUsageDate;
    @Schema(description = "特种设备使用登记")
    private Integer specEqpVtLicenseNo;
    @Schema(description = "设备状态")
    private String specEqpVtStatus;
    @Schema(description = "上次检验日期")
    private LocalDate specEqpVtLastInspectDate;
    @Schema(description = "下次检验日期")
    private LocalDate specEqpVtNextInspectDate;
    @Schema(description = "检验机构")
    private String specEqpVtInspectCompany;
    @Schema(description = "运维责任人")
    private String specEqpVtMaintainResponsible;
    @Schema(description = "最后一次维护记录")
    private String specEqpVtMaintainRecord;
    @Schema(description = "事故记录")
    private String specEqpVtAccidentRecord;
    @Schema(description = "创建时间")
    private LocalDate specEqpVtCreateTime;
    @Schema(description = "更新时间")
    private LocalDate specEqpVtUpdateTime;
    @Schema(description = "所属工厂")
    private String specEqpVtFactory;
    @Schema(description = "备用1")
    private String specEqpVtBackup1;
    @Schema(description = "备用2")
    private String specEqpVtBackup2;
    @Schema(description = "备用3")
    private String specEqpVtBackup3;
}
