package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.RadiationInstrumentExportDTO;
import com.youlai.boot.ledger.model.dto.RelayProtectionSettingExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.RelayProtectionSetting;
import com.youlai.boot.ledger.model.form.RelayProtectionSettingForm;

/**
 * 继电保护定值台账对象转换器
 *
 * @author dazao
 * @since 2026-02-11 09:41
 */
@Mapper(componentModel = "spring")
public interface RelayProtectionSettingConverter{

    RelayProtectionSettingForm toForm(RelayProtectionSetting entity);

    RelayProtectionSetting toEntity(RelayProtectionSettingForm formData);

    RelayProtectionSetting toEntity(RelayProtectionSettingExportDto relayProtectionSettingExportDto);
}