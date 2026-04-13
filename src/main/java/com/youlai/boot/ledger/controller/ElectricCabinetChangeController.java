package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.ElectricCabinetChangesImportListener;
import com.youlai.boot.ledger.model.dto.ElectricCabinetChangeExportDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetChangeExportQuery;
import com.youlai.boot.ledger.service.ElectricCabinetChangeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ElectricCabinetChangeForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetChangeQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetChangeVO;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 抽屉柜变更记录前端控制层
 *
 * @author dazao
 * @since 2026-03-13 11:16
 */
@Tag(name = "抽屉柜变更记录接口")
@RestController
@RequestMapping("/api/v1/electric-cabinet-change")
@RequiredArgsConstructor
public class ElectricCabinetChangeController  {

    private final ElectricCabinetChangeService electricCabinetChangeService;

    @Operation(summary = "抽屉柜变更记录分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-change:query')")
    public PageResult<ElectricCabinetChangeVO> getElectricCabinetChangePage(ElectricCabinetChangeQuery queryParams ) {
        IPage<ElectricCabinetChangeVO> result = electricCabinetChangeService.getElectricCabinetChangePage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增抽屉柜变更记录")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-change:add')")
    public Result<Void> saveElectricCabinetChange(@RequestBody @Valid ElectricCabinetChangeForm formData ) {
        boolean result = electricCabinetChangeService.saveElectricCabinetChange(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取抽屉柜变更记录表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-change:edit')")
    public Result<ElectricCabinetChangeForm> getElectricCabinetChangeForm(
        @Parameter(description = "抽屉柜变更记录ID") @PathVariable Long id
    ) {
        ElectricCabinetChangeForm formData = electricCabinetChangeService.getElectricCabinetChangeFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改抽屉柜变更记录")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-change:edit')")
    public Result<Void> updateElectricCabinetChange(
            @Parameter(description = "抽屉柜变更记录ID") @PathVariable Long id,
            @RequestBody @Validated ElectricCabinetChangeForm formData
    ) {
        boolean result = electricCabinetChangeService.updateElectricCabinetChange(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除抽屉柜变更记录")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-change:delete')")
    public Result<Void> deleteElectricCabinetChanges(
        @Parameter(description = "抽屉柜变更记录ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = electricCabinetChangeService.deleteElectricCabinetChanges(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出抽屉柜变更记录")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-change:query')")
    public void exportElectricCabinetChanges(ElectricCabinetChangeExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "抽屉柜变更记录表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<ElectricCabinetChangeExportDto> electricCabinetChangeExportDtoList =
                this.electricCabinetChangeService.exportElectricCabinetChanges(queryParams);
        EasyExcel
                .write(response.getOutputStream(),
                        ElectricCabinetChangeExportDto.class)
                .sheet("抽屉柜变更记录表").doWrite(electricCabinetChangeExportDtoList);
    }

    @Operation(summary = "导入抽屉柜变更记录")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-change:add')")
    public Result<ExcelResult>  importElectricCabinetChanges(MultipartFile file) throws IOException {
        var electricCabinetChangesImportListener = new ElectricCabinetChangesImportListener();
        ExcelUtils.importExcel(file.getInputStream(), ElectricCabinetChangeExportDto.class,electricCabinetChangesImportListener);
        return Result.success(electricCabinetChangesImportListener.getExcelResult());
    }
}
