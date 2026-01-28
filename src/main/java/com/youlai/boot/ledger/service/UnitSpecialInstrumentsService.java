package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.UnitSpecialInstrumentsExportDto;
import com.youlai.boot.ledger.model.entity.UnitSpecialInstruments;
import com.youlai.boot.ledger.model.form.UnitSpecialInstrumentsForm;
import com.youlai.boot.ledger.model.query.UnitSpecialInstrumentsQuery;
import com.youlai.boot.ledger.model.query.UnitSpecialInstrumentsQueryExport;
import com.youlai.boot.ledger.model.vo.UnitSpecialInstrumentsVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 机组特殊仪服务类
 *
 * @author dazao
 * @since 2026-01-21 09:01
 */
public interface UnitSpecialInstrumentsService extends IService<UnitSpecialInstruments> {

    /**
     *机组特殊仪分页列表
     *
     * @return {@link IPage<UnitSpecialInstrumentsVO>} 机组特殊仪分页列表
     */
    IPage<UnitSpecialInstrumentsVO> getUnitSpecialInstrumentsPage(UnitSpecialInstrumentsQuery queryParams);

    /**
     * 获取机组特殊仪表单数据
     *
     * @param id 机组特殊仪ID
     * @return 机组特殊仪表单数据
     */
     UnitSpecialInstrumentsForm getUnitSpecialInstrumentsFormData(Long id);

    /**
     * 新增机组特殊仪
     *
     * @param formData 机组特殊仪表单对象
     * @return 是否新增成功
     */
    boolean saveUnitSpecialInstruments(UnitSpecialInstrumentsForm formData);

    /**
     * 修改机组特殊仪
     *
     * @param id   机组特殊仪ID
     * @param formData 机组特殊仪表单对象
     * @return 是否修改成功
     */
    boolean updateUnitSpecialInstruments(Long id, UnitSpecialInstrumentsForm formData);

    /**
     * 删除机组特殊仪
     *
     * @param ids 机组特殊仪ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteUnitSpecialInstrumentss(String ids);

    List<UnitSpecialInstrumentsExportDto> listExportUnitSpecialInstrument(UnitSpecialInstrumentsQueryExport queryParams);

}
