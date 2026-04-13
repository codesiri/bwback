package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.ElectricCabinetDocumentExportDto;
import com.youlai.boot.ledger.model.dto.ElectricCabinetMainComponentDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.ElectricCabinetDocument;
import com.youlai.boot.ledger.model.form.ElectricCabinetDocumentForm;

/**
 * 抽屉柜相关资料归档对象转换器
 *
 * @author dazao
 * @since 2026-03-12 09:11
 */
@Mapper(componentModel = "spring")
public interface ElectricCabinetDocumentConverter{

    ElectricCabinetDocumentForm toForm(ElectricCabinetDocument entity);

    ElectricCabinetDocument toEntity(ElectricCabinetDocumentForm formData);

    ElectricCabinetDocument toEntity(ElectricCabinetDocumentExportDto dto);
}