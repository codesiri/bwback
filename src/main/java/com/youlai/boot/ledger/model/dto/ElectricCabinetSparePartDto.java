package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ElectricCabinetSparePartDto {
    /**
     * 备件名称
     */
    @ExcelProperty("备件名称")
    private String ecspPartName;
    /**
     * 规格型号
     */
    @ExcelProperty("规格型号")
    private String ecspSpecModel;
    /**
     * 对应柜体 / 抽屉
     */
    @ExcelProperty("对应柜体 / 抽屉")
    private String ecspCorrespondingCabinet;
    /**
     * 额定参数
     */
    @ExcelProperty("额定参数")
    private String ecspRatedParameters;
    /**
     * 生产厂家
     */
    @ExcelProperty("生产厂家")
    private String ecspManufacturer;
    /**
     * 库存数量
     */
    @ExcelProperty("库存数量")
    private String ecspStockQuantity;
    /**
     * 入库日期
     */
    @ExcelProperty("入库日期")
    private LocalDate ecspStockDate;
    /**
     * 领用数量
     */
    @ExcelProperty("领用数量")
    private String ecspUsedQuantity;
    /**
     * 领用日期
     */
    @ExcelProperty("领用日期")
    private LocalDateTime ecspUsedDate;
    /**
     * 领用原因
     */
    @ExcelProperty("领用原因")
    private String ecspUsedReason;
    /**
     * 领用人
     */
    @ExcelProperty("领用人")
    private String ecspUser;
    /**
     * 补充日期
     */
    @ExcelProperty("补充日期")
    private LocalDate ecspSupplementDate;
    /**
     * 所属工厂
     */
    @ExcelProperty("所属工厂")
    private String ecspFactory;
}
