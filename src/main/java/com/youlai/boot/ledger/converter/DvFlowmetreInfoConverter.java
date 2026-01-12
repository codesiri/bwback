package com.youlai.boot.ledger.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.entity.DvFlowmetreInfo;
import com.youlai.boot.ledger.model.form.DvFlowmetreInfoForm;

/**
 * 流量计对象转换器
 *
 * @author dazao
 * @since 2026-01-09 09:04
 */
@Mapper(componentModel = "spring")
public interface DvFlowmetreInfoConverter{

    DvFlowmetreInfoForm toForm(DvFlowmetreInfo entity);

    DvFlowmetreInfo toEntity(DvFlowmetreInfoForm formData);
}