package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.RadiationInstrumentExportDTO;
import com.youlai.boot.ledger.model.entity.RadiationInstrument;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.RadiationInstrumentQuery;
import com.youlai.boot.ledger.model.vo.RadiationInstrumentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 放射仪Mapper接口
 *
 * @author baiwei
 * @since 2026-01-28 09:50
 */
@Mapper
public interface RadiationInstrumentMapper extends BaseMapper<RadiationInstrument> {

    /**
     * 获取放射仪分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<RadiationInstrumentVO>} 放射仪分页列表
     */
    Page<RadiationInstrumentVO> getRadiationInstrumentPage(Page<RadiationInstrumentVO> page, RadiationInstrumentQuery queryParams);
    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<RadiationInstrumentExportDTO> listExportRadiationInstrument(RadiationInstrumentQuery queryParams);

}

