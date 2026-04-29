package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.SeHeaterImportListener;
import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.service.SeHeaterService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SeHeaterForm;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.model.vo.SeHeaterVO;
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
 * 换热器前端控制层
 *
 * @author baiwei
 * @since 2026-03-03 10:16
 */
@Tag(name = "换热器接口")
@RestController
@RequestMapping("/api/v1/se-heater")
@RequiredArgsConstructor
public class SeHeaterController  {

    private final SeHeaterService seHeaterService;

    @Operation(summary = "换热器分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:se-heater:query')")
    public PageResult<SeHeaterVO> getSeHeaterPage(SeHeaterQuery queryParams ) {
        IPage<SeHeaterVO> result = seHeaterService.getSeHeaterPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增换热器")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:se-heater:add')")
    public Result<Void> saveSeHeater(@RequestBody @Valid SeHeaterForm formData ) {
        boolean result = seHeaterService.saveSeHeater(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取换热器表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:se-heater:edit')")
    public Result<SeHeaterForm> getSeHeaterForm(
        @Parameter(description = "换热器ID") @PathVariable Long id
    ) {
        SeHeaterForm formData = seHeaterService.getSeHeaterFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改换热器")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:se-heater:edit')")
    public Result<Void> updateSeHeater(
            @Parameter(description = "换热器ID") @PathVariable Long id,
            @RequestBody @Validated SeHeaterForm formData
    ) {
        boolean result = seHeaterService.updateSeHeater(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除换热器")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:se-heater:delete')")
    public Result<Void> deleteSeHeaters(
        @Parameter(description = "换热器ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = seHeaterService.deleteSeHeaters(ids);
        return Result.judge(result);
    }


    @Operation(summary = "导出换热器")
    @GetMapping("/export")
    public void exportSeHeaters(SeHeaterQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "换热器";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SeHeaterExportDto> listExportSeHeaters = seHeaterService.listExportSeHeater(queryParams);
        EasyExcel.write(response.getOutputStream(), SeHeaterExportDto.class).sheet("导出换热器")
                .doWrite(listExportSeHeaters);
    }


    @Operation(summary = "导入换热器")
    @PostMapping("/import")
    public Result<ExcelResult> importSeHeaters(MultipartFile file) throws IOException {
        SeHeaterImportListener listener = new SeHeaterImportListener();
        ExcelUtils.importExcel(file.getInputStream(), SeHeaterExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "换热器导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateSeHeater(HttpServletResponse response) {
        String fileName = "换热器导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("换热器导入模板下载失败", e);
        }
    }



}
