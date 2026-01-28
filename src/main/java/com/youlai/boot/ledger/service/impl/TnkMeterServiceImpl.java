package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.TnkMeterExportDto;
import com.youlai.boot.ledger.model.query.TnkMeterExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.TnkMeterMapper;
import com.youlai.boot.ledger.service.TnkMeterService;
import com.youlai.boot.ledger.model.entity.TnkMeter;
import com.youlai.boot.ledger.model.form.TnkMeterForm;
import com.youlai.boot.ledger.model.query.TnkMeterQuery;
import com.youlai.boot.ledger.model.vo.TnkMeterVO;
import com.youlai.boot.ledger.converter.TnkMeterConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 罐区仪服务实现类
 *
 * @author dazao
 * @since 2026-01-20 08:17
 */
@Service
@RequiredArgsConstructor
public class TnkMeterServiceImpl extends ServiceImpl<TnkMeterMapper, TnkMeter> implements TnkMeterService {

    private final TnkMeterConverter tnkMeterConverter;

    /**
     * 获取罐区仪分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<TnkMeterVO>} 罐区仪分页列表
     */
    @Override
    public IPage<TnkMeterVO> getTnkMeterPage(TnkMeterQuery queryParams) {
        Page<TnkMeterVO> pageVO = this.baseMapper.getTnkMeterPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }

    /**
     * 获取罐区仪表单数据
     *
     * @param id 罐区仪ID
     * @return 罐区仪表单数据
     */
    @Override
    public TnkMeterForm getTnkMeterFormData(Long id) {
        TnkMeter entity = this.getById(id);
        return tnkMeterConverter.toForm(entity);
    }

    /**
     * 新增罐区仪
     *
     * @param formData 罐区仪表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveTnkMeter(TnkMeterForm formData) {
        TnkMeter entity = tnkMeterConverter.toEntity(formData);
        Long tnMeterTag = this.baseMapper.selectCount(new QueryWrapper<TnkMeter>().eq("tn_meter_tag", entity.getTnkMeterTag()));
        Assert.isTrue(tnMeterTag == 0, "位号已经存在");
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }

    /**
     * 更新罐区仪
     *
     * @param id       罐区仪ID
     * @param formData 罐区仪表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateTnkMeter(Long id, TnkMeterForm formData) {
        TnkMeter entity = tnkMeterConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除罐区仪
     *
     * @param ids 罐区仪ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteTnkMeters(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的罐区仪数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<TnkMeterExportDto> listExportTnkMeters(TnkMeterExportQuery queryParams) {
        return this.baseMapper.listExportTnkMeters(queryParams);
    }

}
