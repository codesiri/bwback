package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SpecEqpSteamTurbineAccountExportDto;
import com.youlai.boot.ledger.model.entity.SpecEqpSteamTurbineAccount;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SpecEqpSteamTurbineAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpSteamTurbineAccountVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 汽轮机Mapper接口
 *
 * @author baiwei
 * @since 2026-02-03 09:38
 */
@Mapper
public interface SpecEqpSteamTurbineAccountMapper extends BaseMapper<SpecEqpSteamTurbineAccount> {

    /**
     * 获取汽轮机分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SpecEqpSteamTurbineAccountVO>} 汽轮机分页列表
     */
    Page<SpecEqpSteamTurbineAccountVO> getSpecEqpSteamTurbineAccountPage(Page<SpecEqpSteamTurbineAccountVO> page, SpecEqpSteamTurbineAccountQuery queryParams);


    List<SpecEqpSteamTurbineAccountExportDto> listExportSpecEqpCraneTransAccounts(SpecEqpSteamTurbineAccountQuery queryParams);
}
