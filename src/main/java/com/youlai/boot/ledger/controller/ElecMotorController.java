package com.youlai.boot.ledger.controller;

import com.youlai.boot.ledger.service.ElecMotorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ElecMotorForm;
import com.youlai.boot.ledger.model.query.ElecMotorQuery;
import com.youlai.boot.ledger.model.vo.ElecMotorVO;
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
 * 电器电动机前端控制层
 *
 * @author dazao
 * @since 2026-01-13 10:10
 */
@Tag(name = "电器电动机接口")
@RestController
@RequestMapping("/api/v1/elec-motor")
@RequiredArgsConstructor
public class ElecMotorController  {

    private final ElecMotorService elecMotorService;

    @Operation(summary = "电器电动机分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:elec-motor:query')")
    public PageResult<ElecMotorVO> getElecMotorPage(ElecMotorQuery queryParams ) {
        IPage<ElecMotorVO> result = elecMotorService.getElecMotorPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增电器电动机")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:elec-motor:add')")
    public Result<Void> saveElecMotor(@RequestBody @Valid ElecMotorForm formData ) {
        boolean result = elecMotorService.saveElecMotor(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取电器电动机表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:elec-motor:edit')")
    public Result<ElecMotorForm> getElecMotorForm(
        @Parameter(description = "电器电动机ID") @PathVariable Long id
    ) {
        ElecMotorForm formData = elecMotorService.getElecMotorFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改电器电动机")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:elec-motor:edit')")
    public Result<Void> updateElecMotor(
            @Parameter(description = "电器电动机ID") @PathVariable Long id,
            @RequestBody @Validated ElecMotorForm formData
    ) {
        boolean result = elecMotorService.updateElecMotor(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除电器电动机")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:elec-motor:delete')")
    public Result<Void> deleteElecMotors(
        @Parameter(description = "电器电动机ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = elecMotorService.deleteElecMotors(ids);
        return Result.judge(result);
    }
}
