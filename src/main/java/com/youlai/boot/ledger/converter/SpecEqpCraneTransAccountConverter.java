package com.youlai.boot.ledger.converter;


import com.youlai.boot.ledger.model.dto.SpecEqpCraneTransAccountsExportDto;
import org.mapstruct.Mapper;
import com.youlai.boot.ledger.model.entity.SpecEqpCraneTransAccount;
import com.youlai.boot.ledger.model.form.SpecEqpCraneTransAccountForm;

/**
 * 起重运输类对象转换器
 *
 * @author baiwei
 * @since 2026-02-03 09:22
 */
@Mapper(componentModel = "spring")
public interface SpecEqpCraneTransAccountConverter{

    SpecEqpCraneTransAccountForm toForm(SpecEqpCraneTransAccount entity);

    SpecEqpCraneTransAccount toEntity(SpecEqpCraneTransAccountForm formData);

    SpecEqpCraneTransAccount toEntity(SpecEqpCraneTransAccountsExportDto dto);

}