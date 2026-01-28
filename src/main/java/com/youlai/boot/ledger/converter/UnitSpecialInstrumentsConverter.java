package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.UnitSpecialInstrumentsExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.UnitSpecialInstruments;
import com.youlai.boot.ledger.model.form.UnitSpecialInstrumentsForm;

/**
 * 机组特殊仪对象转换器
 *
 * @author dazao
 * @since 2026-01-21 09:01
 */
@Mapper(componentModel = "spring")
public interface UnitSpecialInstrumentsConverter{

    UnitSpecialInstrumentsForm toForm(UnitSpecialInstruments entity);

    UnitSpecialInstruments toEntity(UnitSpecialInstrumentsForm formData);

    UnitSpecialInstruments toEntity(UnitSpecialInstrumentsExportDto dto);
}