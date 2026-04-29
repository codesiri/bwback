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
 * 换热器实体对象
 *
 * @author baiwei
 * @since 2026-03-03 10:16
 */
@Getter
@Setter
@TableName("se_heater")
public class SeHeater implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 换热器设备编号
     */
    private String seHeaterEquipCode;
    /**
     * 换热器名称
     */
    private String seHeaterName;
    /**
     * 换热器类型
     */
    private String seHeaterType;
    /**
     * 设备规格
     */
    private String seHeaterSpec;
    /**
     * 换热面积（㎡）
     */
    private String seHeaterArea;
    /**
     * 设计压力（MPa）
     */
    private String seHeaterDesignP;
    /**
     * 设计温度（℃）
     */
    private String seHeaterDesignT;
    /**
     * 介质类型
     */
    private String seHeaterMedium;
    /**
     * 主体材质
     */
    private String seHeaterMaterial;
    /**
     * 安装位置
     */
    private String seHeaterInstallPos;
    /**
     * 投用日期
     */
    private LocalDate seHeaterInService;
    /**
     * 法定校验周期
     */
    private String seHeaterInspectCycle;
    /**
     * 上次校验日期
     */
    private String seHeaterLastInspect;
    /**
     * 下次校验日期
     */
    private String seHeaterNextInspect;
    /**
     * 检验结果
     */
    private String seHeaterInspectResult;
    /**
     * 清洗周期
     */
    private String seHeaterCleanCycle;
    /**
     * 上次清洗日期
     */
    private LocalDate seHeaterLastClean;
    /**
     * 下次清洗日期
     */
    private LocalDate seHeaterNextClean;
    /**
     * 污垢热阻（m²・K/W）
     */
    private String seHeaterFoulingRate;
    /**
     * 换热效率（%）
     */
    private String seHeaterEnergyEff;
    /**
     * 维保记录
     */
    private String seHeaterMaintainRecord;
    /**
     * 故障记录
     */
    private String seHeaterFaultRecord;
    /**
     * 台账录入 / 维护人员
     */
    private String seHeaterOperator;
    /**
     * 台账记录创建时间
     */
    private LocalDateTime seHeaterCreateTime;
    /**
     * 台账记录最后修改时间
     */
    private LocalDateTime seHeaterUpdateTime;
    /**
     * 设备状态
     */
    private String seHeaterStatus;
    /**
     * 所属工厂
     */
    private String seHeaterFactory;
    /**
     * 备用1
     */
    private String seHeaterReserve1;
    /**
     * 备用2
     */
    private String seHeaterReserve2;
    /**
     * 备用3
     */
    private String seHeaterReserve3;
}
