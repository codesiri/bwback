package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 抽屉柜抽屉单元明细实体对象
 *
 * @author youlaitech
 * @since 2026-03-17 09:40
 */
@Getter
@Setter
@TableName("electric_cabinet_drawer_unit")
public class ElectricCabinetDrawerUnit  {

    private static final long serialVersionUID = 1L;
    @TableId
    private long id;
    /**
     * 抽屉编号
     */
    private String ecduDrawerNo;
    /**
     * 单元名称
     */
    private String ecduUnitName;
    /**
     * 额定电流（A）
     */
    private String ecduRatedCurrent;
    /**
     * 额定电压（V）
     */
    private String ecduRatedVoltage;
    /**
     * 开关型号
     */
    private String ecduSwitchModel;
    /**
     * 开关厂家
     */
    private String ecduSwitchManufacturer;
    /**
     * 整定电流（A）
     */
    private String ecduSettingCurrent;
    /**
     * 对应负载
     */
    private String ecduCorrespondingLoad;
    /**
     * 安装位置
     */
    private String ecduInstallLocation;
    /**
     * 单元状态
     */
    private String ecduUnitStatus;
    /**
     * 所属工厂
     */
    private String ecduFactory;
    /**
     * 备用1
     */
    private String ecduReserve1;
    /**
     * 备用2
     */
    private String ecduReserve2;
    /**
     * 备用3
     */
    private String ecduReserve3;
}
