
package com.youlai.boot.ledger.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.boot.ledger.model.entity.PressureInstrument;
import com.youlai.boot.ledger.model.form.PressureInstrumentForm;
import com.youlai.boot.ledger.model.query.PressureInstrumentQueryPlus;
import com.youlai.boot.ledger.model.vo.PressureInstrumentVO;
import com.youlai.boot.ledger.model.dto.PressureInstrumentExportDTO;
import java.util.List;
/**
 * 温度服务类
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
public interface PressureInstrumentService extends IService<PressureInstrument> {
    /**
     *压力分页列表
     *
     * @return {@link IPage<PressureInstrumentVO>} 压力分页列表
     */
    IPage<PressureInstrumentVO> getPressureInstrumentPage(PressureInstrumentQueryPlus queryParams);
    /**
     * 获取压力表单数据
     *
     * @param id 压力ID
     * @return 压力表单数据
     */
    PressureInstrumentForm getPressureInstrumentFormData(Long id);
    /**
     * 新增压力
     *
     * @param formData 压力表单对象
     * @return 是否新增成功
     */
    boolean savePressureInstrument(PressureInstrumentForm formData);
    /**
     * 修改压力
     *
     * @param id   压力ID
     * @param formData 压力表单对象
     * @return 是否修改成功
     */
    boolean updatePressureInstrument(Long id, PressureInstrumentForm formData);
    /**
     * 删除压力
     *
     * @param ids 压力ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deletePressureInstrument(String ids);
    /**
     * 获取导出压力列表
     *
     * @param queryParams 查询参数
     * @return {@link List < PressureInstrumentExportDTO >} 导出压力列表
     */
    List<PressureInstrumentExportDTO> listExportPressureInstrument(PressureInstrumentQueryPlus queryParams);
}