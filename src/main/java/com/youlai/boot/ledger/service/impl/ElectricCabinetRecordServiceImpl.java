package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.ledger.model.dto.ElectricCabinetRecordExportDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetRecordExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ElectricCabinetRecordMapper;
import com.youlai.boot.ledger.service.ElectricCabinetRecordService;
import com.youlai.boot.ledger.model.entity.ElectricCabinetRecord;
import com.youlai.boot.ledger.model.form.ElectricCabinetRecordForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetRecordQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetRecordVO;
import com.youlai.boot.ledger.converter.ElectricCabinetRecordConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 电器日常巡检记录服务实现类
 *
 * @author cc
 * @since 2026-03-03 09:40
 */
@Service
@RequiredArgsConstructor
public class ElectricCabinetRecordServiceImpl extends ServiceImpl<ElectricCabinetRecordMapper, ElectricCabinetRecord> implements ElectricCabinetRecordService {

    private final ElectricCabinetRecordConverter electricCabinetRecordConverter;

    /**
    * 获取电器日常巡检记录分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<ElectricCabinetRecordVO>} 电器日常巡检记录分页列表
    */
    @Override
    public IPage<ElectricCabinetRecordVO> getElectricCabinetRecordPage(ElectricCabinetRecordQuery queryParams) {
        Page<ElectricCabinetRecordVO> pageVO = this.baseMapper.getElectricCabinetRecordPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取电器日常巡检记录表单数据
     *
     * @param id 电器日常巡检记录ID
     * @return 电器日常巡检记录表单数据
     */
    @Override
    public ElectricCabinetRecordForm getElectricCabinetRecordFormData(Long id) {
        ElectricCabinetRecord entity = this.getById(id);
        return electricCabinetRecordConverter.toForm(entity);
    }
    
    /**
     * 新增电器日常巡检记录
     *
     * @param formData 电器日常巡检记录表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveElectricCabinetRecord(ElectricCabinetRecordForm formData) {
        ElectricCabinetRecord entity = electricCabinetRecordConverter.toEntity(formData);
        long id = IDUtil.genIdByLeaf();
        entity.setId(id);
        return this.save(entity);
    }
    
    /**
     * 更新电器日常巡检记录
     *
     * @param id   电器日常巡检记录ID
     * @param formData 电器日常巡检记录表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateElectricCabinetRecord(Long id,ElectricCabinetRecordForm formData) {
        ElectricCabinetRecord entity = electricCabinetRecordConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除电器日常巡检记录
     *
     * @param ids 电器日常巡检记录ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteElectricCabinetRecords(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的电器日常巡检记录数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<ElectricCabinetRecordExportDto> exportElectricCabinetRecords(ElectricCabinetRecordExportQuery queryParams) {
        return this.baseMapper.exportElectricCabinetRecords(queryParams);
    }

}
