package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.ledger.model.dto.GroundSystemEquipmentExportDto;
import com.youlai.boot.ledger.model.query.GroundSystemEquipmentExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.GroundSystemEquipmentMapper;
import com.youlai.boot.ledger.service.GroundSystemEquipmentService;
import com.youlai.boot.ledger.model.entity.GroundSystemEquipment;
import com.youlai.boot.ledger.model.form.GroundSystemEquipmentForm;
import com.youlai.boot.ledger.model.query.GroundSystemEquipmentQuery;
import com.youlai.boot.ledger.model.vo.GroundSystemEquipmentVO;
import com.youlai.boot.ledger.converter.GroundSystemEquipmentConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 电器接地系统服务实现类
 *
 * @author dazao
 * @since 2026-03-09 08:51
 */
@Service
@RequiredArgsConstructor
public class GroundSystemEquipmentServiceImpl extends ServiceImpl<GroundSystemEquipmentMapper, GroundSystemEquipment> implements GroundSystemEquipmentService {

    private final GroundSystemEquipmentConverter groundSystemEquipmentConverter;

    /**
    * 获取电器接地系统分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<GroundSystemEquipmentVO>} 电器接地系统分页列表
    */
    @Override
    public IPage<GroundSystemEquipmentVO> getGroundSystemEquipmentPage(GroundSystemEquipmentQuery queryParams) {
        Page<GroundSystemEquipmentVO> pageVO = this.baseMapper.getGroundSystemEquipmentPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取电器接地系统表单数据
     *
     * @param id 电器接地系统ID
     * @return 电器接地系统表单数据
     */
    @Override
    public GroundSystemEquipmentForm getGroundSystemEquipmentFormData(Long id) {
        GroundSystemEquipment entity = this.getById(id);
        return groundSystemEquipmentConverter.toForm(entity);
    }
    
    /**
     * 新增电器接地系统
     *
     * @param formData 电器接地系统表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveGroundSystemEquipment(GroundSystemEquipmentForm formData) {
        GroundSystemEquipment entity = groundSystemEquipmentConverter.toEntity(formData);
        long idByLeaf = IDUtil.genIdByLeaf();
        entity.setId(idByLeaf);
        return this.save(entity);
    }
    
    /**
     * 更新电器接地系统
     *
     * @param id   电器接地系统ID
     * @param formData 电器接地系统表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateGroundSystemEquipment(Long id,GroundSystemEquipmentForm formData) {
        GroundSystemEquipment entity = groundSystemEquipmentConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除电器接地系统
     *
     * @param ids 电器接地系统ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteGroundSystemEquipments(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的电器接地系统数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<GroundSystemEquipmentExportDto> exportGroundSystemEquipments(GroundSystemEquipmentExportQuery queryParams) {
        return this.baseMapper.exportGroundSystemEquipments(queryParams);
    }

}
