package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SpecEqpSteamTurbineAccountExportDto;
import com.youlai.boot.ledger.model.entity.SpecEqpSteamTurbineAccount;
import com.youlai.boot.ledger.model.form.SpecEqpSteamTurbineAccountForm;
import com.youlai.boot.ledger.model.query.SpecEqpSteamTurbineAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpSteamTurbineAccountVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 汽轮机服务类
 *
 * @author baiwei
 * @since 2026-02-03 09:38
 */
public interface SpecEqpSteamTurbineAccountService extends IService<SpecEqpSteamTurbineAccount> {

    /**
     *汽轮机分页列表
     *
     * @return {@link IPage<SpecEqpSteamTurbineAccountVO>} 汽轮机分页列表
     */
    IPage<SpecEqpSteamTurbineAccountVO> getSpecEqpSteamTurbineAccountPage(SpecEqpSteamTurbineAccountQuery queryParams);

    /**
     * 获取汽轮机表单数据
     *
     * @param id 汽轮机ID
     * @return 汽轮机表单数据
     */
     SpecEqpSteamTurbineAccountForm getSpecEqpSteamTurbineAccountFormData(Long id);

    /**
     * 新增汽轮机
     *
     * @param formData 汽轮机表单对象
     * @return 是否新增成功
     */
    boolean saveSpecEqpSteamTurbineAccount(SpecEqpSteamTurbineAccountForm formData);

    /**
     * 修改汽轮机
     *
     * @param id   汽轮机ID
     * @param formData 汽轮机表单对象
     * @return 是否修改成功
     */
    boolean updateSpecEqpSteamTurbineAccount(Long id, SpecEqpSteamTurbineAccountForm formData);

    /**
     * 删除汽轮机
     *
     * @param ids 汽轮机ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSpecEqpSteamTurbineAccounts(String ids);


    /**
     * 获取导出列表
     *
     * @param queryParams 查询参数
     * @return {@link List < SpecEqpCraneTransAccountsExportDto >} 导出压力列表
     */
    List<SpecEqpSteamTurbineAccountExportDto> listExportSpecEqpSteamTurbineAccount(SpecEqpSteamTurbineAccountQuery queryParams);

}
