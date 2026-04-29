package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.SeRefrigeratorExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.SeRefrigerator;
import com.youlai.boot.ledger.model.form.SeRefrigeratorForm;

/**
 * 特种设备制冷机台账对象转换器
 *
 * @author baiwei
 * @since 2026-02-14 08:38
 */
@Mapper(componentModel = "spring")
public interface SeRefrigeratorConverter{

    SeRefrigeratorForm toForm(SeRefrigerator entity);

    SeRefrigerator toEntity(SeRefrigeratorForm formData);

    SeRefrigerator toEntity(SeRefrigeratorExportDto dto);

}