package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.ElectricCabinetChangeExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.ElectricCabinetChange;
import com.youlai.boot.ledger.model.form.ElectricCabinetChangeForm;

/**
 * 抽屉柜变更记录对象转换器
 *
 * @author dazao
 * @since 2026-03-13 11:16
 */
@Mapper(componentModel = "spring")
public interface ElectricCabinetChangeConverter{

    ElectricCabinetChangeForm toForm(ElectricCabinetChange entity);

    ElectricCabinetChange toEntity(ElectricCabinetChangeForm formData);

    ElectricCabinetChange toEntity(ElectricCabinetChangeExportDto dto);
}