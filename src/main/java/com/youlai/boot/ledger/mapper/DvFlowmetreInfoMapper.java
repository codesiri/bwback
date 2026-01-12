package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.entity.DvFlowmetreInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.DvFlowmetreInfoQuery;
import com.youlai.boot.ledger.model.vo.DvFlowmetreInfoVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 流量计Mapper接口
 *
 * @author dazao
 * @since 2026-01-09 09:04
 */
@Mapper
public interface DvFlowmetreInfoMapper extends BaseMapper<DvFlowmetreInfo> {

    /**
     * 获取流量计分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<DvFlowmetreInfoVO>} 流量计分页列表
     */
    Page<DvFlowmetreInfoVO> getDvFlowmetreInfoPage(Page<DvFlowmetreInfoVO> page, DvFlowmetreInfoQuery queryParams);

}
