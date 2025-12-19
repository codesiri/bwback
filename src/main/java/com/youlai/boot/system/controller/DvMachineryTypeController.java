package com.youlai.boot.system.controller;

import com.youlai.boot.system.model.entity.DvMachineryType;
import com.youlai.boot.system.model.query.QueryDvTypeParams;
import com.youlai.boot.system.service.DvMachineryTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.system.model.form.DvMachineryTypeForm;
import com.youlai.boot.system.model.query.DvMachineryTypeQuery;
import com.youlai.boot.system.model.vo.DvMachineryTypeVO;
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

import java.util.List;

/**
 * 设备类型前端控制层
 *
 * @author youlaitech
 * @since 2025-12-17 08:15
 */
@Tag(name = "设备类型接口")
@RestController
@RequestMapping("/api/v1/dv-machinery-type")
@RequiredArgsConstructor
public class DvMachineryTypeController  {

    private final DvMachineryTypeService dvMachineryTypeService;

    @Operation(summary = "设备类型分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('system:dv-machinery-type:query')")
    public PageResult<DvMachineryTypeVO> getDvMachineryTypePage(DvMachineryTypeQuery queryParams ) {
        IPage<DvMachineryTypeVO> result = dvMachineryTypeService.getDvMachineryTypePage(queryParams);
        return PageResult.success(result);
    }

    @Deprecated
    @Operation(summary = "根据设备名称或者是否启用模糊查询设备类型")
    @GetMapping("/queryDvType")
    public Result<List<DvMachineryTypeVO>> queryDvTypeByParams(QueryDvTypeParams queryDvTypeParams){
        System.out.println(queryDvTypeParams);
        dvMachineryTypeService.queryDvTypeByParams(queryDvTypeParams);
        return  Result.success();
    }

    @Operation(summary = "新增设备类型")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('system:dv-machinery-type:add')")
    public Result<Void> saveDvMachineryType(@RequestBody @Valid DvMachineryTypeForm formData ) {
        boolean result = dvMachineryTypeService.saveDvMachineryType(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取设备类型表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('system:dv-machinery-type:edit')")
    public Result<DvMachineryTypeForm> getDvMachineryTypeForm(
        @Parameter(description = "设备类型ID") @PathVariable Long id
    ) {
        DvMachineryTypeForm formData = dvMachineryTypeService.getDvMachineryTypeFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改设备类型")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('system:dv-machinery-type:edit')")
    public Result<Void> updateDvMachineryType(
            @Parameter(description = "设备类型ID") @PathVariable Long id,
            @RequestBody @Validated DvMachineryTypeForm formData
    ) {
        boolean result = dvMachineryTypeService.updateDvMachineryType(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除设备类型")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('system:dv-machinery-type:delete')")
    public Result<Void> deleteDvMachineryTypes(
        @Parameter(description = "设备类型ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = dvMachineryTypeService.deleteDvMachineryTypes(ids);
        return Result.judge(result);
    }

    @Operation(summary = "查询所有设备类型注意，这个树形3结构在前端构建")
    @GetMapping("/list")
    @PreAuthorize("@ss.hasPerm('system:dv-machinery-type:list')")
    public Result<List<DvMachineryTypeVO>> list(DvMachineryType dvMachineryType){
        List<DvMachineryTypeVO> dvMachineryTypeVOS = dvMachineryTypeService.selectDvMachineryTypeList(dvMachineryType);
        return Result.success(dvMachineryTypeVOS);
    }
}
