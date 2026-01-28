package com.youlai.boot.ledger.controller;


import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.youlai.boot.common.annotation.Log;
import com.youlai.boot.common.enums.LogModuleEnum;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.core.web.PageResult;
import com.youlai.boot.core.web.Result;
import com.youlai.boot.ledger.model.form.PressureInstrumentForm;
import com.youlai.boot.ledger.model.query.PressureInstrumentQueryPlus;
import com.youlai.boot.ledger.model.vo.PressureInstrumentVO;
import com.youlai.boot.ledger.service.PressureInstrumentService;
import com.youlai.boot.ledger.model.dto.PressureInstrumentExportDTO;
import com.youlai.boot.ledger.listener.PressureInstrumentImportListener;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 压力前端控制层
 *
 * @author WY
 * @since 2026-1-7 16:00
 */
@Tag(name = "压力接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pressure-instrument")
public class PressureInstrumentController {

    private final PressureInstrumentService pressureInstrumentService;

    @Operation(summary = "压力分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:pressure-instrument:query')")
    @Log(value = "压力分页列表", module = LogModuleEnum.PRESSURE_INSTRUMENT)
    public PageResult<PressureInstrumentVO> getPressureInstrumentPage(PressureInstrumentQueryPlus queryParams) {
        IPage<PressureInstrumentVO> result = pressureInstrumentService.getPressureInstrumentPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增压力")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:pressure-instrument:add')")
    @Log(value = "新增压力表", module = LogModuleEnum.PRESSURE_INSTRUMENT)
    public Result<Void> savePressureInstrument(@RequestBody @Valid PressureInstrumentForm formData) {
        boolean result = pressureInstrumentService.savePressureInstrument(formData);
        return Result.judge(result);
    }


    @Operation(summary = "获取压力表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:pressure-instrument:edit')")
    @Log(value = "获取压力表单数据", module = LogModuleEnum.PRESSURE_INSTRUMENT)
    public Result<PressureInstrumentForm> getPressureInstrumentForm(
            @Parameter(description = "压力ID") @PathVariable Long id
    ) {
        PressureInstrumentForm formData = pressureInstrumentService.getPressureInstrumentFormData(id);
        return Result.success(formData);
    }


    @Operation(summary = "修改压力")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:pressure-instrument:edit')")
    @Log(value = "修改压力表", module = LogModuleEnum.PRESSURE_INSTRUMENT)
    public Result<Void> updatePressureInstrument(
            @Parameter(description = "压力ID") @PathVariable Long id,
            @RequestBody @Validated PressureInstrumentForm formData
    ) {
        boolean result = pressureInstrumentService.updatePressureInstrument(id, formData);
        return Result.judge(result);
    }


    @Operation(summary = "删除压力")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:pressure-instrument:delete')")
    @Log(value = "删除压力表", module = LogModuleEnum.PRESSURE_INSTRUMENT)
    public Result<Void> deletePressureInstrument(
            @Parameter(description = "压力ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = pressureInstrumentService.deletePressureInstrument(ids);
        return Result.judge(result);
    }


    @Operation(summary = "导出压力表")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:pressure-instrument:export')")
    @Log(value = "导出压力表", module = LogModuleEnum.PRESSURE_INSTRUMENT)
    public void exportPressureInstrument(PressureInstrumentQueryPlus queryParams, HttpServletResponse response) throws IOException {
        String fileName = "压力列表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        List<PressureInstrumentExportDTO> exportPressureInstrumentList = pressureInstrumentService.listExportPressureInstrument(queryParams);
        EasyExcel.write(response.getOutputStream(), PressureInstrumentExportDTO.class).sheet("压力列表")
                .doWrite(exportPressureInstrumentList);
    }


    @Operation(summary = "导入压力")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:pressure-instrument:import')")
    @Log(value = "导入压力", module = LogModuleEnum.PRESSURE_INSTRUMENT)
    public Result<ExcelResult> importUsers(MultipartFile file) throws IOException {

        PressureInstrumentImportListener listener = new PressureInstrumentImportListener();
        ExcelUtils.importExcel(file.getInputStream(), PressureInstrumentExportDTO.class, listener);
        return Result.success(listener.getExcelResult());

    }


    @Operation(summary = "压力表导入模板下载")
    @GetMapping("/template")
    @Log(value = "压力表导入模板下载", module = LogModuleEnum.PRESSURE_INSTRUMENT)
    public void downloadTemplate(HttpServletResponse response) {
        String fileName = "压力表导入模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("压力表导入模板下载失败", e);
        }
    }


}

