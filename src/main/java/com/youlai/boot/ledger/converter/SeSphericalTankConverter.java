package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SeSphericalTankExportDto;
import com.youlai.boot.ledger.model.entity.SeHeater;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.SeSphericalTank;
import com.youlai.boot.ledger.model.form.SeSphericalTankForm;

/**
 * 球罐对象转换器
 *
 * @author baiwei
 * @since 2026-03-06 09:49
 */
@Mapper(componentModel = "spring")
public interface SeSphericalTankConverter{

    SeSphericalTankForm toForm(SeSphericalTank entity);

    SeSphericalTank toEntity(SeSphericalTankForm formData);

    SeSphericalTank toEntity(SeSphericalTankExportDto dto);
}