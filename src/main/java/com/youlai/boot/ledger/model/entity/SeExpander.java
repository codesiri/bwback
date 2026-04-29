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
 * 特种设备膨胀机台账实体对象
 *
 * @author baiwei
 * @since 2026-02-09 09:15
 */
@Getter
@Setter
@TableName("se_expander")
public class SeExpander implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 膨胀机设备编号
     */
    private String seExpanderEquipCode;
    /**
     * 设备名称
     */
    private String seExpanderName;
    /**
     * 设备类型
     */
    private String seExpanderType;
    /**
     * 规格型号
     */
    private String seExpanderSpec;
    /**
     * 额定功率
     */
    private String seExpanderRatedPower;
    /**
     * 额定转速
     */
    private String seExpanderRatedSpeed;
    /**
     * 进口压力
     */
    private String seExpanderInletP;
    /**
     * 进口温度
     */
    private String seExpanderInletT;
    /**
     * 出口压力
     */
    private String seExpanderOutletP;
    /**
     * 出口温度
     */
    private String seExpanderOutletT;
    /**
     * 工作介质
     */
    private String seExpanderMedia;
    /**
     * 主体材质
     */
    private String seExpanderMaterial;
    /**
     * 防爆等级
     */
    private String seExpanderExplosionProof;
    /**
     * 联轴器类型
     */
    private String seExpanderCouplingType;
    /**
     * 轴承类型
     */
    private String seExpanderBearingType;
    /**
     * 润滑方式及油品
     */
    private String seExpanderLubrication;
    /**
     * 安装位置
     */
    private String seExpanderInstallPos;
    /**
     * 投用日期
     */
    private String seExpanderInService;
    /**
     * 定期检验周期
     */
    private String seExpanderInspectCycle;
    /**
     * 上次检验日期
     */
    private String seExpanderLastInspect;
    /**
     * 下次检验日期
     */
    private String seExpanderNextInspect;
    /**
     * 检验结果
     */
    private String seExpanderInspectResult;
    /**
     * 上次润滑日期
     */
    private String seExpanderLastLubricate;
    /**
     * 下次润滑日期
     */
    private String seExpanderNextLubricate;
    /**
     * 运行振动值
     */
    private String seExpanderVibration;
    /**
     * 膨胀机运行效率
     */
    private String seExpanderEfficiency;
    /**
     * 维保维修记录
     */
    private String seExpanderMaintainRecord;
    /**
     * 故障及异常记录
     */
    private String seExpanderFaultRecord;
    /**
     * 录入 / 维护人员
     */
    private String seExpanderOperator;
    /**
     * 创建时间
     */
    private LocalDate seExpanderCreateTime;
    /**
     * 最后更新时间
     */
    private LocalDate seExpanderUpdateTime;
    /**
     * 设备状态
     */
    private String seExpanderStatus;
    /**
     * 所属工厂
     */
    private String seExpanderFactory;
    /**
     * 备用1
     */
    private String seExpanderReserve1;
    /**
     * 备用2
     */
    private String seExpanderReserve2;
    /**
     * 备用3
     */
    private String seExpanderReserve3;
}
