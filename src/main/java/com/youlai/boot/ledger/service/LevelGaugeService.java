package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.LevelGaugeExportDto;
import com.youlai.boot.ledger.model.entity.LevelGauge;
import com.youlai.boot.ledger.model.form.LevelGaugeForm;
import com.youlai.boot.ledger.model.query.LevelGaugeExportQuery;
import com.youlai.boot.ledger.model.query.LevelGaugeQuery;
import com.youlai.boot.ledger.model.vo.LevelGaugeVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 液位计服务类
 *
 * @author dazao
 * @since 2026-01-20 15:40
 */
public interface LevelGaugeService extends IService<LevelGauge> {

    /**
     *液位计分页列表
     *
     * @return {@link IPage<LevelGaugeVO>} 液位计分页列表
     */
    IPage<LevelGaugeVO> getLevelGaugePage(LevelGaugeQuery queryParams);

    /**
     * 获取液位计表单数据
     *
     * @param id 液位计ID
     * @return 液位计表单数据
     */
     LevelGaugeForm getLevelGaugeFormData(Long id);

    /**
     * 新增液位计
     *
     * @param formData 液位计表单对象
     * @return 是否新增成功
     */
    boolean saveLevelGauge(LevelGaugeForm formData);

    /**
     * 修改液位计
     *
     * @param id   液位计ID
     * @param formData 液位计表单对象
     * @return 是否修改成功
     */
    boolean updateLevelGauge(Long id, LevelGaugeForm formData);

    /**
     * 删除液位计
     *
     * @param ids 液位计ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteLevelGauges(String ids);

    List<LevelGaugeExportDto> listExportLevelGauge(LevelGaugeExportQuery queryParams);
}
