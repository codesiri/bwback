package com.youlai.boot.ledger.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.SwitchValve;
import com.youlai.boot.ledger.model.form.SwitchValveForm;

/**
 * 开关阀对象转换器
 *
 * @author dazao
 * @since 2026-01-27 08:43
 */
@Mapper(componentModel = "spring")
public interface SwitchValveConverter{

    SwitchValveForm toForm(SwitchValve entity);

    SwitchValve toEntity(SwitchValveForm formData);
}