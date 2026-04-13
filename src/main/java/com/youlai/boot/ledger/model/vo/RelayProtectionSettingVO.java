package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 继电保护定值台账视图对象
 *
 * @author dazao
 * @since 2026-02-11 09:41
 */
@Getter
@Setter
@Schema( description = "继电保护定值台账视图对象")
public class RelayProtectionSettingVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "继电器编号")
    private String rpsRelayCode;
    @Schema(description = "继电器类型")
    private String rpsRelayType;
    @Schema(description = "继电器型号")
    private String rpsRelayModel;
    @Schema(description = "过流保护定值（A）")
    private String rpsOvercurrentSetting;
    @Schema(description = "过流保护延时（s）")
    private String rpsOvercurrentDelay;
    @Schema(description = "速断保护定值（A）")
    private String rpsInstantaneousSetting;
    @Schema(description = "接地故障定值（A）")
    private String rpsEarthFaultSetting;
    @Schema(description = "过载保护定值（%）")
    private String rpsOverloadSetting;
    @Schema(description = "定值整定日期")
    private LocalDate rpsSettingDate;
    @Schema(description = "整定人员")
    private String rpsSettingPerson;
    @Schema(description = "上次校验日期")
    private LocalDate rpsLastCheckDate;
    @Schema(description = "下次校验日期")
    private LocalDate rpsNextCheckDate;
    @Schema(description = "定值变更记录")
    private String rpsChangeRecord;
    @Schema(description = "安装位置")
    private String rpsInstallPosition;
    @Schema(description = "所属工厂")
    private String rpsFactory;
}
