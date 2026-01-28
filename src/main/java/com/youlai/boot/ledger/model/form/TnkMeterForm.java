package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * 罐区仪表单对象
 *
 * @author dazao
 * @since 2026-01-20 08:17
 */
@Getter
@Setter
@Schema(description = "罐区仪表单对象")
public class TnkMeterForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;

    @Schema(description = "仪表位号")
    @NotBlank(message = "仪表位号不能为空")
    @Size(max=255, message="仪表位号长度不能超过255个字符")
    private String tnkMeterTag;

    @Schema(description = "装置")
    @NotBlank(message = "装置不能为空")
    @Size(max=255, message="装置长度不能超过255个字符")
    private String tnkMeterDev;

    @Schema(description = "用途")
    @NotBlank(message = "用途不能为空")
    @Size(max=255, message="用途长度不能超过255个字符")
    private String tnkMeterPurp;

    @Schema(description = "回路分类")
    @Size(max=255, message="回路分类长度不能超过255个字符")
    private String tnkMeterLoop;

    @Schema(description = "仪表名称")
    @NotBlank(message = "仪表名称不能为空")
    @Size(max=255, message="仪表名称长度不能超过255个字符")
    private String tnkMeterName;

    @Schema(description = "型号")
    @NotBlank(message = "型号不能为空")
    @Size(max=255, message="型号长度不能超过255个字符")
    private String tnkMeterModel;

    @Schema(description = "规格")
    @NotBlank(message = "规格不能为空")
    @Size(max=255, message="规格长度不能超过255个字符")
    private String tnkMeterSpec;

    @Schema(description = "量程")
    @NotBlank(message = "量程不能为空")
    @Size(max=255, message="量程长度不能超过255个字符")
    private String tnkMeterRange;

    @Schema(description = "厂家")
    @NotBlank(message = "厂家不能为空")
    @Size(max=255, message="厂家长度不能超过255个字符")
    private String tnkMeterManu;

    @Schema(description = "测量值")
    @Size(max=255, message="测量值长度不能超过255个字符")
    private String tnkMeterMeas;

    @Schema(description = "工艺介质")
    @Size(max=255, message="工艺介质长度不能超过255个字符")
    private String tnkMeterMedProc;

    @Schema(description = "介质状态")
    @NotNull(message = "介质状态不能为空")
    private Integer tnkMeterMedStat;

    @Schema(description = "压力（Kpa）")
    @Size(max=255, message="压力（Kpa）长度不能超过255个字符")
    private String tnkMeterPress;

    @Schema(description = "温度（℃）")
    @Size(max=255, message="温度（℃）长度不能超过255个字符")
    private String tnkMeterTemp;

    @Schema(description = "公称通径")
    @Size(max=255, message="公称通径长度不能超过255个字符")
    private String tnkMeterNomDia;

    @Schema(description = "故障压力")
    @Size(max=255, message="故障压力长度不能超过255个字符")
    private String tnkMeterFaultPress;

    @Schema(description = "泄露状态")
    @NotNull(message = "泄露状态不能为空")
    private Integer tnkMeterLeakStat;

    @Schema(description = "等级")
    @Size(max=255, message="等级长度不能超过255个字符")
    private String tnkMeterLeakLv;

    @Schema(description = "检查时间")
    @NotNull(message = "检查时间不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tnkMeterChkTime;

    @Schema(description = "检查周期")
    @NotBlank(message = "检查周期不能为空")
    @Size(max=255, message="检查周期长度不能超过255个字符")
    private String tnkMeterChkCycle;

    @Schema(description = "出厂编号")
    @NotBlank(message = "出厂编号不能为空")
    @Size(max=255, message="出厂编号长度不能超过255个字符")
    private String tnkMeterFactoryNo;

    @Schema(description = "备注")
    @Size(max=65535, message="备注长度不能超过65535个字符")
    private String tnkMeterRemark;

    @Schema(description = "设备状态")
    @NotNull(message = "设备状态不能为空")
    private Integer status;

    @Schema(description = "设备类型")
    @Size(max=255, message="设备类型长度不能超过255个字符")
    private String dvType;

}
