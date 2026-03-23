package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ElectricCabinetDocumentExportDto {
    /**
     * 资料名称
     */
    @ExcelProperty("资料名称")
    private String ecdDocName;
    /**
     * 资料类型
     */
    @ExcelProperty("资料类型")
    private String ecdDocType;
    /**
     * 	编号
     */
    @ExcelProperty("编号")
    private String ecdDocNo;
    /**
     * 归档日期
     */
    @ExcelProperty("归档日期")
    private LocalDate ecdArchiveDate;
    /**
     * 保管人
     */
    @ExcelProperty("保管人")
    private String ecdCustodian;
    /**
     * 存放位置
     */
    @ExcelProperty("存放位置")
    private String ecdLocation;
    /**
     * 所属工厂
     */
    @ExcelProperty("所属工厂")
    private String ecdFactory;
}
