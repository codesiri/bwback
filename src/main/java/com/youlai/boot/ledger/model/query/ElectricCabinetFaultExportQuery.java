package com.youlai.boot.ledger.model.query;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ElectricCabinetFaultExportQuery {
    /**
     * 故障日期
     */
    private LocalDate ecfFaultDate;
    /**
     * 故障发生时间
     */
    private LocalDate ecfFaultTime;
    /**
     * 故障柜体 / 抽屉编号
     */
    private String ecfFaultCabinet;
    /**
     * 故障现象
     */
    private String ecfFaultPhenomenon;
    /**
     * 故障原因分析
     */
    private String ecfFaultReason;
    /**
     * 维修人员
     */
    private String ecfRepairPerson;
    /**
     * 维修方案
     */
    private String ecfRepairScheme;
    /**
     * 更换元器件
     */
    private String ecfReplaceComponent;
    /**
     * 维修完成时间
     */
    private LocalDateTime ecfRepairCompleteTime;
    /**
     * 	恢复运行时间
     */
    private LocalDateTime ecfRecoverTime;
    /**
     * 维修结果
     */
    private String ecfRepairResult;
    /**
     * 验收人
     */
    private String ecfChecker;
    /**
     * 故障分类
     */
    private String ecfFaultType;
    /**
     * 所属工厂
     */
    private String ecfFactory;
    /**
     * 备用1
     */
    private String ecfReserve1;
    /**
     * 备用2
     */
    private String ecfReserve2;
    /**
     * 备用3
     */
    private String ecfReserve3;
}
