package com.youlai.boot.ledger.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.AnalyInstrument;
import com.youlai.boot.ledger.model.form.AnalyInstrumentForm;

/**
 * 分析仪对象转换器
 *
 * @author dazao
 * @since 2026-01-23 14:48
 */
@Mapper(componentModel = "spring")
public interface AnalyInstrumentConverter{

    AnalyInstrumentForm toForm(AnalyInstrument entity);

    AnalyInstrument toEntity(AnalyInstrumentForm formData);
}