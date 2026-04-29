package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.SePumpImportListener;
import com.youlai.boot.ledger.model.dto.SePumpExportDto;
import com.youlai.boot.ledger.service.SePumpService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SePumpForm;
import com.youlai.boot.ledger.model.query.SePumpQuery;
import com.youlai.boot.ledger.model.vo.SePumpVO;
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
 * 泵前端控制层
 *
 * @author baiwei
 * @since 2026-02-05 14:46
 */
@Tag(name = "泵接口")
@RestController
@RequestMapping("/api/v1/se-pump")
@RequiredArgsConstructor
public class SePumpController  {

    private final SePumpService sePumpService;

    @Operation(summary = "泵分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:se-pump:query')")
    public PageResult<SePumpVO> getSePumpPage(SePumpQuery queryParams ) {
        IPage<SePumpVO> result = sePumpService.getSePumpPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增泵")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:se-pump:add')")
    public Result<Void> saveSePump(@RequestBody @Valid SePumpForm formData ) {
        boolean result = sePumpService.saveSePump(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取泵表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:se-pump:edit')")
    public Result<SePumpForm> getSePumpForm(
        @Parameter(description = "泵ID") @PathVariable Long id
    ) {
        SePumpForm formData = sePumpService.getSePumpFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改泵")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:se-pump:edit')")
    public Result<Void> updateSePump(
            @Parameter(description = "泵ID") @PathVariable Long id,
            @RequestBody @Validated SePumpForm formData
    ) {
        boolean result = sePumpService.updateSePump(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除泵")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:se-pump:delete')")
    public Result<Void> deleteSePumps(
        @Parameter(description = "泵ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = sePumpService.deleteSePumps(ids);
        return Result.judge(result);
    }


    @Operation(summary = "导出泵")
    @GetMapping("/export")
    public void exportSePumps(SePumpQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "泵";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SePumpExportDto> listExportSePumps = sePumpService.listExportSePumps(queryParams);
        EasyExcel.write(response.getOutputStream(), SePumpExportDto.class).sheet("导出泵")
                .doWrite(listExportSePumps);
    }


    @Operation(summary = "导入泵")
    @PostMapping("/import")
    public Result<ExcelResult> importSePump(MultipartFile file) throws IOException {
        SePumpImportListener listener = new SePumpImportListener();
        ExcelUtils.importExcel(file.getInputStream(), SePumpExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "泵导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateSePump(HttpServletResponse response) {
        String fileName = "泵导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("泵导入模板下载失败", e);
        }
    }




}
