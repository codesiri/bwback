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
 * 泵实体对象
 *
 * @author baiwei
 * @since 2026-02-05 14:46
 */
@Getter
@Setter
@TableName("se_pump")
public class SePump implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     *
     * 泵设备编号(位号)
     */
    private String sePumpEquipCode;
    /**
     * 设备名称
     */
    private String sePumpName;
    /**
     * 泵类型
     */
    private String sePumpType;
    /**
     * 设备状态
     */
    private String sePumpStatus;
    /**
     * 规格型号
     */
    private String sePumpSpec;
    /**
     * 额定流量
     */
    private String sePumpFlow;
    /**
     * 额定量程
     */
    private String sePumpHead;
    /**
     * 额定功率
     */
    private String sePumpRatedPower;
    /**
     * 额定转速
     */
    private String sePumpRatedSpeed;
    /**
     * 输送介质
     */
    private String sePumpMedium;
    /**
     * 介质温度
     */
    private String sePumpMediumTemp;
    /**
     * 设计压力
     */
    private String sePumpDesignP;
    /**
     * 过流部件材质
     */
    private String sePumpMaterial;
    /**
     * 密封形式
     */
    private String sePumpSealType;
    /**
     * 防爆等级
     */
    private String sePumpExplosionProof;
    /**
     * 配套电机型号
     */
    private String sePumpMotorModel;
    /**
     * 安装位置
     */
    private String sePumpInstallPos;
    /**
     * 投用日期
     */
    private String sePumpInService;
    /**
     * 定期检验周期
     */
    private String sePumpInspectCycle;
    /**
     * 上次检验日期
     */
    private LocalDate sePumpLastInspect;
    /**
     * 下次检验日期
     */
    private LocalDate sePumpNextInspect;
    /**
     * 检验结果
     */
    private String sePumpInspectResult;
    /**
     * 上次维保日期
     */
    private LocalDate sePumpLastMaintain;
    /**
     * 下次维保日期
     */
    private LocalDate sePumpNextMaintain;
    /**
     * 运行振动值
     */
    private String sePumpVibration;
    /**
     * 密封泄漏状态
     */
    private String sePumpLeakStatus;
    /**
     * 维保维修记录
     */
    private String sePumpMaintainRecord;
    /**
     * 故障及异常记录
     */
    private String sePumpFaultRecord;
    /**
     * 录入维护人员
     */
    private String sePumpOperator;
    /**
     * 记录创建时间
     */
    private LocalDate sePumpCreateTime;
    /**
     * 最后更新时间
     */
    private LocalDate sePumpUpdateTime;
    /**
     * 所属工厂
     */
    private String sePumpFactory;
    /**
     * 备用1
     */
    private String sePumpReserve1;
    /**
     * 备用2
     */
    private String sePumpReserve2;
    /**
     * 备用3
     */
    private String sePumpReserve3;
}
