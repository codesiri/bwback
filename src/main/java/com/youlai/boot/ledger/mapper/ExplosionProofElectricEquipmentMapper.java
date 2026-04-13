package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.ExplosionProofElectricEquipmentExportDto;
import com.youlai.boot.ledger.model.entity.ExplosionProofElectricEquipment;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ExplosionProofElectricEquipmentExportQuery;
import com.youlai.boot.ledger.model.query.ExplosionProofElectricEquipmentQuery;
import com.youlai.boot.ledger.model.vo.ExplosionProofElectricEquipmentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 防爆电气设备Mapper接口
 *
 * @author dazao
 * @since 2026-02-06 15:59
 */
@Mapper
public interface ExplosionProofElectricEquipmentMapper extends BaseMapper<ExplosionProofElectricEquipment> {

    /**
     * 获取防爆电气设备分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ExplosionProofElectricEquipmentVO>} 防爆电气设备分页列表
     */
    Page<ExplosionProofElectricEquipmentVO> getExplosionProofElectricEquipmentPage(Page<ExplosionProofElectricEquipmentVO> page, ExplosionProofElectricEquipmentQuery queryParams);

    List<ExplosionProofElectricEquipmentExportDto> exportExplosionProofElectricEquipments(ExplosionProofElectricEquipmentExportQuery queryParams);
}
