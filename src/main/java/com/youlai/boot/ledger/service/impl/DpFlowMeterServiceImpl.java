package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.DpFlowMeterMapper;
import com.youlai.boot.ledger.service.DpFlowMeterService;
import com.youlai.boot.ledger.model.entity.DpFlowMeter;
import com.youlai.boot.ledger.model.form.DpFlowMeterForm;
import com.youlai.boot.ledger.model.query.DpFlowMeterQuery;
import com.youlai.boot.ledger.model.vo.DpFlowMeterVO;
import com.youlai.boot.ledger.converter.DpFlowMeterConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 差压流量计服务实现类
 *
 * @author dazao
 * @since 2026-01-08 16:41
 */
@Service
@RequiredArgsConstructor
public class DpFlowMeterServiceImpl extends ServiceImpl<DpFlowMeterMapper, DpFlowMeter> implements DpFlowMeterService {

    private final DpFlowMeterConverter dpFlowMeterConverter;

    /**
    * 获取差压流量计分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<DpFlowMeterVO>} 差压流量计分页列表
    */
    @Override
    public IPage<DpFlowMeterVO> getDpFlowMeterPage(DpFlowMeterQuery queryParams) {
        Page<DpFlowMeterVO> pageVO = this.baseMapper.getDpFlowMeterPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取差压流量计表单数据
     *
     * @param id 差压流量计ID
     * @return 差压流量计表单数据
     */
    @Override
    public DpFlowMeterForm getDpFlowMeterFormData(Long id) {
        DpFlowMeter entity = this.getById(id);
        return dpFlowMeterConverter.toForm(entity);
    }
    
    /**
     * 新增差压流量计
     *
     * @param formData 差压流量计表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveDpFlowMeter(DpFlowMeterForm formData) {
        DpFlowMeter entity = dpFlowMeterConverter.toEntity(formData);
//        this.baseMapper.selectCount(new QueryWrapper<DpFlowMeter>().eq("tag_number",entity.get))
        return this.save(entity);
    }
    
    /**
     * 更新差压流量计
     *
     * @param id   差压流量计ID
     * @param formData 差压流量计表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateDpFlowMeter(Long id,DpFlowMeterForm formData) {
        DpFlowMeter entity = dpFlowMeterConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除差压流量计
     *
     * @param ids 差压流量计ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteDpFlowMeters(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的差压流量计数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
