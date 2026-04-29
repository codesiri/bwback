package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
/**
 * 换热器视图对象
 *
 * @author baiwei
 * @since 2026-03-03 10:16
 */
@Getter
@Setter
@Schema( description = "换热器视图对象")
public class SeHeaterVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "换热器设备编号")
    private String seHeaterEquipCode;
    @Schema(description = "换热器名称")
    private String seHeaterName;
    @Schema(description = "换热器类型")
    private String seHeaterType;
    @Schema(description = "设备规格")
    private String seHeaterSpec;
    @Schema(description = "换热面积（㎡）")
    private String seHeaterArea;
    @Schema(description = "设计压力（MPa）")
    private String seHeaterDesignP;
    @Schema(description = "设计温度（℃）")
    private String seHeaterDesignT;
    @Schema(description = "介质类型")
    private String seHeaterMedium;
    @Schema(description = "主体材质")
    private String seHeaterMaterial;
    @Schema(description = "安装位置")
    private String seHeaterInstallPos;
    @Schema(description = "投用日期")
    private LocalDate seHeaterInService;
    @Schema(description = "法定校验周期")
    private String seHeaterInspectCycle;
    @Schema(description = "上次校验日期")
    private String seHeaterLastInspect;
    @Schema(description = "下次校验日期")
    private String seHeaterNextInspect;
    @Schema(description = "检验结果")
    private String seHeaterInspectResult;
    @Schema(description = "清洗周期")
    private String seHeaterCleanCycle;
    @Schema(description = "上次清洗日期")
    private LocalDate seHeaterLastClean;
    @Schema(description = "下次清洗日期")
    private LocalDate seHeaterNextClean;
    @Schema(description = "污垢热阻（m²・K/W）")
    private String seHeaterFoulingRate;
    @Schema(description = "换热效率（%）")
    private String seHeaterEnergyEff;
    @Schema(description = "维保记录")
    private String seHeaterMaintainRecord;
    @Schema(description = "故障记录")
    private String seHeaterFaultRecord;
    @Schema(description = "台账录入 / 维护人员")
    private String seHeaterOperator;
    @Schema(description = "台账记录创建时间")
    private LocalDateTime seHeaterCreateTime;
    @Schema(description = "台账记录最后修改时间")
    private LocalDateTime seHeaterUpdateTime;
    @Schema(description = "设备状态")
    private String seHeaterStatus;
    @Schema(description = "所属工厂")
    private String seHeaterFactory;
    @Schema(description = "备用1")
    private String seHeaterReserve1;
    @Schema(description = "备用2")
    private String seHeaterReserve2;
    @Schema(description = "备用3")
    private String seHeaterReserve3;
}
