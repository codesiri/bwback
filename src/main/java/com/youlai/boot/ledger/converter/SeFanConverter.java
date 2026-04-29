package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.SeFanExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.SeFan;
import com.youlai.boot.ledger.model.form.SeFanForm;

/**
 * 特种设备风机台账对象转换器
 *
 * @author youlaitech
 * @since 2026-02-09 09:18
 */
@Mapper(componentModel = "spring")
public interface SeFanConverter{

    SeFanForm toForm(SeFan entity);

    SeFan toEntity(SeFanForm formData);

    SeFan toEntity(SeFanExportDto dto);
}