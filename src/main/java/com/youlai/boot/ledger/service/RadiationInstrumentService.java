package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.RadiationInstrumentExportDTO;
import com.youlai.boot.ledger.model.entity.RadiationInstrument;
import com.youlai.boot.ledger.model.form.RadiationInstrumentForm;
import com.youlai.boot.ledger.model.query.RadiationInstrumentQuery;
import com.youlai.boot.ledger.model.vo.RadiationInstrumentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 放射仪服务类
 *
 * @author baiwei
 * @since 2026-01-28 09:50
 */
public interface RadiationInstrumentService extends IService<RadiationInstrument> {

    /**
     *放射仪分页列表
     *
     * @return {@link IPage<RadiationInstrumentVO>} 放射仪分页列表
     */
    IPage<RadiationInstrumentVO> getRadiationInstrumentPage(RadiationInstrumentQuery queryParams);

    /**
     * 获取放射仪表单数据
     *
     * @param id 放射仪ID
     * @return 放射仪表单数据
     */
    RadiationInstrumentForm getRadiationInstrumentFormData(Long id);

    /**
     * 新增放射仪
     *
     * @param formData 放射仪表单对象
     * @return 是否新增成功
     */
    boolean saveRadiationInstrument(RadiationInstrumentForm formData);

    /**
     * 修改放射仪
     *
     * @param id   放射仪ID
     * @param formData 放射仪表单对象
     * @return 是否修改成功
     */
    boolean updateRadiationInstrument(Long id, RadiationInstrumentForm formData);

    /**
     * 删除放射仪
     *
     * @param ids 放射仪ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteRadiationInstruments(String ids);

    /**
     * 获取导出压力列表
     *
     * @param queryParams 查询参数
     * @return {@link List < RadiationInstrumentDTO >} 导出压力列表
     */
    List<RadiationInstrumentExportDTO> listExportRadiationInstruments(RadiationInstrumentQuery queryParams);

}

