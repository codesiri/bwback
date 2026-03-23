package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.ControlValveExportDto;
import org.mapstruct.Mapper;
import com.youlai.boot.ledger.model.entity.ControlValve;
import com.youlai.boot.ledger.model.form.ControlValveForm;

/**
 * 调节阀对象转换器
 *
 * @author cc
 * @since 2026-01-28 11:03
 */
@Mapper(componentModel = "spring")
public interface ControlValveConverter{

    ControlValveForm toForm(ControlValve entity);

    ControlValve toEntity(ControlValveForm formData);

    ControlValve toEntity(ControlValveExportDto dto);
}
