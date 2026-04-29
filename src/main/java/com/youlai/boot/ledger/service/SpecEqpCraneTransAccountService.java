package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SpecEqpCraneTransAccountsExportDto;
import com.youlai.boot.ledger.model.entity.SpecEqpCraneTransAccount;
import com.youlai.boot.ledger.model.form.SpecEqpCraneTransAccountForm;
import com.youlai.boot.ledger.model.query.SpecEqpCraneTransAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpCraneTransAccountVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 起重运输类服务类
 *
 * @author baiwei
 * @since 2026-02-03 09:22
 */
public interface SpecEqpCraneTransAccountService extends IService<SpecEqpCraneTransAccount> {

    /**
     *起重运输类分页列表
     *
     * @return {@link IPage<SpecEqpCraneTransAccountVO>} 起重运输类分页列表
     */
    IPage<SpecEqpCraneTransAccountVO> getSpecEqpCraneTransAccountPage(SpecEqpCraneTransAccountQuery queryParams);

    /**
     * 获取起重运输类表单数据
     *
     * @param id 起重运输类ID
     * @return 起重运输类表单数据
     */
     SpecEqpCraneTransAccountForm getSpecEqpCraneTransAccountFormData(Long id);

    /**
     * 新增起重运输类
     *
     * @param formData 起重运输类表单对象
     * @return 是否新增成功
     */
    boolean saveSpecEqpCraneTransAccount(SpecEqpCraneTransAccountForm formData);

    /**
     * 修改起重运输类
     *
     * @param id   起重运输类ID
     * @param formData 起重运输类表单对象
     * @return 是否修改成功
     */
    boolean updateSpecEqpCraneTransAccount(Long id, SpecEqpCraneTransAccountForm formData);

    /**
     * 删除起重运输类
     *
     * @param ids 起重运输类ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSpecEqpCraneTransAccounts(String ids);

    /**
     * 获取导出压力列表
     *
     * @param queryParams 查询参数
     * @return {@link List < SpecEqpCraneTransAccountsExportDto >} 导出压力列表
     */
    List<SpecEqpCraneTransAccountsExportDto> listExportSpecEqpCraneTransAccounts(SpecEqpCraneTransAccountQuery queryParams);

}
