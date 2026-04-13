package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 电器日常巡检记录表单对象
 *
 * @author cc
 * @since 2026-03-03 09:40
 */
@Getter
@Setter
@Schema(description = "电器日常巡检记录表单对象")
public class ElectricCabinetRecordForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;

    @Schema(description = "巡检日期")
    @NotNull(message = "巡检日期不能为空")
    private LocalDate ecrInspectDate;

    @Schema(description = "巡检人")
    @NotBlank(message = "巡检人不能为空")
    @Size(max=255, message="巡检人长度不能超过255个字符")
    private String ecrInspectPerson;

    @Schema(description = "巡检项目")
    @NotBlank(message = "巡检项目不能为空")
    @Size(max=255, message="巡检项目长度不能超过255个字符")
    private String ecrInspectItem;

    @Schema(description = "巡检结果")
    @NotBlank(message = "巡检结果不能为空")
    @Size(max=255, message="巡检结果长度不能超过255个字符")
    private String ecrInspectResult;

    @Schema(description = "问题描述")
    @Size(max=255, message="问题描述长度不能超过255个字符")
    private String ecrProblemDesc;

    @Schema(description = "处理措施")
    @Size(max=255, message="处理措施长度不能超过255个字符")
    private String ecrMeasure;

    @Schema(description = "处理人")
    @Size(max=255, message="处理人长度不能超过255个字符")
    private String ecrHandler;

    @Schema(description = "所属工厂")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String ecrFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String ecrReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String ecrReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String ecrReserve3;


}
