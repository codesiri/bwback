package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ElectricCabinetDocumentExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetDrawerUnit;
import com.youlai.boot.ledger.model.form.ElectricCabinetDrawerUnitForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetDrawerUnitQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetDrawerUnitsExportQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetDrawerUnitVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 抽屉柜抽屉单元明细服务类
 *
 * @author youlaitech
 * @since 2026-03-17 09:40
 */
public interface ElectricCabinetDrawerUnitService extends IService<ElectricCabinetDrawerUnit> {

    /**
     *抽屉柜抽屉单元明细分页列表
     *
     * @return {@link IPage<ElectricCabinetDrawerUnitVO>} 抽屉柜抽屉单元明细分页列表
     */
    IPage<ElectricCabinetDrawerUnitVO> getElectricCabinetDrawerUnitPage(ElectricCabinetDrawerUnitQuery queryParams);

    /**
     * 获取抽屉柜抽屉单元明细表单数据
     *
     * @param id 抽屉柜抽屉单元明细ID
     * @return 抽屉柜抽屉单元明细表单数据
     */
     ElectricCabinetDrawerUnitForm getElectricCabinetDrawerUnitFormData(Long id);

    /**
     * 新增抽屉柜抽屉单元明细
     *
     * @param formData 抽屉柜抽屉单元明细表单对象
     * @return 是否新增成功
     */
    boolean saveElectricCabinetDrawerUnit(ElectricCabinetDrawerUnitForm formData);

    /**
     * 修改抽屉柜抽屉单元明细
     *
     * @param id   抽屉柜抽屉单元明细ID
     * @param formData 抽屉柜抽屉单元明细表单对象
     * @return 是否修改成功
     */
    boolean updateElectricCabinetDrawerUnit(Long id, ElectricCabinetDrawerUnitForm formData);

    /**
     * 删除抽屉柜抽屉单元明细
     *
     * @param ids 抽屉柜抽屉单元明细ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteElectricCabinetDrawerUnits(String ids);

    List<ElectricCabinetDocumentExportDto> exportElectricCabinetDrawerUnits(ElectricCabinetDrawerUnitsExportQuery queryParams);
}
