package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 差压流量计实体对象
 *
 * @author dazao
 * @since 2026-01-08 16:41
 */
@Getter
@Setter
@TableName("dp_flow_meter")
public class DpFlowMeter  {

    private static final long serialVersionUID = 1L;

    @TableId
    private long id;
    /**
     * 装置名称
     */
    private String dpFlowDevice;
    /**
     * 位号
     */
    private String dpFlowTag;
    /**
     * 安装位置及用途
     */
    private String dpFlowLocation;
    /**
     * 设备名称（差压流量计）
     */
    private String dpFlowEquip;
    /**
     * 规格型号
     */
    private String dpFlowModel;
    /**
     * 生产厂家
     */
    private String dpFlowManu;
    /**
     * 量程
     */
    private String dpFlowRange;
    /**
     * 测量范围
     */
    private String dpFlowMeasRange;
    /**
     * 介质名称
     */
    private String dpFlowMedName;
    /**
     * 介质设计温度
     */
    private String dpFlowMedTemp;
    /**
     * 介质设计力（MPa）
     */
    private String dpFlowMedPress;
    /**
     * 连接方式及规格
     */
    private String dpFlowConnection;
    /**
     * 精度
     */
    private String dpFlowAccuracy;
    /**
     * 是否伴热（是 / 否）
     */
    private Integer dpFlowHeat;
    /**
     * 是否联锁（是 / 否）
     */
    private Integer dpFlowInterlock;
    /**
     * 联锁设定值
     */
    private String dpFlowInterlockVal;
    /**
     * 备注
     */
    private String dpFlowRemark;
    /**
     * 设备编码
     */
    private String dvCode;
    /**
     * 设备状态
     */
    private Integer status;
    /**
     * 设备类型
     */
    private String dvType;
}
