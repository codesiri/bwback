package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.ElectricCabinetRecordExportDto;
import com.youlai.boot.ledger.model.dto.ElectricCabinetSparePartDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetSparePart;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ElectricCabinetRecordExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetSparePartExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetSparePartQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetSparePartVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 电器备品备件管理记录Mapper接口
 *
 * @author youlaitech
 * @since 2026-03-04 08:46
 */
@Mapper
public interface ElectricCabinetSparePartMapper extends BaseMapper<ElectricCabinetSparePart> {

    /**
     * 获取电器备品备件管理记录分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ElectricCabinetSparePartVO>} 电器备品备件管理记录分页列表
     */
    Page<ElectricCabinetSparePartVO> getElectricCabinetSparePartPage(Page<ElectricCabinetSparePartVO> page, ElectricCabinetSparePartQuery queryParams);

    List<ElectricCabinetSparePartDto> exportElectricCabinetSpareParts(ElectricCabinetSparePartExportQuery params);
}
