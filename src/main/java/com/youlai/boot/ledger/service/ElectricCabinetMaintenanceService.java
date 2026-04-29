package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ElectricCabinetMaintenanceExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetMaintenance;
import com.youlai.boot.ledger.model.form.ElectricCabinetMaintenanceForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetMaintenanceQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetMaintenanceVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 抽屉柜维护保养记录服务类
 *
 * @author c
 * @since 2026-04-16 14:43
 */
public interface ElectricCabinetMaintenanceService extends IService<ElectricCabinetMaintenance> {

    /**
     *抽屉柜维护保养记录分页列表
     *
     * @return {@link IPage<ElectricCabinetMaintenanceVO>} 抽屉柜维护保养记录分页列表
     */
    IPage<ElectricCabinetMaintenanceVO> getElectricCabinetMaintenancePage(ElectricCabinetMaintenanceQuery queryParams);

    /**
     * 获取抽屉柜维护保养记录表单数据
     *
     * @param id 抽屉柜维护保养记录ID
     * @return 抽屉柜维护保养记录表单数据
     */
     ElectricCabinetMaintenanceForm getElectricCabinetMaintenanceFormData(Long id);

    /**
     * 新增抽屉柜维护保养记录
     *
     * @param formData 抽屉柜维护保养记录表单对象
     * @return 是否新增成功
     */
    boolean saveElectricCabinetMaintenance(ElectricCabinetMaintenanceForm formData);

    /**
     * 修改抽屉柜维护保养记录
     *
     * @param id   抽屉柜维护保养记录ID
     * @param formData 抽屉柜维护保养记录表单对象
     * @return 是否修改成功
     */
    boolean updateElectricCabinetMaintenance(Long id, ElectricCabinetMaintenanceForm formData);

    /**
     * 删除抽屉柜维护保养记录
     *
     * @param ids 抽屉柜维护保养记录ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteElectricCabinetMaintenances(String ids);

    /**
     * 获取导出抽屉柜维护保养记录列表
     *
     * @param queryParams 查询参数
     * @return {@link List<ElectricCabinetMaintenanceExportDto>} 导出列表
     */
    List<ElectricCabinetMaintenanceExportDto> listExportElectricCabinetMaintenances(ElectricCabinetMaintenanceQuery queryParams);

}
