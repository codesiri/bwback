package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectricCabinetDrawerUnitsExportDto {
    /**
     * 抽屉编号
     */
    @ExcelProperty("抽屉编号")
    private String ecduDrawerNo;
    /**
     * 单元名称
     */
    @ExcelProperty("单元名称")
    private String ecduUnitName;
    /**
     * 额定电流（A）
     */
    @ExcelProperty("额定电流（A）")
    private String ecduRatedCurrent;
    /**
     * 额定电压（V）
     */
    @ExcelProperty("额定电压（V）")
    private String ecduRatedVoltage;
    /**
     * 开关型号
     */
    @ExcelProperty("开关型号")
    private String ecduSwitchModel;
    /**
     * 开关厂家
     */
    @ExcelProperty("开关厂家")
    private String ecduSwitchManufacturer;
    /**
     * 整定电流（A）
     */
    @ExcelProperty("整定电流（A）")
    private String ecduSettingCurrent;
    /**
     * 对应负载
     */
    @ExcelProperty("对应负载")
    private String ecduCorrespondingLoad;
    /**
     * 安装位置
     */
    private String ecduInstallLocation;
    /**
     * 单元状态
     */
    private String ecduUnitStatus;
    /**
     * 所属工厂
     */
    private String ecduFactory;
}
