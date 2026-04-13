package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.ElectricCabinetChangeExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetChange;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ElectricCabinetChangeExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetChangeQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetChangeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 抽屉柜变更记录Mapper接口
 *
 * @author dazao
 * @since 2026-03-13 11:16
 */
@Mapper
public interface ElectricCabinetChangeMapper extends BaseMapper<ElectricCabinetChange> {

    /**
     * 获取抽屉柜变更记录分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ElectricCabinetChangeVO>} 抽屉柜变更记录分页列表
     */
    Page<ElectricCabinetChangeVO> getElectricCabinetChangePage(Page<ElectricCabinetChangeVO> page, ElectricCabinetChangeQuery queryParams);

    List<ElectricCabinetChangeExportDto> exportElectricCabinetChanges(ElectricCabinetChangeExportQuery queryParams);

}
