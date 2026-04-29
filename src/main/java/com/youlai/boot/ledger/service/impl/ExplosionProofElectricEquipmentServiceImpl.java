package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.ExplosionProofElectricEquipmentExportDto;
import com.youlai.boot.ledger.model.query.ExplosionProofElectricEquipmentExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ExplosionProofElectricEquipmentMapper;
import com.youlai.boot.ledger.service.ExplosionProofElectricEquipmentService;
import com.youlai.boot.ledger.model.entity.ExplosionProofElectricEquipment;
import com.youlai.boot.ledger.model.form.ExplosionProofElectricEquipmentForm;
import com.youlai.boot.ledger.model.query.ExplosionProofElectricEquipmentQuery;
import com.youlai.boot.ledger.model.vo.ExplosionProofElectricEquipmentVO;
import com.youlai.boot.ledger.converter.ExplosionProofElectricEquipmentConverter;

import java.util.Arrays;
import java.util.List;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 防爆电气设备服务实现类
 *
 * @author dazao
 * @since 2026-02-06 15:59
 */
@Service
@RequiredArgsConstructor
public class ExplosionProofElectricEquipmentServiceImpl extends ServiceImpl<ExplosionProofElectricEquipmentMapper, ExplosionProofElectricEquipment> implements ExplosionProofElectricEquipmentService {

    private final ExplosionProofElectricEquipmentConverter explosionProofElectricEquipmentConverter;

    /**
     * 获取防爆电气设备分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<ExplosionProofElectricEquipmentVO>} 防爆电气设备分页列表
     */
    @Override
    public IPage<ExplosionProofElectricEquipmentVO> getExplosionProofElectricEquipmentPage(ExplosionProofElectricEquipmentQuery queryParams) {
        Page<ExplosionProofElectricEquipmentVO> pageVO = this.baseMapper.getExplosionProofElectricEquipmentPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }

    /**
     * 获取防爆电气设备表单数据
     *
     * @param id 防爆电气设备ID
     * @return 防爆电气设备表单数据
     */
    @Override
    public ExplosionProofElectricEquipmentForm getExplosionProofElectricEquipmentFormData(Long id) {
        ExplosionProofElectricEquipment entity = this.getById(id);
        return explosionProofElectricEquipmentConverter.toForm(entity);
    }

    /**
     * 新增防爆电气设备
     *
     * @param formData 防爆电气设备表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveExplosionProofElectricEquipment(ExplosionProofElectricEquipmentForm formData) {
        ExplosionProofElectricEquipment entity = explosionProofElectricEquipmentConverter.toEntity(formData);
        String equipmentCode = entity.getEquipmentCode();
        long count = this.count(new QueryWrapper<ExplosionProofElectricEquipment>()
                .eq("equipment_code", equipmentCode));
        Assert.isTrue(count == 0 ,"设备编号已经存在");
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }

    /**
     * 更新防爆电气设备
     *
     * @param id       防爆电气设备ID
     * @param formData 防爆电气设备表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateExplosionProofElectricEquipment(Long id, ExplosionProofElectricEquipmentForm formData) {
        ExplosionProofElectricEquipment entity = explosionProofElectricEquipmentConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除防爆电气设备
     *
     * @param ids 防爆电气设备ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteExplosionProofElectricEquipments(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的防爆电气设备数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<ExplosionProofElectricEquipmentExportDto> exportExplosionProofElectricEquipments(ExplosionProofElectricEquipmentExportQuery queryParams) {
        return this
                .baseMapper
                .exportExplosionProofElectricEquipments(queryParams);

    }

}
