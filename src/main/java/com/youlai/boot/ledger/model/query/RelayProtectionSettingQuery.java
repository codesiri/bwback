package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 继电保护定值台账分页查询对象
 *
 * @author dazao
 * @since 2026-02-11 09:41
 */
@Schema(description ="继电保护定值台账查询对象")
@Getter
@Setter
public class RelayProtectionSettingQuery extends BasePageQuery {

    @Schema(description = "继电器编号")
    private String rpsRelayCode;
    @Schema(description = "继电器类型")
    private String rpsRelayType;
    @Schema(description = "上次校验日期")
    private List<String> rpsLastCheckDate;
    @Schema(description = "下次校验日期")
    private List<String> rpsNextCheckDate;
    @Schema(description = "安装位置")
    private String rpsInstallPosition;
    @Schema(description = "所属工厂")
    private String rpsFactory;
}
