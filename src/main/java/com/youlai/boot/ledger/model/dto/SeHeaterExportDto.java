package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;
/**
 * 换热器视图对象
 *
 * @author baiwei
 * @since 2026-03-03 10:16
 */
@Getter
@Setter
@Schema( description = "换热器视图对象")
public class SeHeaterExportDto {

    
    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "换热器设备编号")
    private String seHeaterEquipCode;
    @ExcelProperty(value = "换热器名称")
    private String seHeaterName;
    @ExcelProperty(value = "换热器类型")
    private String seHeaterType;
    @ExcelProperty(value = "设备规格")
    private String seHeaterSpec;
    @ExcelProperty(value = "换热面积（㎡）")
    private String seHeaterArea;
    @ExcelProperty(value = "设计压力（MPa）")
    private String seHeaterDesignP;
    @ExcelProperty(value = "设计温度（℃）")
    private String seHeaterDesignT;
    @ExcelProperty(value = "介质类型")
    private String seHeaterMedium;
    @ExcelProperty(value = "主体材质")
    private String seHeaterMaterial;
    @ExcelProperty(value = "安装位置")
    private String seHeaterInstallPos;
    @ExcelProperty(value = "投用日期")
    private LocalDate seHeaterInService;
    @ExcelProperty(value = "法定校验周期")
    private String seHeaterInspectCycle;
    @ExcelProperty(value = "上次校验日期")
    private String seHeaterLastInspect;
    @ExcelProperty(value = "下次校验日期")
    private String seHeaterNextInspect;
    @ExcelProperty(value = "检验结果")
    private String seHeaterInspectResult;
    @ExcelProperty(value = "清洗周期")
    private String seHeaterCleanCycle;
    @ExcelProperty(value = "上次清洗日期")
    private LocalDate seHeaterLastClean;
    @ExcelProperty(value = "下次清洗日期")
    private LocalDate seHeaterNextClean;
    @ExcelProperty(value = "污垢热阻（m²・K/W）")
    private String seHeaterFoulingRate;
    @ExcelProperty(value = "换热效率（%）")
    private String seHeaterEnergyEff;
    @ExcelProperty(value = "维保记录")
    private String seHeaterMaintainRecord;
    @ExcelProperty(value = "故障记录")
    private String seHeaterFaultRecord;
    @ExcelProperty(value = "台账录入 / 维护人员")
    private String seHeaterOperator;
    @ExcelProperty(value = "台账记录创建时间")
    private LocalDateTime seHeaterCreateTime;
    @ExcelProperty(value = "台账记录最后修改时间")
    private LocalDateTime seHeaterUpdateTime;
    @ExcelProperty(value = "设备状态")
    private String seHeaterStatus;
    @ExcelProperty(value = "所属工厂")
    private String seHeaterFactory;
    @ExcelProperty(value = "备用1")
    private String seHeaterReserve1;
    @ExcelProperty(value = "备用2")
    private String seHeaterReserve2;
    @ExcelProperty(value = "备用3")
    private String seHeaterReserve3;
}
