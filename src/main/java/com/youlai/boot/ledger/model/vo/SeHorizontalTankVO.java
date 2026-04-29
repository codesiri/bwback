package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
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
public class SeHorizontalTankVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "卧罐设备编号")
    private String seHtankEquipCode;
    @Schema(description = "卧罐名称")
    private String seHtankName;
    @Schema(description = "规格型号")
    private String seHtankSpec;
    @Schema(description = "设计容积（m³）")
    private String seHtankDesignVolume;
    @Schema(description = "工作容积（m³）")
    private String seHtankOperatingVolume;
    @Schema(description = "设计压力（MPa）")
    private String seHtankDesignP;
    @Schema(description = "工作压力（MPa）")
    private String seHtankOperatingP;
    @Schema(description = "设计温度（℃）")
    private String seHtankDesignT;
    @Schema(description = "工作温度（℃）")
    private String seHtankOperatingT;
    @Schema(description = "储存介质")
    private String seHtankMedia;
    @Schema(description = "主体材质")
    private String seHtankMaterial;
    @Schema(description = "罐体壁厚（mm）")
    private String seHtankThickness;
    @Schema(description = "密封形式")
    private String seHtankSealType;
    @Schema(description = "防腐措施")
    private String seHtankAntiCorrosion;
    @Schema(description = "支撑形式")
    private String seHtankSupportType;
    @Schema(description = "安全阀型号规格（核心安全附件，需定期校验）")
    private String seHtankSafetyValveModel;
    @Schema(description = "安装位置")
    private String seHtankInstallPos;
    @Schema(description = "投用日期")
    private LocalDate seHtankInService;
    @Schema(description = "定期检验周期（全面检验每 3 年，年度检查每年，按规范执行）")
    private String seHtankInspectCycle;
    @Schema(description = "上次检验日期（含无损检测、压力试验、密封校验）")
    private LocalDate seHtankLastInspect;
    @Schema(description = "下次检验日期（系统预警用，同步安全附件校验周期）")
    private LocalDate seHtankNextInspect;
    @Schema(description = "检验结果")
    private String seHtankInspectResult;
    @Schema(description = "上次水压 / 气压试验日期")
    private String seHtankLastPressureTest;
    @Schema(description = "液位计型号")
    private String seHtankLevelGaugeModel;
    @Schema(description = "腐蚀状况")
    private String seHtankCorrosionStatus;
    @Schema(description = "维保维修记录")
    private String seHtankMaintainRecord;
    @Schema(description = "故障及异常记录")
    private String seHtankFaultRecord;
    @Schema(description = "录入维护人员")
    private String seHtankOperator;
    @Schema(description = "记录创建时间")
    private LocalDate seHtankCreateTime;
    @Schema(description = "最后更新时间")
    private LocalDate seHtankUpdateTime;
    @Schema(description = "设备状态")
    private String seHtankStatus;
    @Schema(description = "所属工厂")
    private String seHtankFactory;
    @Schema(description = "备用1")
    private String seHtankReserve1;
    @Schema(description = "备用2")
    private String seHtankReserve2;
    @Schema(description = "备用3")
    private String seHtankReserve3;
}
