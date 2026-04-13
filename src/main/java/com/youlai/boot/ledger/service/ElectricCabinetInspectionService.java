package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ElectricCabinetInspectionExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetInspection;
import com.youlai.boot.ledger.model.form.ElectricCabinetInspectionForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetInspectionExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetInspectionQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetInspectionVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 抽屉柜检修试验记录服务类
 *
 * @author youlaitech
 * @since 2026-03-18 16:19
 */
public interface ElectricCabinetInspectionService extends IService<ElectricCabinetInspection> {

    /**
     *抽屉柜检修试验记录分页列表
     *
     * @return {@link IPage<ElectricCabinetInspectionVO>} 抽屉柜检修试验记录分页列表
     */
    IPage<ElectricCabinetInspectionVO> getElectricCabinetInspectionPage(ElectricCabinetInspectionQuery queryParams);

    /**
     * 获取抽屉柜检修试验记录表单数据
     *
     * @param id 抽屉柜检修试验记录ID
     * @return 抽屉柜检修试验记录表单数据
     */
     ElectricCabinetInspectionForm getElectricCabinetInspectionFormData(Long id);

    /**
     * 新增抽屉柜检修试验记录
     *
     * @param formData 抽屉柜检修试验记录表单对象
     * @return 是否新增成功
     */
    boolean saveElectricCabinetInspection(ElectricCabinetInspectionForm formData);

    /**
     * 修改抽屉柜检修试验记录
     *
     * @param id   抽屉柜检修试验记录ID
     * @param formData 抽屉柜检修试验记录表单对象
     * @return 是否修改成功
     */
    boolean updateElectricCabinetInspection(Long id, ElectricCabinetInspectionForm formData);

    /**
     * 删除抽屉柜检修试验记录
     *
     * @param ids 抽屉柜检修试验记录ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteElectricCabinetInspections(String ids);

    List<ElectricCabinetInspectionExportDto> exportElectricCabinetInspections(ElectricCabinetInspectionExportQuery queryParams);
}
