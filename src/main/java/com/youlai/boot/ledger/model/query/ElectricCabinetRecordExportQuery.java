package com.youlai.boot.ledger.model.query;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ElectricCabinetRecordExportQuery {
    /**
     * 巡检日期
     */
    private LocalDate ecrInspectDate;
    /**
     * 巡检人
     */
    private String ecrInspectPerson;
    /**
     * 巡检项目
     *
     */
    private String ecrInspectItem;
    /**
     * 巡检结果
     */
    private String ecrInspectResult;
    /**
     * 所属工厂
     */
    private String ecrFactory;
}
