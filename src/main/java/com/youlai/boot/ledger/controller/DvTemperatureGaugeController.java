package com.youlai.boot.ledger.controller;

import com.youlai.boot.common.annotation.RepeatSubmit;
import com.youlai.boot.ledger.model.query.DvTemperatureGaugeQueryPlus;
import com.youlai.boot.ledger.service.DvTemperatureGaugeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.DvTemperatureGaugeForm;
import com.youlai.boot.ledger.model.query.DvTemperatureGaugeQuery;
import com.youlai.boot.ledger.model.vo.DvTemperatureGaugeVO;
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
 * 温度前端控制层
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
@Tag(name = "温度接口")
@RestController
@RequestMapping("/api/v1/dv-temperature-gauge")
@RequiredArgsConstructor
public class DvTemperatureGaugeController  {

    private final DvTemperatureGaugeService dvTemperatureGaugeService;

    @Operation(summary = "温度分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:query')")
    public PageResult<DvTemperatureGaugeVO> getDvTemperatureGaugePage(DvTemperatureGaugeQueryPlus queryParams,String tagNumber,String status,String dvName ) {
        System.out.println(status);
        IPage<DvTemperatureGaugeVO> result = dvTemperatureGaugeService.getDvTemperatureGaugePage(queryParams,tagNumber,status,dvName);
        return PageResult.success(result);
    }

    @RepeatSubmit
    @Operation(summary = "新增温度")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:add')")
    public Result<Void> saveDvTemperatureGauge(@RequestBody @Valid DvTemperatureGaugeForm formData ) {
        boolean result = dvTemperatureGaugeService.saveDvTemperatureGauge(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取温度表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:edit')")
    public Result<DvTemperatureGaugeForm> getDvTemperatureGaugeForm(
        @Parameter(description = "温度ID") @PathVariable Long id
    ) {
        DvTemperatureGaugeForm formData = dvTemperatureGaugeService.getDvTemperatureGaugeFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改温度")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:edit')")
    public Result<Void> updateDvTemperatureGauge(
            @Parameter(description = "温度ID") @PathVariable Long id,
            @RequestBody @Validated DvTemperatureGaugeForm formData
    ) {
        boolean result = dvTemperatureGaugeService.updateDvTemperatureGauge(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除温度")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:delete')")
    public Result<Void> deleteDvTemperatureGauges(
        @Parameter(description = "温度ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = dvTemperatureGaugeService.deleteDvTemperatureGauges(ids);
        return Result.judge(result);
    }
}
