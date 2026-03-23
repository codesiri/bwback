package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 调节阀分页查询对象
 *
 * @author cc
 * @since 2026-01-28 11:03
 */
@Schema(description ="调节阀查询对象")
@Getter
@Setter
public class ControlValveQuery extends BasePageQuery {

    @Schema(description = "设备类型")
    private String dvType;
    @Schema(description = "位号")
    private String tagNo;
    @Schema(description = "设备状态")
    private Integer status;
    @Schema(description = "所属工厂")
    private Integer factory;

}

