package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.SePumpExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.SePump;
import com.youlai.boot.ledger.model.form.SePumpForm;

/**
 * 泵对象转换器
 *
 * @author baiwei
 * @since 2026-02-05 14:46
 */
@Mapper(componentModel = "spring")
public interface SePumpConverter{

    SePumpForm toForm(SePump entity);

    SePump toEntity(SePumpForm formData);

    SePump toEntity(SePumpExportDto dto);
}