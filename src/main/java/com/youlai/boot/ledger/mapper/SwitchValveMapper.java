package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SwitchValveExportDto;
import com.youlai.boot.ledger.model.entity.SwitchValve;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SwitchValveQuery;
import com.youlai.boot.ledger.model.vo.SwitchValveVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 开关阀Mapper接口
 *
 * @author dazao
 * @since 2026-01-27 08:43
 */
@Mapper
public interface SwitchValveMapper extends BaseMapper<SwitchValve> {

    /**
     * 获取开关阀分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SwitchValveVO>} 开关阀分页列表
     */
    Page<SwitchValveVO> getSwitchValvePage(Page<SwitchValveVO> page, SwitchValveQuery queryParams);

    List<SwitchValveExportDto> exportSwitchValveTable(SwitchValveQuery queryParams);
}
