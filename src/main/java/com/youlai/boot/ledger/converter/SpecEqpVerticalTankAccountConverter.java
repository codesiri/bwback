package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.SpecEqpVerticalTankAccountExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.SpecEqpVerticalTankAccount;
import com.youlai.boot.ledger.model.form.SpecEqpVerticalTankAccountForm;

/**
 * 立罐对象转换器
 *
 * @author baiwei
 * @since 2026-03-06 10:04
 */
@Mapper(componentModel = "spring")
public interface SpecEqpVerticalTankAccountConverter{

    SpecEqpVerticalTankAccountForm toForm(SpecEqpVerticalTankAccount entity);

    SpecEqpVerticalTankAccount toEntity(SpecEqpVerticalTankAccountForm formData);

    SpecEqpVerticalTankAccount toEntity(SpecEqpVerticalTankAccountExportDto dto);
}