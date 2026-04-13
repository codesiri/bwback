package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.ElectricLightEquipmentListener;
import com.youlai.boot.ledger.model.dto.ElectricLightEquipmentDto;
import com.youlai.boot.ledger.model.dto.LevelGaugeExportDto;
import com.youlai.boot.ledger.model.query.ElectricLightEquipmentExportQuery;
import com.youlai.boot.ledger.service.ElectricLightEquipmentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ElectricLightEquipmentForm;
import com.youlai.boot.ledger.model.query.ElectricLightEquipmentQuery;
import com.youlai.boot.ledger.model.vo.ElectricLightEquipmentVO;
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
 * 电气照明设备前端控制层
 *
 * @author dazao
 * @since 2026-02-04 09:24
 */
@Tag(name = "电气照明设备接口")
@RestController
@RequestMapping("/api/v1/electric-light-equipment")
@RequiredArgsConstructor
public class ElectricLightEquipmentController  {

    private final ElectricLightEquipmentService electricLightEquipmentService;

    @Operation(summary = "电气照明设备分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:electric-light-equipment:query')")
    public PageResult<ElectricLightEquipmentVO> getElectricLightEquipmentPage(ElectricLightEquipmentQuery queryParams ) {
        IPage<ElectricLightEquipmentVO> result = electricLightEquipmentService.getElectricLightEquipmentPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增电气照明设备")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:electric-light-equipment:add')")
    public Result<Void> saveElectricLightEquipment(@RequestBody @Valid ElectricLightEquipmentForm formData ) {
        boolean result = electricLightEquipmentService.saveElectricLightEquipment(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取电气照明设备表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:electric-light-equipment:edit')")
    public Result<ElectricLightEquipmentForm> getElectricLightEquipmentForm(
        @Parameter(description = "电气照明设备ID") @PathVariable Long id
    ) {
        ElectricLightEquipmentForm formData = electricLightEquipmentService.getElectricLightEquipmentFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改电气照明设备")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-light-equipment:edit')")
    public Result<Void> updateElectricLightEquipment(
            @Parameter(description = "电气照明设备ID") @PathVariable Long id,
            @RequestBody @Validated ElectricLightEquipmentForm formData
    ) {
        boolean result = electricLightEquipmentService.updateElectricLightEquipment(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除电气照明设备")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-light-equipment:delete')")
    public Result<Void> deleteElectricLightEquipments(
        @Parameter(description = "电气照明设备ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = electricLightEquipmentService.deleteElectricLightEquipments(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出电气照明设备")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:electric-light-equipment:query')")
    public void exportElectricLightEquipment(ElectricLightEquipmentExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "电气照明设备表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<ElectricLightEquipmentDto> exportElectricLightEquipment = this
                .electricLightEquipmentService
                .exportElectricLightEquipment(queryParams);
        EasyExcel.write(response.getOutputStream(), ElectricLightEquipmentDto.class).sheet("电气照明设备表")
                .doWrite(exportElectricLightEquipment);
    }
    @Operation(summary = "导入电气照明设备")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:electric-light-equipment:add')")
    public Result<ExcelResult> importElectricLightEquipment(MultipartFile file) throws IOException {
        ElectricLightEquipmentListener electricLightEquipmentListener = new ElectricLightEquipmentListener();
        ExcelUtils.importExcel(file.getInputStream(), ElectricLightEquipmentDto.class,electricLightEquipmentListener);
        return Result.success(electricLightEquipmentListener.getExcelResult());
    }
}
