package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.ElectricLightEquipmentDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.ElectricLightEquipment;
import com.youlai.boot.ledger.model.form.ElectricLightEquipmentForm;

/**
 * 电气照明设备对象转换器
 *
 * @author dazao
 * @since 2026-02-04 09:24
 */
@Mapper(componentModel = "spring")
public interface ElectricLightEquipmentConverter{

    ElectricLightEquipmentForm toForm(ElectricLightEquipment entity);

    ElectricLightEquipment toEntity(ElectricLightEquipmentForm formData);
    ElectricLightEquipment toEntity(ElectricLightEquipmentDto dto);
}