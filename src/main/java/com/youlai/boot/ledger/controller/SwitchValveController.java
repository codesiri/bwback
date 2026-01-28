package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import com.youlai.boot.ledger.model.dto.SwitchValveExportDto;
import com.youlai.boot.ledger.model.dto.TnkMeterExportDto;
import com.youlai.boot.ledger.service.SwitchValveService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SwitchValveForm;
import com.youlai.boot.ledger.model.query.SwitchValveQuery;
import com.youlai.boot.ledger.model.vo.SwitchValveVO;
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

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 开关阀前端控制层
 *
 * @author dazao
 * @since 2026-01-27 08:43
 */
@Tag(name = "开关阀接口")
@RestController
@RequestMapping("/api/v1/switch-valve")
@RequiredArgsConstructor
public class SwitchValveController  {

    private final SwitchValveService switchValveService;

    @Operation(summary = "开关阀分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:switch-valve:query')")
    public PageResult<SwitchValveVO> getSwitchValvePage(SwitchValveQuery queryParams ) {
        IPage<SwitchValveVO> result = switchValveService.getSwitchValvePage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增开关阀")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:switch-valve:add')")
    public Result<Void> saveSwitchValve(@RequestBody @Valid SwitchValveForm formData ) {
        boolean result = switchValveService.saveSwitchValve(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取开关阀表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:switch-valve:edit')")
    public Result<SwitchValveForm> getSwitchValveForm(
        @Parameter(description = "开关阀ID") @PathVariable Long id
    ) {
        SwitchValveForm formData = switchValveService.getSwitchValveFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改开关阀")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:switch-valve:edit')")
    public Result<Void> updateSwitchValve(
            @Parameter(description = "开关阀ID") @PathVariable Long id,
            @RequestBody @Validated SwitchValveForm formData
    ) {
        boolean result = switchValveService.updateSwitchValve(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除开关阀")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:switch-valve:delete')")
    public Result<Void> deleteSwitchValves(
        @Parameter(description = "开关阀ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = switchValveService.deleteSwitchValves(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出开关阀表")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:switch-valve:export')")
    public void exportSwitchValveTable(SwitchValveQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "开关阀表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SwitchValveExportDto> exportSwitchValveTable = this
                .switchValveService
                .exportSwitchValveTable(queryParams);
        EasyExcel.write(response.getOutputStream(), SwitchValveExportDto.class).sheet("开关阀表")
                .doWrite(exportSwitchValveTable);
    }
}
