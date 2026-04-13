package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.GroundSystemEquipmentExportDto;
import com.youlai.boot.ledger.model.entity.GroundSystemEquipment;
import com.youlai.boot.ledger.model.form.GroundSystemEquipmentForm;
import com.youlai.boot.ledger.model.query.GroundSystemEquipmentExportQuery;
import com.youlai.boot.ledger.model.query.GroundSystemEquipmentQuery;
import com.youlai.boot.ledger.model.vo.GroundSystemEquipmentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 电器接地系统服务类
 *
 * @author dazao
 * @since 2026-03-09 08:51
 */
public interface GroundSystemEquipmentService extends IService<GroundSystemEquipment> {

    /**
     *电器接地系统分页列表
     *
     * @return {@link IPage<GroundSystemEquipmentVO>} 电器接地系统分页列表
     */
    IPage<GroundSystemEquipmentVO> getGroundSystemEquipmentPage(GroundSystemEquipmentQuery queryParams);

    /**
     * 获取电器接地系统表单数据
     *
     * @param id 电器接地系统ID
     * @return 电器接地系统表单数据
     */
     GroundSystemEquipmentForm getGroundSystemEquipmentFormData(Long id);

    /**
     * 新增电器接地系统
     *
     * @param formData 电器接地系统表单对象
     * @return 是否新增成功
     */
    boolean saveGroundSystemEquipment(GroundSystemEquipmentForm formData);

    /**
     * 修改电器接地系统
     *
     * @param id   电器接地系统ID
     * @param formData 电器接地系统表单对象
     * @return 是否修改成功
     */
    boolean updateGroundSystemEquipment(Long id, GroundSystemEquipmentForm formData);

    /**
     * 删除电器接地系统
     *
     * @param ids 电器接地系统ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteGroundSystemEquipments(String ids);

    List<GroundSystemEquipmentExportDto> exportGroundSystemEquipments(GroundSystemEquipmentExportQuery queryParams);
}
