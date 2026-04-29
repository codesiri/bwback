package com.youlai.boot.ledger.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.dto.ElectricCabinetSparePartDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetSparePart;
import com.youlai.boot.ledger.model.form.ElectricCabinetSparePartForm;

/**
 * 电器备品备件管理记录对象转换器
 *
 * @author youlaitech
 * @since 2026-03-04 08:46
 */
@Mapper(componentModel = "spring")
public interface ElectricCabinetSparePartConverter{

    ElectricCabinetSparePartForm toForm(ElectricCabinetSparePart entity);

    ElectricCabinetSparePart toEntity(ElectricCabinetSparePartForm formData);

    ElectricCabinetSparePart toEntity(ElectricCabinetSparePartDto dto);
}