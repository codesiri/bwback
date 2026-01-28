package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.UnitSpecialInstrumentsExportDto;
import com.youlai.boot.ledger.model.query.UnitSpecialInstrumentsQueryExport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.UnitSpecialInstrumentsMapper;
import com.youlai.boot.ledger.service.UnitSpecialInstrumentsService;
import com.youlai.boot.ledger.model.entity.UnitSpecialInstruments;
import com.youlai.boot.ledger.model.form.UnitSpecialInstrumentsForm;
import com.youlai.boot.ledger.model.query.UnitSpecialInstrumentsQuery;
import com.youlai.boot.ledger.model.vo.UnitSpecialInstrumentsVO;
import com.youlai.boot.ledger.converter.UnitSpecialInstrumentsConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 机组特殊仪服务实现类
 *
 * @author dazao
 * @since 2026-01-21 09:01
 */
@Service
@RequiredArgsConstructor
public class UnitSpecialInstrumentsServiceImpl extends ServiceImpl<UnitSpecialInstrumentsMapper, UnitSpecialInstruments> implements UnitSpecialInstrumentsService {

    private final UnitSpecialInstrumentsConverter unitSpecialInstrumentsConverter;

    /**
     * 获取机组特殊仪分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<UnitSpecialInstrumentsVO>} 机组特殊仪分页列表
     */
    @Override
    public IPage<UnitSpecialInstrumentsVO> getUnitSpecialInstrumentsPage(UnitSpecialInstrumentsQuery queryParams) {
        Page<UnitSpecialInstrumentsVO> pageVO = this.baseMapper.getUnitSpecialInstrumentsPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }

    /**
     * 获取机组特殊仪表单数据
     *
     * @param id 机组特殊仪ID
     * @return 机组特殊仪表单数据
     */
    @Override
    public UnitSpecialInstrumentsForm getUnitSpecialInstrumentsFormData(Long id) {
        UnitSpecialInstruments entity = this.getById(id);
        return unitSpecialInstrumentsConverter.toForm(entity);
    }

    /**
     * 新增机组特殊仪
     *
     * @param formData 机组特殊仪表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveUnitSpecialInstruments(UnitSpecialInstrumentsForm formData) {
        UnitSpecialInstruments entity = unitSpecialInstrumentsConverter.toEntity(formData);
        Long count = this.baseMapper
                .selectCount(new QueryWrapper<UnitSpecialInstruments>()
                        .eq("tag_number",
                                entity.getTagNumber()));
        Assert.isTrue(count == 0 ,"位号已经存在");
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }

    /**
     * 更新机组特殊仪
     *
     * @param id       机组特殊仪ID
     * @param formData 机组特殊仪表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateUnitSpecialInstruments(Long id, UnitSpecialInstrumentsForm formData) {
        UnitSpecialInstruments entity = unitSpecialInstrumentsConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除机组特殊仪
     *
     * @param ids 机组特殊仪ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteUnitSpecialInstrumentss(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的机组特殊仪数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<UnitSpecialInstrumentsExportDto> listExportUnitSpecialInstrument(UnitSpecialInstrumentsQueryExport queryParams) {
        return this.baseMapper.listExportUnitSpecialInstrument(queryParams);
    }

}
