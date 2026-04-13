package com.youlai.boot.maintence.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.maintence.model.entity.MaintainPlan;
import com.youlai.boot.maintence.model.form.MaintainPlanForm;

/**
 * 维修计划对象转换器
 *
 * @author youlaitech
 * @since 2026-04-10 08:37
 */
@Mapper(componentModel = "spring")
public interface MaintainPlanConverter{

    MaintainPlanForm toForm(MaintainPlan entity);

    MaintainPlan toEntity(MaintainPlanForm formData);
}