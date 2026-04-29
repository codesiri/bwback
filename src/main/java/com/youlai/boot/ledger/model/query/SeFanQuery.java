package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 特种设备风机台账分页查询对象
 *
 * @author youlaitech
 * @since 2026-02-09 09:18
 */
@Schema(description ="特种设备风机台账查询对象")
@Getter
@Setter
public class SeFanQuery extends BasePageQuery {
    @Schema(description = "风机设备编号")
    private String seFanEquipCode;
    @Schema(description = "设备名称")
    private String seFanName;
    @Schema(description = "设备状态")
    private Integer seFanStatus;
    @Schema(description = "所属工厂")
    private Integer seFanFactory;

}
