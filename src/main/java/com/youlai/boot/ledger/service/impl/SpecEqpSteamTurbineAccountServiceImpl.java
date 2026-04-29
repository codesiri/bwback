package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.SpecEqpSteamTurbineAccountExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SpecEqpSteamTurbineAccountMapper;
import com.youlai.boot.ledger.service.SpecEqpSteamTurbineAccountService;
import com.youlai.boot.ledger.model.entity.SpecEqpSteamTurbineAccount;
import com.youlai.boot.ledger.model.form.SpecEqpSteamTurbineAccountForm;
import com.youlai.boot.ledger.model.query.SpecEqpSteamTurbineAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpSteamTurbineAccountVO;
import com.youlai.boot.ledger.converter.SpecEqpSteamTurbineAccountConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 汽轮机服务实现类
 *
 * @author baiwei
 * @since 2026-02-03 09:38
 */
@Service
@RequiredArgsConstructor
public class SpecEqpSteamTurbineAccountServiceImpl extends ServiceImpl<SpecEqpSteamTurbineAccountMapper, SpecEqpSteamTurbineAccount> implements SpecEqpSteamTurbineAccountService {

    private final SpecEqpSteamTurbineAccountConverter specEqpSteamTurbineAccountConverter;

    /**
    * 获取汽轮机分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SpecEqpSteamTurbineAccountVO>} 汽轮机分页列表
    */
    @Override
    public IPage<SpecEqpSteamTurbineAccountVO> getSpecEqpSteamTurbineAccountPage(SpecEqpSteamTurbineAccountQuery queryParams) {
        Page<SpecEqpSteamTurbineAccountVO> pageVO = this.baseMapper.getSpecEqpSteamTurbineAccountPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取汽轮机表单数据
     *
     * @param id 汽轮机ID
     * @return 汽轮机表单数据
     */
    @Override
    public SpecEqpSteamTurbineAccountForm getSpecEqpSteamTurbineAccountFormData(Long id) {
        SpecEqpSteamTurbineAccount entity = this.getById(id);
        return specEqpSteamTurbineAccountConverter.toForm(entity);
    }
    
    /**
     * 新增汽轮机
     *
     * @param formData 汽轮机表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSpecEqpSteamTurbineAccount(SpecEqpSteamTurbineAccountForm formData) {
        SpecEqpSteamTurbineAccount entity = specEqpSteamTurbineAccountConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新汽轮机
     *
     * @param id   汽轮机ID
     * @param formData 汽轮机表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSpecEqpSteamTurbineAccount(Long id,SpecEqpSteamTurbineAccountForm formData) {
        SpecEqpSteamTurbineAccount entity = specEqpSteamTurbineAccountConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除汽轮机
     *
     * @param ids 汽轮机ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSpecEqpSteamTurbineAccounts(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的汽轮机数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }


    /**
     * 获取导出压力列表
     *
     * @param queryParams 查询参数
     * @return {@link List < SpecEqpCraneTransAccountsExportDto >} 导出压力列表
     */
    public List<SpecEqpSteamTurbineAccountExportDto> listExportSpecEqpSteamTurbineAccount(SpecEqpSteamTurbineAccountQuery queryParams){
        List<SpecEqpSteamTurbineAccountExportDto> exportSpecEqpSteamTurbineAccount = this.baseMapper.listExportSpecEqpCraneTransAccounts(queryParams);
        return exportSpecEqpSteamTurbineAccount;
    }

}
