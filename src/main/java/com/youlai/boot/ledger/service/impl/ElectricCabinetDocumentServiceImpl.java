package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.ElectricCabinetDocumentExportDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetDocumentsExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ElectricCabinetDocumentMapper;
import com.youlai.boot.ledger.service.ElectricCabinetDocumentService;
import com.youlai.boot.ledger.model.entity.ElectricCabinetDocument;
import com.youlai.boot.ledger.model.form.ElectricCabinetDocumentForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetDocumentQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetDocumentVO;
import com.youlai.boot.ledger.converter.ElectricCabinetDocumentConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 抽屉柜相关资料归档服务实现类
 *
 * @author dazao
 * @since 2026-03-12 09:11
 */
@Service
@RequiredArgsConstructor
public class ElectricCabinetDocumentServiceImpl extends ServiceImpl<ElectricCabinetDocumentMapper, ElectricCabinetDocument> implements ElectricCabinetDocumentService {

    private final ElectricCabinetDocumentConverter electricCabinetDocumentConverter;

    /**
    * 获取抽屉柜相关资料归档分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<ElectricCabinetDocumentVO>} 抽屉柜相关资料归档分页列表
    */
    @Override
    public IPage<ElectricCabinetDocumentVO> getElectricCabinetDocumentPage(ElectricCabinetDocumentQuery queryParams) {
        Page<ElectricCabinetDocumentVO> pageVO = this.baseMapper.getElectricCabinetDocumentPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取抽屉柜相关资料归档表单数据
     *
     * @param id 抽屉柜相关资料归档ID
     * @return 抽屉柜相关资料归档表单数据
     */
    @Override
    public ElectricCabinetDocumentForm getElectricCabinetDocumentFormData(Long id) {
        ElectricCabinetDocument entity = this.getById(id);
        return electricCabinetDocumentConverter.toForm(entity);
    }
    
    /**
     * 新增抽屉柜相关资料归档
     *
     * @param formData 抽屉柜相关资料归档表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveElectricCabinetDocument(ElectricCabinetDocumentForm formData) {
        ElectricCabinetDocument entity = electricCabinetDocumentConverter.toEntity(formData);
        IDgenAdapterLeaf  iDgenAdapterLeaf = new IDgenAdapterLeaf();
        var id= iDgenAdapterLeaf.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }
    
    /**
     * 更新抽屉柜相关资料归档
     *
     * @param id   抽屉柜相关资料归档ID
     * @param formData 抽屉柜相关资料归档表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateElectricCabinetDocument(Long id,ElectricCabinetDocumentForm formData) {
        ElectricCabinetDocument entity = electricCabinetDocumentConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除抽屉柜相关资料归档
     *
     * @param ids 抽屉柜相关资料归档ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteElectricCabinetDocuments(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的抽屉柜相关资料归档数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<ElectricCabinetDocumentExportDto> exportElectricCabinetDocuments(ElectricCabinetDocumentsExportQuery queryParams) {
        return this.baseMapper.exportElectricCabinetDocuments(queryParams);
    }

}
