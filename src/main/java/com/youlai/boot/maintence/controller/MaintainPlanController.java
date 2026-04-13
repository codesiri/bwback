package com.youlai.boot.maintence.controller;

import com.youlai.boot.maintence.service.MaintainPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.maintence.model.form.MaintainPlanForm;
import com.youlai.boot.maintence.model.query.MaintainPlanQuery;
import com.youlai.boot.maintence.model.vo.MaintainPlanVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.youlai.boot.core.web.PageResult;
import com.youlai.boot.core.web.Result;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

/**
 * 维修计划前端控制层
 *
 * @author youlaitech
 * @since 2026-04-10 08:37
 */
@Tag(name = "维修计划接口")
@RestController
@RequestMapping("/api/v1/maintain-plan")
@RequiredArgsConstructor
public class MaintainPlanController  {

    private final MaintainPlanService maintainPlanService;

    @Operation(summary = "维修计划分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('maintence:maintain-plan:query')")
    public PageResult<MaintainPlanVO> getMaintainPlanPage(MaintainPlanQuery queryParams ) {
        IPage<MaintainPlanVO> result = maintainPlanService.getMaintainPlanPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增维修计划")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('maintence:maintain-plan:add')")
    public Result<Void> saveMaintainPlan(@RequestBody @Valid MaintainPlanForm formData ) {
        boolean result = maintainPlanService.saveMaintainPlan(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取维修计划表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('maintence:maintain-plan:edit')")
    public Result<MaintainPlanForm> getMaintainPlanForm(
        @Parameter(description = "维修计划ID") @PathVariable Long id
    ) {
        MaintainPlanForm formData = maintainPlanService.getMaintainPlanFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改维修计划")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('maintence:maintain-plan:edit')")
    public Result<Void> updateMaintainPlan(
            @Parameter(description = "维修计划ID") @PathVariable Long id,
            @RequestBody @Validated MaintainPlanForm formData
    ) {
        boolean result = maintainPlanService.updateMaintainPlan(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除维修计划")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('maintence:maintain-plan:delete')")
    public Result<Void> deleteMaintainPlans(
        @Parameter(description = "维修计划ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = maintainPlanService.deleteMaintainPlans(ids);
        return Result.judge(result);
    }
}
