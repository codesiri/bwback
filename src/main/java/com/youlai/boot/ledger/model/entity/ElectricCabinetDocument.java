package com.youlai.boot.ledger.model.entity;

import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.time.LocalDate;

/**
 * 抽屉柜相关资料归档实体对象
 *
 * @author dazao
 * @since 2026-03-12 09:11
 */
@Getter
@Setter
@TableName("electric_cabinet_document")
public class ElectricCabinetDocument extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 资料名称
     */
    private String ecdDocName;
    /**
     * 资料类型
     */
    private String ecdDocType;
    /**
     * 	编号
     */
    private String ecdDocNo;
    /**
     * 归档日期
     */
    private LocalDate ecdArchiveDate;
    /**
     * 保管人
     */
    private String ecdCustodian;
    /**
     * 存放位置
     */
    private String ecdLocation;
    /**
     * 所属工厂
     */
    private String ecdFactory;
    /**
     * 备用1
     */
    private String ecdReserve1;
    /**
     * 备用2
     */
    private String ecdReserve2;
    /**
     * 备用3
     */
    private String ecdReserve3;
}
