package com.youlai.boot.ledger.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 电器日常巡检记录分页查询对象
 *
 * @author cc
 * @since 2026-03-03 09:40
 */
@Schema(description ="电器日常巡检记录查询对象")
@Getter
@Setter
public class ElectricCabinetRecordQuery extends BasePageQuery {
    /**
     * 巡检日期
     */
    private LocalDate ecrInspectDate;
    /**
     * 巡检人
     */
    private String ecrInspectPerson;
    /**
     * 巡检项目
     *
     */
    private String ecrInspectItem;
    /**
     * 巡检结果
     */
    private String ecrInspectResult;
    /**
     * 所属工厂
     */
    private String ecrFactory;
}
