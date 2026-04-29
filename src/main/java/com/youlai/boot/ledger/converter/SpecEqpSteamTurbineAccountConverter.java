package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.SpecEqpSteamTurbineAccountExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.SpecEqpSteamTurbineAccount;
import com.youlai.boot.ledger.model.form.SpecEqpSteamTurbineAccountForm;

/**
 * 汽轮机对象转换器
 *
 * @author baiwei
 * @since 2026-02-03 09:38
 */
@Mapper(componentModel = "spring")
public interface SpecEqpSteamTurbineAccountConverter{

    SpecEqpSteamTurbineAccountForm toForm(SpecEqpSteamTurbineAccount entity);

    SpecEqpSteamTurbineAccount toEntity(SpecEqpSteamTurbineAccountForm formData);

    SpecEqpSteamTurbineAccount toEntity(SpecEqpSteamTurbineAccountExportDto dto);
}