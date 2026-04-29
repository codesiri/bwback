package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 特种设备膨胀机台账视图对象
 *
 * @author baiwei
 * @since 2026-02-09 09:15
 */
@Getter
@Setter
@Schema( description = "特种设备膨胀机台账视图对象")
public class SeExpanderVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "膨胀机设备编号")
    private String seExpanderEquipCode;
    @Schema(description = "设备名称")
    private String seExpanderName;
    @Schema(description = "设备类型")
    private String seExpanderType;
    @Schema(description = "规格型号")
    private String seExpanderSpec;
    @Schema(description = "额定功率")
    private String seExpanderRatedPower;
    @Schema(description = "额定转速")
    private String seExpanderRatedSpeed;
    @Schema(description = "进口压力")
    private String seExpanderInletP;
    @Schema(description = "进口温度")
    private String seExpanderInletT;
    @Schema(description = "出口压力")
    private String seExpanderOutletP;
    @Schema(description = "出口温度")
    private String seExpanderOutletT;
    @Schema(description = "工作介质")
    private String seExpanderMedia;
    @Schema(description = "主体材质")
    private String seExpanderMaterial;
    @Schema(description = "防爆等级")
    private String seExpanderExplosionProof;
    @Schema(description = "联轴器类型")
    private String seExpanderCouplingType;
    @Schema(description = "轴承类型")
    private String seExpanderBearingType;
    @Schema(description = "润滑方式及油品")
    private String seExpanderLubrication;
    @Schema(description = "安装位置")
    private String seExpanderInstallPos;
    @Schema(description = "投用日期")
    private String seExpanderInService;
    @Schema(description = "定期检验周期")
    private String seExpanderInspectCycle;
    @Schema(description = "上次检验日期")
    private String seExpanderLastInspect;
    @Schema(description = "下次检验日期")
    private String seExpanderNextInspect;
    @Schema(description = "检验结果")
    private String seExpanderInspectResult;
    @Schema(description = "上次润滑日期")
    private String seExpanderLastLubricate;
    @Schema(description = "下次润滑日期")
    private String seExpanderNextLubricate;
    @Schema(description = "运行振动值")
    private String seExpanderVibration;
    @Schema(description = "膨胀机运行效率")
    private String seExpanderEfficiency;
    @Schema(description = "维保维修记录")
    private String seExpanderMaintainRecord;
    @Schema(description = "故障及异常记录")
    private String seExpanderFaultRecord;
    @Schema(description = "录入 / 维护人员")
    private String seExpanderOperator;
    @Schema(description = "创建时间")
    private LocalDate seExpanderCreateTime;
    @Schema(description = "最后更新时间")
    private LocalDate seExpanderUpdateTime;
    @Schema(description = "设备状态")
    private String seExpanderStatus;
    @Schema(description = "所属工厂")
    private String seExpanderFactory;
    @Schema(description = "备用1")
    private String seExpanderReserve1;
    @Schema(description = "备用2")
    private String seExpanderReserve2;
    @Schema(description = "备用3")
    private String seExpanderReserve3;
}
