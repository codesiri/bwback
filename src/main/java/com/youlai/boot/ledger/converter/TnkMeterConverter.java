package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.TnkMeterExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.TnkMeter;
import com.youlai.boot.ledger.model.form.TnkMeterForm;

/**
 * 罐区仪对象转换器
 *
 * @author dazao
 * @since 2026-01-20 08:17
 */
@Mapper(componentModel = "spring")
public interface TnkMeterConverter{

    TnkMeterForm toForm(TnkMeter entity);

    TnkMeter toEntity(TnkMeterForm formData);

    TnkMeter toEntity(TnkMeterExportDto dto);
}