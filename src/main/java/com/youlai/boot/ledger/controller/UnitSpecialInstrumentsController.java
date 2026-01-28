package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.annotation.Log;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.UnitSpecialInstrumentImportListener;
import com.youlai.boot.ledger.model.dto.UnitSpecialInstrumentsExportDto;
import com.youlai.boot.ledger.model.query.UnitSpecialInstrumentsQueryExport;
import com.youlai.boot.ledger.service.UnitSpecialInstrumentsService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.UnitSpecialInstrumentsForm;
import com.youlai.boot.ledger.model.query.UnitSpecialInstrumentsQuery;
import com.youlai.boot.ledger.model.vo.UnitSpecialInstrumentsVO;
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
 * 机组特殊仪前端控制层
 *
 * @author dazao
 * @since 2026-01-21 09:01
 */
@Tag(name = "机组特殊仪接口")
@RestController
@RequestMapping("/api/v1/unit-special-instruments")
@RequiredArgsConstructor
public class UnitSpecialInstrumentsController  {

    private final UnitSpecialInstrumentsService unitSpecialInstrumentsService;

    @Operation(summary = "机组特殊仪分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:unit-special-instruments:query')")
    public PageResult<UnitSpecialInstrumentsVO> getUnitSpecialInstrumentsPage(UnitSpecialInstrumentsQuery queryParams ) {
        IPage<UnitSpecialInstrumentsVO> result = unitSpecialInstrumentsService.getUnitSpecialInstrumentsPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增机组特殊仪")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:unit-special-instruments:add')")
    public Result<Void> saveUnitSpecialInstruments(@RequestBody @Valid UnitSpecialInstrumentsForm formData ) {
        boolean result = unitSpecialInstrumentsService.saveUnitSpecialInstruments(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取机组特殊仪表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:unit-special-instruments:edit')")
    public Result<UnitSpecialInstrumentsForm> getUnitSpecialInstrumentsForm(
        @Parameter(description = "机组特殊仪ID") @PathVariable Long id
    ) {
        UnitSpecialInstrumentsForm formData = unitSpecialInstrumentsService.getUnitSpecialInstrumentsFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改机组特殊仪")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:unit-special-instruments:edit')")
    public Result<Void> updateUnitSpecialInstruments(
            @Parameter(description = "机组特殊仪ID") @PathVariable Long id,
            @RequestBody @Validated UnitSpecialInstrumentsForm formData
    ) {
        boolean result = unitSpecialInstrumentsService.updateUnitSpecialInstruments(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除机组特殊仪")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:unit-special-instruments:delete')")
    public Result<Void> deleteUnitSpecialInstrumentss(
        @Parameter(description = "机组特殊仪ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = unitSpecialInstrumentsService.deleteUnitSpecialInstrumentss(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出机组特殊仪表")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:unit-special-instruments:export')")
    public void exportUnitSpecialInstruments(UnitSpecialInstrumentsQueryExport queryParams, HttpServletResponse response) throws IOException {
        String fileName = "导出机组特殊仪表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        List<UnitSpecialInstrumentsExportDto> exportUnitSpecialInstrumentList = unitSpecialInstrumentsService.listExportUnitSpecialInstrument(queryParams);
        EasyExcel.write(response.getOutputStream(), UnitSpecialInstrumentsExportDto.class).sheet("动设备")
                .doWrite(exportUnitSpecialInstrumentList);
    }

    @Operation(summary = "导出机组特殊仪表模板下载.xlsx")
    @GetMapping("/template")
    public void downloadTemplate(HttpServletResponse response){
        String fileName = "机组特殊仪表导入模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);
        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("机组特殊仪表导入模板下载失败", e);
        }
    }

    @Operation(summary = "导入机组特殊仪表")
    @PostMapping("/import")
    public Result<ExcelResult> importUnitSpecialInstrument(MultipartFile file) throws IOException {
        UnitSpecialInstrumentImportListener listener = new UnitSpecialInstrumentImportListener();
        ExcelUtils.importExcel(file.getInputStream(), UnitSpecialInstrumentsExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }

}
