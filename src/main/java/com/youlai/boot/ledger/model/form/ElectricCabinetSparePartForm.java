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
 * 电器备品备件管理记录表单对象
 *
 * @author youlaitech
 * @since 2026-03-04 08:46
 */
@Getter
@Setter
@Schema(description = "电器备品备件管理记录表单对象")
public class ElectricCabinetSparePartForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "备件名称")
    @NotBlank(message = "备件名称不能为空")
    @Size(max=255, message="备件名称长度不能超过255个字符")
    private String ecspPartName;

    @Schema(description = "规格型号")
    @NotBlank(message = "规格型号不能为空")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String ecspSpecModel;

    @Schema(description = "对应柜体 / 抽屉")
    @Size(max=255, message="对应柜体 / 抽屉长度不能超过255个字符")
    private String ecspCorrespondingCabinet;

    @Schema(description = "额定参数")
    @Size(max=255, message="额定参数长度不能超过255个字符")
    private String ecspRatedParameters;

    @Schema(description = "生产厂家")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String ecspManufacturer;

    @Schema(description = "库存数量")
    @NotBlank(message = "库存数量不能为空")
    @Size(max=255, message="库存数量长度不能超过255个字符")
    private String ecspStockQuantity;

    @Schema(description = "入库日期")
    @NotNull(message = "入库日期不能为空")
    private LocalDate ecspStockDate;

    @Schema(description = "领用数量")
    @Size(max=255, message="领用数量长度不能超过255个字符")
    private String ecspUsedQuantity;

    @Schema(description = "领用日期")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ecspUsedDate;

    @Schema(description = "领用原因")
    @Size(max=255, message="领用原因长度不能超过255个字符")
    private String ecspUsedReason;

    @Schema(description = "领用人")
    @Size(max=255, message="领用人长度不能超过255个字符")
    private String ecspUser;

    @Schema(description = "补充日期")
    private LocalDate ecspSupplementDate;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String ecspFactory;


}
