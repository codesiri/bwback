package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ElectricLightEquipmentDto;
import com.youlai.boot.ledger.model.entity.ElectricLightEquipment;
import com.youlai.boot.ledger.model.form.ElectricLightEquipmentForm;
import com.youlai.boot.ledger.model.query.ElectricLightEquipmentExportQuery;
import com.youlai.boot.ledger.model.query.ElectricLightEquipmentQuery;
import com.youlai.boot.ledger.model.vo.ElectricLightEquipmentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 电气照明设备服务类
 *
 * @author dazao
 * @since 2026-02-04 09:24
 */
public interface ElectricLightEquipmentService extends IService<ElectricLightEquipment> {

    /**
     *电气照明设备分页列表
     *
     * @return {@link IPage<ElectricLightEquipmentVO>} 电气照明设备分页列表
     */
    IPage<ElectricLightEquipmentVO> getElectricLightEquipmentPage(ElectricLightEquipmentQuery queryParams);

    /**
     * 获取电气照明设备表单数据
     *
     * @param id 电气照明设备ID
     * @return 电气照明设备表单数据
     */
     ElectricLightEquipmentForm getElectricLightEquipmentFormData(Long id);

    /**
     * 新增电气照明设备
     *
     * @param formData 电气照明设备表单对象
     * @return 是否新增成功
     */
    boolean saveElectricLightEquipment(ElectricLightEquipmentForm formData);

    /**
     * 修改电气照明设备
     *
     * @param id   电气照明设备ID
     * @param formData 电气照明设备表单对象
     * @return 是否修改成功
     */
    boolean updateElectricLightEquipment(Long id, ElectricLightEquipmentForm formData);

    /**
     * 删除电气照明设备
     *
     * @param ids 电气照明设备ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteElectricLightEquipments(String ids);

    List<ElectricLightEquipmentDto> exportElectricLightEquipment(ElectricLightEquipmentExportQuery queryParams);
}
