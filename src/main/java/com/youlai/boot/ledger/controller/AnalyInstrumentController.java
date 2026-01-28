package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.AnalyInstrumentImportListener;
import com.youlai.boot.ledger.listener.DvFlowmetreInfoImportListener;
import com.youlai.boot.ledger.model.dto.AnalyInstrumentExportDto;
import com.youlai.boot.ledger.model.dto.DvFlowmetreInfoExportDto;
import com.youlai.boot.ledger.model.query.AnalyInstrumentExportQuery;
import com.youlai.boot.ledger.service.AnalyInstrumentService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.AnalyInstrumentForm;
import com.youlai.boot.ledger.model.query.AnalyInstrumentQuery;
import com.youlai.boot.ledger.model.vo.AnalyInstrumentVO;
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
 * 分析仪前端控制层
 *
 * @author dazao
 * @since 2026-01-23 14:48
 */
@Tag(name = "分析仪接口")
@RestController
@RequestMapping("/api/v1/analy-instrument")
@RequiredArgsConstructor
public class AnalyInstrumentController {

    private final AnalyInstrumentService analyInstrumentService;

    @Operation(summary = "分析仪分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:analy-instrument:query')")
    public PageResult<AnalyInstrumentVO> getAnalyInstrumentPage(AnalyInstrumentQuery queryParams) {
        IPage<AnalyInstrumentVO> result = analyInstrumentService.getAnalyInstrumentPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增分析仪")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:analy-instrument:add')")
    public Result<Void> saveAnalyInstrument(@RequestBody @Valid AnalyInstrumentForm formData) {
        boolean result = analyInstrumentService.saveAnalyInstrument(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取分析仪表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:analy-instrument:edit')")
    public Result<AnalyInstrumentForm> getAnalyInstrumentForm(
            @Parameter(description = "分析仪ID") @PathVariable Long id
    ) {
        AnalyInstrumentForm formData = analyInstrumentService.getAnalyInstrumentFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改分析仪")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:analy-instrument:edit')")
    public Result<Void> updateAnalyInstrument(
            @Parameter(description = "分析仪ID") @PathVariable Long id,
            @RequestBody @Validated AnalyInstrumentForm formData
    ) {
        boolean result = analyInstrumentService.updateAnalyInstrument(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除分析仪")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:analy-instrument:delete')")
    public Result<Void> deleteAnalyInstruments(
            @Parameter(description = "分析仪ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = analyInstrumentService.deleteAnalyInstruments(ids);
        return Result.judge(result);
    }

    @Operation(summary = "分析仪表导入模板下载")
    @GetMapping("/template")
    public void downTemplate(HttpServletResponse response) {
        String fileName = "分析仪表模板.xslx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);
        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("分析仪表导入模板下载失败", e);
        }
    }

    @Operation(summary = "导出分析仪表")
    @GetMapping("/export")
    public void exportTable(AnalyInstrumentExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "分析仪表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<AnalyInstrumentExportDto> listExportAnalyInstrument = this.analyInstrumentService.listExportAnalyInstrument(queryParams);
        EasyExcel.write(response.getOutputStream(), AnalyInstrumentExportDto.class).sheet("分析仪表")
                .doWrite(listExportAnalyInstrument);
    }
    @Operation(summary = "导入分析仪表")
    @PostMapping("/import")
    public Result<ExcelResult> importAnalyInstrument(MultipartFile file) throws IOException {
        AnalyInstrumentImportListener listener = new AnalyInstrumentImportListener();
        ExcelUtils.importExcel(file.getInputStream(), AnalyInstrumentExportDto.class, listener);
        return Result.success(listener.getExcelResult());
    }
}



