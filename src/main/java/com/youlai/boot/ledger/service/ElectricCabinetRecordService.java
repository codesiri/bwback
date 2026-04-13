package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ElectricCabinetRecordExportDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetRecord;
import com.youlai.boot.ledger.model.form.ElectricCabinetRecordForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetRecordExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetRecordQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetRecordVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 电器日常巡检记录服务类
 *
 * @author cc
 * @since 2026-03-03 09:40
 */
public interface ElectricCabinetRecordService extends IService<ElectricCabinetRecord> {

    /**
     *电器日常巡检记录分页列表
     *
     * @return {@link IPage<ElectricCabinetRecordVO>} 电器日常巡检记录分页列表
     */
    IPage<ElectricCabinetRecordVO> getElectricCabinetRecordPage(ElectricCabinetRecordQuery queryParams);

    /**
     * 获取电器日常巡检记录表单数据
     *
     * @param id 电器日常巡检记录ID
     * @return 电器日常巡检记录表单数据
     */
     ElectricCabinetRecordForm getElectricCabinetRecordFormData(Long id);

    /**
     * 新增电器日常巡检记录
     *
     * @param formData 电器日常巡检记录表单对象
     * @return 是否新增成功
     */
    boolean saveElectricCabinetRecord(ElectricCabinetRecordForm formData);

    /**
     * 修改电器日常巡检记录
     *
     * @param id   电器日常巡检记录ID
     * @param formData 电器日常巡检记录表单对象
     * @return 是否修改成功
     */
    boolean updateElectricCabinetRecord(Long id, ElectricCabinetRecordForm formData);

    /**
     * 删除电器日常巡检记录
     *
     * @param ids 电器日常巡检记录ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteElectricCabinetRecords(String ids);

    List<ElectricCabinetRecordExportDto> exportElectricCabinetRecords(ElectricCabinetRecordExportQuery queryParams);
}
