package com.youlai.boot.ledger.model.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import com.youlai.boot.common.base.BasePageQuery;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description ="压力查询对象修改")
@Getter
@Setter
public class PressureInstrumentQueryPlus extends BasePageQuery {

    //    String pressure_tag,String pressure_device
    @Schema(description="位号")
    private String pressureTag;

    @Schema(description="装置名称")
    private String pressureDevice;

}

