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
 * 球罐实体对象
 *
 * @author baiwei
 * @since 2026-03-06 09:49
 */
@Getter
@Setter
@TableName("se_spherical_tank")
public class SeSphericalTank implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 球罐设备编号
     */
    private String seTankEquipCode;
    /**
     * 球罐名称
     */
    private String seTankName;
    /**
     * 规格型号
     */
    private String seTankSpec;
    /**
     * 设计容积（m³）
     */
    private String seTankDesignVolume;
    /**
     * 工作容积（m³）
     */
    private String seTankOperatingVolume;
    /**
     * 设计压力（MPa）
     */
    private String seTankDesignP;
    /**
     * 工作压力（MPa）
     */
    private String seTankOperatingP;
    /**
     * 设计温度（℃）
     */
    private String seTankDesignT;
    /**
     * 工作温度（℃）
     */
    private String seTankOperatingT;
    /**
     * 储存介质
     */
    private String seTankMedia;
    /**
     * 主体材质
     */
    private String seTankMaterial;
    /**
     * 罐体壁厚（mm）
     */
    private String seTankThickness;
    /**
     * 密封形式
     */
    private String seTankSealType;
    /**
     * 防腐措施
     */
    private String seTankAntiCorrosion;
    /**
     * 安全阀型号规格
     */
    private String seTankSafetyValveModel;
    /**
     * 安装位置
     */
    private String seTankInstallPos;
    /**
     * 投用日期
     */
    private String seTankInService;
    /**
     * 定期检验周期
     */
    private String seTankInspectCycle;
    /**
     * 上次检验日期
     */
    private LocalDate seTankLastInspect;
    /**
     * 下次检验日期
     */
    private LocalDate seTankNextInspect;
    /**
     * 检验结果
     */
    private String seTankInspectResult;
    /**
     * 上次水压 / 气压试验日期
     */
    private LocalDate seTankLastPressureTest;
    /**
     * 液位计型号
     */
    private String seTankLevelGaugeModel;
    /**
     * 腐蚀状况
     */
    private String seTankCorrosionStatus;
    /**
     * 维保维修记录
     */
    private String seTankMaintainRecord;
    /**
     * 故障及异常记录
     */
    private String seTankFaultRecord;
    /**
     * 录入维护人员
     */
    private String seTankOperator;
    /**
     * 记录创建时间
     */
    private LocalDate seTankCreateTime;
    /**
     * 最后更新时间
     */
    private LocalDate seTankUpdateTime;
    /**
     * 设备状态
     */
    private String seTankStatus;
    /**
     * 所属工厂
     */
    private String seTankFactory;
    /**
     * 备用1
     */
    private String seTankReserve1;
    /**
     * 备用2
     */
    private String seTankReserve2;
    /**
     * 备用3
     */
    private String seTankReserve3;
}
