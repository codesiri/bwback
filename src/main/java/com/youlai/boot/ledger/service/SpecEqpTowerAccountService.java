package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SpecEqpTowerAccountExportDto;
import com.youlai.boot.ledger.model.entity.SpecEqpTowerAccount;
import com.youlai.boot.ledger.model.form.SpecEqpTowerAccountForm;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.model.query.SpecEqpTowerAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpTowerAccountVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 塔类服务类
 *
 * @author baiwei
 * @since 2026-03-06 09:57
 */
public interface SpecEqpTowerAccountService extends IService<SpecEqpTowerAccount> {

    /**
     *塔类分页列表
     *
     * @return {@link IPage<SpecEqpTowerAccountVO>} 塔类分页列表
     */
    IPage<SpecEqpTowerAccountVO> getSpecEqpTowerAccountPage(SpecEqpTowerAccountQuery queryParams);

    /**
     * 获取塔类表单数据
     *
     * @param id 塔类ID
     * @return 塔类表单数据
     */
     SpecEqpTowerAccountForm getSpecEqpTowerAccountFormData(Long id);

    /**
     * 新增塔类
     *
     * @param formData 塔类表单对象
     * @return 是否新增成功
     */
    boolean saveSpecEqpTowerAccount(SpecEqpTowerAccountForm formData);

    /**
     * 修改塔类
     *
     * @param id   塔类ID
     * @param formData 塔类表单对象
     * @return 是否修改成功
     */
    boolean updateSpecEqpTowerAccount(Long id, SpecEqpTowerAccountForm formData);

    /**
     * 删除塔类
     *
     * @param ids 塔类ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSpecEqpTowerAccounts(String ids);
    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SpecEqpTowerAccountExportDto >} 导出压力列表
     * */
    List<SpecEqpTowerAccountExportDto>  listExportSpecEqpTowerAccount(SpecEqpTowerAccountQuery queryParams);

}
