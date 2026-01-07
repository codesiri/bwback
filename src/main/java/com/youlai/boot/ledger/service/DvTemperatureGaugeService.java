package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.entity.DvTemperatureGauge;
import com.youlai.boot.ledger.model.form.DvTemperatureGaugeForm;
import com.youlai.boot.ledger.model.query.DvTemperatureGaugeQuery;
import com.youlai.boot.ledger.model.query.DvTemperatureGaugeQueryPlus;
import com.youlai.boot.ledger.model.vo.DvTemperatureGaugeVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 温度服务类
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
public interface DvTemperatureGaugeService extends IService<DvTemperatureGauge> {

    /**
     *温度分页列表
     *
     * @return {@link IPage<DvTemperatureGaugeVO>} 温度分页列表
     */
    IPage<DvTemperatureGaugeVO> getDvTemperatureGaugePage(DvTemperatureGaugeQueryPlus queryParams,String tagNumber,String status);

    /**
     * 获取温度表单数据
     *
     * @param id 温度ID
     * @return 温度表单数据
     */
     DvTemperatureGaugeForm getDvTemperatureGaugeFormData(Long id);

    /**
     * 新增温度
     *
     * @param formData 温度表单对象
     * @return 是否新增成功
     */
    boolean saveDvTemperatureGauge(DvTemperatureGaugeForm formData);

    /**
     * 修改温度
     *
     * @param id   温度ID
     * @param formData 温度表单对象
     * @return 是否修改成功
     */
    boolean updateDvTemperatureGauge(Long id, DvTemperatureGaugeForm formData);

    /**
     * 删除温度
     *
     * @param ids 温度ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteDvTemperatureGauges(String ids);

}
