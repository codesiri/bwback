package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 特种设备膨胀机台账分页查询对象
 *
 * @author baiwei
 * @since 2026-02-09 09:15
 */
@Schema(description ="特种设备膨胀机台账查询对象")
@Getter
@Setter
public class SeExpanderQuery extends BasePageQuery {
    @Schema(description = "膨胀机设备编号")
    private String seExpanderEquipCode;
    @Schema(description = "设备名称")
    private String seExpanderName;
    @Schema(description = "设备状态")
    private Integer seExpanderStatus;
    @Schema(description = "所属工厂")
    private Integer seExpanderFactory;

}
