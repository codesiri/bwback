package com.youlai.boot.ledger.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.time.LocalDate;

/**
 * 抽屉柜检修试验记录实体对象
 *
 * @author youlaitech
 * @since 2026-03-18 16:19
 */
@Getter
@Setter
@TableName("electric_cabinet_inspection")
public class ElectricCabinetInspection {

    private static final long serialVersionUID = 1L;

    @TableId
    private  long id;
    /**
     * 报告编号
     */
    private String eciReportNo;
    /**
     * 检修 / 试验日期
     */
    private LocalDate eciInspectDate;
    /**
     * 检修 / 试验单位
     */
    private String eciInspectUnit;
    /**
     * 检修 / 试验人员
     */
    private String eciInspectPerson;
    /**
     * 检修 / 试验类型
     */
    private String eciInspectType;
    /**
     * 检修 / 试验项目
     */
    private String eciInspectItem;
    /**
     * 试验数据
     */
    private String eciTestData;
    /**
     * 合格标准
     */
    private String eciStandard;
    /**
     * 结果判定
     */
    private String eciResult;
    /**
     * 整改内容
     */
    private String eciRectifyContent;
    /**
     * 复检结果
     */
    private String eciRecheckResult;
    /**
     * 所属工厂
     */
    private String eciFactory;
    /**
     * 备用1
     */
    @TableField("eci_reserve_1")
    private String eciReserve1;

    /**
     * 备用2
     */
    @TableField("eci_reserve_2")
    private String eciReserve2;
    /**
     * 备用3
     */
    @TableField("eci_reserve_3")
    private String eciReserve3;
}
