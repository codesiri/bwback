package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.CableLineEquipmentExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.CableLineEquipment;
import com.youlai.boot.ledger.model.form.CableLineEquipmentForm;

/**
 * 电器电缆线路对象转换器
 *
 * @author dazao
 * @since 2026-03-05 08:45
 */
@Mapper(componentModel = "spring")
public interface CableLineEquipmentConverter{

    CableLineEquipmentForm toForm(CableLineEquipment entity);

    CableLineEquipment toEntity(CableLineEquipmentForm formData);

    CableLineEquipment toEntity (CableLineEquipmentExportDto dto);
}