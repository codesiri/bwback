package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.SeHeaterImportListener;
import com.youlai.boot.ledger.listener.SpecEqpVerticalTankAccountImportListener;
import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SpecEqpVerticalTankAccountExportDto;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.service.SpecEqpVerticalTankAccountService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SpecEqpVerticalTankAccountForm;
import com.youlai.boot.ledger.model.query.SpecEqpVerticalTankAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpVerticalTankAccountVO;
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
 * 立罐前端控制层
 *
 * @author baiwei
 * @since 2026-03-06 10:04
 */
@Tag(name = "立罐接口")
@RestController
@RequestMapping("/api/v1/spec-eqp-vertical-tank-account")
@RequiredArgsConstructor
public class SpecEqpVerticalTankAccountController  {

    private final SpecEqpVerticalTankAccountService specEqpVerticalTankAccountService;

    @Operation(summary = "立罐分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-vertical-tank-account:query')")
    public PageResult<SpecEqpVerticalTankAccountVO> getSpecEqpVerticalTankAccountPage(SpecEqpVerticalTankAccountQuery queryParams ) {
        IPage<SpecEqpVerticalTankAccountVO> result = specEqpVerticalTankAccountService.getSpecEqpVerticalTankAccountPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增立罐")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-vertical-tank-account:add')")
    public Result<Void> saveSpecEqpVerticalTankAccount(@RequestBody @Valid SpecEqpVerticalTankAccountForm formData ) {
        boolean result = specEqpVerticalTankAccountService.saveSpecEqpVerticalTankAccount(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取立罐表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-vertical-tank-account:edit')")
    public Result<SpecEqpVerticalTankAccountForm> getSpecEqpVerticalTankAccountForm(
        @Parameter(description = "立罐ID") @PathVariable Long id
    ) {
        SpecEqpVerticalTankAccountForm formData = specEqpVerticalTankAccountService.getSpecEqpVerticalTankAccountFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改立罐")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-vertical-tank-account:edit')")
    public Result<Void> updateSpecEqpVerticalTankAccount(
            @Parameter(description = "立罐ID") @PathVariable Long id,
            @RequestBody @Validated SpecEqpVerticalTankAccountForm formData
    ) {
        boolean result = specEqpVerticalTankAccountService.updateSpecEqpVerticalTankAccount(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除立罐")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-vertical-tank-account:delete')")
    public Result<Void> deleteSpecEqpVerticalTankAccounts(
        @Parameter(description = "立罐ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = specEqpVerticalTankAccountService.deleteSpecEqpVerticalTankAccounts(ids);
        return Result.judge(result);
    }


    @Operation(summary = "导出立罐")
    @GetMapping("/export")
    public void exportSpecEqpVerticalTankAccount(SpecEqpVerticalTankAccountQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "立罐";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SpecEqpVerticalTankAccountExportDto> listExportSpecEqpVerticalTankAccounts = specEqpVerticalTankAccountService.listExportSpecEqpVerticalTankAccount(queryParams);
        EasyExcel.write(response.getOutputStream(), SpecEqpVerticalTankAccountExportDto.class).sheet("立罐")
                .doWrite(listExportSpecEqpVerticalTankAccounts);
    }


    @Operation(summary = "导入立罐")
    @PostMapping("/import")
    public Result<ExcelResult> importSpecEqpVerticalTankAccounts(MultipartFile file) throws IOException {
        SpecEqpVerticalTankAccountImportListener listener = new SpecEqpVerticalTankAccountImportListener();
        ExcelUtils.importExcel(file.getInputStream(), SpecEqpVerticalTankAccountExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "立罐导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateSeHeater(HttpServletResponse response) {
        String fileName = "立罐导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("立罐导入模板下载失败", e);
        }
    }



}
