package com.youlai.boot.ledger.controller;

import com.youlai.boot.common.annotation.RepeatSubmit;
import com.youlai.boot.ledger.service.StaticEquipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.StaticEquipForm;
import com.youlai.boot.ledger.model.query.StaticEquipQuery;
import com.youlai.boot.ledger.model.vo.StaticEquipVO;
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
 * 静设备前端控制层
 *
 * @author dazao
 * @since 2026-01-08 08:37
 */
@Tag(name = "静设备接口")
@RestController
@RequestMapping("/api/v1/static-equip")
@RequiredArgsConstructor
public class StaticEquipController  {

    private final StaticEquipService staticEquipService;

    @Operation(summary = "静设备分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:static-equip:query')")
    public PageResult<StaticEquipVO> getStaticEquipPage(StaticEquipQuery queryParams ) {
        IPage<StaticEquipVO> result = staticEquipService.getStaticEquipPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增静设备")
    @PostMapping
    @RepeatSubmit
    @PreAuthorize("@ss.hasPerm('ledger:static-equip:add')")
    public Result<Void> saveStaticEquip(@RequestBody @Valid StaticEquipForm formData ) {
        boolean result = staticEquipService.saveStaticEquip(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取静设备表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:static-equip:edit')")
    public Result<StaticEquipForm> getStaticEquipForm(
        @Parameter(description = "静设备ID") @PathVariable Long id
    ) {
        StaticEquipForm formData = staticEquipService.getStaticEquipFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改静设备")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:static-equip:edit')")
    public Result<Void> updateStaticEquip(
            @Parameter(description = "静设备ID") @PathVariable Long id,
            @RequestBody @Validated StaticEquipForm formData
    ) {
        boolean result = staticEquipService.updateStaticEquip(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除静设备")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:static-equip:delete')")
    public Result<Void> deleteStaticEquips(
        @Parameter(description = "静设备ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = staticEquipService.deleteStaticEquips(ids);
        return Result.judge(result);
    }
}
