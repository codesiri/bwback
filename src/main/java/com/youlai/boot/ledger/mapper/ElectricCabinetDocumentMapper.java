package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.ElectricCabinetDocumentExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetDocument;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.ElectricCabinetDocumentQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetDocumentsExportQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetDocumentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 抽屉柜相关资料归档Mapper接口
 *
 * @author dazao
 * @since 2026-03-12 09:11
 */
@Mapper
public interface ElectricCabinetDocumentMapper extends BaseMapper<ElectricCabinetDocument> {

    /**
     * 获取抽屉柜相关资料归档分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<ElectricCabinetDocumentVO>} 抽屉柜相关资料归档分页列表
     */
    Page<ElectricCabinetDocumentVO> getElectricCabinetDocumentPage(Page<ElectricCabinetDocumentVO> page, ElectricCabinetDocumentQuery queryParams);

    List<ElectricCabinetDocumentExportDto> exportElectricCabinetDocuments(ElectricCabinetDocumentsExportQuery queryParams);
}
