package com.youlai.boot.maintence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.maintence.model.dto.MaintainPlanExportDto;
import com.youlai.boot.maintence.model.entity.MaintainPlan;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.maintence.model.query.MaintainPlanQuery;
import com.youlai.boot.maintence.model.vo.MaintainPlanVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 维修计划Mapper接口
 *
 * @author youlaitech
 * @since 2026-04-10 08:37
 */
@Mapper
public interface MaintainPlanMapper extends BaseMapper<MaintainPlan> {

    /**
     * 获取维修计划分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<MaintainPlanVO>} 维修计划分页列表
     */
    Page<MaintainPlanVO> getMaintainPlanPage(Page<MaintainPlanVO> page, MaintainPlanQuery queryParams);

    List<MaintainPlanExportDto> exportMaintainPlans();

}
