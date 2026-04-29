package com.youlai.boot.ledger.converter;

import com.youlai.boot.ledger.model.dto.SeHorizontalTankExportDto;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.SeHorizontalTank;
import com.youlai.boot.ledger.model.form.SeHorizontalTankForm;

/**
 * 卧罐对象转换器
 *
 * @author baiwei
 * @since 2026-03-06 09:33
 */
@Mapper(componentModel = "spring")
public interface SeHorizontalTankConverter{

    SeHorizontalTankForm toForm(SeHorizontalTank entity);

    SeHorizontalTank toEntity(SeHorizontalTankForm formData);

    SeHorizontalTank toEntity(SeHorizontalTankExportDto dto);

}