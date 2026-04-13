package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.ElectricLightEquipmentDto;
import com.youlai.boot.ledger.model.entity.ElectricLightEquipment;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ElectricLightEquipmentExportQuery;
import com.youlai.boot.ledger.model.query.ElectricLightEquipmentQuery;
import com.youlai.boot.ledger.model.vo.ElectricLightEquipmentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 电气照明设备Mapper接口
 *
 * @author dazao
 * @since 2026-02-04 09:24
 */
@Mapper
public interface ElectricLightEquipmentMapper extends BaseMapper<ElectricLightEquipment> {

    /**
     * 获取电气照明设备分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ElectricLightEquipmentVO>} 电气照明设备分页列表
     */
    Page<ElectricLightEquipmentVO> getElectricLightEquipmentPage(Page<ElectricLightEquipmentVO> page, ElectricLightEquipmentQuery queryParams);

    List<ElectricLightEquipmentDto> exportElectricLightEquipment(ElectricLightEquipmentExportQuery queryParams);
}
