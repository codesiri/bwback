package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
/**
 * 特种设备制冷机台账实体对象
 *
 * @author baiwei
 * @since 2026-02-14 08:38
 */
@Getter
@Setter
@TableName("se_refrigerator")
public class SeRefrigerator implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 制冷机设备编号
     */
    private String seRefrigeratorEquipCode;
    /**
     * 制冷机设备名称
     */
    private String seRefrigeratorName;
    /**
     * 制冷机类型
     */
    private String seRefrigeratorType;
    /**
     * 规格型号
     */
    private String seRefrigeratorSpec;
    /**
     * 额定制冷量（kW）
     */
    private String seRefrigeratorCoolingCapacity;
    /**
     * 额定输入功率（kW）
     */
    private String seRefrigeratorRatedPower;
    /**
     * 蒸发温度（℃）
     */
    private String seRefrigeratorEvapTemp;
    /**
     * 冷凝温度（℃）
     */
    private String seRefrigeratorCondTemp;
    /**
     * 制冷剂类型
     */
    private String seRefrigeratorRefrigerant;
    /**
     * 冷冻油型号及类型
     */
    private String seRefrigeratorOilType;
    /**
     * 主体材质
     */
    private String seRefrigeratorMaterial;
    /**
     * 防爆等级
     */
    private String seRefrigeratorExplosionProof;
    /**
     * 配套电机型号
     */
    private String seRefrigeratorMotorModel;
    /**
     * 冷却方式
     */
    private String seRefrigeratorCoolingType;
    /**
     * 安装位置
     */
    private String seRefrigeratorInstallPos;
    /**
     * 投用日期
     */
    private LocalDate seRefrigeratorInService;
    /**
     * 定期检验周期
     */
    private String seRefrigeratorInspectCycle;
    /**
     * 上次检验日期
     */
    private LocalDate seRefrigeratorLastInspect;
    /**
     * 下次检验日期
     */
    private LocalDate seRefrigeratorNextInspect;
    /**
     * 检验结果
     */
    private String seRefrigeratorInspectResult;
    /**
     * 上次维保日期
     */
    private LocalDate seRefrigeratorLastMaintain;
    /**
     * 下次维保日期
     */
    private LocalDate seRefrigeratorNextMaintain;
    /**
     * 上次气密性 / 泄漏检测日期
     */
    private LocalDate seRefrigeratorLeakTest;
    /**
     * 制冷系数（COP 值）
     */
    private String seRefrigeratorCoeff;
    /**
     * 维保维修记录
     */
    private String seRefrigeratorMaintainRecord;
    /**
     * 故障及异常记录
     */
    private String seRefrigeratorFaultRecord;
    /**
     * 录入 / 维护人员
     */
    private String seRefrigeratorOperator;
    /**
     * 创建时间
     */
    private LocalDate seRefrigeratorCreateTime;
    /**
     * 最后更新时间
     */
    private LocalDate seRefrigeratorUpdateTime;
    /**
     * 所属工厂
     */
    private String seRefrigeratorFactory;
    /**
     * 设备状态
     */
    private String seRefrigeratorStatus;
    /**
     * 备用1
     */
    private String seRefrigeratorReserve1;
    /**
     * 备用2
     */
    private String seRefrigeratorReserve2;
    /**
     * 备用3
     */
    private String seRefrigeratorReserve3;
}
