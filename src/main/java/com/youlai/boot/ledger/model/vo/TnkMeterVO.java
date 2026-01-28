package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 罐区仪视图对象
 *
 * @author dazao
 * @since 2026-01-20 08:17
 */
@Getter
@Setter
@Schema( description = "罐区仪视图对象")
public class TnkMeterVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private long id;
    @Schema(description = "仪表位号")
    private String tnkMeterTag;
    @Schema(description = "装置")
    private String tnkMeterDev;
    @Schema(description = "用途")
    private String tnkMeterPurp;
    @Schema(description = "回路分类")
    private String tnkMeterLoop;
    @Schema(description = "仪表名称")
    private String tnkMeterName;
    @Schema(description = "型号")
    private String tnkMeterModel;
    @Schema(description = "规格")
    private String tnkMeterSpec;
    @Schema(description = "量程")
    private String tnkMeterRange;
    @Schema(description = "厂家")
    private String tnkMeterManu;
    @Schema(description = "测量值")
    private String tnkMeterMeas;
    @Schema(description = "工艺介质")
    private String tnkMeterMedProc;
    @Schema(description = "介质状态")
    private Integer tnkMeterMedStat;
    @Schema(description = "压力（Kpa）")
    private String tnkMeterPress;
    @Schema(description = "温度（℃）")
    private String tnkMeterTemp;
    @Schema(description = "公称通径")
    private String tnkMeterNomDia;
    @Schema(description = "故障压力")
    private String tnkMeterFaultPress;
    @Schema(description = "泄露状态")
    private Integer tnkMeterLeakStat;
    @Schema(description = "等级")
    private String tnkMeterLeakLv;
    @Schema(description = "检查时间")
    private LocalDateTime tnkMeterChkTime;
    @Schema(description = "检查周期")
    private String tnkMeterChkCycle;
    @Schema(description = "出厂编号")
    private String tnkMeterFactoryNo;
    @Schema(description = "备注")
    private String tnkMeterRemark;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "设备类型")
    private String dvType;
}
