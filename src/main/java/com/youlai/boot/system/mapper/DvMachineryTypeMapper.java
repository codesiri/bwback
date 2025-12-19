package com.youlai.boot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.system.model.entity.DvMachineryType;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.query.DvMachineryTypeQuery;
import com.youlai.boot.system.model.query.QueryDvTypeParams;
import com.youlai.boot.system.model.vo.DvMachineryTypeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 设备类型Mapper接口
 *
 * @author youlaitech
 * @since 2025-12-17 08:15
 */
@Mapper
public interface DvMachineryTypeMapper extends BaseMapper<DvMachineryType> {

    /**
     * 获取设备类型分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<DvMachineryTypeVO>} 设备类型分页列表
     */
    Page<DvMachineryTypeVO> getDvMachineryTypePage(Page<DvMachineryTypeVO> page, DvMachineryTypeQuery queryParams);
    List<DvMachineryTypeVO> selectDvMachineryTypeList(DvMachineryType dvMachineryType);
    List<DvMachineryTypeVO> queryDvTypeByParams(QueryDvTypeParams queryDvTypeParams);
}
