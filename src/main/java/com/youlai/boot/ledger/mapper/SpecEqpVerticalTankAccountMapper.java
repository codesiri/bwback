package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SpecEqpVerticalTankAccountExportDto;
import com.youlai.boot.ledger.model.entity.SpecEqpVerticalTankAccount;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.model.query.SpecEqpVerticalTankAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpVerticalTankAccountVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 立罐Mapper接口
 *
 * @author baiwei
 * @since 2026-03-06 10:04
 */
@Mapper
public interface SpecEqpVerticalTankAccountMapper extends BaseMapper<SpecEqpVerticalTankAccount> {

    /**
     * 获取立罐分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SpecEqpVerticalTankAccountVO>} 立罐分页列表
     */
    Page<SpecEqpVerticalTankAccountVO> getSpecEqpVerticalTankAccountPage(Page<SpecEqpVerticalTankAccountVO> page, SpecEqpVerticalTankAccountQuery queryParams);


    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<SpecEqpVerticalTankAccountExportDto> listExportSpecEqpVerticalTankAccount(SpecEqpVerticalTankAccountQuery queryParams);


}
