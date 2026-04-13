package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ExplosionProofElectricEquipmentExportDto;
import com.youlai.boot.ledger.model.entity.ExplosionProofElectricEquipment;
import com.youlai.boot.ledger.model.form.ExplosionProofElectricEquipmentForm;
import com.youlai.boot.ledger.model.query.ExplosionProofElectricEquipmentExportQuery;
import com.youlai.boot.ledger.model.query.ExplosionProofElectricEquipmentQuery;
import com.youlai.boot.ledger.model.vo.ExplosionProofElectricEquipmentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 防爆电气设备服务类
 *
 * @author dazao
 * @since 2026-02-06 15:59
 */
public interface ExplosionProofElectricEquipmentService extends IService<ExplosionProofElectricEquipment> {

    /**
     *防爆电气设备分页列表
     *
     * @return {@link IPage<ExplosionProofElectricEquipmentVO>} 防爆电气设备分页列表
     */
    IPage<ExplosionProofElectricEquipmentVO> getExplosionProofElectricEquipmentPage(ExplosionProofElectricEquipmentQuery queryParams);

    /**
     * 获取防爆电气设备表单数据
     *
     * @param id 防爆电气设备ID
     * @return 防爆电气设备表单数据
     */
     ExplosionProofElectricEquipmentForm getExplosionProofElectricEquipmentFormData(Long id);

    /**
     * 新增防爆电气设备
     *
     * @param formData 防爆电气设备表单对象
     * @return 是否新增成功
     */
    boolean saveExplosionProofElectricEquipment(ExplosionProofElectricEquipmentForm formData);

    /**
     * 修改防爆电气设备
     *
     * @param id   防爆电气设备ID
     * @param formData 防爆电气设备表单对象
     * @return 是否修改成功
     */
    boolean updateExplosionProofElectricEquipment(Long id, ExplosionProofElectricEquipmentForm formData);

    /**
     * 删除防爆电气设备
     *
     * @param ids 防爆电气设备ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteExplosionProofElectricEquipments(String ids);

    List<ExplosionProofElectricEquipmentExportDto> exportExplosionProofElectricEquipments(ExplosionProofElectricEquipmentExportQuery queryParams);

}
