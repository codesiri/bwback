package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SpecEqpCraneTransAccountsExportDto;
import com.youlai.boot.ledger.model.entity.SpecEqpCraneTransAccount;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SpecEqpCraneTransAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpCraneTransAccountVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 起重运输类Mapper接口
 *
 * @author baiwei
 * @since 2026-02-03 09:22
 */
@Mapper
public interface SpecEqpCraneTransAccountMapper extends BaseMapper<SpecEqpCraneTransAccount> {

    /**
     * 获取起重运输类分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SpecEqpCraneTransAccountVO>} 起重运输类分页列表
     */
    Page<SpecEqpCraneTransAccountVO> getSpecEqpCraneTransAccountPage(Page<SpecEqpCraneTransAccountVO> page, SpecEqpCraneTransAccountQuery queryParams);


    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<SpecEqpCraneTransAccountsExportDto> listExportSpecEqpCraneTransAccounts(SpecEqpCraneTransAccountQuery queryParams);
}
