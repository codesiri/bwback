package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.GroundSystemEquipmentExportDto;
import com.youlai.boot.ledger.model.entity.GroundSystemEquipment;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.GroundSystemEquipmentExportQuery;
import com.youlai.boot.ledger.model.query.GroundSystemEquipmentQuery;
import com.youlai.boot.ledger.model.vo.GroundSystemEquipmentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 电器接地系统Mapper接口
 *
 * @author dazao
 * @since 2026-03-09 08:51
 */
@Mapper
public interface GroundSystemEquipmentMapper extends BaseMapper<GroundSystemEquipment> {

    /**
     * 获取电器接地系统分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<GroundSystemEquipmentVO>} 电器接地系统分页列表
     */
    Page<GroundSystemEquipmentVO> getGroundSystemEquipmentPage(Page<GroundSystemEquipmentVO> page, GroundSystemEquipmentQuery queryParams);

    List<GroundSystemEquipmentExportDto> exportGroundSystemEquipments(GroundSystemEquipmentExportQuery queryParams);
}
