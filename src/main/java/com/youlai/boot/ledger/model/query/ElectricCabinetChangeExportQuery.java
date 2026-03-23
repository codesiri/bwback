package com.youlai.boot.ledger.model.query;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
public class ElectricCabinetChangeExportQuery {
    /**
     * 变更日期
     */
    private LocalDate eccChangeDate;
    /**
     * 变更申请人
     */
    private String eccApplicant;
    /**
     * 变更原因
     */
    private String eccChangeReason;
    /**
     * 变更内容
     */
    private String eccChangeContent;
    /**
     * 变更实施人
     */
    private String eccImplementer;
    /**
     * 验收人
     */
    private String eccChecker;
    /**
     * 变更后状态
     */
    private String eccAfterStatus;
    /**
     * 相关资料更新情况
     */
    private LocalDateTime eccDataUpdate;
    /**
     * 所属工厂
     */
    private String eccFactory;
    /**
     * 备用1
     */
    private String eccReserve1;
    /**
     * 备用2
     */
    private String eccReserve2;
    /**
     * 备用3
     */
    private String eccReserve3;
}
