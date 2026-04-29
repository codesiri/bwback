package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 泵分页查询对象
 *
 * @author baiwei
 * @since 2026-02-05 14:46
 */
@Schema(description ="泵查询对象")
@Getter
@Setter
public class SePumpQuery extends BasePageQuery {

    @Schema(description = "泵设备编号")
    private String sePumpEquipCode;
    @Schema(description = "设备名称")
    private String sePumpName;
    @Schema(description = "泵类型")
    private Integer sePumpType;
    @Schema(description = "设备状态")
    private Integer sePumpStatus;

}
