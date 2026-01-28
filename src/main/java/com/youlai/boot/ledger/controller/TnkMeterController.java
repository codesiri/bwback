package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.TnkMeterImportListener;
import com.youlai.boot.ledger.model.dto.PressureInstrumentExportDTO;
import com.youlai.boot.ledger.model.dto.TnkMeterExportDto;
import com.youlai.boot.ledger.model.query.TnkMeterExportQuery;
import com.youlai.boot.ledger.service.TnkMeterService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.TnkMeterForm;
import com.youlai.boot.ledger.model.query.TnkMeterQuery;
import com.youlai.boot.ledger.model.vo.TnkMeterVO;
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
 * 罐区仪前端控制层
 *
 * @author dazao
 * @since 2026-01-20 08:17
 */
@Tag(name = "罐区仪接口")
@RestController
@RequestMapping("/api/v1/tnk-meter")
@RequiredArgsConstructor
public class TnkMeterController {

    private final TnkMeterService tnkMeterService;

    @Operation(summary = "罐区仪分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:tnk-meter:query')")
    public PageResult<TnkMeterVO> getTnkMeterPage(TnkMeterQuery queryParams) {
        IPage<TnkMeterVO> result = tnkMeterService.getTnkMeterPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增罐区仪")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:tnk-meter:add')")
    public Result<Void> saveTnkMeter(@RequestBody @Valid TnkMeterForm formData) {
        boolean result = tnkMeterService.saveTnkMeter(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取罐区仪表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:tnk-meter:edit')")
    public Result<TnkMeterForm> getTnkMeterForm(
            @Parameter(description = "罐区仪ID") @PathVariable Long id
    ) {
        TnkMeterForm formData = tnkMeterService.getTnkMeterFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改罐区仪")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:tnk-meter:edit')")
    public Result<Void> updateTnkMeter(
            @Parameter(description = "罐区仪ID") @PathVariable Long id,
            @RequestBody @Validated TnkMeterForm formData
    ) {
        boolean result = tnkMeterService.updateTnkMeter(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除罐区仪")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:tnk-meter:delete')")
    public Result<Void> deleteTnkMeters(
            @Parameter(description = "罐区仪ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = tnkMeterService.deleteTnkMeters(ids);
        return Result.judge(result);
    }

    @Operation(summary = "罐区仪导出")
    @GetMapping("/export")
    public void exportTnkMeters(TnkMeterExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "罐区仪表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<TnkMeterExportDto> tnkMeterExportDtoList = tnkMeterService.listExportTnkMeters(queryParams);
        EasyExcel.write(response.getOutputStream(), TnkMeterExportDto.class).sheet("罐区仪列表")
                .doWrite(tnkMeterExportDtoList);
    }

    @Operation(summary = "罐区仪导入模板下载")
    @GetMapping("/template")
    public void templateTnkMeters(HttpServletResponse response) {
        String fileName = "罐区仪表导入模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("罐区仪表导入模板下载失败", e);
        }
    }

    @Operation(summary = "罐区仪导入文件")
    @PostMapping("/import")
    public Result<ExcelResult> importTnkMeters(MultipartFile file) throws IOException {
        TnkMeterImportListener tnkMeterImportListener = new TnkMeterImportListener();
        ExcelUtils.importExcel(file.getInputStream(), TnkMeterExportDto.class, tnkMeterImportListener);
        return Result.success(tnkMeterImportListener.getExcelResult());
    }
}