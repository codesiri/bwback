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
 * 抽屉柜变更记录表单对象
 *
 * @author dazao
 * @since 2026-03-13 11:16
 */
@Getter
@Setter
@Schema(description = "抽屉柜变更记录表单对象")
public class ElectricCabinetChangeForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;

    @Schema(description = "变更日期")
    @NotNull(message = "变更日期不能为空")
    private LocalDate eccChangeDate;

    @Schema(description = "变更申请人")
    @NotBlank(message = "变更申请人不能为空")
    @Size(max=255, message="变更申请人长度不能超过255个字符")
    private String eccApplicant;

    @Schema(description = "变更原因")
    @NotBlank(message = "变更原因不能为空")
    @Size(max=255, message="变更原因长度不能超过255个字符")
    private String eccChangeReason;

    @Schema(description = "变更内容")
    @NotBlank(message = "变更内容不能为空")
    @Size(max=255, message="变更内容长度不能超过255个字符")
    private String eccChangeContent;

    @Schema(description = "变更实施人")
    @NotBlank(message = "变更实施人不能为空")
    @Size(max=255, message="变更实施人长度不能超过255个字符")
    private String eccImplementer;

    @Schema(description = "验收人")
    @Size(max=255, message="验收人长度不能超过255个字符")
    private String eccChecker;

    @Schema(description = "变更后状态")
    @NotBlank(message = "变更后状态不能为空")
    @Size(max=255, message="变更后状态长度不能超过255个字符")
    private String eccAfterStatus;

    @Schema(description = "相关资料更新情况")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eccDataUpdate;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String eccFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String eccReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String eccReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String eccReserve3;


}
