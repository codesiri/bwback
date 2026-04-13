package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.GroundSystemEquipmentExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.GroundSystemEquipment;
import com.youlai.boot.ledger.model.form.GroundSystemEquipmentForm;

/**
 * 电器接地系统对象转换器
 *
 * @author dazao
 * @since 2026-03-09 08:51
 */
@Mapper(componentModel = "spring")
public interface GroundSystemEquipmentConverter{

    GroundSystemEquipmentForm toForm(GroundSystemEquipment entity);

    GroundSystemEquipment toEntity(GroundSystemEquipmentForm formData);
    GroundSystemEquipment toEntity(GroundSystemEquipmentExportDto dto);
}