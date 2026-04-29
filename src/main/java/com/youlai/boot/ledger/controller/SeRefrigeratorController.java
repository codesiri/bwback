package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.SePumpImportListener;
import com.youlai.boot.ledger.listener.SeRefrigeratorImportListener;
import com.youlai.boot.ledger.model.dto.SePumpExportDto;
import com.youlai.boot.ledger.model.dto.SeRefrigeratorExportDto;
import com.youlai.boot.ledger.model.query.SePumpQuery;
import com.youlai.boot.ledger.service.SeRefrigeratorService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SeRefrigeratorForm;
import com.youlai.boot.ledger.model.query.SeRefrigeratorQuery;
import com.youlai.boot.ledger.model.vo.SeRefrigeratorVO;
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
 * 特种设备制冷机台账前端控制层
 *
 * @author baiwei
 * @since 2026-02-14 08:38
 */
@Tag(name = "特种设备制冷机台账接口")
@RestController
@RequestMapping("/api/v1/se-refrigerator")
@RequiredArgsConstructor
public class SeRefrigeratorController  {

    private final SeRefrigeratorService seRefrigeratorService;

    @Operation(summary = "特种设备制冷机台账分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:se-refrigerator:query')")
    public PageResult<SeRefrigeratorVO> getSeRefrigeratorPage(SeRefrigeratorQuery queryParams ) {
        IPage<SeRefrigeratorVO> result = seRefrigeratorService.getSeRefrigeratorPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增特种设备制冷机台账")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:se-refrigerator:add')")
    public Result<Void> saveSeRefrigerator(@RequestBody @Valid SeRefrigeratorForm formData ) {
        boolean result = seRefrigeratorService.saveSeRefrigerator(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取特种设备制冷机台账表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:se-refrigerator:edit')")
    public Result<SeRefrigeratorForm> getSeRefrigeratorForm(
        @Parameter(description = "特种设备制冷机台账ID") @PathVariable Long id
    ) {
        SeRefrigeratorForm formData = seRefrigeratorService.getSeRefrigeratorFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改特种设备制冷机台账")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:se-refrigerator:edit')")
    public Result<Void> updateSeRefrigerator(
            @Parameter(description = "特种设备制冷机台账ID") @PathVariable Long id,
            @RequestBody @Validated SeRefrigeratorForm formData
    ) {
        boolean result = seRefrigeratorService.updateSeRefrigerator(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除特种设备制冷机台账")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:se-refrigerator:delete')")
    public Result<Void> deleteSeRefrigerators(
        @Parameter(description = "特种设备制冷机台账ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = seRefrigeratorService.deleteSeRefrigerators(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出制冷机")
    @GetMapping("/export")
    public void exportSeRefrigerators(SeRefrigeratorQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "制冷机";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SeRefrigeratorExportDto> listExportSeRefrigerators = seRefrigeratorService.listExportSeRefrigerators(queryParams);
        EasyExcel.write(response.getOutputStream(), SeRefrigeratorExportDto.class).sheet("导出制冷机")
                .doWrite(listExportSeRefrigerators);
    }

    @Operation(summary = "导入制冷机")
    @PostMapping("/import")
    public Result<ExcelResult> importSeRefrigerator(MultipartFile file) throws IOException {
        SeRefrigeratorImportListener listener = new SeRefrigeratorImportListener();
        ExcelUtils.importExcel(file.getInputStream(), SeRefrigeratorExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "制冷机导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateSeRefrigerator(HttpServletResponse response) {
        String fileName = "制冷机导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("制冷机导入模板下载失败", e);
        }
    }



}
