package com.youlai.boot.system.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.entity.DvMachineryType;
import com.youlai.boot.system.model.form.DvMachineryTypeForm;

/**
 * 设备类型对象转换器
 *
 * @author youlaitech
 * @since 2025-12-17 08:15
 */
@Mapper(componentModel = "spring")
public interface DvMachineryTypeConverter{

    DvMachineryTypeForm toForm(DvMachineryType entity);

    DvMachineryType toEntity(DvMachineryTypeForm formData);
}