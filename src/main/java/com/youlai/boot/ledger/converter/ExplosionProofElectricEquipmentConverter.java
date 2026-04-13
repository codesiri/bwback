package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.ExplosionProofElectricEquipmentExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.ExplosionProofElectricEquipment;
import com.youlai.boot.ledger.model.form.ExplosionProofElectricEquipmentForm;

/**
 * 防爆电气设备对象转换器
 *
 * @author dazao
 * @since 2026-02-06 15:59
 */
@Mapper(componentModel = "spring")
public interface ExplosionProofElectricEquipmentConverter{

    ExplosionProofElectricEquipmentForm toForm(ExplosionProofElectricEquipment entity);

    ExplosionProofElectricEquipment toEntity(ExplosionProofElectricEquipmentForm formData);

    ExplosionProofElectricEquipment toEntity(ExplosionProofElectricEquipmentExportDto dto);
}