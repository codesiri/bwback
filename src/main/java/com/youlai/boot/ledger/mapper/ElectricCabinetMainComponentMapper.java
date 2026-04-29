package com.youlai.boot.ledger.mapper;

import com.youlai.boot.ledger.model.dto.ElectricCabinetMainComponentDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.entity.ElectricCabinetMainComponent;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ElectricCabinetMainComponentQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetMainComponentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 抽屉柜主要元器件信息Mapper接口
 *
 * @author youlaitech
 * @since 2026-03-17 09:38
 */
@Mapper
public interface ElectricCabinetMainComponentMapper extends BaseMapper<ElectricCabinetMainComponent> {

    /**
     * 获取抽屉柜主要元器件信息分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ElectricCabinetMainComponentVO>} 抽屉柜主要元器件信息分页列表
     */
    Page<ElectricCabinetMainComponentVO> getElectricCabinetMainComponentPage(Page<ElectricCabinetMainComponentVO> page, ElectricCabinetMainComponentQuery queryParams);

    List<ElectricCabinetMainComponentDto> exportElectricCabinetMainComponents();

}
