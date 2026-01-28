package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.TnkMeterExportDto;
import com.youlai.boot.ledger.model.entity.TnkMeter;
import com.youlai.boot.ledger.model.form.TnkMeterForm;
import com.youlai.boot.ledger.model.query.TnkMeterExportQuery;
import com.youlai.boot.ledger.model.query.TnkMeterQuery;
import com.youlai.boot.ledger.model.vo.TnkMeterVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 罐区仪服务类
 *
 * @author dazao
 * @since 2026-01-20 08:17
 */
public interface TnkMeterService extends IService<TnkMeter> {

    /**
     *罐区仪分页列表
     *
     * @return {@link IPage<TnkMeterVO>} 罐区仪分页列表
     */
    IPage<TnkMeterVO> getTnkMeterPage(TnkMeterQuery queryParams);

    /**
     * 获取罐区仪表单数据
     *
     * @param id 罐区仪ID
     * @return 罐区仪表单数据
     */
     TnkMeterForm getTnkMeterFormData(Long id);

    /**
     * 新增罐区仪
     *
     * @param formData 罐区仪表单对象
     * @return 是否新增成功
     */
    boolean saveTnkMeter(TnkMeterForm formData);

    /**
     * 修改罐区仪
     *
     * @param id   罐区仪ID
     * @param formData 罐区仪表单对象
     * @return 是否修改成功
     */
    boolean updateTnkMeter(Long id, TnkMeterForm formData);

    /**
     * 删除罐区仪
     *
     * @param ids 罐区仪ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteTnkMeters(String ids);

    List<TnkMeterExportDto> listExportTnkMeters(TnkMeterExportQuery queryParams);
}
