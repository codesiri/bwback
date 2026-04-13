package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.ElectricCabinetRecordExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetRecord;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ElectricCabinetRecordExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetRecordQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetRecordVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 电器日常巡检记录Mapper接口
 *
 * @author cc
 * @since 2026-03-03 09:40
 */
@Mapper
public interface ElectricCabinetRecordMapper extends BaseMapper<ElectricCabinetRecord> {

    /**
     * 获取电器日常巡检记录分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ElectricCabinetRecordVO>} 电器日常巡检记录分页列表
     */
    Page<ElectricCabinetRecordVO> getElectricCabinetRecordPage(Page<ElectricCabinetRecordVO> page, ElectricCabinetRecordQuery queryParams);
    List<ElectricCabinetRecordExportDto> exportElectricCabinetRecords(ElectricCabinetRecordExportQuery queryParams);
}
