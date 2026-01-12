package com.youlai.boot.ledger.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.DpFlowMeter;
import com.youlai.boot.ledger.model.form.DpFlowMeterForm;

/**
 * 差压流量计对象转换器
 *
 * @author dazao
 * @since 2026-01-08 16:41
 */
@Mapper(componentModel = "spring")
public interface DpFlowMeterConverter{

    DpFlowMeterForm toForm(DpFlowMeter entity);

    DpFlowMeter toEntity(DpFlowMeterForm formData);
}