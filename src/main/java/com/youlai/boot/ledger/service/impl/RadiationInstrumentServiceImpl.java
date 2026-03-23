package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.RadiationInstrumentExportDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.RadiationInstrumentMapper;
import com.youlai.boot.ledger.service.RadiationInstrumentService;
import com.youlai.boot.ledger.model.entity.RadiationInstrument;
import com.youlai.boot.ledger.model.form.RadiationInstrumentForm;
import com.youlai.boot.ledger.model.query.RadiationInstrumentQuery;
import com.youlai.boot.ledger.model.vo.RadiationInstrumentVO;
import com.youlai.boot.ledger.converter.RadiationInstrumentConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 放射仪服务实现类
 *
 * @author baiwei
 * @since 2026-01-28 09:50
 */
@Service
@RequiredArgsConstructor
public class RadiationInstrumentServiceImpl extends ServiceImpl<RadiationInstrumentMapper, RadiationInstrument> implements RadiationInstrumentService {

    private final RadiationInstrumentConverter radiationInstrumentConverter;

    /**
     * 获取放射仪分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<RadiationInstrumentVO>} 放射仪分页列表
     */
    @Override
    public IPage<RadiationInstrumentVO> getRadiationInstrumentPage(RadiationInstrumentQuery queryParams) {
        Page<RadiationInstrumentVO> pageVO = this.baseMapper.getRadiationInstrumentPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }

    /**
     * 获取放射仪表单数据
     *
     * @param id 放射仪ID
     * @return 放射仪表单数据
     */
    @Override
    public RadiationInstrumentForm getRadiationInstrumentFormData(Long id) {
        RadiationInstrument entity = this.getById(id);
        return radiationInstrumentConverter.toForm(entity);
    }

    /**
     * 新增放射仪
     *
     * @param formData 放射仪表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveRadiationInstrument(RadiationInstrumentForm formData) {
        RadiationInstrument entity = radiationInstrumentConverter.toEntity(formData);
        String tagNumber = entity.getTagNumber();
        long count = this.count(new QueryWrapper<RadiationInstrument>().eq("tag_number", tagNumber));
        Assert.isTrue(count == 0, "位号已经存在");
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }

    /**
     * 更新放射仪
     *
     * @param id   放射仪ID
     * @param formData 放射仪表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateRadiationInstrument(Long id,RadiationInstrumentForm formData) {
        RadiationInstrument entity = radiationInstrumentConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除放射仪
     *
     * @param ids 放射仪ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteRadiationInstruments(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的放射仪数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    /**
     * 获取导出压力列表
     *
     * @param queryParams 查询参数
     * @return {@link List<  RadiationInstrumentExportDTO  >} 导出压力列表
     */
    @Override
    public List<RadiationInstrumentExportDTO> listExportRadiationInstruments(RadiationInstrumentQuery queryParams) {
        return this.baseMapper.listExportRadiationInstrument(queryParams);
    }

}

