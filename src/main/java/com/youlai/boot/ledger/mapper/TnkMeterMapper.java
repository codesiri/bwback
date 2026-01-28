package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.TnkMeterExportDto;
import com.youlai.boot.ledger.model.entity.TnkMeter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.TnkMeterExportQuery;
import com.youlai.boot.ledger.model.query.TnkMeterQuery;
import com.youlai.boot.ledger.model.vo.TnkMeterVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 罐区仪Mapper接口
 *
 * @author dazao
 * @since 2026-01-20 08:17
 */
@Mapper
public interface TnkMeterMapper extends BaseMapper<TnkMeter> {

    /**
     * 获取罐区仪分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<TnkMeterVO>} 罐区仪分页列表
     */
    Page<TnkMeterVO> getTnkMeterPage(Page<TnkMeterVO> page, TnkMeterQuery queryParams);
    List<TnkMeterExportDto> listExportTnkMeters(TnkMeterExportQuery queryParams);
}
