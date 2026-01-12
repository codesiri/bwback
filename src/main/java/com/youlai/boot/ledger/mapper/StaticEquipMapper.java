package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.entity.StaticEquip;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.StaticEquipQuery;
import com.youlai.boot.ledger.model.vo.StaticEquipVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 静设备Mapper接口
 *
 * @author dazao
 * @since 2026-01-08 08:37
 */
@Mapper
public interface StaticEquipMapper extends BaseMapper<StaticEquip> {

    /**
     * 获取静设备分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<StaticEquipVO>} 静设备分页列表
     */
    Page<StaticEquipVO> getStaticEquipPage(Page<StaticEquipVO> page, StaticEquipQuery queryParams);

}
