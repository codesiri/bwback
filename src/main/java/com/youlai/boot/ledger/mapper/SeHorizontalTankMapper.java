package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SeHorizontalTankExportDto;
import com.youlai.boot.ledger.model.entity.SeHorizontalTank;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SeHorizontalTankQuery;
import com.youlai.boot.ledger.model.vo.SeHorizontalTankVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 卧罐Mapper接口
 *
 * @author baiwei
 * @since 2026-03-06 09:33
 */
@Mapper
public interface SeHorizontalTankMapper extends BaseMapper<SeHorizontalTank> {

    /**
     * 获取卧罐分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SeHorizontalTankVO>} 卧罐分页列表
     */
    Page<SeHorizontalTankVO> getSeHorizontalTankPage(Page<SeHorizontalTankVO> page, SeHorizontalTankQuery queryParams);


    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<SeHorizontalTankExportDto> listExportSeHorizontalTank(SeHorizontalTankQuery queryParams);
}
