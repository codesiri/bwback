package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.ElectricCabinetDrawerUnitsExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.ElectricCabinetDrawerUnit;
import com.youlai.boot.ledger.model.form.ElectricCabinetDrawerUnitForm;

/**
 * 抽屉柜抽屉单元明细对象转换器
 *
 * @author youlaitech
 * @since 2026-03-17 09:40
 */
@Mapper(componentModel = "spring")
public interface ElectricCabinetDrawerUnitConverter{

    ElectricCabinetDrawerUnitForm toForm(ElectricCabinetDrawerUnit entity);

    ElectricCabinetDrawerUnit toEntity(ElectricCabinetDrawerUnitForm formData);

    ElectricCabinetDrawerUnit toEntity(ElectricCabinetDrawerUnitsExportDto dto);
}