package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.ElecMotorsExportDto;
import com.youlai.boot.ledger.model.entity.ElecMotor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ElecMotorExportQuery;
import com.youlai.boot.ledger.model.query.ElecMotorQuery;
import com.youlai.boot.ledger.model.vo.ElecMotorVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 电器电动机Mapper接口
 *
 * @author dazao
 * @since 2026-01-13 10:10
 */
@Mapper
public interface ElecMotorMapper extends BaseMapper<ElecMotor> {

    /**
     * 获取电器电动机分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ElecMotorVO>} 电器电动机分页列表
     */
    Page<ElecMotorVO> getElecMotorPage(Page<ElecMotorVO> page, ElecMotorQuery queryParams);

    List<ElecMotorsExportDto> listExportElecMotor(ElecMotorExportQuery query);
}
