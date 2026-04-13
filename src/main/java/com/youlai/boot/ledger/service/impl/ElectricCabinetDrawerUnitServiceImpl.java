package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.ledger.model.dto.ElectricCabinetDocumentExportDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetDrawerUnitsExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ElectricCabinetDrawerUnitMapper;
import com.youlai.boot.ledger.service.ElectricCabinetDrawerUnitService;
import com.youlai.boot.ledger.model.entity.ElectricCabinetDrawerUnit;
import com.youlai.boot.ledger.model.form.ElectricCabinetDrawerUnitForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetDrawerUnitQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetDrawerUnitVO;
import com.youlai.boot.ledger.converter.ElectricCabinetDrawerUnitConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 抽屉柜抽屉单元明细服务实现类
 *
 * @author youlaitech
 * @since 2026-03-17 09:40
 */
@Service
@RequiredArgsConstructor
public class ElectricCabinetDrawerUnitServiceImpl extends ServiceImpl<ElectricCabinetDrawerUnitMapper, ElectricCabinetDrawerUnit> implements ElectricCabinetDrawerUnitService {

    private final ElectricCabinetDrawerUnitConverter electricCabinetDrawerUnitConverter;

    /**
    * 获取抽屉柜抽屉单元明细分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<ElectricCabinetDrawerUnitVO>} 抽屉柜抽屉单元明细分页列表
    */
    @Override
    public IPage<ElectricCabinetDrawerUnitVO> getElectricCabinetDrawerUnitPage(ElectricCabinetDrawerUnitQuery queryParams) {
        Page<ElectricCabinetDrawerUnitVO> pageVO = this.baseMapper.getElectricCabinetDrawerUnitPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取抽屉柜抽屉单元明细表单数据
     *
     * @param id 抽屉柜抽屉单元明细ID
     * @return 抽屉柜抽屉单元明细表单数据
     */
    @Override
    public ElectricCabinetDrawerUnitForm getElectricCabinetDrawerUnitFormData(Long id) {
        ElectricCabinetDrawerUnit entity = this.getById(id);
        return electricCabinetDrawerUnitConverter.toForm(entity);
    }
    
    /**
     * 新增抽屉柜抽屉单元明细
     *
     * @param formData 抽屉柜抽屉单元明细表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveElectricCabinetDrawerUnit(ElectricCabinetDrawerUnitForm formData) {
        ElectricCabinetDrawerUnit entity = electricCabinetDrawerUnitConverter.toEntity(formData);
        long genIdByJdk = IDUtil.genIdByJdk();
        //TODO 暂时使用美团jdk，后续换为美团leaf
        entity.setId(genIdByJdk);
        return this.save(entity);
    }
    
    /**
     * 更新抽屉柜抽屉单元明细
     *
     * @param id   抽屉柜抽屉单元明细ID
     * @param formData 抽屉柜抽屉单元明细表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateElectricCabinetDrawerUnit(Long id,ElectricCabinetDrawerUnitForm formData) {
        ElectricCabinetDrawerUnit entity = electricCabinetDrawerUnitConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除抽屉柜抽屉单元明细
     *
     * @param ids 抽屉柜抽屉单元明细ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteElectricCabinetDrawerUnits(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的抽屉柜抽屉单元明细数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<ElectricCabinetDocumentExportDto> exportElectricCabinetDrawerUnits(ElectricCabinetDrawerUnitsExportQuery queryParams) {
        return this.baseMapper.exportElectricCabinetDrawerUnits(queryParams);
    }

}
