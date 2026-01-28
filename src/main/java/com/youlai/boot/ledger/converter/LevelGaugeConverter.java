package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.LevelGaugeExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.LevelGauge;
import com.youlai.boot.ledger.model.form.LevelGaugeForm;

/**
 * 液位计对象转换器
 *
 * @author dazao
 * @since 2026-01-20 15:40
 */
@Mapper(componentModel = "spring")
public interface LevelGaugeConverter{

    LevelGaugeForm toForm(LevelGauge entity);

    LevelGauge toEntity(LevelGaugeForm formData);
    LevelGauge toEntity(LevelGaugeExportDto  dto);
}