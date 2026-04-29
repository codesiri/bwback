package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SpecEqpVerticalTankAccountExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SpecEqpVerticalTankAccountMapper;
import com.youlai.boot.ledger.service.SpecEqpVerticalTankAccountService;
import com.youlai.boot.ledger.model.entity.SpecEqpVerticalTankAccount;
import com.youlai.boot.ledger.model.form.SpecEqpVerticalTankAccountForm;
import com.youlai.boot.ledger.model.query.SpecEqpVerticalTankAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpVerticalTankAccountVO;
import com.youlai.boot.ledger.converter.SpecEqpVerticalTankAccountConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 立罐服务实现类
 *
 * @author baiwei
 * @since 2026-03-06 10:04
 */
@Service
@RequiredArgsConstructor
public class SpecEqpVerticalTankAccountServiceImpl extends ServiceImpl<SpecEqpVerticalTankAccountMapper, SpecEqpVerticalTankAccount> implements SpecEqpVerticalTankAccountService {

    private final SpecEqpVerticalTankAccountConverter specEqpVerticalTankAccountConverter;

    /**
    * 获取立罐分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SpecEqpVerticalTankAccountVO>} 立罐分页列表
    */
    @Override
    public IPage<SpecEqpVerticalTankAccountVO> getSpecEqpVerticalTankAccountPage(SpecEqpVerticalTankAccountQuery queryParams) {
        Page<SpecEqpVerticalTankAccountVO> pageVO = this.baseMapper.getSpecEqpVerticalTankAccountPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取立罐表单数据
     *
     * @param id 立罐ID
     * @return 立罐表单数据
     */
    @Override
    public SpecEqpVerticalTankAccountForm getSpecEqpVerticalTankAccountFormData(Long id) {
        SpecEqpVerticalTankAccount entity = this.getById(id);
        return specEqpVerticalTankAccountConverter.toForm(entity);
    }
    
    /**
     * 新增立罐
     *
     * @param formData 立罐表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSpecEqpVerticalTankAccount(SpecEqpVerticalTankAccountForm formData) {
        SpecEqpVerticalTankAccount entity = specEqpVerticalTankAccountConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新立罐
     *
     * @param id   立罐ID
     * @param formData 立罐表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSpecEqpVerticalTankAccount(Long id,SpecEqpVerticalTankAccountForm formData) {
        SpecEqpVerticalTankAccount entity = specEqpVerticalTankAccountConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除立罐
     *
     * @param ids 立罐ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSpecEqpVerticalTankAccounts(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的立罐数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }


    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SpecEqpVerticalTankAccountExportDto >} 导出压力列表
     * */
    public List<SpecEqpVerticalTankAccountExportDto>  listExportSpecEqpVerticalTankAccount(SpecEqpVerticalTankAccountQuery queryParams){
        List<SpecEqpVerticalTankAccountExportDto> exportSpecEqpVerticalTankAccount = this.baseMapper.listExportSpecEqpVerticalTankAccount(queryParams);
        return exportSpecEqpVerticalTankAccount;
    }

}
