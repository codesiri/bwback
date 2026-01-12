package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.entity.DpFlowMeter;
import com.youlai.boot.ledger.model.form.DpFlowMeterForm;
import com.youlai.boot.ledger.model.query.DpFlowMeterQuery;
import com.youlai.boot.ledger.model.vo.DpFlowMeterVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 差压流量计服务类
 *
 * @author dazao
 * @since 2026-01-08 16:41
 */
public interface DpFlowMeterService extends IService<DpFlowMeter> {

    /**
     *差压流量计分页列表
     *
     * @return {@link IPage<DpFlowMeterVO>} 差压流量计分页列表
     */
    IPage<DpFlowMeterVO> getDpFlowMeterPage(DpFlowMeterQuery queryParams);

    /**
     * 获取差压流量计表单数据
     *
     * @param id 差压流量计ID
     * @return 差压流量计表单数据
     */
     DpFlowMeterForm getDpFlowMeterFormData(Long id);

    /**
     * 新增差压流量计
     *
     * @param formData 差压流量计表单对象
     * @return 是否新增成功
     */
    boolean saveDpFlowMeter(DpFlowMeterForm formData);

    /**
     * 修改差压流量计
     *
     * @param id   差压流量计ID
     * @param formData 差压流量计表单对象
     * @return 是否修改成功
     */
    boolean updateDpFlowMeter(Long id, DpFlowMeterForm formData);

    /**
     * 删除差压流量计
     *
     * @param ids 差压流量计ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteDpFlowMeters(String ids);

}
