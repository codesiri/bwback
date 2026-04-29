package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 特种设备压缩机台账视图对象
 *
 * @author baiwei
 * @since 2026-02-09 09:07
 */
@Getter
@Setter
@Schema( description = "特种设备压缩机台账视图对象")
public class SeCompressorVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "压缩机设备编号")
    private String seCompressorEquipCode;
    @Schema(description = "设备名称")
    private String seCompressorName;
    @Schema(description = "压缩机类型")
    private String seCompressorType;
    @Schema(description = "规格型号")
    private String seCompressorSpec;
    @Schema(description = "额定排气量（m³/min）")
    private String seCompressorRatedFlow;
    @Schema(description = "额定排气压力（MPa）")
    private String seCompressorRatedPressure;
    @Schema(description = "额定输入功率（kW）")
    private String seCompressorRatedPower;
    @Schema(description = "额定转速（r/min）")
    private String seCompressorRatedSpeed;
    @Schema(description = "输送介质")
    private String seCompressorMedia;
    @Schema(description = "进气温度（℃）")
    private String seCompressorInletTemp;
    @Schema(description = "排气温度（℃）")
    private String seCompressorOutletTemp;
    @Schema(description = "设计压力（MPa）")
    private String seCompressorDesignP;
    @Schema(description = "主体 / 过流部件材质")
    private String seCompressorMaterial;
    @Schema(description = "防爆等级")
    private String seCompressorExplosionProof;
    @Schema(description = "配套电机型号")
    private String seCompressorMotorModel;
    @Schema(description = "润滑方式及油品")
    private String seCompressorLubrication;
    @Schema(description = "冷却方式（水冷 / 风冷）")
    private String seCompressorCoolingType;
    @Schema(description = "安装位置")
    private String seCompressorInstallPos;
    @Schema(description = "投用日期")
    private LocalDate seCompressorInService;
    @Schema(description = "定期检验周期")
    private String seCompressorInspectCycle;
    @Schema(description = "上次检验日期")
    private LocalDate seCompressorLastInspect;
    @Schema(description = "下次检验日期")
    private LocalDate seCompressorNextInspect;
    @Schema(description = "检验结果")
    private String seCompressorInspectResult;
    @Schema(description = "上次维保日期")
    private String seCompressorLastMaintain;
    @Schema(description = "下次维保日期")
    private String seCompressorNextMaintain;
    @Schema(description = "运行振动值（mm/s）")
    private String seCompressorVibration;
    @Schema(description = "压缩比")
    private String seCompressorPressureRatio;
    @Schema(description = "维保维修记录")
    private String seCompressorMaintainRecord;
    @Schema(description = "故障及异常记录")
    private String seCompressorFaultRecord;
    @Schema(description = "录入维护人员")
    private String seCompressorOperator;
    @Schema(description = "记录创建时间")
    private LocalDate seCompressorCreateTime;
    @Schema(description = "最后更新时间")
    private LocalDate seCompressorUpdateTime;
    @Schema(description = "设备状态")
    private String seCompressorStatus;
    @Schema(description = "所属工厂")
    private String seCompressorFactory;
    @Schema(description = "备用1")
    private String seCompressorReserve1;
    @Schema(description = "备用2")
    private String seCompressorReserve2;
    @Schema(description = "备用3")
    private String seCompressorReserve3;
}
