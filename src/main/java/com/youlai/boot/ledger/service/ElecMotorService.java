package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ElecMotorsExportDto;
import com.youlai.boot.ledger.model.entity.ElecMotor;
import com.youlai.boot.ledger.model.form.ElecMotorForm;
import com.youlai.boot.ledger.model.query.ElecMotorExportQuery;
import com.youlai.boot.ledger.model.query.ElecMotorQuery;
import com.youlai.boot.ledger.model.vo.ElecMotorVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 电器电动机服务类
 *
 * @author dazao
 * @since 2026-01-13 10:10
 */
public interface ElecMotorService extends IService<ElecMotor> {

    /**
     *电器电动机分页列表
     *
     * @return {@link IPage<ElecMotorVO>} 电器电动机分页列表
     */
    IPage<ElecMotorVO> getElecMotorPage(ElecMotorQuery queryParams);

    /**
     * 获取电器电动机表单数据
     *
     * @param id 电器电动机ID
     * @return 电器电动机表单数据
     */
     ElecMotorForm getElecMotorFormData(Long id);

    /**
     * 新增电器电动机
     *
     * @param formData 电器电动机表单对象
     * @return 是否新增成功
     */
    boolean saveElecMotor(ElecMotorForm formData);

    /**
     * 修改电器电动机
     *
     * @param id   电器电动机ID
     * @param formData 电器电动机表单对象
     * @return 是否修改成功
     */
    boolean updateElecMotor(Long id, ElecMotorForm formData);

    /**
     * 删除电器电动机
     *
     * @param ids 电器电动机ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteElecMotors(String ids);

    List<ElecMotorsExportDto> listExportElecMotor(ElecMotorExportQuery query);
}
