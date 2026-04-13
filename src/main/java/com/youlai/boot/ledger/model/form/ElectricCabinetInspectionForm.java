package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 抽屉柜检修试验记录表单对象
 *
 * @author youlaitech
 * @since 2026-03-18 16:19
 */
@Getter
@Setter
@Schema(description = "抽屉柜检修试验记录表单对象")
public class ElectricCabinetInspectionForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "报告编号")
    @NotBlank(message = "报告编号不能为空")
    @Size(max=255, message="报告编号长度不能超过255个字符")
    private String eciReportNo;

    @Schema(description = "检修 / 试验日期")
    @NotNull(message = "检修 / 试验日期不能为空")
    private LocalDate eciInspectDate;

    @Schema(description = "检修 / 试验单位")
    @NotBlank(message = "检修 / 试验单位不能为空")
    @Size(max=255, message="检修 / 试验单位长度不能超过255个字符")
    private String eciInspectUnit;

    @Schema(description = "检修 / 试验人员")
    @NotBlank(message = "检修 / 试验人员不能为空")
    @Size(max=255, message="检修 / 试验人员长度不能超过255个字符")
    private String eciInspectPerson;

    @Schema(description = "检修 / 试验类型")
    @NotBlank(message = "检修 / 试验类型不能为空")
    @Size(max=255, message="检修 / 试验类型长度不能超过255个字符")
    private String eciInspectType;

    @Schema(description = "检修 / 试验项目")
    @NotBlank(message = "检修 / 试验项目不能为空")
    @Size(max=255, message="检修 / 试验项目长度不能超过255个字符")
    private String eciInspectItem;

    @Schema(description = "试验数据")
    @Size(max=255, message="试验数据长度不能超过255个字符")
    private String eciTestData;

    @Schema(description = "合格标准")
    @Size(max=255, message="合格标准长度不能超过255个字符")
    private String eciStandard;

    @Schema(description = "结果判定")
    @NotBlank(message = "结果判定不能为空")
    @Size(max=255, message="结果判定长度不能超过255个字符")
    private String eciResult;

    @Schema(description = "整改内容")
    @Size(max=255, message="整改内容长度不能超过255个字符")
    private String eciRectifyContent;

    @Schema(description = "复检结果")
    @Size(max=255, message="复检结果长度不能超过255个字符")
    private String eciRecheckResult;

    @Schema(description = "所属工厂")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String eciFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String eciReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String eciReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String eciReserve3;


}
