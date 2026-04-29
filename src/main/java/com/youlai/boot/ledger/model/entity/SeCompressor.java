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
 * 特种设备压缩机台账实体对象
 *
 * @author baiwei
 * @since 2026-02-09 09:07
 */
@Getter
@Setter
@TableName("se_compressor")
public class SeCompressor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 压缩机设备编号
     */
    private String seCompressorEquipCode;
    /**
     * 设备名称
     */
    private String seCompressorName;
    /**
     * 压缩机类型
     */
    private String seCompressorType;
    /**
     * 规格型号
     */
    private String seCompressorSpec;
    /**
     * 额定排气量（m³/min）
     */
    private String seCompressorRatedFlow;
    /**
     * 额定排气压力（MPa）
     */
    private String seCompressorRatedPressure;
    /**
     * 额定输入功率（kW）
     */
    private String seCompressorRatedPower;
    /**
     * 额定转速（r/min）
     */
    private String seCompressorRatedSpeed;
    /**
     * 输送介质
     */
    private String seCompressorMedia;
    /**
     * 进气温度（℃）
     */
    private String seCompressorInletTemp;
    /**
     * 排气温度（℃）
     */
    private String seCompressorOutletTemp;
    /**
     * 设计压力（MPa）
     */
    private String seCompressorDesignP;
    /**
     * 主体 / 过流部件材质
     */
    private String seCompressorMaterial;
    /**
     * 防爆等级
     */
    private String seCompressorExplosionProof;
    /**
     * 配套电机型号
     */
    private String seCompressorMotorModel;
    /**
     * 润滑方式及油品
     */
    private String seCompressorLubrication;
    /**
     * 冷却方式（水冷 / 风冷）
     */
    private String seCompressorCoolingType;
    /**
     * 安装位置
     */
    private String seCompressorInstallPos;
    /**
     * 投用日期
     */
    private LocalDate seCompressorInService;
    /**
     * 定期检验周期
     */
    private String seCompressorInspectCycle;
    /**
     * 上次检验日期
     */
    private LocalDate seCompressorLastInspect;
    /**
     * 下次检验日期
     */
    private LocalDate seCompressorNextInspect;
    /**
     * 检验结果
     */
    private String seCompressorInspectResult;
    /**
     * 上次维保日期
     */
    private String seCompressorLastMaintain;
    /**
     * 下次维保日期
     */
    private String seCompressorNextMaintain;
    /**
     * 运行振动值（mm/s）
     */
    private String seCompressorVibration;
    /**
     * 压缩比
     */
    private String seCompressorPressureRatio;
    /**
     * 维保维修记录
     */
    private String seCompressorMaintainRecord;
    /**
     * 故障及异常记录
     */
    private String seCompressorFaultRecord;
    /**
     * 录入维护人员
     */
    private String seCompressorOperator;
    /**
     * 记录创建时间
     */
    private LocalDate seCompressorCreateTime;
    /**
     * 最后更新时间
     */
    private LocalDate seCompressorUpdateTime;
    /**
     * 设备状态
     */
    private String seCompressorStatus;
    /**
     * 所属工厂
     */
    private String seCompressorFactory;
    /**
     * 备用1
     */
    private String seCompressorReserve1;
    /**
     * 备用2
     */
    private String seCompressorReserve2;
    /**
     * 备用3
     */
    private String seCompressorReserve3;
}
