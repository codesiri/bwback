package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.SeCompressorImportListener;
import com.youlai.boot.ledger.listener.SePumpImportListener;
import com.youlai.boot.ledger.model.dto.SeCompressorExportDto;
import com.youlai.boot.ledger.model.dto.SePumpExportDto;
import com.youlai.boot.ledger.model.query.SePumpQuery;
import com.youlai.boot.ledger.service.SeCompressorService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SeCompressorForm;
import com.youlai.boot.ledger.model.query.SeCompressorQuery;
import com.youlai.boot.ledger.model.vo.SeCompressorVO;
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
 * 特种设备压缩机台账前端控制层
 *
 * @author baiwei
 * @since 2026-02-09 09:07
 */
@Tag(name = "特种设备压缩机台账接口")
@RestController
@RequestMapping("/api/v1/se-compressor")
@RequiredArgsConstructor
public class SeCompressorController  {

    private final SeCompressorService seCompressorService;

    @Operation(summary = "特种设备压缩机台账分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:se-compressor:query')")
    public PageResult<SeCompressorVO> getSeCompressorPage(SeCompressorQuery queryParams ) {
        IPage<SeCompressorVO> result = seCompressorService.getSeCompressorPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增特种设备压缩机台账")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:se-compressor:add')")
    public Result<Void> saveSeCompressor(@RequestBody @Valid SeCompressorForm formData ) {
        boolean result = seCompressorService.saveSeCompressor(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取特种设备压缩机台账表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:se-compressor:edit')")
    public Result<SeCompressorForm> getSeCompressorForm(
        @Parameter(description = "特种设备压缩机台账ID") @PathVariable Long id
    ) {
        SeCompressorForm formData = seCompressorService.getSeCompressorFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改特种设备压缩机台账")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:se-compressor:edit')")
    public Result<Void> updateSeCompressor(
            @Parameter(description = "特种设备压缩机台账ID") @PathVariable Long id,
            @RequestBody @Validated SeCompressorForm formData
    ) {
        boolean result = seCompressorService.updateSeCompressor(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除特种设备压缩机台账")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:se-compressor:delete')")
    public Result<Void> deleteSeCompressors(
        @Parameter(description = "特种设备压缩机台账ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = seCompressorService.deleteSeCompressors(ids);
        return Result.judge(result);
    }



    @Operation(summary = "导出压缩机")
    @GetMapping("/export")
    public void exportSePumps(SeCompressorQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "压缩机";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SeCompressorExportDto> listExportSeCompressor = seCompressorService.listExportSeCompressor(queryParams);
        EasyExcel.write(response.getOutputStream(), SeCompressorExportDto.class).sheet("导出压缩机")
                .doWrite(listExportSeCompressor);
    }

    @Operation(summary = "导入压缩机")
    @PostMapping("/import")
    public Result<ExcelResult> importSeCompressor(MultipartFile file) throws IOException {
        SeCompressorImportListener listener = new SeCompressorImportListener();
        ExcelUtils.importExcel(file.getInputStream(), SeCompressorExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "压缩机导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateSeCompressor(HttpServletResponse response) {
        String fileName = "压缩机导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("压缩机导入模板下载失败", e);
        }

    }






}
