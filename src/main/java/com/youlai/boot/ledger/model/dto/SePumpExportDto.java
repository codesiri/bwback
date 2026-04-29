package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

/**
 * 泵视图对象
 *
 * @author baiwei
 * @since 2026-02-05 14:46
 */
@Getter
@Setter
@Schema( description = "泵导出导入视图对象")
public class SePumpExportDto {


    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "泵设备编号")
    private String sePumpEquipCode;
    @ExcelProperty(value = "设备名称")
    private String sePumpName;
    @ExcelProperty(value = "泵类型")
    private String sePumpType;
    @ExcelProperty(value = "设备状态")
    private String sePumpStatus;
    @ExcelProperty(value = "规格型号")
    private String sePumpSpec;
    @ExcelProperty(value = "额定流量")
    private String sePumpFlow;
    @ExcelProperty(value = "额定量程")
    private String sePumpHead;
    @ExcelProperty(value = "额定功率")
    private String sePumpRatedPower;
    @ExcelProperty(value = "额定转速")
    private String sePumpRatedSpeed;
    @ExcelProperty(value = "输送介质")
    private String sePumpMedium;
    @ExcelProperty(value = "介质温度")
    private String sePumpMediumTemp;
    @ExcelProperty(value = "设计压力")
    private String sePumpDesignP;
    @ExcelProperty(value = "过流部件材质")
    private String sePumpMaterial;
    @ExcelProperty(value = "密封形式")
    private String sePumpSealType;
    @ExcelProperty(value = "防爆等级")
    private String sePumpExplosionProof;
    @ExcelProperty(value = "配套电机型号")
    private String sePumpMotorModel;
    @ExcelProperty(value = "安装位置")
    private String sePumpInstallPos;
    @ExcelProperty(value = "投用日期")
    private String sePumpInService;
    @ExcelProperty(value = "定期检验周期")
    private String sePumpInspectCycle;
    @ExcelProperty(value = "上次检验日期")
    private LocalDate sePumpLastInspect;
    @ExcelProperty(value = "下次检验日期")
    private LocalDate sePumpNextInspect;
    @ExcelProperty(value = "检验结果")
    private String sePumpInspectResult;
    @ExcelProperty(value = "上次维保日期")
    private LocalDate sePumpLastMaintain;
    @ExcelProperty(value = "下次维保日期")
    private LocalDate sePumpNextMaintain;
    @ExcelProperty(value = "运行振动值")
    private String sePumpVibration;
    @ExcelProperty(value = "密封泄漏状态")
    private String sePumpLeakStatus;
    @ExcelProperty(value = "维保维修记录")
    private String sePumpMaintainRecord;
    @ExcelProperty(value = "故障及异常记录")
    private String sePumpFaultRecord;
    @ExcelProperty(value = "录入维护人员")
    private String sePumpOperator;
    @ExcelProperty(value = "记录创建时间")
    private LocalDate sePumpCreateTime;
    @ExcelProperty(value = "最后更新时间")
    private LocalDate sePumpUpdateTime;
    @ExcelProperty(value = "所属工厂")
    private String sePumpFactory;
    @ExcelProperty(value = "备用1")
    private String sePumpReserve1;
    @ExcelProperty(value = "备用2")
    private String sePumpReserve2;
    @ExcelProperty(value = "备用3")
    private String sePumpReserve3;
}
