package com.youlai.boot.ledger.model.query;


import java.time.LocalDate;

public class ElectricCabinetInspectionExportQuery {
    /**
     * 报告编号
     */
    private String eciReportNo;
    /**
     * 检修 / 试验日期
     */
    private LocalDate eciInspectDate;
    /**
     * 检修 / 试验单位
     */
    private String eciInspectUnit;
    /**
     * 检修 / 试验人员
     */
    private String eciInspectPerson;
    /**
     * 检修 / 试验类型
     */
    private String eciInspectType;
    /**
     * 检修 / 试验项目
     */
    private String eciInspectItem;
    /**
     * 试验数据
     */
    private String eciTestData;
    /**
     * 合格标准
     */
    private String eciStandard;
    /**
     * 结果判定
     */
    private String eciResult;
    /**
     * 整改内容
     */
    private String eciRectifyContent;
    /**
     * 复检结果
     */
    private String eciRecheckResult;
    /**
     * 所属工厂
     */
    private String eciFactory;

}
