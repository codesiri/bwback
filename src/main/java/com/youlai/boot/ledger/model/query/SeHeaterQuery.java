package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 换热器分页查询对象
 *
 * @author baiwei
 * @since 2026-03-03 10:16
 */
@Schema(description ="换热器查询对象")
@Getter
@Setter
public class SeHeaterQuery extends BasePageQuery {

    @Schema(description = "换热器设备编号")
    private String seHeaterEquipCode;
    @Schema(description = "换热器名称")
    private String seHeaterName;
    @Schema(description = "设备状态")
    private Integer seHeaterStatus;
    @Schema(description = "所属工厂")
    private Integer seHeaterFactory;

}
