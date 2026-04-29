package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.SeExpanderImportListener;
import com.youlai.boot.ledger.listener.SePumpImportListener;
import com.youlai.boot.ledger.model.dto.SeExpanderExportDto;
import com.youlai.boot.ledger.model.dto.SePumpExportDto;
import com.youlai.boot.ledger.model.query.SePumpQuery;
import com.youlai.boot.ledger.service.SeExpanderService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SeExpanderForm;
import com.youlai.boot.ledger.model.query.SeExpanderQuery;
import com.youlai.boot.ledger.model.vo.SeExpanderVO;
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
 * 特种设备膨胀机台账前端控制层
 *
 * @author baiwei
 * @since 2026-02-09 09:15
 */
@Tag(name = "特种设备膨胀机台账接口")
@RestController
@RequestMapping("/api/v1/se-expander")
@RequiredArgsConstructor
public class SeExpanderController  {

    private final SeExpanderService seExpanderService;

    @Operation(summary = "特种设备膨胀机台账分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:se-expander:query')")
    public PageResult<SeExpanderVO> getSeExpanderPage(SeExpanderQuery queryParams ) {
        IPage<SeExpanderVO> result = seExpanderService.getSeExpanderPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增特种设备膨胀机台账")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:se-expander:add')")
    public Result<Void> saveSeExpander(@RequestBody @Valid SeExpanderForm formData ) {
        boolean result = seExpanderService.saveSeExpander(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取特种设备膨胀机台账表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:se-expander:edit')")
    public Result<SeExpanderForm> getSeExpanderForm(
        @Parameter(description = "特种设备膨胀机台账ID") @PathVariable Long id
    ) {
        SeExpanderForm formData = seExpanderService.getSeExpanderFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改特种设备膨胀机台账")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:se-expander:edit')")
    public Result<Void> updateSeExpander(
            @Parameter(description = "特种设备膨胀机台账ID") @PathVariable Long id,
            @RequestBody @Validated SeExpanderForm formData
    ) {
        boolean result = seExpanderService.updateSeExpander(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除特种设备膨胀机台账")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:se-expander:delete')")
    public Result<Void> deleteSeExpanders(
        @Parameter(description = "特种设备膨胀机台账ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = seExpanderService.deleteSeExpanders(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出膨胀机")
    @GetMapping("/export")
    public void exportSePumps(SeExpanderQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "膨胀机台账";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SeExpanderExportDto> listExportSeExpander = seExpanderService.listExportSeExpander(queryParams);
        EasyExcel.write(response.getOutputStream(), SeExpanderExportDto.class).sheet("导出膨胀机")
                .doWrite(listExportSeExpander);
    }

    @Operation(summary = "导入膨胀机")
    @PostMapping("/import")
    public Result<ExcelResult> importSeExpander(MultipartFile file) throws IOException {
        SeExpanderImportListener listener = new SeExpanderImportListener();
        ExcelUtils.importExcel(file.getInputStream(), SeExpanderExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "膨胀机导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateSeExpander(HttpServletResponse response) {
        String fileName = "膨胀机导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("膨胀机导入模板下载失败", e);
        }
    }




}
