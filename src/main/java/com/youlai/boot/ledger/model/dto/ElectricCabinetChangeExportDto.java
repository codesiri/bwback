package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ElectricCabinetChangeExportDto {
    /**
     * 变更日期
     */
    @ExcelProperty("变更日期")
    private LocalDate eccChangeDate;
    /**
     * 变更申请人
     */
    @ExcelProperty("变更申请人")
    private String eccApplicant;
    /**
     * 变更原因
     */
    @ExcelProperty("变更原因")
    private String eccChangeReason;
    /**
     * 变更内容
     */
    @ExcelProperty("变更内容")
    private String eccChangeContent;
    /**
     * 变更实施人
     */
    @ExcelProperty("变更实施人")
    private String eccImplementer;
    /**
     * 验收人
     */
    @ExcelProperty("验收人")
    private String eccChecker;
    /**
     * 变更后状态
     */
    @ExcelProperty("变更后状态")
    private String eccAfterStatus;
    /**
     * 相关资料更新情况
     */
    @ExcelProperty("相关资料更新情况")
    private LocalDateTime eccDataUpdate;
    /**
     * 所属工厂
     */
    @ExcelProperty("所属工厂")
    private String eccFactory;
}
