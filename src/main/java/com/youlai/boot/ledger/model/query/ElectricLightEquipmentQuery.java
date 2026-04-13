package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 电气照明设备分页查询对象
 *
 * @author dazao
 * @since 2026-02-04 09:24
 */
@Schema(description ="电气照明设备查询对象")
@Getter
@Setter
public class ElectricLightEquipmentQuery extends BasePageQuery {

    @Schema(description = "设备名称")
    private String eleLightName;
    @Schema(description = "生产厂家")
    private String eleManufacturer;
    @Schema(description = "投运日期")
    private List<String> eleCommissioningDate;
    @Schema(description = "上次维护日期")
    private List<String> eleLastMaintainDate;
    @Schema(description = "下次维护日期")
    private List<String> eleNextMaintainDate;
    @Schema(description = "	设备状态")
    private Integer eleStatus;
    @Schema(description = "所属工厂")
    private String eleFactory;
}
