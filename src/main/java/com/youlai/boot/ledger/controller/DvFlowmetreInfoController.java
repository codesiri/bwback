package com.youlai.boot.ledger.controller;

import com.youlai.boot.ledger.service.DvFlowmetreInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.DvFlowmetreInfoForm;
import com.youlai.boot.ledger.model.query.DvFlowmetreInfoQuery;
import com.youlai.boot.ledger.model.vo.DvFlowmetreInfoVO;
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
 * 流量计前端控制层
 *
 * @author dazao
 * @since 2026-01-09 09:04
 */
@Tag(name = "流量计接口")
@RestController
@RequestMapping("/api/v1/dv-flowmetre-info")
@RequiredArgsConstructor
public class DvFlowmetreInfoController  {

    private final DvFlowmetreInfoService dvFlowmetreInfoService;

    @Operation(summary = "流量计分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:dv-flowmetre-info:query')")
    public PageResult<DvFlowmetreInfoVO> getDvFlowmetreInfoPage(DvFlowmetreInfoQuery queryParams ) {
        IPage<DvFlowmetreInfoVO> result = dvFlowmetreInfoService.getDvFlowmetreInfoPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增流量计")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:dv-flowmetre-info:add')")
    public Result<Void> saveDvFlowmetreInfo(@RequestBody @Valid DvFlowmetreInfoForm formData ) {
        boolean result = dvFlowmetreInfoService.saveDvFlowmetreInfo(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取流量计表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:dv-flowmetre-info:edit')")
    public Result<DvFlowmetreInfoForm> getDvFlowmetreInfoForm(
        @Parameter(description = "流量计ID") @PathVariable Long id
    ) {
        DvFlowmetreInfoForm formData = dvFlowmetreInfoService.getDvFlowmetreInfoFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改流量计")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:dv-flowmetre-info:edit')")
    public Result<Void> updateDvFlowmetreInfo(
            @Parameter(description = "流量计ID") @PathVariable Long id,
            @RequestBody @Validated DvFlowmetreInfoForm formData
    ) {
        boolean result = dvFlowmetreInfoService.updateDvFlowmetreInfo(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除流量计")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:dv-flowmetre-info:delete')")
    public Result<Void> deleteDvFlowmetreInfos(
        @Parameter(description = "流量计ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = dvFlowmetreInfoService.deleteDvFlowmetreInfos(ids);
        return Result.judge(result);
    }
}
