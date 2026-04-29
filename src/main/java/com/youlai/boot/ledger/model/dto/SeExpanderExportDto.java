package com.youlai.boot.ledger.model.dto;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 特种设备膨胀机台账视图对象
 *
 * @author baiwei
 * @since 2026-02-09 09:15
 */
@Getter
@Setter
@Schema( description = "特种设备膨胀机台账视图对象")
public class SeExpanderExportDto {


    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "膨胀机设备编号")
    private String seExpanderEquipCode;
    @ExcelProperty(value = "设备名称")
    private String seExpanderName;
    @ExcelProperty(value = "设备类型")
    private String seExpanderType;
    @ExcelProperty(value = "规格型号")
    private String seExpanderSpec;
    @ExcelProperty(value = "额定功率")
    private String seExpanderRatedPower;
    @ExcelProperty(value = "额定转速")
    private String seExpanderRatedSpeed;
    @ExcelProperty(value = "进口压力")
    private String seExpanderInletP;
    @ExcelProperty(value = "进口温度")
    private String seExpanderInletT;
    @ExcelProperty(value = "出口压力")
    private String seExpanderOutletP;
    @ExcelProperty(value = "出口温度")
    private String seExpanderOutletT;
    @ExcelProperty(value = "工作介质")
    private String seExpanderMedia;
    @ExcelProperty(value = "主体材质")
    private String seExpanderMaterial;
    @ExcelProperty(value = "防爆等级")
    private String seExpanderExplosionProof;
    @ExcelProperty(value = "联轴器类型")
    private String seExpanderCouplingType;
    @ExcelProperty(value = "轴承类型")
    private String seExpanderBearingType;
    @ExcelProperty(value = "润滑方式及油品")
    private String seExpanderLubrication;
    @ExcelProperty(value = "安装位置")
    private String seExpanderInstallPos;
    @ExcelProperty(value = "投用日期")
    private String seExpanderInService;
    @ExcelProperty(value = "定期检验周期")
    private String seExpanderInspectCycle;
    @ExcelProperty(value = "上次检验日期")
    private String seExpanderLastInspect;
    @ExcelProperty(value = "下次检验日期")
    private String seExpanderNextInspect;
    @ExcelProperty(value = "检验结果")
    private String seExpanderInspectResult;
    @ExcelProperty(value = "上次润滑日期")
    private String seExpanderLastLubricate;
    @ExcelProperty(value = "下次润滑日期")
    private String seExpanderNextLubricate;
    @ExcelProperty(value = "运行振动值")
    private String seExpanderVibration;
    @ExcelProperty(value = "膨胀机运行效率")
    private String seExpanderEfficiency;
    @ExcelProperty(value = "维保维修记录")
    private String seExpanderMaintainRecord;
    @ExcelProperty(value = "故障及异常记录")
    private String seExpanderFaultRecord;
    @ExcelProperty(value = "录入 / 维护人员")
    private String seExpanderOperator;
    @ExcelProperty(value = "创建时间")
    private LocalDate seExpanderCreateTime;
    @ExcelProperty(value = "最后更新时间")
    private LocalDate seExpanderUpdateTime;
    @ExcelProperty(value = "设备状态")
    private String seExpanderStatus;
    @ExcelProperty(value = "所属工厂")
    private String seExpanderFactory;
    @ExcelProperty(value = "备用1")
    private String seExpanderReserve1;
    @ExcelProperty(value = "备用2")
    private String seExpanderReserve2;
    @ExcelProperty(value = "备用3")
    private String seExpanderReserve3;
}
