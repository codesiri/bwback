package com.youlai.boot.ledger.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RelayProtectionSettingDto {
    /**
     * 继电器编号
     */
    private String rpsRelayCode;
    /**
     * 继电器类型
     */
    private String rpsRelayType;
    /**
     * 继电器型号
     */
    private String rpsRelayModel;
    /**
     * 过流保护定值（A）
     */
    private String rpsOvercurrentSetting;
    /**
     * 过流保护延时（s）
     */
    private String rpsOvercurrentDelay;
    /**
     * 速断保护定值（A）
     */
    private String rpsInstantaneousSetting;
    /**
     * 接地故障定值（A）
     */
    private String rpsEarthFaultSetting;
    /**
     * 过载保护定值（%）
     */
    private String rpsOverloadSetting;
    /**
     * 定值整定日期
     */
    private LocalDate rpsSettingDate;
    /**
     * 整定人员
     */
    private String rpsSettingPerson;
    /**
     * 上次校验日期
     */
    private LocalDate rpsLastCheckDate;
    /**
     * 下次校验日期
     */
    private LocalDate rpsNextCheckDate;
    /**
     * 定值变更记录
     */
    private String rpsChangeRecord;
    /**
     * 安装位置
     */
    private String rpsInstallPosition;
    /**
     * 所属工厂
     */
    private String rpsFactory;
    /**
     * 备用1
     */
    private String rpsReserve1;
    /**
     * 备用2
     */
    private String rpsReserve2;
    /**
     * 备用3
     */
    private String rpsReserve3;
}
