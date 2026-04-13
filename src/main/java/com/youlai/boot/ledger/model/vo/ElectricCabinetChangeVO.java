package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 抽屉柜变更记录视图对象
 *
 * @author dazao
 * @since 2026-03-13 11:16
 */
@Getter
@Setter
@Schema( description = "抽屉柜变更记录视图对象")
public class ElectricCabinetChangeVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "变更日期")
    private LocalDate eccChangeDate;
    @Schema(description = "变更申请人")
    private String eccApplicant;
    @Schema(description = "变更原因")
    private String eccChangeReason;
    @Schema(description = "变更内容")
    private String eccChangeContent;
    @Schema(description = "变更实施人")
    private String eccImplementer;
    @Schema(description = "验收人")
    private String eccChecker;
    @Schema(description = "变更后状态")
    private String eccAfterStatus;
    @Schema(description = "相关资料更新情况")
    private LocalDateTime eccDataUpdate;
    @Schema(description = "所属工厂")
    private String eccFactory;
    @Schema(description = "备用1")
    private String eccReserve1;
    @Schema(description = "备用2")
    private String eccReserve2;
    @Schema(description = "备用3")
    private String eccReserve3;
}
