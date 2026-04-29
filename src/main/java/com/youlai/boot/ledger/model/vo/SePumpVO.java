package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
/**
 * 泵视图对象
 *
 * @author baiwei
 * @since 2026-02-05 14:46
 */
@Getter
@Setter
@Schema( description = "泵视图对象")
public class SePumpVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "泵设备编号")
    private String sePumpEquipCode;
    @Schema(description = "设备名称")
    private String sePumpName;
    @Schema(description = "泵类型")
    private String sePumpType;
    @Schema(description = "设备状态")
    private String sePumpStatus;
    @Schema(description = "规格型号")
    private String sePumpSpec;
    @Schema(description = "额定流量")
    private String sePumpFlow;
    @Schema(description = "额定量程")
    private String sePumpHead;
    @Schema(description = "额定功率")
    private String sePumpRatedPower;
    @Schema(description = "额定转速")
    private String sePumpRatedSpeed;
    @Schema(description = "输送介质")
    private String sePumpMedium;
    @Schema(description = "介质温度")
    private String sePumpMediumTemp;
    @Schema(description = "设计压力")
    private String sePumpDesignP;
    @Schema(description = "过流部件材质")
    private String sePumpMaterial;
    @Schema(description = "密封形式")
    private String sePumpSealType;
    @Schema(description = "防爆等级")
    private String sePumpExplosionProof;
    @Schema(description = "配套电机型号")
    private String sePumpMotorModel;
    @Schema(description = "安装位置")
    private String sePumpInstallPos;
    @Schema(description = "投用日期")
    private String sePumpInService;
    @Schema(description = "定期检验周期")
    private String sePumpInspectCycle;
    @Schema(description = "上次检验日期")
    private LocalDate sePumpLastInspect;
    @Schema(description = "下次检验日期")
    private LocalDate sePumpNextInspect;
    @Schema(description = "检验结果")
    private String sePumpInspectResult;
    @Schema(description = "上次维保日期")
    private LocalDate sePumpLastMaintain;
    @Schema(description = "下次维保日期")
    private LocalDate sePumpNextMaintain;
    @Schema(description = "运行振动值")
    private String sePumpVibration;
    @Schema(description = "密封泄漏状态")
    private String sePumpLeakStatus;
    @Schema(description = "维保维修记录")
    private String sePumpMaintainRecord;
    @Schema(description = "故障及异常记录")
    private String sePumpFaultRecord;
    @Schema(description = "录入维护人员")
    private String sePumpOperator;
    @Schema(description = "记录创建时间")
    private LocalDate sePumpCreateTime;
    @Schema(description = "最后更新时间")
    private LocalDate sePumpUpdateTime;
    @Schema(description = "所属工厂")
    private String sePumpFactory;
    @Schema(description = "备用1")
    private String sePumpReserve1;
    @Schema(description = "备用2")
    private String sePumpReserve2;
    @Schema(description = "备用3")
    private String sePumpReserve3;
}
