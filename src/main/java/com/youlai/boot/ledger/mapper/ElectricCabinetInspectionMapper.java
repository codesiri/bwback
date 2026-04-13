package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.ElectricCabinetInspectionExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetInspection;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ElectricCabinetInspectionExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetInspectionQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetInspectionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 抽屉柜检修试验记录Mapper接口
 *
 * @author youlaitech
 * @since 2026-03-18 16:19
 */
@Mapper
public interface ElectricCabinetInspectionMapper extends BaseMapper<ElectricCabinetInspection> {

    /**
     * 获取抽屉柜检修试验记录分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ElectricCabinetInspectionVO>} 抽屉柜检修试验记录分页列表
     */
    Page<ElectricCabinetInspectionVO> getElectricCabinetInspectionPage(Page<ElectricCabinetInspectionVO> page, ElectricCabinetInspectionQuery queryParams);

    List<ElectricCabinetInspectionExportDto> exportElectricCabinetInspections(ElectricCabinetInspectionExportQuery queryParams);
}
