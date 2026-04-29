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
 * 卧罐实体对象
 *
 * @author baiwei
 * @since 2026-03-06 09:33
 */
@Getter
@Setter
@TableName("se_horizontal_tank")
public class SeHorizontalTank implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 卧罐设备编号
     */
    private String seHtankEquipCode;
    /**
     * 卧罐名称
     */
    private String seHtankName;
    /**
     * 规格型号
     */
    private String seHtankSpec;
    /**
     * 设计容积（m³）
     */
    private String seHtankDesignVolume;
    /**
     * 工作容积（m³）
     */
    private String seHtankOperatingVolume;
    /**
     * 设计压力（MPa）
     */
    private String seHtankDesignP;
    /**
     * 工作压力（MPa）
     */
    private String seHtankOperatingP;
    /**
     * 设计温度（℃）
     */
    private String seHtankDesignT;
    /**
     * 工作温度（℃）
     */
    private String seHtankOperatingT;
    /**
     * 储存介质
     */
    private String seHtankMedia;
    /**
     * 主体材质
     */
    private String seHtankMaterial;
    /**
     * 罐体壁厚（mm）
     */
    private String seHtankThickness;
    /**
     * 密封形式
     */
    private String seHtankSealType;
    /**
     * 防腐措施
     */
    private String seHtankAntiCorrosion;
    /**
     * 支撑形式
     */
    private String seHtankSupportType;
    /**
     * 安全阀型号规格（核心安全附件，需定期校验）
     */
    private String seHtankSafetyValveModel;
    /**
     * 安装位置
     */
    private String seHtankInstallPos;
    /**
     * 投用日期
     */
    private LocalDate seHtankInService;
    /**
     * 定期检验周期（全面检验每 3 年，年度检查每年，按规范执行）
     */
    private String seHtankInspectCycle;
    /**
     * 上次检验日期（含无损检测、压力试验、密封校验）
     */
    private LocalDate seHtankLastInspect;
    /**
     * 下次检验日期（系统预警用，同步安全附件校验周期）
     */
    private LocalDate seHtankNextInspect;
    /**
     * 检验结果
     */
    private String seHtankInspectResult;
    /**
     * 上次水压 / 气压试验日期
     */
    private String seHtankLastPressureTest;
    /**
     * 液位计型号
     */
    private String seHtankLevelGaugeModel;
    /**
     * 腐蚀状况
     */
    private String seHtankCorrosionStatus;
    /**
     * 维保维修记录
     */
    private String seHtankMaintainRecord;
    /**
     * 故障及异常记录
     */
    private String seHtankFaultRecord;
    /**
     * 录入维护人员
     */
    private String seHtankOperator;
    /**
     * 记录创建时间
     */
    private LocalDate seHtankCreateTime;
    /**
     * 最后更新时间
     */
    private LocalDate seHtankUpdateTime;
    /**
     * 设备状态
     */
    private String seHtankStatus;
    /**
     * 所属工厂
     */
    private String seHtankFactory;
    /**
     * 备用1
     */
    private String seHtankReserve1;
    /**
     * 备用2
     */
    private String seHtankReserve2;
    /**
     * 备用3
     */
    private String seHtankReserve3;
}
