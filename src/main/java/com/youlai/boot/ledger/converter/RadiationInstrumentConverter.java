package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.RadiationInstrumentExportDTO;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.RadiationInstrument;
import com.youlai.boot.ledger.model.form.RadiationInstrumentForm;

/**
 * 放射仪对象转换器
 *
 * @author baiwei
 * @since 2026-01-28 09:50
 */
@Mapper(componentModel = "spring")
public interface RadiationInstrumentConverter{

    RadiationInstrumentForm toForm(RadiationInstrument entity);

    RadiationInstrument toEntity(RadiationInstrumentForm formData);

    RadiationInstrument toEntity(RadiationInstrumentExportDTO dto);
}
