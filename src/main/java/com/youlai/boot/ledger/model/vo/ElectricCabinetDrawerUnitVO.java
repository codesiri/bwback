package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 抽屉柜抽屉单元明细视图对象
 *
 * @author youlaitech
 * @since 2026-03-17 09:40
 */
@Getter
@Setter
@Schema( description = "抽屉柜抽屉单元明细视图对象")
public class ElectricCabinetDrawerUnitVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "抽屉编号")
    private String ecduDrawerNo;
    @Schema(description = "单元名称")
    private String ecduUnitName;
    @Schema(description = "额定电流（A）")
    private String ecduRatedCurrent;
    @Schema(description = "额定电压（V）")
    private String ecduRatedVoltage;
    @Schema(description = "开关型号")
    private String ecduSwitchModel;
    @Schema(description = "开关厂家")
    private String ecduSwitchManufacturer;
    @Schema(description = "整定电流（A）")
    private String ecduSettingCurrent;
    @Schema(description = "对应负载")
    private String ecduCorrespondingLoad;
    @Schema(description = "安装位置")
    private String ecduInstallLocation;
    @Schema(description = "单元状态")
    private String ecduUnitStatus;
    @Schema(description = "所属工厂")
    private String ecduFactory;
    @Schema(description = "备用1")
    private String ecduReserve1;
    @Schema(description = "备用2")
    private String ecduReserve2;
    @Schema(description = "备用3")
    private String ecduReserve3;
}
