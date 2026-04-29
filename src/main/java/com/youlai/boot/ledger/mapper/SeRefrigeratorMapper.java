package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SeRefrigeratorExportDto;
import com.youlai.boot.ledger.model.entity.SeRefrigerator;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SeRefrigeratorQuery;
import com.youlai.boot.ledger.model.vo.SeRefrigeratorVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 特种设备制冷机台账Mapper接口
 *
 * @author baiwei
 * @since 2026-02-14 08:38
 */
@Mapper
public interface SeRefrigeratorMapper extends BaseMapper<SeRefrigerator> {

    /**
     * 获取特种设备制冷机台账分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SeRefrigeratorVO>} 特种设备制冷机台账分页列表
     */
    Page<SeRefrigeratorVO> getSeRefrigeratorPage(Page<SeRefrigeratorVO> page, SeRefrigeratorQuery queryParams);

    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<SeRefrigeratorExportDto> listExportSeRefrigerator(SeRefrigeratorQuery queryParams);
}
