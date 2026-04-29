package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 特种设备压缩机台账分页查询对象
 *
 * @author baiwei
 * @since 2026-02-09 09:07
 */
@Schema(description ="特种设备压缩机台账查询对象")
@Getter
@Setter
public class SeCompressorQuery extends BasePageQuery {

    @Schema(description = "压缩机设备编号")
    private String seCompressorEquipCode;
    @Schema(description = "设备名称")
    private String seCompressorName;
    @Schema(description = "设备状态")
    private Integer seCompressorStatus;
    @Schema(description = "所属工厂")
    private Integer seCompressorFactory;
}
