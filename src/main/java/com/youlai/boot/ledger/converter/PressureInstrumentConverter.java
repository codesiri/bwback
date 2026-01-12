package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.PressureInstrumentExportDTO;
import com.youlai.boot.ledger.model.entity.PressureInstrument;
import com.youlai.boot.ledger.model.form.PressureInstrumentForm;
import org.mapstruct.Mapper;

/**
 * 压力对象转换器
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
@Mapper(componentModel = "spring")
public interface PressureInstrumentConverter {

    PressureInstrumentForm toForm(PressureInstrument entity);

    PressureInstrument toEntity(PressureInstrumentForm formData);


    PressureInstrument toEntity(PressureInstrumentExportDTO dto);

}
