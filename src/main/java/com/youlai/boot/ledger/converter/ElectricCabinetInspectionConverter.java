package com.youlai.boot.ledger.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.dto.ElectricCabinetInspectionExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetInspection;
import com.youlai.boot.ledger.model.form.ElectricCabinetInspectionForm;

/**
 * 抽屉柜检修试验记录对象转换器
 *
 * @author youlaitech
 * @since 2026-03-18 16:19
 */
@Mapper(componentModel = "spring")
public interface ElectricCabinetInspectionConverter{

    ElectricCabinetInspectionForm toForm(ElectricCabinetInspection entity);

    ElectricCabinetInspection toEntity(ElectricCabinetInspectionForm formData);

    ElectricCabinetInspection toEntity(ElectricCabinetInspectionExportDto dto);
}