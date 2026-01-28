package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.SwitchValveExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SwitchValveMapper;
import com.youlai.boot.ledger.service.SwitchValveService;
import com.youlai.boot.ledger.model.entity.SwitchValve;
import com.youlai.boot.ledger.model.form.SwitchValveForm;
import com.youlai.boot.ledger.model.query.SwitchValveQuery;
import com.youlai.boot.ledger.model.vo.SwitchValveVO;
import com.youlai.boot.ledger.converter.SwitchValveConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 开关阀服务实现类
 *
 * @author dazao
 * @since 2026-01-27 08:43
 */
@Service
@RequiredArgsConstructor
public class SwitchValveServiceImpl extends ServiceImpl<SwitchValveMapper, SwitchValve> implements SwitchValveService {

    private final SwitchValveConverter switchValveConverter;

    /**
    * 获取开关阀分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SwitchValveVO>} 开关阀分页列表
    */
    @Override
    public IPage<SwitchValveVO> getSwitchValvePage(SwitchValveQuery queryParams) {
        Page<SwitchValveVO> pageVO = this.baseMapper.getSwitchValvePage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取开关阀表单数据
     *
     * @param id 开关阀ID
     * @return 开关阀表单数据
     */
    @Override
    public SwitchValveForm getSwitchValveFormData(Long id) {
        SwitchValve entity = this.getById(id);
        return switchValveConverter.toForm(entity);
    }
    
    /**
     * 新增开关阀
     *
     * @param formData 开关阀表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSwitchValve(SwitchValveForm formData) {
        SwitchValve entity = switchValveConverter.toEntity(formData);
        String switchValveTag = entity.getSwitchValveTag();
        long count = this.count(new QueryWrapper<SwitchValve>().eq("switch_valve_tag", switchValveTag));
        Assert.isTrue(count == 0 , "位号已经存在");
        //入库
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
//        Assert.isTrue(id, "id生成错误");
        entity.setId(id);
        return this.save(entity);
    }
    
    /**
     * 更新开关阀
     *
     * @param id   开关阀ID
     * @param formData 开关阀表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSwitchValve(Long id,SwitchValveForm formData) {
        SwitchValve entity = switchValveConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除开关阀
     *
     * @param ids 开关阀ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSwitchValves(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的开关阀数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<SwitchValveExportDto> exportSwitchValveTable(SwitchValveQuery queryParams) {
        return this.baseMapper.exportSwitchValveTable(queryParams);
    }

}
