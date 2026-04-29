package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.SeExpanderExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.SeExpander;
import com.youlai.boot.ledger.model.form.SeExpanderForm;

/**
 * 特种设备膨胀机台账对象转换器
 *
 * @author baiwei
 * @since 2026-02-09 09:15
 */
@Mapper(componentModel = "spring")
public interface SeExpanderConverter{

    SeExpanderForm toForm(SeExpander entity);

    SeExpander toEntity(SeExpanderForm formData);

    SeExpander toEntity(SeExpanderExportDto dto);

}