package com.youlai.boot.ledger.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.StaticEquip;
import com.youlai.boot.ledger.model.form.StaticEquipForm;

/**
 * 静设备对象转换器
 *
 * @author dazao
 * @since 2026-01-08 08:37
 */
@Mapper(componentModel = "spring")
public interface StaticEquipConverter{

    StaticEquipForm toForm(StaticEquip entity);

    StaticEquip toEntity(StaticEquipForm formData);
}