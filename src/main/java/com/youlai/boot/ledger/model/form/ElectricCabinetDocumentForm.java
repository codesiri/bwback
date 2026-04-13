package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 抽屉柜相关资料归档表单对象
 *
 * @author dazao
 * @since 2026-03-12 09:11
 */
@Getter
@Setter
@Schema(description = "抽屉柜相关资料归档表单对象")
public class ElectricCabinetDocumentForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "资料名称")
    @Size(max=255, message="资料名称长度不能超过255个字符")
    private String ecdDocName;

    @Schema(description = "资料类型")
    @Size(max=255, message="资料类型长度不能超过255个字符")
    private String ecdDocType;

    @Schema(description = "	编号")
    @Size(max=255, message="	编号长度不能超过255个字符")
    private String ecdDocNo;

    @Schema(description = "归档日期")
    private LocalDate ecdArchiveDate;

    @Schema(description = "保管人")
    @Size(max=255, message="保管人长度不能超过255个字符")
    private String ecdCustodian;

    @Schema(description = "存放位置")
    @NotBlank(message = "存放位置不能为空")
    @Size(max=255, message="存放位置长度不能超过255个字符")
    private String ecdLocation;

    @Schema(description = "所属工厂")
    @NotBlank(message = "所属工厂不能为空")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String ecdFactory;
}
