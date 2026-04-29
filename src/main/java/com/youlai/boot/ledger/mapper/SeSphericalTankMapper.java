package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SeSphericalTankExportDto;
import com.youlai.boot.ledger.model.entity.SeSphericalTank;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.model.query.SeSphericalTankQuery;
import com.youlai.boot.ledger.model.vo.SeSphericalTankVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 球罐Mapper接口
 *
 * @author baiwei
 * @since 2026-03-06 09:49
 */
@Mapper
public interface SeSphericalTankMapper extends BaseMapper<SeSphericalTank> {

    /**
     * 获取球罐分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SeSphericalTankVO>} 球罐分页列表
     */
    Page<SeSphericalTankVO> getSeSphericalTankPage(Page<SeSphericalTankVO> page, SeSphericalTankQuery queryParams);


    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return 导出列表
     */
    List<SeSphericalTankExportDto> listExportSeSphericalTank(SeSphericalTankQuery queryParams);

}
