package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.SpecEqpCraneTransAccountsExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SpecEqpCraneTransAccountMapper;
import com.youlai.boot.ledger.service.SpecEqpCraneTransAccountService;
import com.youlai.boot.ledger.model.entity.SpecEqpCraneTransAccount;
import com.youlai.boot.ledger.model.form.SpecEqpCraneTransAccountForm;
import com.youlai.boot.ledger.model.query.SpecEqpCraneTransAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpCraneTransAccountVO;
import com.youlai.boot.ledger.converter.SpecEqpCraneTransAccountConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 起重运输类服务实现类
 *
 * @author baiwei
 * @since 2026-02-03 09:22
 */
@Service
@RequiredArgsConstructor
public class SpecEqpCraneTransAccountServiceImpl extends ServiceImpl<SpecEqpCraneTransAccountMapper, SpecEqpCraneTransAccount> implements SpecEqpCraneTransAccountService {

    private final SpecEqpCraneTransAccountConverter specEqpCraneTransAccountConverter;

    /**
    * 获取起重运输类分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SpecEqpCraneTransAccountVO>} 起重运输类分页列表
    */
    @Override
    public IPage<SpecEqpCraneTransAccountVO> getSpecEqpCraneTransAccountPage(SpecEqpCraneTransAccountQuery queryParams) {
        Page<SpecEqpCraneTransAccountVO> pageVO = this.baseMapper.getSpecEqpCraneTransAccountPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取起重运输类表单数据
     *
     * @param id 起重运输类ID
     * @return 起重运输类表单数据
     */
    @Override
    public SpecEqpCraneTransAccountForm getSpecEqpCraneTransAccountFormData(Long id) {
        SpecEqpCraneTransAccount entity = this.getById(id);
        return specEqpCraneTransAccountConverter.toForm(entity);
    }
    
    /**
     * 新增起重运输类
     *
     * @param formData 起重运输类表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSpecEqpCraneTransAccount(SpecEqpCraneTransAccountForm formData) {
        SpecEqpCraneTransAccount entity = specEqpCraneTransAccountConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新起重运输类
     *
     * @param id   起重运输类ID
     * @param formData 起重运输类表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSpecEqpCraneTransAccount(Long id,SpecEqpCraneTransAccountForm formData) {
        SpecEqpCraneTransAccount entity = specEqpCraneTransAccountConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除起重运输类
     *
     * @param ids 起重运输类ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSpecEqpCraneTransAccounts(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的起重运输类数据为空");
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
    public  List<SpecEqpCraneTransAccountsExportDto> listExportSpecEqpCraneTransAccounts(SpecEqpCraneTransAccountQuery queryParams){

        List<SpecEqpCraneTransAccountsExportDto> exportRadiationInstrument = this.baseMapper.listExportSpecEqpCraneTransAccounts(queryParams);
        return exportRadiationInstrument;
    }



}
