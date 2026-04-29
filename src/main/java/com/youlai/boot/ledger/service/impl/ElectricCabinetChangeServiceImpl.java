package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.ledger.model.dto.ElectricCabinetChangeExportDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetChangeExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ElectricCabinetChangeMapper;
import com.youlai.boot.ledger.service.ElectricCabinetChangeService;
import com.youlai.boot.ledger.model.entity.ElectricCabinetChange;
import com.youlai.boot.ledger.model.form.ElectricCabinetChangeForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetChangeQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetChangeVO;
import com.youlai.boot.ledger.converter.ElectricCabinetChangeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 抽屉柜变更记录服务实现类
 *
 * @author dazao
 * @since 2026-03-13 11:16
 */
@Service
@RequiredArgsConstructor
public class ElectricCabinetChangeServiceImpl extends ServiceImpl<ElectricCabinetChangeMapper, ElectricCabinetChange> implements ElectricCabinetChangeService {

    private final ElectricCabinetChangeConverter electricCabinetChangeConverter;

    /**
    * 获取抽屉柜变更记录分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<ElectricCabinetChangeVO>} 抽屉柜变更记录分页列表
    */
    @Override
    public IPage<ElectricCabinetChangeVO> getElectricCabinetChangePage(ElectricCabinetChangeQuery queryParams) {
        Page<ElectricCabinetChangeVO> pageVO = this.baseMapper.getElectricCabinetChangePage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取抽屉柜变更记录表单数据
     *
     * @param id 抽屉柜变更记录ID
     * @return 抽屉柜变更记录表单数据
     */
    @Override
    public ElectricCabinetChangeForm getElectricCabinetChangeFormData(Long id) {
        ElectricCabinetChange entity = this.getById(id);
        return electricCabinetChangeConverter.toForm(entity);
    }
    
    /**
     * 新增抽屉柜变更记录
     *
     * @param formData 抽屉柜变更记录表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveElectricCabinetChange(ElectricCabinetChangeForm formData) {
        ElectricCabinetChange entity = electricCabinetChangeConverter.toEntity(formData);
        long idByLeaf = IDUtil.genIdByLeaf();
        entity.setId(idByLeaf);
        return this.save(entity);
    }
    
    /**
     * 更新抽屉柜变更记录
     *
     * @param id   抽屉柜变更记录ID
     * @param formData 抽屉柜变更记录表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateElectricCabinetChange(Long id,ElectricCabinetChangeForm formData) {
        ElectricCabinetChange entity = electricCabinetChangeConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除抽屉柜变更记录
     *
     * @param ids 抽屉柜变更记录ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteElectricCabinetChanges(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的抽屉柜变更记录数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<ElectricCabinetChangeExportDto> exportElectricCabinetChanges(ElectricCabinetChangeExportQuery queryParams) {
        return this.baseMapper.exportElectricCabinetChanges(queryParams);
    }

}
