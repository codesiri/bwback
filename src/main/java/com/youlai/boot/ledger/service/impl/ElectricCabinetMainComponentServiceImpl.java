package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.ledger.model.dto.ElectricCabinetMainComponentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ElectricCabinetMainComponentMapper;
import com.youlai.boot.ledger.service.ElectricCabinetMainComponentService;
import com.youlai.boot.ledger.model.entity.ElectricCabinetMainComponent;
import com.youlai.boot.ledger.model.form.ElectricCabinetMainComponentForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetMainComponentQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetMainComponentVO;
import com.youlai.boot.ledger.converter.ElectricCabinetMainComponentConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 抽屉柜主要元器件信息服务实现类
 *
 * @author youlaitech
 * @since 2026-03-17 09:38
 */
@Service
@RequiredArgsConstructor
public class ElectricCabinetMainComponentServiceImpl extends ServiceImpl<ElectricCabinetMainComponentMapper, ElectricCabinetMainComponent> implements ElectricCabinetMainComponentService {

    private final ElectricCabinetMainComponentConverter electricCabinetMainComponentConverter;

    /**
    * 获取抽屉柜主要元器件信息分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<ElectricCabinetMainComponentVO>} 抽屉柜主要元器件信息分页列表
    */
    @Override
    public IPage<ElectricCabinetMainComponentVO> getElectricCabinetMainComponentPage(ElectricCabinetMainComponentQuery queryParams) {
        Page<ElectricCabinetMainComponentVO> pageVO = this.baseMapper.getElectricCabinetMainComponentPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取抽屉柜主要元器件信息表单数据
     *
     * @param id 抽屉柜主要元器件信息ID
     * @return 抽屉柜主要元器件信息表单数据
     */
    @Override
    public ElectricCabinetMainComponentForm getElectricCabinetMainComponentFormData(Long id) {
        ElectricCabinetMainComponent entity = this.getById(id);
        return electricCabinetMainComponentConverter.toForm(entity);
    }
    
    /**
     * 新增抽屉柜主要元器件信息
     *
     * @param formData 抽屉柜主要元器件信息表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveElectricCabinetMainComponent(ElectricCabinetMainComponentForm formData) {
        ElectricCabinetMainComponent entity = electricCabinetMainComponentConverter.toEntity(formData);
        //TODO 后续换位美团leaf
        var id = IDUtil.genIdByJdk();
        entity.setId(id);
        return this.save(entity);
    }
    
    /**
     * 更新抽屉柜主要元器件信息
     *
     * @param id   抽屉柜主要元器件信息ID
     * @param formData 抽屉柜主要元器件信息表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateElectricCabinetMainComponent(Long id,ElectricCabinetMainComponentForm formData) {
        ElectricCabinetMainComponent entity = electricCabinetMainComponentConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除抽屉柜主要元器件信息
     *
     * @param ids 抽屉柜主要元器件信息ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteElectricCabinetMainComponents(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的抽屉柜主要元器件信息数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<ElectricCabinetMainComponentDto> exportElectricCabinetMainComponents() {
        return List.of();
    }

}
