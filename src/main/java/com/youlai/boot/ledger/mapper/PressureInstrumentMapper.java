package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.dto.PressureInstrumentExportDTO;
import com.youlai.boot.ledger.model.entity.PressureInstrument;
import com.youlai.boot.ledger.model.query.PressureInstrumentQueryPlus;
import com.youlai.boot.ledger.model.vo.PressureInstrumentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 压力Mapper接口
 *
 * @author wy
 * @since 2025-12-29 11:00
 */
@Mapper
public interface PressureInstrumentMapper extends BaseMapper<PressureInstrument> {

    /**
     * 获取压力分页数据
     *
     * @param page 分页对象
     * @return {@link Page<PressureInstrumentVO>} 压力分页列表
     */
    Page<PressureInstrumentVO> getPressureInstrumentPage(Page<PressureInstrumentVO> page, PressureInstrumentQueryPlus queryParams);

    /**
     * 获取导出压力列表
     *
     * @param queryParams 查询参数
     * @return 导出压力列表
     */
    List<PressureInstrumentExportDTO> listExportPressureInstruments(PressureInstrumentQueryPlus queryParams);


}

