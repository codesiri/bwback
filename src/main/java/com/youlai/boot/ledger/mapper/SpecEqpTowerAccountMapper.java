package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SpecEqpTowerAccountExportDto;
import com.youlai.boot.ledger.model.entity.SpecEqpTowerAccount;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.model.query.SpecEqpTowerAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpTowerAccountVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 塔类Mapper接口
 *
 * @author baiwei
 * @since 2026-03-06 09:57
 */
@Mapper
public interface SpecEqpTowerAccountMapper extends BaseMapper<SpecEqpTowerAccount> {

    /**
     * 获取塔类分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SpecEqpTowerAccountVO>} 塔类分页列表
     */
    Page<SpecEqpTowerAccountVO> getSpecEqpTowerAccountPage(Page<SpecEqpTowerAccountVO> page, SpecEqpTowerAccountQuery queryParams);
    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<SpecEqpTowerAccountExportDto> listExportSpecEqpTowerAccount(SpecEqpTowerAccountQuery queryParams);

}
