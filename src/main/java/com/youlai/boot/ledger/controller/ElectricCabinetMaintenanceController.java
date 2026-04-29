package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.ElectricCabinetMaintenanceImportListener;
import com.youlai.boot.ledger.model.dto.ElectricCabinetMaintenanceExportDto;
import com.youlai.boot.ledger.service.ElectricCabinetMaintenanceService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ElectricCabinetMaintenanceForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetMaintenanceQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetMaintenanceVO;
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 抽屉柜维护保养记录前端控制层
 *
 * @author c
 * @since 2026-04-16 14:43
 */
@Tag(name = "抽屉柜维护保养记录接口")
@RestController
@RequestMapping("/api/v1/electric-cabinet-maintenance")
@RequiredArgsConstructor
public class ElectricCabinetMaintenanceController  {

    private final ElectricCabinetMaintenanceService electricCabinetMaintenanceService;

    @Operation(summary = "抽屉柜维护保养记录分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-maintenance:query')")
    public PageResult<ElectricCabinetMaintenanceVO> getElectricCabinetMaintenancePage(ElectricCabinetMaintenanceQuery queryParams ) {
        IPage<ElectricCabinetMaintenanceVO> result = electricCabinetMaintenanceService.getElectricCabinetMaintenancePage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增抽屉柜维护保养记录")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-maintenance:add')")
    public Result<Void> saveElectricCabinetMaintenance(@RequestBody @Valid ElectricCabinetMaintenanceForm formData ) {
        boolean result = electricCabinetMaintenanceService.saveElectricCabinetMaintenance(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取抽屉柜维护保养记录表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-maintenance:edit')")
    public Result<ElectricCabinetMaintenanceForm> getElectricCabinetMaintenanceForm(
        @Parameter(description = "抽屉柜维护保养记录ID") @PathVariable Long id
    ) {
        ElectricCabinetMaintenanceForm formData = electricCabinetMaintenanceService.getElectricCabinetMaintenanceFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改抽屉柜维护保养记录")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-maintenance:edit')")
    public Result<Void> updateElectricCabinetMaintenance(
            @Parameter(description = "抽屉柜维护保养记录ID") @PathVariable Long id,
            @RequestBody @Validated ElectricCabinetMaintenanceForm formData
    ) {
        boolean result = electricCabinetMaintenanceService.updateElectricCabinetMaintenance(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除抽屉柜维护保养记录")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-maintenance:delete')")
    public Result<Void> deleteElectricCabinetMaintenances(
        @Parameter(description = "抽屉柜维护保养记录ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = electricCabinetMaintenanceService.deleteElectricCabinetMaintenances(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出抽屉柜维护保养记录")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-maintenance:export')")
    public void exportElectricCabinetMaintenances(ElectricCabinetMaintenanceQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "导出抽屉柜维护保养记录.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        List<ElectricCabinetMaintenanceExportDto> exportList = electricCabinetMaintenanceService.listExportElectricCabinetMaintenances(queryParams);
        EasyExcel.write(response.getOutputStream(), ElectricCabinetMaintenanceExportDto.class).sheet("抽屉柜维护保养记录")
                .doWrite(exportList);
    }

    @Operation(summary = "导入抽屉柜维护保养记录")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-maintenance:import')")
    public Result<ExcelResult> importElectricCabinetMaintenances(MultipartFile file) throws IOException {
        ElectricCabinetMaintenanceImportListener listener = new ElectricCabinetMaintenanceImportListener();
        ExcelUtils.importExcel(file.getInputStream(), ElectricCabinetMaintenanceExportDto.class, listener);
        return Result.success(listener.getExcelResult());
    }

    @Operation(summary = "抽屉柜维护保养记录导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateElectricCabinetMaintenances(HttpServletResponse response) {
        String fileName = "抽屉柜维护保养记录导入模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("抽屉柜维护保养记录导入模板下载失败", e);
        }
    }
}
