package com.youlai.boot.ledger.service.impl;

import cn.hutool.core.util.IdUtil;
import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.ledger.model.dto.ElectricCabinetInspectionExportDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetInspectionExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ElectricCabinetInspectionMapper;
import com.youlai.boot.ledger.service.ElectricCabinetInspectionService;
import com.youlai.boot.ledger.model.entity.ElectricCabinetInspection;
import com.youlai.boot.ledger.model.form.ElectricCabinetInspectionForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetInspectionQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetInspectionVO;
import com.youlai.boot.ledger.converter.ElectricCabinetInspectionConverter;

import java.util.Arrays;
import java.util.List;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 抽屉柜检修试验记录服务实现类
 *
 * @author youlaitech
 * @since 2026-03-18 16:19
 */
@Service
@RequiredArgsConstructor
public class ElectricCabinetInspectionServiceImpl extends ServiceImpl<ElectricCabinetInspectionMapper, ElectricCabinetInspection> implements ElectricCabinetInspectionService {

    private final ElectricCabinetInspectionConverter electricCabinetInspectionConverter;

    /**
    * 获取抽屉柜检修试验记录分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<ElectricCabinetInspectionVO>} 抽屉柜检修试验记录分页列表
    */
    @Override
    public IPage<ElectricCabinetInspectionVO> getElectricCabinetInspectionPage(ElectricCabinetInspectionQuery queryParams) {
        Page<ElectricCabinetInspectionVO> pageVO = this.baseMapper.getElectricCabinetInspectionPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取抽屉柜检修试验记录表单数据
     *
     * @param id 抽屉柜检修试验记录ID
     * @return 抽屉柜检修试验记录表单数据
     */
    @Override
    public ElectricCabinetInspectionForm getElectricCabinetInspectionFormData(Long id) {
        ElectricCabinetInspection entity = this.getById(id);
        return electricCabinetInspectionConverter.toForm(entity);
    }
    
    /**
     * 新增抽屉柜检修试验记录
     *
     * @param formData 抽屉柜检修试验记录表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveElectricCabinetInspection(ElectricCabinetInspectionForm formData) {
        ElectricCabinetInspection entity = electricCabinetInspectionConverter.toEntity(formData);
        long genIdByJdk = IDUtil.genIdByLeaf();
        entity.setId(genIdByJdk);
        return this.save(entity);
    }
    
    /**
     * 更新抽屉柜检修试验记录
     *
     * @param id   抽屉柜检修试验记录ID
     * @param formData 抽屉柜检修试验记录表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateElectricCabinetInspection(Long id,ElectricCabinetInspectionForm formData) {
        ElectricCabinetInspection entity = electricCabinetInspectionConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除抽屉柜检修试验记录
     *
     * @param ids 抽屉柜检修试验记录ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteElectricCabinetInspections(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的抽屉柜检修试验记录数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<ElectricCabinetInspectionExportDto> exportElectricCabinetInspections(ElectricCabinetInspectionExportQuery queryParams) {
        return this.baseMapper.exportElectricCabinetInspections(queryParams);
    }

}
