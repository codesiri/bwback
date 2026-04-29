package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SeExpanderExportDto;
import com.youlai.boot.ledger.model.entity.SeExpander;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SeExpanderQuery;
import com.youlai.boot.ledger.model.vo.SeExpanderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 特种设备膨胀机台账Mapper接口
 *
 * @author baiwei
 * @since 2026-02-09 09:15
 */
@Mapper
public interface SeExpanderMapper extends BaseMapper<SeExpander> {

    /**
     * 获取特种设备膨胀机台账分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SeExpanderVO>} 特种设备膨胀机台账分页列表
     */
    Page<SeExpanderVO> getSeExpanderPage(Page<SeExpanderVO> page, SeExpanderQuery queryParams);


    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<SeExpanderExportDto> listExportSeExpander(SeExpanderQuery queryParams);
}
