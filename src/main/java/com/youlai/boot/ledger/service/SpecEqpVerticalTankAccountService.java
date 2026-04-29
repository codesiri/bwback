package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SpecEqpVerticalTankAccountExportDto;
import com.youlai.boot.ledger.model.entity.SpecEqpVerticalTankAccount;
import com.youlai.boot.ledger.model.form.SpecEqpVerticalTankAccountForm;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.model.query.SpecEqpVerticalTankAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpVerticalTankAccountVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 立罐服务类
 *
 * @author baiwei
 * @since 2026-03-06 10:04
 */
public interface SpecEqpVerticalTankAccountService extends IService<SpecEqpVerticalTankAccount> {

    /**
     *立罐分页列表
     *
     * @return {@link IPage<SpecEqpVerticalTankAccountVO>} 立罐分页列表
     */
    IPage<SpecEqpVerticalTankAccountVO> getSpecEqpVerticalTankAccountPage(SpecEqpVerticalTankAccountQuery queryParams);

    /**
     * 获取立罐表单数据
     *
     * @param id 立罐ID
     * @return 立罐表单数据
     */
     SpecEqpVerticalTankAccountForm getSpecEqpVerticalTankAccountFormData(Long id);

    /**
     * 新增立罐
     *
     * @param formData 立罐表单对象
     * @return 是否新增成功
     */
    boolean saveSpecEqpVerticalTankAccount(SpecEqpVerticalTankAccountForm formData);

    /**
     * 修改立罐
     *
     * @param id   立罐ID
     * @param formData 立罐表单对象
     * @return 是否修改成功
     */
    boolean updateSpecEqpVerticalTankAccount(Long id, SpecEqpVerticalTankAccountForm formData);

    /**
     * 删除立罐
     *
     * @param ids 立罐ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSpecEqpVerticalTankAccounts(String ids);


    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SpecEqpVerticalTankAccountExportDto >} 导出压力列表
     * */
    List<SpecEqpVerticalTankAccountExportDto>  listExportSpecEqpVerticalTankAccount(SpecEqpVerticalTankAccountQuery queryParams);

}
