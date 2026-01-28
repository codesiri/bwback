package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.LevelGaugeExportDto;
import com.youlai.boot.ledger.model.entity.LevelGauge;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.LevelGaugeExportQuery;
import com.youlai.boot.ledger.model.query.LevelGaugeQuery;
import com.youlai.boot.ledger.model.vo.LevelGaugeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 液位计Mapper接口
 *
 * @author dazao
 * @since 2026-01-20 15:40
 */
@Mapper
public interface LevelGaugeMapper extends BaseMapper<LevelGauge> {

    /**
     * 获取液位计分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<LevelGaugeVO>} 液位计分页列表
     */
    Page<LevelGaugeVO> getLevelGaugePage(Page<LevelGaugeVO> page, LevelGaugeQuery queryParams);

    List<LevelGaugeExportDto> listExportLevelGauge(LevelGaugeExportQuery queryParams);
}
