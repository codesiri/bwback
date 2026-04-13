package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.ElectricCabinetRecordExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.ElectricCabinetRecord;
import com.youlai.boot.ledger.model.form.ElectricCabinetRecordForm;

/**
 * 电器日常巡检记录对象转换器
 *
 * @author cc
 * @since 2026-03-03 09:40
 */
@Mapper(componentModel = "spring")
public interface ElectricCabinetRecordConverter{

    ElectricCabinetRecordForm toForm(ElectricCabinetRecord entity);

    ElectricCabinetRecord toEntity(ElectricCabinetRecordForm formData);
    ElectricCabinetRecord toEntity(ElectricCabinetRecordExportDto dto);
}