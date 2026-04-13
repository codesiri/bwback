package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.ElectricCabinetRecordExportDto;
import com.youlai.boot.ledger.model.dto.ElectricCabinetSparePartDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetRecordExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetSparePartExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ElectricCabinetSparePartMapper;
import com.youlai.boot.ledger.service.ElectricCabinetSparePartService;
import com.youlai.boot.ledger.model.entity.ElectricCabinetSparePart;
import com.youlai.boot.ledger.model.form.ElectricCabinetSparePartForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetSparePartQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetSparePartVO;
import com.youlai.boot.ledger.converter.ElectricCabinetSparePartConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 电器备品备件管理记录服务实现类
 *
 * @author youlaitech
 * @since 2026-03-04 08:46
 */
@Service
@RequiredArgsConstructor
public class ElectricCabinetSparePartServiceImpl extends ServiceImpl<ElectricCabinetSparePartMapper, ElectricCabinetSparePart> implements ElectricCabinetSparePartService {

    private final ElectricCabinetSparePartConverter electricCabinetSparePartConverter;

    /**
    * 获取电器备品备件管理记录分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<ElectricCabinetSparePartVO>} 电器备品备件管理记录分页列表
    */
    @Override
    public IPage<ElectricCabinetSparePartVO> getElectricCabinetSparePartPage(ElectricCabinetSparePartQuery queryParams) {
        Page<ElectricCabinetSparePartVO> pageVO = this.baseMapper.getElectricCabinetSparePartPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取电器备品备件管理记录表单数据
     *
     * @param id 电器备品备件管理记录ID
     * @return 电器备品备件管理记录表单数据
     */
    @Override
    public ElectricCabinetSparePartForm getElectricCabinetSparePartFormData(Long id) {
        ElectricCabinetSparePart entity = this.getById(id);
        return electricCabinetSparePartConverter.toForm(entity);
    }
    
    /**
     * 新增电器备品备件管理记录
     *
     * @param formData 电器备品备件管理记录表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveElectricCabinetSparePart(ElectricCabinetSparePartForm formData) {
        ElectricCabinetSparePart entity = electricCabinetSparePartConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新电器备品备件管理记录
     *
     * @param id   电器备品备件管理记录ID
     * @param formData 电器备品备件管理记录表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateElectricCabinetSparePart(Long id,ElectricCabinetSparePartForm formData) {
        ElectricCabinetSparePart entity = electricCabinetSparePartConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除电器备品备件管理记录
     *
     * @param ids 电器备品备件管理记录ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteElectricCabinetSpareParts(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的电器备品备件管理记录数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<ElectricCabinetSparePartDto> exportElectricCabinetSpareParts(ElectricCabinetSparePartExportQuery params) {
        return this.baseMapper.exportElectricCabinetSpareParts(params);
    }

}
