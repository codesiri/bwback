package com.youlai.boot.ledger.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.converter.PressureInstrumentConverter;
import com.youlai.boot.ledger.mapper.PressureInstrumentMapper;
import com.youlai.boot.ledger.model.dto.PressureInstrumentExportDTO;
import com.youlai.boot.ledger.model.entity.PressureInstrument;
import com.youlai.boot.ledger.model.form.PressureInstrumentForm;
import com.youlai.boot.ledger.model.query.PressureInstrumentQueryPlus;
import com.youlai.boot.ledger.model.vo.PressureInstrumentVO;
import com.youlai.boot.ledger.service.PressureInstrumentService;
import com.youlai.boot.system.service.DictItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 压力服务实现类
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
@Service
@RequiredArgsConstructor
public class PressureInstrumentServiceImpl extends ServiceImpl<PressureInstrumentMapper, PressureInstrument> implements PressureInstrumentService {

    private final PressureInstrumentConverter pressureInstrumentConverter;
    private final DictItemService dictItemService;
    /**
     * 获取压力分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<PressureInstrumentVO>} 压力分页列表
     */
    @Override
    public IPage<PressureInstrumentVO> getPressureInstrumentPage(PressureInstrumentQueryPlus queryParams) {
        Page<PressureInstrumentVO> pageVO = this.baseMapper.getPressureInstrumentPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),queryParams
        );
        return pageVO;
    }



    /**
     * 获取压力表单数据
     *
     * @param id 压力ID
     * @return 压力表单数据
     */
    @Override
    public PressureInstrumentForm getPressureInstrumentFormData(Long id) {
        PressureInstrument entity = this.getById(id);
        return pressureInstrumentConverter.toForm(entity);
    }




    /**
     * 新增压力
     *
     * @param formData 压力表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean savePressureInstrument(PressureInstrumentForm formData) {
        PressureInstrument entity = pressureInstrumentConverter.toEntity(formData);
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        //生成id
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }

    /**
     * 更新压力
     *
     * @param id   压力ID
     * @param formData 压力表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updatePressureInstrument(Long id,PressureInstrumentForm formData) {
        PressureInstrument entity = pressureInstrumentConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除压力
     *
     * @param ids 压力ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deletePressureInstrument(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的压力数据为空");
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
     * @return {@link List<PressureInstrumentExportDTO>} 导出压力列表
     */
    @Override
    public List<PressureInstrumentExportDTO> listExportPressureInstrument(PressureInstrumentQueryPlus queryParams) {
        return this.baseMapper.listExportPressureInstruments(queryParams);

    }

}

