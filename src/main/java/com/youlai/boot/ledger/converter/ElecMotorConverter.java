package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.ElecMotorsExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.ElecMotor;
import com.youlai.boot.ledger.model.form.ElecMotorForm;

/**
 * 电器电动机对象转换器
 *
 * @author dazao
 * @since 2026-01-13 10:10
 */
@Mapper(componentModel = "spring")
public interface ElecMotorConverter{

    ElecMotorForm toForm(ElecMotor entity);

    ElecMotor toEntity(ElecMotorForm formData);
    ElecMotor toEntity(ElecMotorsExportDto dto);
}