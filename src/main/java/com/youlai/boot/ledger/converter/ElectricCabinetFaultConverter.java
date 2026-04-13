package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.ElectricCabinetFaultExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.ElectricCabinetFault;
import com.youlai.boot.ledger.model.form.ElectricCabinetFaultForm;

/**
 * 抽屉柜故障维修记录对象转换器
 *
 * @author youlaitech
 * @since 2026-03-23 17:05
 */
@Mapper(componentModel = "spring")
public interface ElectricCabinetFaultConverter{

    ElectricCabinetFaultForm toForm(ElectricCabinetFault entity);

    ElectricCabinetFault toEntity(ElectricCabinetFaultForm formData);

    ElectricCabinetFault toEntity(ElectricCabinetFaultExportDto dto);
}