package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;
import java.time.LocalDate;
/**
 * 特种设备风机台账实体对象
 *
 * @author youlaitech
 * @since 2026-02-09 09:18
 */
@Getter
@Setter
@TableName("se_fan")
public class SeFan implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 风机设备编号
     */
    private String seFanEquipCode;
    /**
     * 风机名称
     */
    private String seFanName;
    /**
     * 风机类型
     */
    private String seFanType;
    /**
     * 设备规格
     */
    private String seFanSpec;
    /**
     * 额定功率（kW）
     */
    private String seFanRatedPower;
    /**
     * 额定转速（r/min）
     */
    private String seFanRatedSpeed;
    /**
     * 额定压力（kPa，正压 / 负压标注在备注）
     */
    private String seFanRatedPressure;
    /**
     * 额定风量（m³/h）
     */
    private String seFanRatedFlow;
    /**
     * 输送介质
     */
    private String seFanMedium;
    /**
     * 主体材质
     */
    private String seFanMaterial;
    /**
     * 防爆等级
     */
    private String seFanExplosionProof;
    /**
     * 配套电机型号
     */
    private String seFanMotorModel;
    /**
     * 安装位置
     */
    private String seFanInstallPos;
    /**
     * 投用日期
     */
    private String seFanInService;
    /**
     * 法定检验周期
     */
    private String seFanInspectCycle;
    /**
     * 上次检验日期
     */
    private LocalDate seFanLastInspect;
    /**
     * 下次检验日期
     */
    private LocalDate seFanNextInspect;
    /**
     * 检验结果
     */
    private String seFanInspectResult;
    /**
     * 润滑方式
     */
    private String seFanLubrication;
    /**
     * 上次润滑日期
     */
    private LocalDate seFanLastLubricate;
    /**
     * 下次润滑日期
     */
    private LocalDate seFanNextLubricate;
    /**
     * 运行振动值（mm/s，标准≤4.5mm/s）
     */
    private String seFanVibration;
    /**
     * 维保记录
     */
    private String seFanMaintainRecord;
    /**
     * 故障记录
     */
    private String seFanFaultRecord;
    /**
     * 台账录入 / 维护人员
     */
    private String seFanOperator;
    /**
     * 台账记录创建时间
     */
    private LocalDateTime seFanCreateTime;
    /**
     * 台账记录最后修改时间
     */
    private LocalDateTime seFanUpdateTime;
    /**
     * 设备状态
     */
    private String seFanStatus;
    /**
     * 所属工厂
     */
    private String seFanFactory;
    /**
     * 备用1
     */
    private String seFanReserve1;
    /**
     * 备用2
     */
    private String seFanReserve2;
    /**
     * 备用3
     */
    private String seFanReserve3;
}
