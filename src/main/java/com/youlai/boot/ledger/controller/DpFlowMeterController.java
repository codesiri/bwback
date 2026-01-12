package com.youlai.boot.ledger.controller;

import com.youlai.boot.ledger.service.DpFlowMeterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.DpFlowMeterForm;
import com.youlai.boot.ledger.model.query.DpFlowMeterQuery;
import com.youlai.boot.ledger.model.vo.DpFlowMeterVO;
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
 * 差压流量计前端控制层
 *
 * @author dazao
 * @since 2026-01-08 16:41
 */
@Tag(name = "差压流量计接口")
@RestController
@RequestMapping("/api/v1/dp-flow-meter")
@RequiredArgsConstructor
public class DpFlowMeterController  {

    private final DpFlowMeterService dpFlowMeterService;

    @Operation(summary = "差压流量计分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:dp-flow-meter:query')")
    public PageResult<DpFlowMeterVO> getDpFlowMeterPage(DpFlowMeterQuery queryParams ) {
        IPage<DpFlowMeterVO> result = dpFlowMeterService.getDpFlowMeterPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增差压流量计")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:dp-flow-meter:add')")
    public Result<Void> saveDpFlowMeter(@RequestBody @Valid DpFlowMeterForm formData ) {
        boolean result = dpFlowMeterService.saveDpFlowMeter(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取差压流量计表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:dp-flow-meter:edit')")
    public Result<DpFlowMeterForm> getDpFlowMeterForm(
        @Parameter(description = "差压流量计ID") @PathVariable Long id
    ) {
        DpFlowMeterForm formData = dpFlowMeterService.getDpFlowMeterFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改差压流量计")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:dp-flow-meter:edit')")
    public Result<Void> updateDpFlowMeter(
            @Parameter(description = "差压流量计ID") @PathVariable Long id,
            @RequestBody @Validated DpFlowMeterForm formData
    ) {
        boolean result = dpFlowMeterService.updateDpFlowMeter(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除差压流量计")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:dp-flow-meter:delete')")
    public Result<Void> deleteDpFlowMeters(
        @Parameter(description = "差压流量计ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = dpFlowMeterService.deleteDpFlowMeters(ids);
        return Result.judge(result);
    }
}
