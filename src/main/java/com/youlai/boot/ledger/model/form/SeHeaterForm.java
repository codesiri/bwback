package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
/**
 * 换热器表单对象
 *
 * @author baiwei
 * @since 2026-03-03 10:16
 */
@Getter
@Setter
@Schema(description = "换热器表单对象")
public class SeHeaterForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "换热器设备编号")
    @NotBlank(message = "换热器设备编号不能为空")
    @Size(max=255, message="换热器设备编号长度不能超过255个字符")
    private String seHeaterEquipCode;

    @Schema(description = "换热器名称")
    @NotBlank(message = "换热器名称不能为空")
    @Size(max=255, message="换热器名称长度不能超过255个字符")
    private String seHeaterName;

    @Schema(description = "换热器类型")
    @NotBlank(message = "换热器类型不能为空")
    @Size(max=255, message="换热器类型长度不能超过255个字符")
    private String seHeaterType;

    @Schema(description = "设备规格")
    @NotBlank(message = "设备规格不能为空")
    @Size(max=255, message="设备规格长度不能超过255个字符")
    private String seHeaterSpec;

    @Schema(description = "换热面积（㎡）")
    @NotBlank(message = "换热面积（㎡）不能为空")
    @Size(max=255, message="换热面积（㎡）长度不能超过255个字符")
    private String seHeaterArea;

    @Schema(description = "设计压力（MPa）")
    @NotBlank(message = "设计压力（MPa）不能为空")
    @Size(max=255, message="设计压力（MPa）长度不能超过255个字符")
    private String seHeaterDesignP;

    @Schema(description = "设计温度（℃）")
    @NotBlank(message = "设计温度（℃）不能为空")
    @Size(max=255, message="设计温度（℃）长度不能超过255个字符")
    private String seHeaterDesignT;

    @Schema(description = "介质类型")
    @NotBlank(message = "介质类型不能为空")
    @Size(max=255, message="介质类型长度不能超过255个字符")
    private String seHeaterMedium;

    @Schema(description = "主体材质")
    @NotBlank(message = "主体材质不能为空")
    @Size(max=255, message="主体材质长度不能超过255个字符")
    private String seHeaterMaterial;

    @Schema(description = "安装位置")
    @NotBlank(message = "安装位置不能为空")
    @Size(max=255, message="安装位置长度不能超过255个字符")
    private String seHeaterInstallPos;

    @Schema(description = "投用日期")
    private LocalDate seHeaterInService;

    @Schema(description = "法定校验周期")
    @NotBlank(message = "法定校验周期不能为空")
    @Size(max=255, message="法定校验周期长度不能超过255个字符")
    private String seHeaterInspectCycle;

    @Schema(description = "上次校验日期")
    @NotBlank(message = "上次校验日期不能为空")
    @Size(max=255, message="上次校验日期长度不能超过255个字符")
    private String seHeaterLastInspect;

    @Schema(description = "下次校验日期")
    @NotBlank(message = "下次校验日期不能为空")
    @Size(max=255, message="下次校验日期长度不能超过255个字符")
    private String seHeaterNextInspect;

    @Schema(description = "检验结果")
    @NotBlank(message = "检验结果不能为空")
    @Size(max=255, message="检验结果长度不能超过255个字符")
    private String seHeaterInspectResult;

    @Schema(description = "清洗周期")
    @NotBlank(message = "清洗周期不能为空")
    @Size(max=255, message="清洗周期长度不能超过255个字符")
    private String seHeaterCleanCycle;

    @Schema(description = "上次清洗日期")
    private LocalDate seHeaterLastClean;

    @Schema(description = "下次清洗日期")
    private LocalDate seHeaterNextClean;

    @Schema(description = "污垢热阻（m²・K/W）")
    @Size(max=255, message="污垢热阻（m²・K/W）长度不能超过255个字符")
    private String seHeaterFoulingRate;

    @Schema(description = "换热效率（%）")
    @Size(max=255, message="换热效率（%）长度不能超过255个字符")
    private String seHeaterEnergyEff;

    @Schema(description = "维保记录")
    @Size(max=255, message="维保记录长度不能超过255个字符")
    private String seHeaterMaintainRecord;

    @Schema(description = "故障记录")
    @Size(max=255, message="故障记录长度不能超过255个字符")
    private String seHeaterFaultRecord;

    @Schema(description = "台账录入 / 维护人员")
    @NotBlank(message = "台账录入 / 维护人员不能为空")
    @Size(max=255, message="台账录入 / 维护人员长度不能超过255个字符")
    private String seHeaterOperator;

    @Schema(description = "台账记录创建时间")
    @NotNull(message = "台账记录创建时间不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime seHeaterCreateTime;

    @Schema(description = "台账记录最后修改时间")
    @NotNull(message = "台账记录最后修改时间不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime seHeaterUpdateTime;

    @Schema(description = "设备状态")
    @Size(max=255, message="设备状态长度不能超过255个字符")
    private String seHeaterStatus;

    @Schema(description = "所属工厂")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String seHeaterFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String seHeaterReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String seHeaterReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String seHeaterReserve3;


}
