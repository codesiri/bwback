package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.entity.SeHeater;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.model.vo.SeHeaterVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 换热器Mapper接口
 *
 * @author baiwei
 * @since 2026-03-03 10:16
 */
@Mapper
public interface SeHeaterMapper extends BaseMapper<SeHeater> {

    /**
     * 获取换热器分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SeHeaterVO>} 换热器分页列表
     */
    Page<SeHeaterVO> getSeHeaterPage(Page<SeHeaterVO> page, SeHeaterQuery queryParams);

    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<SeHeaterExportDto> listExportSeHeater(SeHeaterQuery queryParams);

}
