package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.SeCompressorExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.SeCompressor;
import com.youlai.boot.ledger.model.form.SeCompressorForm;

/**
 * 特种设备压缩机台账对象转换器
 *
 * @author baiwei
 * @since 2026-02-09 09:07
 */
@Mapper(componentModel = "spring")
public interface SeCompressorConverter{

    SeCompressorForm toForm(SeCompressor entity);

    SeCompressor toEntity(SeCompressorForm formData);

    SeCompressor toEntity(SeCompressorExportDto dto);
    
}