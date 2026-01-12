package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.entity.DpFlowMeter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.DpFlowMeterQuery;
import com.youlai.boot.ledger.model.vo.DpFlowMeterVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 差压流量计Mapper接口
 *
 * @author dazao
 * @since 2026-01-08 16:41
 */
@Mapper
public interface DpFlowMeterMapper extends BaseMapper<DpFlowMeter> {

    /**
     * 获取差压流量计分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<DpFlowMeterVO>} 差压流量计分页列表
     */
    Page<DpFlowMeterVO> getDpFlowMeterPage(Page<DpFlowMeterVO> page, DpFlowMeterQuery queryParams);

}
