package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.AnalyInstrumentExportDto;
import com.youlai.boot.ledger.model.entity.AnalyInstrument;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.AnalyInstrumentExportQuery;
import com.youlai.boot.ledger.model.query.AnalyInstrumentQuery;
import com.youlai.boot.ledger.model.vo.AnalyInstrumentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 分析仪Mapper接口
 *
 * @author dazao
 * @since 2026-01-23 14:48
 */
@Mapper
public interface AnalyInstrumentMapper extends BaseMapper<AnalyInstrument> {
    /**
     * 获取分析仪分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<AnalyInstrumentVO>} 分析仪分页列表
     */
    Page<AnalyInstrumentVO> getAnalyInstrumentPage(Page<AnalyInstrumentVO> page, AnalyInstrumentQuery queryParams);

    List<AnalyInstrumentExportDto> listExportAnalyInstrument(AnalyInstrumentExportQuery queryParams);

}
