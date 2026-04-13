package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.ElectricLightEquipmentDto;
import com.youlai.boot.ledger.model.query.ElectricLightEquipmentExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ElectricLightEquipmentMapper;
import com.youlai.boot.ledger.service.ElectricLightEquipmentService;
import com.youlai.boot.ledger.model.entity.ElectricLightEquipment;
import com.youlai.boot.ledger.model.form.ElectricLightEquipmentForm;
import com.youlai.boot.ledger.model.query.ElectricLightEquipmentQuery;
import com.youlai.boot.ledger.model.vo.ElectricLightEquipmentVO;
import com.youlai.boot.ledger.converter.ElectricLightEquipmentConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 电气照明设备服务实现类
 *
 * @author dazao
 * @since 2026-02-04 09:24
 */
@Service
@RequiredArgsConstructor
public class ElectricLightEquipmentServiceImpl extends ServiceImpl<ElectricLightEquipmentMapper, ElectricLightEquipment> implements ElectricLightEquipmentService {

    private final ElectricLightEquipmentConverter electricLightEquipmentConverter;

    /**
    * 获取电气照明设备分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<ElectricLightEquipmentVO>} 电气照明设备分页列表
    */
    @Override
    public IPage<ElectricLightEquipmentVO> getElectricLightEquipmentPage(ElectricLightEquipmentQuery queryParams) {
        Page<ElectricLightEquipmentVO> pageVO = this.baseMapper.getElectricLightEquipmentPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取电气照明设备表单数据
     *
     * @param id 电气照明设备ID
     * @return 电气照明设备表单数据
     */
    @Override
    public ElectricLightEquipmentForm getElectricLightEquipmentFormData(Long id) {
        ElectricLightEquipment entity = this.getById(id);
        return electricLightEquipmentConverter.toForm(entity);
    }
    
    /**
     * 新增电气照明设备
     *
     * @param formData 电气照明设备表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveElectricLightEquipment(ElectricLightEquipmentForm formData) {
        ElectricLightEquipment entity = electricLightEquipmentConverter.toEntity(formData);
        long count = this.count(new QueryWrapper<ElectricLightEquipment>().eq("ele_light_code", entity.getEleLightCode()));
        Assert.isTrue(count == 0 ,"设备编号已经存在");
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }
    
    /**
     * 更新电气照明设备
     *
     * @param id   电气照明设备ID
     * @param formData 电气照明设备表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateElectricLightEquipment(Long id,ElectricLightEquipmentForm formData) {
        ElectricLightEquipment entity = electricLightEquipmentConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除电气照明设备
     *
     * @param ids 电气照明设备ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteElectricLightEquipments(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的电气照明设备数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<ElectricLightEquipmentDto> exportElectricLightEquipment(ElectricLightEquipmentExportQuery queryParams) {
        List<ElectricLightEquipmentDto> electricLightEquipmentDtoList=this.baseMapper.exportElectricLightEquipment(queryParams);
        return electricLightEquipmentDtoList;
    }

}
