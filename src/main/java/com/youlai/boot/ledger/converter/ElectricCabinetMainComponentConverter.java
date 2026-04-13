package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.ElectricCabinetChangeExportDto;
import com.youlai.boot.ledger.model.dto.ElectricCabinetMainComponentDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.ElectricCabinetMainComponent;
import com.youlai.boot.ledger.model.form.ElectricCabinetMainComponentForm;

/**
 * 抽屉柜主要元器件信息对象转换器
 *
 * @author youlaitech
 * @since 2026-03-17 09:38
 */
@Mapper(componentModel = "spring")
public interface ElectricCabinetMainComponentConverter{

    ElectricCabinetMainComponentForm toForm(ElectricCabinetMainComponent entity);

    ElectricCabinetMainComponent toEntity(ElectricCabinetMainComponentForm formData);
    ElectricCabinetMainComponent toEntity(ElectricCabinetMainComponentDto dto);
}