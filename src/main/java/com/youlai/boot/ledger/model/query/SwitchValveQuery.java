package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 开关阀分页查询对象
 *
 * @author dazao
 * @since 2026-01-27 08:43
 */
@Schema(description ="开关阀查询对象")
@Getter
@Setter
public class SwitchValveQuery extends BasePageQuery {

    @Schema(description = "位号")
    private String switchValveTag;
    @Schema(description = "设备状态")
    private String status;
    @Schema(description = "s设备类型")
    private String dvType;
    @Schema(description = "所属工厂")
    private String factory;
}
