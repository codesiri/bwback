package com.youlai.boot.ledger.converter;


import com.youlai.boot.ledger.model.dto.SpecEqpTowerAccountExportDto;
import org.mapstruct.Mapper;
import com.youlai.boot.ledger.model.entity.SpecEqpTowerAccount;
import com.youlai.boot.ledger.model.form.SpecEqpTowerAccountForm;

/**
 * 塔类对象转换器
 *
 * @author baiwei
 * @since 2026-03-06 09:57
 */
@Mapper(componentModel = "spring")
public interface SpecEqpTowerAccountConverter{

    SpecEqpTowerAccountForm toForm(SpecEqpTowerAccount entity);

    SpecEqpTowerAccount toEntity(SpecEqpTowerAccountForm formData);

    SpecEqpTowerAccount toEntity(SpecEqpTowerAccountExportDto dto);



}