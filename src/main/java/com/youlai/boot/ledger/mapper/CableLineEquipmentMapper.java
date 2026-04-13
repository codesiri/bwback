package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.CableLineEquipmentExportDto;
import com.youlai.boot.ledger.model.entity.CableLineEquipment;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.CableLineEquipmentExportQuery;
import com.youlai.boot.ledger.model.query.CableLineEquipmentQuery;
import com.youlai.boot.ledger.model.vo.CableLineEquipmentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 电器电缆线路Mapper接口
 *
 * @author dazao
 * @since 2026-03-05 08:45
 */
@Mapper
public interface CableLineEquipmentMapper extends BaseMapper<CableLineEquipment> {

    /**
     * 获取电器电缆线路分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<CableLineEquipmentVO>} 电器电缆线路分页列表
     */
    Page<CableLineEquipmentVO> getCableLineEquipmentPage(Page<CableLineEquipmentVO> page, CableLineEquipmentQuery queryParams);

    List<CableLineEquipmentExportDto> exportCableLineEquipments(CableLineEquipmentExportQuery queryParams);
}
