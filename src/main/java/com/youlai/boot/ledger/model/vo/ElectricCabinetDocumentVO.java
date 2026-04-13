package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 抽屉柜相关资料归档视图对象
 *
 * @author dazao
 * @since 2026-03-12 09:11
 */
@Getter
@Setter
@Schema( description = "抽屉柜相关资料归档视图对象")
public class ElectricCabinetDocumentVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "资料名称")
    private String ecdDocName;
    @Schema(description = "资料类型")
    private String ecdDocType;
    @Schema(description = "	编号")
    private String ecdDocNo;
    @Schema(description = "归档日期")
    private LocalDate ecdArchiveDate;
    @Schema(description = "保管人")
    private String ecdCustodian;
    @Schema(description = "存放位置")
    private String ecdLocation;

}
