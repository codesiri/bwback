package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ElectricCabinetDocumentExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetDocument;
import com.youlai.boot.ledger.model.form.ElectricCabinetDocumentForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetDocumentQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetDocumentsExportQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetDocumentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 抽屉柜相关资料归档服务类
 *
 * @author dazao
 * @since 2026-03-12 09:11
 */
public interface ElectricCabinetDocumentService extends IService<ElectricCabinetDocument> {

    /**
     *抽屉柜相关资料归档分页列表
     *
     * @return {@link IPage<ElectricCabinetDocumentVO>} 抽屉柜相关资料归档分页列表
     */
    IPage<ElectricCabinetDocumentVO> getElectricCabinetDocumentPage(ElectricCabinetDocumentQuery queryParams);

    /**
     * 获取抽屉柜相关资料归档表单数据
     *
     * @param id 抽屉柜相关资料归档ID
     * @return 抽屉柜相关资料归档表单数据
     */
     ElectricCabinetDocumentForm getElectricCabinetDocumentFormData(Long id);

    /**
     * 新增抽屉柜相关资料归档
     *
     * @param formData 抽屉柜相关资料归档表单对象
     * @return 是否新增成功
     */
    boolean saveElectricCabinetDocument(ElectricCabinetDocumentForm formData);

    /**
     * 修改抽屉柜相关资料归档
     *
     * @param id   抽屉柜相关资料归档ID
     * @param formData 抽屉柜相关资料归档表单对象
     * @return 是否修改成功
     */
    boolean updateElectricCabinetDocument(Long id, ElectricCabinetDocumentForm formData);

    /**
     * 删除抽屉柜相关资料归档
     *
     * @param ids 抽屉柜相关资料归档ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteElectricCabinetDocuments(String ids);

    List<ElectricCabinetDocumentExportDto> exportElectricCabinetDocuments(ElectricCabinetDocumentsExportQuery queryParams);
}
