package com.youlai.boot.maintence.service;

import com.youlai.boot.maintence.model.entity.MaintainPlan;
import com.youlai.boot.maintence.model.form.MaintainPlanForm;
import com.youlai.boot.maintence.model.query.MaintainPlanQuery;
import com.youlai.boot.maintence.model.vo.MaintainPlanVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 维修计划服务类
 *
 * @author youlaitech
 * @since 2026-04-10 08:37
 */
public interface MaintainPlanService extends IService<MaintainPlan> {

    /**
     *维修计划分页列表
     *
     * @return {@link IPage<MaintainPlanVO>} 维修计划分页列表
     */
    IPage<MaintainPlanVO> getMaintainPlanPage(MaintainPlanQuery queryParams);

    /**
     * 获取维修计划表单数据
     *
     * @param id 维修计划ID
     * @return 维修计划表单数据
     */
     MaintainPlanForm getMaintainPlanFormData(Long id);

    /**
     * 新增维修计划
     *
     * @param formData 维修计划表单对象
     * @return 是否新增成功
     */
    boolean saveMaintainPlan(MaintainPlanForm formData);

    /**
     * 修改维修计划
     *
     * @param id   维修计划ID
     * @param formData 维修计划表单对象
     * @return 是否修改成功
     */
    boolean updateMaintainPlan(Long id, MaintainPlanForm formData);

    /**
     * 删除维修计划
     *
     * @param ids 维修计划ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteMaintainPlans(String ids);

}
