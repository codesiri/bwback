package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.AnalyInstrumentExportDto;
import com.youlai.boot.ledger.model.entity.AnalyInstrument;
import com.youlai.boot.ledger.model.form.AnalyInstrumentForm;
import com.youlai.boot.ledger.model.query.AnalyInstrumentExportQuery;
import com.youlai.boot.ledger.model.query.AnalyInstrumentQuery;
import com.youlai.boot.ledger.model.vo.AnalyInstrumentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 分析仪服务类
 *
 * @author dazao
 * @since 2026-01-23 14:48
 */
public interface AnalyInstrumentService extends IService<AnalyInstrument> {

    /**
     *分析仪分页列表
     *
     * @return {@link IPage<AnalyInstrumentVO>} 分析仪分页列表
     */
    IPage<AnalyInstrumentVO> getAnalyInstrumentPage(AnalyInstrumentQuery queryParams);

    /**
     * 获取分析仪表单数据
     *
     * @param id 分析仪ID
     * @return 分析仪表单数据
     */
     AnalyInstrumentForm getAnalyInstrumentFormData(Long id);

    /**
     * 新增分析仪
     *
     * @param formData 分析仪表单对象
     * @return 是否新增成功
     */
    boolean saveAnalyInstrument(AnalyInstrumentForm formData);

    /**
     * 修改分析仪
     *
     * @param id   分析仪ID
     * @param formData 分析仪表单对象
     * @return 是否修改成功
     */
    boolean updateAnalyInstrument(Long id, AnalyInstrumentForm formData);

    /**
     * 删除分析仪
     *
     * @param ids 分析仪ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteAnalyInstruments(String ids);

    List<AnalyInstrumentExportDto> listExportAnalyInstrument(AnalyInstrumentExportQuery queryParams);

}
