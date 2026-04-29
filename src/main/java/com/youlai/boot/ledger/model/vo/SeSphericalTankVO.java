package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
/**
 * 球罐视图对象
 *
 * @author baiwei
 * @since 2026-03-06 09:49
 */
@Getter
@Setter
@Schema( description = "球罐视图对象")
public class SeSphericalTankVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "球罐设备编号")
    private String seTankEquipCode;
    @Schema(description = "球罐名称")
    private String seTankName;
    @Schema(description = "规格型号")
    private String seTankSpec;
    @Schema(description = "设计容积（m³）")
    private String seTankDesignVolume;
    @Schema(description = "工作容积（m³）")
    private String seTankOperatingVolume;
    @Schema(description = "设计压力（MPa）")
    private String seTankDesignP;
    @Schema(description = "工作压力（MPa）")
    private String seTankOperatingP;
    @Schema(description = "设计温度（℃）")
    private String seTankDesignT;
    @Schema(description = "工作温度（℃）")
    private String seTankOperatingT;
    @Schema(description = "储存介质")
    private String seTankMedia;
    @Schema(description = "主体材质")
    private String seTankMaterial;
    @Schema(description = "罐体壁厚（mm）")
    private String seTankThickness;
    @Schema(description = "密封形式")
    private String seTankSealType;
    @Schema(description = "防腐措施")
    private String seTankAntiCorrosion;
    @Schema(description = "安全阀型号规格")
    private String seTankSafetyValveModel;
    @Schema(description = "安装位置")
    private String seTankInstallPos;
    @Schema(description = "投用日期")
    private String seTankInService;
    @Schema(description = "定期检验周期")
    private String seTankInspectCycle;
    @Schema(description = "上次检验日期")
    private LocalDate seTankLastInspect;
    @Schema(description = "下次检验日期")
    private LocalDate seTankNextInspect;
    @Schema(description = "检验结果")
    private String seTankInspectResult;
    @Schema(description = "上次水压 / 气压试验日期")
    private LocalDate seTankLastPressureTest;
    @Schema(description = "液位计型号")
    private String seTankLevelGaugeModel;
    @Schema(description = "腐蚀状况")
    private String seTankCorrosionStatus;
    @Schema(description = "维保维修记录")
    private String seTankMaintainRecord;
    @Schema(description = "故障及异常记录")
    private String seTankFaultRecord;
    @Schema(description = "录入维护人员")
    private String seTankOperator;
    @Schema(description = "记录创建时间")
    private LocalDate seTankCreateTime;
    @Schema(description = "最后更新时间")
    private LocalDate seTankUpdateTime;
    @Schema(description = "设备状态")
    private String seTankStatus;
    @Schema(description = "所属工厂")
    private String seTankFactory;
    @Schema(description = "备用1")
    private String seTankReserve1;
    @Schema(description = "备用2")
    private String seTankReserve2;
    @Schema(description = "备用3")
    private String seTankReserve3;
}
