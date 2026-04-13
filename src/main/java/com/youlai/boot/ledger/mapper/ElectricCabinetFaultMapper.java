package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.ElectricCabinetFaultExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetFault;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ElectricCabinetFaultExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetFaultQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetFaultVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 抽屉柜故障维修记录Mapper接口
 *
 * @author youlaitech
 * @since 2026-03-23 17:05
 */
@Mapper
public interface ElectricCabinetFaultMapper extends BaseMapper<ElectricCabinetFault> {

    /**
     * 获取抽屉柜故障维修记录分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ElectricCabinetFaultVO>} 抽屉柜故障维修记录分页列表
     */
    Page<ElectricCabinetFaultVO> getElectricCabinetFaultPage(Page<ElectricCabinetFaultVO> page, ElectricCabinetFaultQuery queryParams);

    List<ElectricCabinetFaultExportDto> exportElectricCabinetFaults(ElectricCabinetFaultExportQuery queryParams);
}
