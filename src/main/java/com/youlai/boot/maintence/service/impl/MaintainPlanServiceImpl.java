package com.youlai.boot.maintence.service.impl;

import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.maintence.model.dto.MaintainPlanExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.maintence.mapper.MaintainPlanMapper;
import com.youlai.boot.maintence.service.MaintainPlanService;
import com.youlai.boot.maintence.model.entity.MaintainPlan;
import com.youlai.boot.maintence.model.form.MaintainPlanForm;
import com.youlai.boot.maintence.model.query.MaintainPlanQuery;
import com.youlai.boot.maintence.model.vo.MaintainPlanVO;
import com.youlai.boot.maintence.converter.MaintainPlanConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 维修计划服务实现类
 *
 * @author youlaitech
 * @since 2026-04-10 08:37
 */
@Service
@RequiredArgsConstructor
public class MaintainPlanServiceImpl extends ServiceImpl<MaintainPlanMapper, MaintainPlan> implements MaintainPlanService {

    private final MaintainPlanConverter maintainPlanConverter;

    /**
    * 获取维修计划分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<MaintainPlanVO>} 维修计划分页列表
    */
    @Override
    public IPage<MaintainPlanVO> getMaintainPlanPage(MaintainPlanQuery queryParams) {
        Page<MaintainPlanVO> pageVO = this.baseMapper.getMaintainPlanPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }

    /**
     * 获取维修计划表单数据
     *
     * @param id 维修计划ID
     * @return 维修计划表单数据
     */
    @Override
    public MaintainPlanForm getMaintainPlanFormData(Long id) {
        MaintainPlan entity = this.getById(id);
        return maintainPlanConverter.toForm(entity);
    }

    /**
     * 新增维修计划
     *
     * @param formData 维修计划表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveMaintainPlan(MaintainPlanForm formData) {
        MaintainPlan entity = maintainPlanConverter.toEntity(formData);
        //TODO 先用jdk生成，后边记得改成美团leaf
        long genIdByJdk = IDUtil.genIdByLeaf();
        entity.setId(genIdByJdk);
        return this.save(entity);
    }

    /**
     * 更新维修计划
     *
     * @param id   维修计划ID
     * @param formData 维修计划表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateMaintainPlan(Long id,MaintainPlanForm formData) {
        MaintainPlan entity = maintainPlanConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除维修计划
     *
     * @param ids 维修计划ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteMaintainPlans(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的维修计划数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<MaintainPlanExportDto> exportMaintainPlans() {
        return this.baseMapper.exportMaintainPlans();
    }

}
