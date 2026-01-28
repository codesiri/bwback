package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.AnalyInstrumentExportDto;
import com.youlai.boot.ledger.model.query.AnalyInstrumentExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.AnalyInstrumentMapper;
import com.youlai.boot.ledger.service.AnalyInstrumentService;
import com.youlai.boot.ledger.model.entity.AnalyInstrument;
import com.youlai.boot.ledger.model.form.AnalyInstrumentForm;
import com.youlai.boot.ledger.model.query.AnalyInstrumentQuery;
import com.youlai.boot.ledger.model.vo.AnalyInstrumentVO;
import com.youlai.boot.ledger.converter.AnalyInstrumentConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 分析仪服务实现类
 *
 * @author dazao
 * @since 2026-01-23 14:48
 */
@Service
@RequiredArgsConstructor
public class AnalyInstrumentServiceImpl extends ServiceImpl<AnalyInstrumentMapper, AnalyInstrument> implements AnalyInstrumentService {

    private final AnalyInstrumentConverter analyInstrumentConverter;

    /**
    * 获取分析仪分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<AnalyInstrumentVO>} 分析仪分页列表
    */
    @Override
    public IPage<AnalyInstrumentVO> getAnalyInstrumentPage(AnalyInstrumentQuery queryParams) {
        Page<AnalyInstrumentVO> pageVO = this.baseMapper.getAnalyInstrumentPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取分析仪表单数据
     *
     * @param id 分析仪ID
     * @return 分析仪表单数据
     */
    @Override
    public AnalyInstrumentForm getAnalyInstrumentFormData(Long id) {
        AnalyInstrument entity = this.getById(id);
        return analyInstrumentConverter.toForm(entity);
    }
    
    /**
     * 新增分析仪
     *
     * @param formData 分析仪表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveAnalyInstrument(AnalyInstrumentForm formData) {
        AnalyInstrument entity = analyInstrumentConverter.toEntity(formData);
        long analyInstrumentCode = this.count(new QueryWrapper<AnalyInstrument>().eq("analy_instrument_code", entity.getAnalyInstrumentCode()));
        Assert.isTrue(analyInstrumentCode == 0, "位号已经存在");
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }
    
    /**
     * 更新分析仪
     *
     * @param id   分析仪ID
     * @param formData 分析仪表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateAnalyInstrument(Long id,AnalyInstrumentForm formData) {
        AnalyInstrument entity = analyInstrumentConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除分析仪
     *
     * @param ids 分析仪ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteAnalyInstruments(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的分析仪数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<AnalyInstrumentExportDto> listExportAnalyInstrument(AnalyInstrumentExportQuery queryParams) {
        List<AnalyInstrumentExportDto> analyInstrumentExportDtos = this.baseMapper.listExportAnalyInstrument(queryParams);
        return analyInstrumentExportDtos;
    }

}
