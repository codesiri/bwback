package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.time.LocalDate;

/**
 * 电器接地系统实体对象
 *
 * @author dazao
 * @since 2026-03-09 08:51
 */
@Getter
@Setter
@TableName("ground_system_equipment")
public class GroundSystemEquipment {

    private static final long serialVersionUID = 1L;

    @TableId
    private long id;
    /**
     * 接地编号
     */
    private String gseGroundCode;
    /**
     * 接地类型
     */
    private String gseGroundType;
    /**
     * 接地结构
     */
    private String gseGroundStruct;
    /**
     * 材质
     */
    private String gseMaterial;
    /**
     * 安装位置
     */
    private String gseInstallArea;
    /**
     * 安装区域及危险等级
     */
    private String gseInstallPosition;
    /**
     * 设计接地电阻值（Ω）
     */
    private String gseDesignResistance;
    /**
     * 上次接地电阻测试日期
     */
    private LocalDate gseLastTestDate;
    /**
     * 上次测试电阻值（Ω）
     */
    private String gseLastTestData;
    /**
     * 下次测试日期
     */
    private LocalDate gseNextTestDate;
    /**
     * 测试人员
     */
    private String gseTestPerson;
    /**
     * 安装日期
     */
    private LocalDate gseInstallDate;
    /**
     * 接地状态
     */
    private String gseStatus;
    /**
     * 所属工厂
     */
    private String gseFactory;

}
