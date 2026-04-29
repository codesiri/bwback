package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SeFanExportDto;
import com.youlai.boot.ledger.model.entity.SeFan;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SeFanQuery;
import com.youlai.boot.ledger.model.vo.SeFanVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 特种设备风机台账Mapper接口
 *
 * @author youlaitech
 * @since 2026-02-09 09:18
 */
@Mapper
public interface SeFanMapper extends BaseMapper<SeFan> {

    /**
     * 获取特种设备风机台账分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SeFanVO>} 特种设备风机台账分页列表
     */
    Page<SeFanVO> getSeFanPage(Page<SeFanVO> page, SeFanQuery queryParams);

    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<SeFanExportDto> listExportSeFan(SeFanQuery queryParams);
}
