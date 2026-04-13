package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ElectricCabinetChangeExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetChange;
import com.youlai.boot.ledger.model.form.ElectricCabinetChangeForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetChangeExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetChangeQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetChangeVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 抽屉柜变更记录服务类
 *
 * @author dazao
 * @since 2026-03-13 11:16
 */
public interface ElectricCabinetChangeService extends IService<ElectricCabinetChange> {

    /**
     *抽屉柜变更记录分页列表
     *
     * @return {@link IPage<ElectricCabinetChangeVO>} 抽屉柜变更记录分页列表
     */
    IPage<ElectricCabinetChangeVO> getElectricCabinetChangePage(ElectricCabinetChangeQuery queryParams);

    /**
     * 获取抽屉柜变更记录表单数据
     *
     * @param id 抽屉柜变更记录ID
     * @return 抽屉柜变更记录表单数据
     */
     ElectricCabinetChangeForm getElectricCabinetChangeFormData(Long id);

    /**
     * 新增抽屉柜变更记录
     *
     * @param formData 抽屉柜变更记录表单对象
     * @return 是否新增成功
     */
    boolean saveElectricCabinetChange(ElectricCabinetChangeForm formData);

    /**
     * 修改抽屉柜变更记录
     *
     * @param id   抽屉柜变更记录ID
     * @param formData 抽屉柜变更记录表单对象
     * @return 是否修改成功
     */
    boolean updateElectricCabinetChange(Long id, ElectricCabinetChangeForm formData);

    /**
     * 删除抽屉柜变更记录
     *
     * @param ids 抽屉柜变更记录ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteElectricCabinetChanges(String ids);

    List<ElectricCabinetChangeExportDto> exportElectricCabinetChanges(ElectricCabinetChangeExportQuery queryParams);

}
