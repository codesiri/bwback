package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.ElectricCabinetDocumentExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetDrawerUnit;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ElectricCabinetDrawerUnitQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetDrawerUnitsExportQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetDrawerUnitVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 抽屉柜抽屉单元明细Mapper接口
 *
 * @author youlaitech
 * @since 2026-03-17 09:40
 */
@Mapper
public interface ElectricCabinetDrawerUnitMapper extends BaseMapper<ElectricCabinetDrawerUnit> {

    /**
     * 获取抽屉柜抽屉单元明细分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ElectricCabinetDrawerUnitVO>} 抽屉柜抽屉单元明细分页列表
     */
    Page<ElectricCabinetDrawerUnitVO> getElectricCabinetDrawerUnitPage(Page<ElectricCabinetDrawerUnitVO> page, ElectricCabinetDrawerUnitQuery queryParams);

    List<ElectricCabinetDocumentExportDto> exportElectricCabinetDrawerUnits(ElectricCabinetDrawerUnitsExportQuery queryParams);
}
