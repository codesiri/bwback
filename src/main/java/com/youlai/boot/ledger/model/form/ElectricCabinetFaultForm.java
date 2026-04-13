package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * 抽屉柜故障维修记录表单对象
 *
 * @author youlaitech
 * @since 2026-03-23 17:05
 */
@Getter
@Setter
@Schema(description = "抽屉柜故障维修记录表单对象")
public class ElectricCabinetFaultForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "故障日期")
    @NotNull(message = "故障日期不能为空")
    private LocalDate ecfFaultDate;

    @Schema(description = "故障发生时间")
    @NotNull(message = "故障发生时间不能为空")
    private LocalDate ecfFaultTime;

    @Schema(description = "故障柜体 / 抽屉编号")
    @NotBlank(message = "故障柜体 / 抽屉编号不能为空")
    @Size(max=255, message="故障柜体 / 抽屉编号长度不能超过255个字符")
    private String ecfFaultCabinet;

    @Schema(description = "故障现象")
    @NotBlank(message = "故障现象不能为空")
    @Size(max=255, message="故障现象长度不能超过255个字符")
    private String ecfFaultPhenomenon;

    @Schema(description = "故障原因分析")
    @Size(max=255, message="故障原因分析长度不能超过255个字符")
    private String ecfFaultReason;

    @Schema(description = "维修人员")
    @NotBlank(message = "维修人员不能为空")
    @Size(max=255, message="维修人员长度不能超过255个字符")
    private String ecfRepairPerson;

    @Schema(description = "维修方案")
    @Size(max=255, message="维修方案长度不能超过255个字符")
    private String ecfRepairScheme;

    @Schema(description = "更换元器件")
    @Size(max=255, message="更换元器件长度不能超过255个字符")
    private String ecfReplaceComponent;

    @Schema(description = "维修完成时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ecfRepairCompleteTime;

    @Schema(description = "	恢复运行时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ecfRecoverTime;

    @Schema(description = "维修结果")
    @NotBlank(message = "维修结果不能为空")
    @Size(max=255, message="维修结果长度不能超过255个字符")
    private String ecfRepairResult;

    @Schema(description = "验收人")
    @Size(max=255, message="验收人长度不能超过255个字符")
    private String ecfChecker;

    @Schema(description = "故障分类")
    @Size(max=255, message="故障分类长度不能超过255个字符")
    private String ecfFaultType;

    @Schema(description = "所属工厂")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String ecfFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String ecfReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String ecfReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String ecfReserve3;


}
