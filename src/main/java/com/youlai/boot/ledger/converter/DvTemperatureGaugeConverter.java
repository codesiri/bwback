package com.youlai.boot.ledger.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.DvTemperatureGauge;
import com.youlai.boot.ledger.model.form.DvTemperatureGaugeForm;

/**
 * 温度对象转换器
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
@Mapper(componentModel = "spring")
public interface DvTemperatureGaugeConverter{

    DvTemperatureGaugeForm toForm(DvTemperatureGauge entity);

    DvTemperatureGauge toEntity(DvTemperatureGaugeForm formData);
}