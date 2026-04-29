package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.SeHeater;
import com.youlai.boot.ledger.model.form.SeHeaterForm;

/**
 * 换热器对象转换器
 *
 * @author baiwei
 * @since 2026-03-03 10:16
 */
@Mapper(componentModel = "spring")
public interface SeHeaterConverter{

    SeHeaterForm toForm(SeHeater entity);

    SeHeater toEntity(SeHeaterForm formData);

    SeHeater toEntity(SeHeaterExportDto dto);
}