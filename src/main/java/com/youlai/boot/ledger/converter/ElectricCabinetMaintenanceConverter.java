package com.youlai.boot.ledger.converter;

import org.mapstruct.Mapper;
import com.youlai.boot.ledger.model.dto.ElectricCabinetMaintenanceExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetMaintenance;
import com.youlai.boot.ledger.model.form.ElectricCabinetMaintenanceForm;

/**
 * 抽屉柜维护保养记录对象转换器
 *
 * @author c
 * @since 2026-04-16 14:43
 */
@Mapper(componentModel = "spring")
public interface ElectricCabinetMaintenanceConverter{

    ElectricCabinetMaintenanceForm toForm(ElectricCabinetMaintenance entity);

    ElectricCabinetMaintenance toEntity(ElectricCabinetMaintenanceForm formData);

    ElectricCabinetMaintenance toEntity(ElectricCabinetMaintenanceExportDto exportDto);
}