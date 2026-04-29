package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SpecEqpTowerAccountExportDto;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SpecEqpTowerAccountMapper;
import com.youlai.boot.ledger.service.SpecEqpTowerAccountService;
import com.youlai.boot.ledger.model.entity.SpecEqpTowerAccount;
import com.youlai.boot.ledger.model.form.SpecEqpTowerAccountForm;
import com.youlai.boot.ledger.model.query.SpecEqpTowerAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpTowerAccountVO;
import com.youlai.boot.ledger.converter.SpecEqpTowerAccountConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 塔类服务实现类
 *
 * @author baiwei
 * @since 2026-03-06 09:57
 */
@Service
@RequiredArgsConstructor
public class SpecEqpTowerAccountServiceImpl extends ServiceImpl<SpecEqpTowerAccountMapper, SpecEqpTowerAccount> implements SpecEqpTowerAccountService {

    private final SpecEqpTowerAccountConverter specEqpTowerAccountConverter;

    /**
    * 获取塔类分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SpecEqpTowerAccountVO>} 塔类分页列表
    */
    @Override
    public IPage<SpecEqpTowerAccountVO> getSpecEqpTowerAccountPage(SpecEqpTowerAccountQuery queryParams) {
        Page<SpecEqpTowerAccountVO> pageVO = this.baseMapper.getSpecEqpTowerAccountPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取塔类表单数据
     *
     * @param id 塔类ID
     * @return 塔类表单数据
     */
    @Override
    public SpecEqpTowerAccountForm getSpecEqpTowerAccountFormData(Long id) {
        SpecEqpTowerAccount entity = this.getById(id);
        return specEqpTowerAccountConverter.toForm(entity);
    }
    
    /**
     * 新增塔类
     *
     * @param formData 塔类表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSpecEqpTowerAccount(SpecEqpTowerAccountForm formData) {
        SpecEqpTowerAccount entity = specEqpTowerAccountConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新塔类
     *
     * @param id   塔类ID
     * @param formData 塔类表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSpecEqpTowerAccount(Long id,SpecEqpTowerAccountForm formData) {
        SpecEqpTowerAccount entity = specEqpTowerAccountConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除塔类
     *
     * @param ids 塔类ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSpecEqpTowerAccounts(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的塔类数据为空");
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
     * @return {@link List < SeHeaterExportDto >} 导出压力列表
     * */
    public List<SpecEqpTowerAccountExportDto>  listExportSpecEqpTowerAccount(SpecEqpTowerAccountQuery queryParams){
        List<SpecEqpTowerAccountExportDto> exportSeHeater = this.baseMapper.listExportSpecEqpTowerAccount(queryParams);
        return exportSeHeater;
    }

}
