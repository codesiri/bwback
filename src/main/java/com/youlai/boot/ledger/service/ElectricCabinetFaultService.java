package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ElectricCabinetFaultExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetFault;
import com.youlai.boot.ledger.model.form.ElectricCabinetFaultForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetFaultExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetFaultQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetFaultVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 抽屉柜故障维修记录服务类
 *
 * @author youlaitech
 * @since 2026-03-23 17:05
 */
public interface ElectricCabinetFaultService extends IService<ElectricCabinetFault> {

    /**
     *抽屉柜故障维修记录分页列表
     *
     * @return {@link IPage<ElectricCabinetFaultVO>} 抽屉柜故障维修记录分页列表
     */
    IPage<ElectricCabinetFaultVO> getElectricCabinetFaultPage(ElectricCabinetFaultQuery queryParams);

    /**
     * 获取抽屉柜故障维修记录表单数据
     *
     * @param id 抽屉柜故障维修记录ID
     * @return 抽屉柜故障维修记录表单数据
     */
     ElectricCabinetFaultForm getElectricCabinetFaultFormData(Long id);

    /**
     * 新增抽屉柜故障维修记录
     *
     * @param formData 抽屉柜故障维修记录表单对象
     * @return 是否新增成功
     */
    boolean saveElectricCabinetFault(ElectricCabinetFaultForm formData);

    /**
     * 修改抽屉柜故障维修记录
     *
     * @param id   抽屉柜故障维修记录ID
     * @param formData 抽屉柜故障维修记录表单对象
     * @return 是否修改成功
     */
    boolean updateElectricCabinetFault(Long id, ElectricCabinetFaultForm formData);

    /**
     * 删除抽屉柜故障维修记录
     *
     * @param ids 抽屉柜故障维修记录ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteElectricCabinetFaults(String ids);

    List<ElectricCabinetFaultExportDto> exportElectricCabinetFaults(ElectricCabinetFaultExportQuery queryParams);
}
