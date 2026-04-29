package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.LevelGaugeExportDto;
import com.youlai.boot.ledger.model.query.LevelGaugeExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.LevelGaugeMapper;
import com.youlai.boot.ledger.service.LevelGaugeService;
import com.youlai.boot.ledger.model.entity.LevelGauge;
import com.youlai.boot.ledger.model.form.LevelGaugeForm;
import com.youlai.boot.ledger.model.query.LevelGaugeQuery;
import com.youlai.boot.ledger.model.vo.LevelGaugeVO;
import com.youlai.boot.ledger.converter.LevelGaugeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 液位计服务实现类
 *
 * @author dazao
 * @since 2026-01-20 15:40
 */
@Service
@RequiredArgsConstructor
public class LevelGaugeServiceImpl extends ServiceImpl<LevelGaugeMapper, LevelGauge> implements LevelGaugeService {

    private final LevelGaugeConverter levelGaugeConverter;

    /**
    * 获取液位计分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<LevelGaugeVO>} 液位计分页列表
    */
    @Override
    public IPage<LevelGaugeVO> getLevelGaugePage(LevelGaugeQuery queryParams) {
        Page<LevelGaugeVO> pageVO = this.baseMapper.getLevelGaugePage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取液位计表单数据
     *
     * @param id 液位计ID
     * @return 液位计表单数据
     */
    @Override
    public LevelGaugeForm getLevelGaugeFormData(Long id) {
        LevelGauge entity = this.getById(id);
        LevelGaugeForm levelGaugeForm = new LevelGaugeForm();
        BeanUtils.copyProperties(entity,levelGaugeForm);
        return levelGaugeForm;
    }
    
    /**
     * 新增液位计
     *
     * @param formData 液位计表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveLevelGauge(LevelGaugeForm formData) {
        LevelGauge entity = levelGaugeConverter.toEntity(formData);
        long levelTag = this
                .count(new QueryWrapper<LevelGauge>().eq("level_tag", entity.getLevelTag()));
        Assert.isTrue(levelTag == 0 ,"位号已经存在");
        //校验通过
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }
    
    /**
     * 更新液位计
     *
     * @param id   液位计ID
     * @param formData 液位计表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateLevelGauge(Long id,LevelGaugeForm formData) {
        LevelGauge entity = new LevelGauge();
        BeanUtils.copyProperties(formData,entity);
        return this.updateById(entity);
    }
    
    /**
     * 删除液位计
     *
     * @param ids 液位计ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteLevelGauges(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的液位计数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<LevelGaugeExportDto> listExportLevelGauge(LevelGaugeExportQuery queryParams) {
        return this.baseMapper.listExportLevelGauge(queryParams);
    }

}
