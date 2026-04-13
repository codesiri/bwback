package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.CableLineEquipmentExportDto;
import com.youlai.boot.ledger.model.entity.CableLineEquipment;
import com.youlai.boot.ledger.model.form.CableLineEquipmentForm;
import com.youlai.boot.ledger.model.query.CableLineEquipmentExportQuery;
import com.youlai.boot.ledger.model.query.CableLineEquipmentQuery;
import com.youlai.boot.ledger.model.vo.CableLineEquipmentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 电器电缆线路服务类
 *
 * @author dazao
 * @since 2026-03-05 08:45
 */
public interface CableLineEquipmentService extends IService<CableLineEquipment> {

    /**
     *电器电缆线路分页列表
     *
     * @return {@link IPage<CableLineEquipmentVO>} 电器电缆线路分页列表
     */
    IPage<CableLineEquipmentVO> getCableLineEquipmentPage(CableLineEquipmentQuery queryParams);

    /**
     * 获取电器电缆线路表单数据
     *
     * @param id 电器电缆线路ID
     * @return 电器电缆线路表单数据
     */
     CableLineEquipmentForm getCableLineEquipmentFormData(Long id);

    /**
     * 新增电器电缆线路
     *
     * @param formData 电器电缆线路表单对象
     * @return 是否新增成功
     */
    boolean saveCableLineEquipment(CableLineEquipmentForm formData);

    /**
     * 修改电器电缆线路
     *
     * @param id   电器电缆线路ID
     * @param formData 电器电缆线路表单对象
     * @return 是否修改成功
     */
    boolean updateCableLineEquipment(Long id, CableLineEquipmentForm formData);

    /**
     * 删除电器电缆线路
     *
     * @param ids 电器电缆线路ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteCableLineEquipments(String ids);

    List<CableLineEquipmentExportDto> exportCableLineEquipments(CableLineEquipmentExportQuery queryParams);
}
