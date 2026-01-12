package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.StaticEquipMapper;
import com.youlai.boot.ledger.service.StaticEquipService;
import com.youlai.boot.ledger.model.entity.StaticEquip;
import com.youlai.boot.ledger.model.form.StaticEquipForm;
import com.youlai.boot.ledger.model.query.StaticEquipQuery;
import com.youlai.boot.ledger.model.vo.StaticEquipVO;
import com.youlai.boot.ledger.converter.StaticEquipConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 静设备服务实现类
 *
 * @author dazao
 * @since 2026-01-08 08:37
 */
@Service
@RequiredArgsConstructor
public class StaticEquipServiceImpl extends ServiceImpl<StaticEquipMapper, StaticEquip> implements StaticEquipService {

    private final StaticEquipConverter staticEquipConverter;

    /**
     * 获取静设备分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<StaticEquipVO>} 静设备分页列表
     */
    @Override
    public IPage<StaticEquipVO> getStaticEquipPage(StaticEquipQuery queryParams) {
        Page<StaticEquipVO> pageVO = this.baseMapper.getStaticEquipPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }

    /**
     * 获取静设备表单数据
     *
     * @param id 静设备ID
     * @return 静设备表单数据
     */
    @Override
    public StaticEquipForm getStaticEquipFormData(Long id) {
        StaticEquip entity = this.getById(id);
        return staticEquipConverter.toForm(entity);
    }

    /**
     * 新增静设备
     *
     * @param formData 静设备表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveStaticEquip(StaticEquipForm formData) {
        StaticEquip entity = staticEquipConverter.toEntity(formData);
        String staticEquipTag = formData.getStaticEquipTag();
        long staticEquipTagCount = this.baseMapper.selectCount(new QueryWrapper<StaticEquip>().eq("static_equip_tag", staticEquipTag));
        if (staticEquipTagCount > 0) {
            return false;
        }
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }

    /**
     * 更新静设备
     *
     * @param id       静设备ID
     * @param formData 静设备表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateStaticEquip(Long id, StaticEquipForm formData) {
        StaticEquip entity = staticEquipConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除静设备
     *
     * @param ids 静设备ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteStaticEquips(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的静设备数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
