package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ElectricCabinetRecordExportDto;
import com.youlai.boot.ledger.model.dto.ElectricCabinetSparePartDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetSparePart;
import com.youlai.boot.ledger.model.form.ElectricCabinetSparePartForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetRecordExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetSparePartExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetSparePartQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetSparePartVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 电器备品备件管理记录服务类
 *
 * @author youlaitech
 * @since 2026-03-04 08:46
 */
public interface ElectricCabinetSparePartService extends IService<ElectricCabinetSparePart> {

    /**
     *电器备品备件管理记录分页列表
     *
     * @return {@link IPage<ElectricCabinetSparePartVO>} 电器备品备件管理记录分页列表
     */
    IPage<ElectricCabinetSparePartVO> getElectricCabinetSparePartPage(ElectricCabinetSparePartQuery queryParams);

    /**
     * 获取电器备品备件管理记录表单数据
     *
     * @param id 电器备品备件管理记录ID
     * @return 电器备品备件管理记录表单数据
     */
     ElectricCabinetSparePartForm getElectricCabinetSparePartFormData(Long id);

    /**
     * 新增电器备品备件管理记录
     *
     * @param formData 电器备品备件管理记录表单对象
     * @return 是否新增成功
     */
    boolean saveElectricCabinetSparePart(ElectricCabinetSparePartForm formData);

    /**
     * 修改电器备品备件管理记录
     *
     * @param id   电器备品备件管理记录ID
     * @param formData 电器备品备件管理记录表单对象
     * @return 是否修改成功
     */
    boolean updateElectricCabinetSparePart(Long id, ElectricCabinetSparePartForm formData);

    /**
     * 删除电器备品备件管理记录
     *
     * @param ids 电器备品备件管理记录ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteElectricCabinetSpareParts(String ids);

    List<ElectricCabinetSparePartDto> exportElectricCabinetSpareParts(ElectricCabinetSparePartExportQuery params);
}
