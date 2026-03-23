package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ElectricCabinetMainComponentDto {
    private static final long serialVersionUID = 1L;

    /**
     * 元器件名称
     */
    @ExcelProperty("元器件名称")
    private String ecmComponentName;
    /**
     * 规格型号
     */
    @ExcelProperty("规格型号")
    private String ecmSpecModel;
    /**
     * 生产厂家
     */
    @ExcelProperty("生产厂家")
    private String ecmManufacturer;
    /**
     * 出厂编号
     */
    @ExcelProperty("出厂编号")
    private String ecmFactoryNo;
    /**
     * 安装位置
     */
    @ExcelProperty("安装位置")
    private String ecmInstallLocation;
    /**
     * 投运日期
     */
    @ExcelProperty("投运日期")
    private LocalDate ecmCommissioningDate;
    /**
     * 额定参数
     */
    @ExcelProperty("额定参数")
    private String ecmRatedParameters;
    /**
     * 所属工厂
     */
    @ExcelProperty("所属工厂")
    private String ecmFactory;
}
