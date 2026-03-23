package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.ControlValveExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ControlValveMapper;
import com.youlai.boot.ledger.service.ControlValveService;
import com.youlai.boot.ledger.model.entity.ControlValve;
import com.youlai.boot.ledger.model.form.ControlValveForm;
import com.youlai.boot.ledger.model.query.ControlValveQuery;
import com.youlai.boot.ledger.model.vo.ControlValveVO;
import com.youlai.boot.ledger.converter.ControlValveConverter;

import java.util.Arrays;
import java.util.List;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 调节阀服务实现类
 *
 * @author cc
 * @since 2026-01-28 11:03
 */
@Service
@RequiredArgsConstructor
public class ControlValveServiceImpl extends ServiceImpl<ControlValveMapper, ControlValve> implements ControlValveService {

    private final ControlValveConverter controlValveConverter;

    /**
     * 获取调节阀分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<ControlValveVO>} 调节阀分页列表
     */
    @Override
    public IPage<ControlValveVO> getControlValvePage(ControlValveQuery queryParams) {
        Page<ControlValveVO> pageVO = this.baseMapper.getControlValvePage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }

    /**
     * 获取调节阀表单数据
     *
     * @param id 调节阀ID
     * @return 调节阀表单数据
     */
    @Override
    public ControlValveForm getControlValveFormData(Long id) {
        ControlValve entity = this.getById(id);
        return controlValveConverter.toForm(entity);
    }

    /**
     * 新增调节阀
     *
     * @param formData 调节阀表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveControlValve(ControlValveForm formData) {
        ControlValve entity = controlValveConverter.toEntity(formData);
        String tagNo = entity.getTagNo();
        long count = this.count(new QueryWrapper<ControlValve>().eq("tag_no", tagNo));
        Assert.isTrue(count == 0, "位号已经存在");
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }

    /**
     * 更新调节阀
     *
     * @param id   调节阀ID
     * @param formData 调节阀表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateControlValve(Long id,ControlValveForm formData) {
        ControlValve entity = controlValveConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除调节阀
     *
     * @param ids 调节阀ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteControlValves(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的调节阀数据为空");
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
     * @return {@link List<ControlValveExportDto>} 导出压力列表
     */
    @Override
    public List<ControlValveExportDto> listExportControlValves(ControlValveQuery queryParams) {
        List<ControlValveExportDto> exportControlValves = this.baseMapper.listExportControlValves(queryParams);
        return exportControlValves;
    }

}

