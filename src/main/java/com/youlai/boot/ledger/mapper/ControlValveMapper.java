package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.ControlValveExportDto;
import com.youlai.boot.ledger.model.entity.ControlValve;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ControlValveQuery;
import com.youlai.boot.ledger.model.vo.ControlValveVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 调节阀Mapper接口
 *
 * @author cc
 * @since 2026-01-28 11:03
 */
@Mapper
public interface ControlValveMapper extends BaseMapper<ControlValve> {

    /**
     * 获取调节阀分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ControlValveVO>} 调节阀分页列表
     */
    Page<ControlValveVO> getControlValvePage(Page<ControlValveVO> page, ControlValveQuery queryParams);

    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<ControlValveExportDto> listExportControlValves(ControlValveQuery queryParams);

}

