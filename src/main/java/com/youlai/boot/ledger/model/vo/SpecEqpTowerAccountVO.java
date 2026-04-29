package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
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
public class SpecEqpTowerAccountVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "塔类设备编码")
    private String specEqpTowerCode;
    @Schema(description = "塔类设备名称")
    private String specEqpTowerName;
    @Schema(description = "所在区域")
    private String specEqpTowerArea;
    @Schema(description = "塔类设备型号")
    private String specEqpTowerModel;
    @Schema(description = "塔器类型")
    private String specEqpTowerType;
    @Schema(description = "塔体材质")
    private String specEqpTowerMaterial;
    @Schema(description = "塔体总高度（m）")
    private String specEqpTowerHeight;
    @Schema(description = "塔体公称直径（m）")
    private String specEqpTowerDiameter;
    @Schema(description = "塔板层数 / 填料高度（层 /m）")
    private String specEqpTowerLayer;
    @Schema(description = "设计压力（MPa）")
    private String specEqpTowerDesignPressure;
    @Schema(description = "设计温度（℃）")
    private String specEqpTowerDesignTemp;
    @Schema(description = "处理介质")
    private String specEqpTowerMedia;
    @Schema(description = "介质特性")
    private String specEqpTowerMediaProperty;
    @Schema(description = "制造厂家")
    private String specEqpTowerManufacturer;
    @Schema(description = "出厂编号")
    private String specEqpTowerFactoryNo;
    @Schema(description = "制造日期")
    private LocalDate specEqpTowerProduceDate;
    @Schema(description = "安装单位")
    private String specEqpTowerInstallCompany;
    @Schema(description = "安装日期")
    private LocalDate specEqpTowerInstallDate;
    @Schema(description = "验收日期")
    private LocalDate specEqpTowerAcceptanceDate;
    @Schema(description = "投用日期")
    private LocalDate specEqpTowerUsageDate;
    @Schema(description = "特种设备使用登记")
    private String specEqpTowerLicenseNo;
    @Schema(description = "设备状态")
    private String specEqpTowerStatus;
    @Schema(description = "上次检验日期")
    private LocalDate specEqpTowerLastInspectDate;
    @Schema(description = "下次检验日期")
    private LocalDate specEqpTowerNextInspectDate;
    @Schema(description = "检验机构")
    private String specEqpTowerInspectCompany;
    @Schema(description = "运维负责人")
    private String specEqpTowerMaintainResponsible;
    @Schema(description = "最后一次维护记录")
    private String specEqpTowerMaintainRecord;
    @Schema(description = "事故记录")
    private String specEqpTowerAccidentRecord;
    @Schema(description = "创建时间")
    private LocalDate specEqpTowerCreateTime;
    @Schema(description = "更新时间")
    private LocalDate specEqpTowerUpdateTime;
    @Schema(description = "所属工厂")
    private String specEqpTowerFactory;
    @Schema(description = "备用1")
    private String specEqpTowerBackup1;
    @Schema(description = "备用2")
    private String specEqpTowerBackup2;
    @Schema(description = "备用3")
    private String specEqpTowerBackup3;
}
