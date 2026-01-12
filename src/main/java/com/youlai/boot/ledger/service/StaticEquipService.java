package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.entity.StaticEquip;
import com.youlai.boot.ledger.model.form.StaticEquipForm;
import com.youlai.boot.ledger.model.query.StaticEquipQuery;
import com.youlai.boot.ledger.model.vo.StaticEquipVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 静设备服务类
 *
 * @author dazao
 * @since 2026-01-08 08:37
 */
public interface StaticEquipService extends IService<StaticEquip> {

    /**
     *静设备分页列表
     *
     * @return {@link IPage<StaticEquipVO>} 静设备分页列表
     */
    IPage<StaticEquipVO> getStaticEquipPage(StaticEquipQuery queryParams);

    /**
     * 获取静设备表单数据
     *
     * @param id 静设备ID
     * @return 静设备表单数据
     */
     StaticEquipForm getStaticEquipFormData(Long id);

    /**
     * 新增静设备
     *
     * @param formData 静设备表单对象
     * @return 是否新增成功
     */
    boolean saveStaticEquip(StaticEquipForm formData);

    /**
     * 修改静设备
     *
     * @param id   静设备ID
     * @param formData 静设备表单对象
     * @return 是否修改成功
     */
    boolean updateStaticEquip(Long id, StaticEquipForm formData);

    /**
     * 删除静设备
     *
     * @param ids 静设备ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteStaticEquips(String ids);

}
