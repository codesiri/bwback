package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.UnitSpecialInstrumentsExportDto;
import com.youlai.boot.ledger.model.entity.UnitSpecialInstruments;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.UnitSpecialInstrumentsQuery;
import com.youlai.boot.ledger.model.query.UnitSpecialInstrumentsQueryExport;
import com.youlai.boot.ledger.model.vo.UnitSpecialInstrumentsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 机组特殊仪Mapper接口
 *
 * @author dazao
 * @since 2026-01-21 09:01
 */
@Mapper
public interface UnitSpecialInstrumentsMapper extends BaseMapper<UnitSpecialInstruments> {

    /**
     * 获取机组特殊仪分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<UnitSpecialInstrumentsVO>} 机组特殊仪分页列表
     */
    Page<UnitSpecialInstrumentsVO> getUnitSpecialInstrumentsPage(Page<UnitSpecialInstrumentsVO> page, UnitSpecialInstrumentsQuery queryParams);
    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<UnitSpecialInstrumentsExportDto> listExportUnitSpecialInstrument(UnitSpecialInstrumentsQueryExport queryParams);

}
