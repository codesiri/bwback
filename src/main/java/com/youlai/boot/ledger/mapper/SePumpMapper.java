package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SePumpExportDto;
import com.youlai.boot.ledger.model.entity.SePump;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SePumpQuery;
import com.youlai.boot.ledger.model.vo.SePumpVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 泵Mapper接口
 *
 * @author baiwei
 * @since 2026-02-05 14:46
 */
@Mapper
public interface SePumpMapper extends BaseMapper<SePump> {

    /**
     * 获取泵分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SePumpVO>} 泵分页列表
     */
    Page<SePumpVO> getSePumpPage(Page<SePumpVO> page, SePumpQuery queryParams);

    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<SePumpExportDto> listExportSePump(SePumpQuery queryParams);

}
