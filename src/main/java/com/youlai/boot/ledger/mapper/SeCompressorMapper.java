package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SeCompressorExportDto;
import com.youlai.boot.ledger.model.entity.SeCompressor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SeCompressorQuery;
import com.youlai.boot.ledger.model.vo.SeCompressorVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 特种设备压缩机台账Mapper接口
 *
 * @author baiwei
 * @since 2026-02-09 09:07
 */
@Mapper
public interface SeCompressorMapper extends BaseMapper<SeCompressor> {

    /**
     * 获取特种设备压缩机台账分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SeCompressorVO>} 特种设备压缩机台账分页列表
     */
    Page<SeCompressorVO> getSeCompressorPage(Page<SeCompressorVO> page, SeCompressorQuery queryParams);

    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<SeCompressorExportDto> listExportSeCompressor(SeCompressorQuery queryParams);
}
