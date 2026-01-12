package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 静设备视图对象
 *
 * @author dazao
 * @since 2026-01-08 08:37
 */
@Getter
@Setter
@Schema( description = "静设备视图对象")
public class StaticEquipVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Schema(description = "设备id")
    private long id;
    @Schema(description = "设备名称")
    private String staticEquipName;
    @Schema(description = "位号")
    private String staticEquipTag;
    @Schema(description = "所处位置")
    private String staticEquipLoc;
    @Schema(description = "操作温度")
    private String staticEquipOpTemp;
    @Schema(description = "操作压力")
    private String staticEquipOpPress;
    @Schema(description = "介质")
    private String staticEquipMed;
    @Schema(description = "出厂编号")
    private String staticEquipFactoryNo;
    @Schema(description = "类别")
    private String staticEquipCategory;
    @Schema(description = "重量（kg）")
    private String staticEquipWeght;
    @Schema(description = "检验日期")
    private LocalDateTime staticEquipInspestDate;
    @Schema(description = "下次检验日期")
    private LocalDateTime staticEquipNextInspestDate;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "设备编码")
    private String dvCode;
}
