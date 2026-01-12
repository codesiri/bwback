package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.query.DvTemperatureGaugeQueryPlus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.DvTemperatureGaugeMapper;
import com.youlai.boot.ledger.service.DvTemperatureGaugeService;
import com.youlai.boot.ledger.model.entity.DvTemperatureGauge;
import com.youlai.boot.ledger.model.form.DvTemperatureGaugeForm;
import com.youlai.boot.ledger.model.query.DvTemperatureGaugeQuery;
import com.youlai.boot.ledger.model.vo.DvTemperatureGaugeVO;
import com.youlai.boot.ledger.converter.DvTemperatureGaugeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 温度服务实现类
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
@Service
@RequiredArgsConstructor
public class DvTemperatureGaugeServiceImpl extends ServiceImpl<DvTemperatureGaugeMapper, DvTemperatureGauge> implements DvTemperatureGaugeService {

    private final DvTemperatureGaugeConverter dvTemperatureGaugeConverter;

    /**
    * 获取温度分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<DvTemperatureGaugeVO>} 温度分页列表
    */
    @Override
    public IPage<DvTemperatureGaugeVO> getDvTemperatureGaugePage(DvTemperatureGaugeQueryPlus queryParams,String tagNumber,String status,String dvName) {
        Page<DvTemperatureGaugeVO> pageVO = this.baseMapper.getDvTemperatureGaugePage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                tagNumber,status,dvName
        );
        return pageVO;
    }
    
    /**
     * 获取温度表单数据
     *
     * @param id 温度ID
     * @return 温度表单数据
     */
    @Override
    public DvTemperatureGaugeForm getDvTemperatureGaugeFormData(Long id) {
        DvTemperatureGauge entity = this.getById(id);
        return dvTemperatureGaugeConverter.toForm(entity);
    }
    
    /**
     * 新增温度
     *
     * @param formData 温度表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveDvTemperatureGauge(DvTemperatureGaugeForm formData) {
        DvTemperatureGauge entity = dvTemperatureGaugeConverter.toEntity(formData);
        long count = this.baseMapper.selectCount(new QueryWrapper<DvTemperatureGauge>().eq("tag_number",entity.getTagNumber()));
        if(count > 0 ){
            return false;
        }
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        //生成id
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }
    
    /**
     * 更新温度
     *
     * @param id   温度ID
     * @param formData 温度表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateDvTemperatureGauge(Long id,DvTemperatureGaugeForm formData) {
        DvTemperatureGauge entity = dvTemperatureGaugeConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除温度
     *
     * @param ids 温度ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteDvTemperatureGauges(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的温度数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
