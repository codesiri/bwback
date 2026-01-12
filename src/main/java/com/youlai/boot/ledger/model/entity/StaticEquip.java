package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 静设备实体对象
 *
 * @author dazao
 * @since 2026-01-08 08:37
 */
@Getter
@Setter
@TableName("static_equip")
public class StaticEquip  {

    private static final long serialVersionUID = 1L;

    @TableId
    long id;

    /**
     * 设备名称
     */
    private String staticEquipName;
    /**
     * 位号
     */
    private String staticEquipTag;
    /**
     * 所处位置
     */
    private String staticEquipLoc;
    /**
     * 操作温度
     */
    private String staticEquipOpTemp;
    /**
     * 操作压力
     */
    private String staticEquipOpPress;
    /**
     * 介质
     */
    private String staticEquipMed;
    /**
     * 出厂编号
     */
    private String staticEquipFactoryNo;
    /**
     * 类别
     */
    private String staticEquipCategory;
    /**
     * 重量（kg）
     */
    private String staticEquipWeght;
    /**
     * 检验日期
     */
    private LocalDateTime staticEquipInspestDate;
    /**
     * 下次检验日期
     */
    private LocalDateTime staticEquipNextInspestDate;
    /**
     * 设备状态
     */
    private Integer status;
    /**
     * 设备编码
     */
    private String dvCode;
}
