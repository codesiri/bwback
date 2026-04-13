package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.ledger.model.dto.CableLineEquipmentExportDto;
import com.youlai.boot.ledger.model.query.CableLineEquipmentExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.CableLineEquipmentMapper;
import com.youlai.boot.ledger.service.CableLineEquipmentService;
import com.youlai.boot.ledger.model.entity.CableLineEquipment;
import com.youlai.boot.ledger.model.form.CableLineEquipmentForm;
import com.youlai.boot.ledger.model.query.CableLineEquipmentQuery;
import com.youlai.boot.ledger.model.vo.CableLineEquipmentVO;
import com.youlai.boot.ledger.converter.CableLineEquipmentConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 电器电缆线路服务实现类
 *
 * @author dazao
 * @since 2026-03-05 08:45
 */
@Service
@RequiredArgsConstructor
public class CableLineEquipmentServiceImpl extends ServiceImpl<CableLineEquipmentMapper, CableLineEquipment> implements CableLineEquipmentService {

    private final CableLineEquipmentConverter cableLineEquipmentConverter;

    /**
    * 获取电器电缆线路分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<CableLineEquipmentVO>} 电器电缆线路分页列表
    */
    @Override
    public IPage<CableLineEquipmentVO> getCableLineEquipmentPage(CableLineEquipmentQuery queryParams) {
        Page<CableLineEquipmentVO> pageVO = this.baseMapper.getCableLineEquipmentPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取电器电缆线路表单数据
     *
     * @param id 电器电缆线路ID
     * @return 电器电缆线路表单数据
     */
    @Override
    public CableLineEquipmentForm getCableLineEquipmentFormData(Long id) {
        CableLineEquipment entity = this.getById(id);
        return cableLineEquipmentConverter.toForm(entity);
    }
    
    /**
     * 新增电器电缆线路
     *
     * @param formData 电器电缆线路表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveCableLineEquipment(CableLineEquipmentForm formData) {
        CableLineEquipment entity = cableLineEquipmentConverter.toEntity(formData);
        String cleCableCode = formData.getCleCableCode();
        long count = this.count(new QueryWrapper<CableLineEquipment>().eq("cle_cable_code", cleCableCode));
        Assert.isTrue(count == 0 , "电器电缆线路编号已经存在");
        return this.save(entity);
    }
    
    /**
     * 更新电器电缆线路
     *
     * @param id   电器电缆线路ID
     * @param formData 电器电缆线路表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateCableLineEquipment(Long id,CableLineEquipmentForm formData) {
        CableLineEquipment entity = cableLineEquipmentConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除电器电缆线路
     *
     * @param ids 电器电缆线路ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteCableLineEquipments(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的电器电缆线路数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<CableLineEquipmentExportDto> exportCableLineEquipments(CableLineEquipmentExportQuery queryParams) {
        return this.baseMapper.exportCableLineEquipments(queryParams);
    }

}
