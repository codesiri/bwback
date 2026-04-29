package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 抽屉柜维护保养记录表单对象
 *
 * @author c
 * @since 2026-04-16 14:43
 */
@Getter
@Setter
@Schema(description = "抽屉柜维护保养记录表单对象")
public class ElectricCabinetMaintenanceForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;

    @Schema(description = "保养日期")
    @NotNull(message = "保养日期不能为空")
    private LocalDate ecmMaintainDate;

    @Schema(description = "保养人员")
    @NotBlank(message = "保养人员不能为空")
    @Size(max=255, message="保养人员长度不能超过255个字符")
    private String ecmMaintainPerson;

    @Schema(description = "保养级别")
    @NotBlank(message = "保养级别不能为空")
    @Size(max=255, message="保养级别长度不能超过255个字符")
    private String ecmMaintainLevel;

    @Schema(description = "保养项目")
    @NotBlank(message = "保养项目不能为空")
    @Size(max=255, message="保养项目长度不能超过255个字符")
    private String ecmMaintainItem;

    @Schema(description = "保养内容")
    @Size(max=255, message="保养内容长度不能超过255个字符")
    private String ecmMaintainContent;

    @Schema(description = "更换元器件")
    @Size(max=255, message="更换元器件长度不能超过255个字符")
    private String ecmReplaceComponent;

    @Schema(description = "保养结果")
    @NotBlank(message = "保养结果不能为空")
    @Size(max=255, message="保养结果长度不能超过255个字符")
    private String ecmMaintainResult;

    @Schema(description = "验收人")
    @Size(max=255, message="验收人长度不能超过255个字符")
    private String ecmChecker;

    @Schema(description = "下次保养日期")
    private LocalDate ecmNextMaintainDate;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String ecmFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String ecmReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String ecmReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String ecmReserve3;


}
