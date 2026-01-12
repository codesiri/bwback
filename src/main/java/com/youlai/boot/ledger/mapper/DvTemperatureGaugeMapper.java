package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.entity.DvTemperatureGauge;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.DvTemperatureGaugeQuery;
import com.youlai.boot.ledger.model.query.DvTemperatureGaugeQueryPlus;
import com.youlai.boot.ledger.model.vo.DvTemperatureGaugeVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 温度Mapper接口
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
@Mapper
public interface DvTemperatureGaugeMapper extends BaseMapper<DvTemperatureGauge> {

    /**
     * 获取温度分页数据
     *
     * @param page 分页对象
     * @return {@link Page<DvTemperatureGaugeVO>} 温度分页列表
     */
    Page<DvTemperatureGaugeVO> getDvTemperatureGaugePage(Page<DvTemperatureGaugeVO> page, String tagNumber,String status,String dvName);

}
