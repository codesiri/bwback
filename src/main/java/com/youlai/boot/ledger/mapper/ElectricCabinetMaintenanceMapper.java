package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.ElectricCabinetMaintenanceExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetMaintenance;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ElectricCabinetMaintenanceQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetMaintenanceVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 抽屉柜维护保养记录Mapper接口
 *
 * @author c
 * @since 2026-04-16 14:43
 */
@Mapper
public interface ElectricCabinetMaintenanceMapper extends BaseMapper<ElectricCabinetMaintenance> {

    /**
     * 获取抽屉柜维护保养记录分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ElectricCabinetMaintenanceVO>} 抽屉柜维护保养记录分页列表
     */
    Page<ElectricCabinetMaintenanceVO> getElectricCabinetMaintenancePage(Page<ElectricCabinetMaintenanceVO> page, ElectricCabinetMaintenanceQuery queryParams);

    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<ElectricCabinetMaintenanceExportDto> listExportElectricCabinetMaintenances(ElectricCabinetMaintenanceQuery queryParams);

}
