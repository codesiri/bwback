package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.RelayProtectionSettingDto;
import com.youlai.boot.ledger.model.dto.RelayProtectionSettingExportDto;
import com.youlai.boot.ledger.model.entity.RelayProtectionSetting;
import com.youlai.boot.ledger.model.form.RelayProtectionSettingForm;
import com.youlai.boot.ledger.model.query.ExplosionProofElectricEquipmentExportQuery;
import com.youlai.boot.ledger.model.query.RelayProtectionSettingExportQuery;
import com.youlai.boot.ledger.model.query.RelayProtectionSettingQuery;
import com.youlai.boot.ledger.model.vo.RelayProtectionSettingVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 继电保护定值台账服务类
 *
 * @author dazao
 * @since 2026-02-11 09:41
 */
public interface RelayProtectionSettingService extends IService<RelayProtectionSetting> {

    /**
     *继电保护定值台账分页列表
     *
     * @return {@link IPage<RelayProtectionSettingVO>} 继电保护定值台账分页列表
     */
    IPage<RelayProtectionSettingVO> getRelayProtectionSettingPage(RelayProtectionSettingQuery queryParams);

    /**
     * 获取继电保护定值台账表单数据
     *
     * @param id 继电保护定值台账ID
     * @return 继电保护定值台账表单数据
     */
     RelayProtectionSettingForm getRelayProtectionSettingFormData(Long id);

    /**
     * 新增继电保护定值台账
     *
     * @param formData 继电保护定值台账表单对象
     * @return 是否新增成功
     */
    boolean saveRelayProtectionSetting(RelayProtectionSettingForm formData);

    /**
     * 修改继电保护定值台账
     *
     * @param id   继电保护定值台账ID
     * @param formData 继电保护定值台账表单对象
     * @return 是否修改成功
     */
    boolean updateRelayProtectionSetting(Long id, RelayProtectionSettingForm formData);

    /**
     * 删除继电保护定值台账
     *
     * @param ids 继电保护定值台账ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteRelayProtectionSettings(String ids);

    List<RelayProtectionSettingExportDto> exportRelayProtectionSettings(RelayProtectionSettingExportQuery queryParams);

}
