package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.annotation.Log;
import com.youlai.boot.common.enums.LogModuleEnum;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.LevelGaugeImportListener;
import com.youlai.boot.ledger.listener.SpecEqpCraneTransAccountsImportListener;
import com.youlai.boot.ledger.model.dto.LevelGaugeExportDto;
import com.youlai.boot.ledger.model.dto.SpecEqpCraneTransAccountsExportDto;
import com.youlai.boot.ledger.model.query.LevelGaugeExportQuery;
import com.youlai.boot.ledger.service.SpecEqpCraneTransAccountService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SpecEqpCraneTransAccountForm;
import com.youlai.boot.ledger.model.query.SpecEqpCraneTransAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpCraneTransAccountVO;
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
 * 起重运输类前端控制层
 *
 * @author baiwei
 * @since 2026-02-03 09:22
 */
@Tag(name = "起重运输类接口")
@RestController
@RequestMapping("/api/v1/spec-eqp-crane-trans-account")
@RequiredArgsConstructor
public class SpecEqpCraneTransAccountController  {

    private final SpecEqpCraneTransAccountService specEqpCraneTransAccountService;

    @Operation(summary = "起重运输类分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-crane-trans-account:query')")
    public PageResult<SpecEqpCraneTransAccountVO> getSpecEqpCraneTransAccountPage(SpecEqpCraneTransAccountQuery queryParams ) {
        IPage<SpecEqpCraneTransAccountVO> result = specEqpCraneTransAccountService.getSpecEqpCraneTransAccountPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增起重运输类")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-crane-trans-account:add')")
    public Result<Void> saveSpecEqpCraneTransAccount(@RequestBody @Valid SpecEqpCraneTransAccountForm formData ) {
        boolean result = specEqpCraneTransAccountService.saveSpecEqpCraneTransAccount(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取起重运输类表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-crane-trans-account:edit')")
    public Result<SpecEqpCraneTransAccountForm> getSpecEqpCraneTransAccountForm(
        @Parameter(description = "起重运输类ID") @PathVariable Long id
    ) {
        SpecEqpCraneTransAccountForm formData = specEqpCraneTransAccountService.getSpecEqpCraneTransAccountFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改起重运输类")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-crane-trans-account:edit')")
    public Result<Void> updateSpecEqpCraneTransAccount(
            @Parameter(description = "起重运输类ID") @PathVariable Long id,
            @RequestBody @Validated SpecEqpCraneTransAccountForm formData
    ) {
        boolean result = specEqpCraneTransAccountService.updateSpecEqpCraneTransAccount(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除起重运输类")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-crane-trans-account:delete')")
    public Result<Void> deleteSpecEqpCraneTransAccounts(
        @Parameter(description = "起重运输类ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = specEqpCraneTransAccountService.deleteSpecEqpCraneTransAccounts(ids);
        return Result.judge(result);
    }


    @Operation(summary = "导出起重运输类")
    @GetMapping("/export")
    public void exportSpecEqpCraneTransAccounts(SpecEqpCraneTransAccountQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "起重运输类";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SpecEqpCraneTransAccountsExportDto> listExportSpecEqpCraneTransAccounts = specEqpCraneTransAccountService.listExportSpecEqpCraneTransAccounts(queryParams);
        EasyExcel.write(response.getOutputStream(), SpecEqpCraneTransAccountsExportDto.class).sheet("导出起重运输类")
                .doWrite(listExportSpecEqpCraneTransAccounts);
    }


    @Operation(summary = "导入起重运输类")
    @PostMapping("/import")
    public Result<ExcelResult> importSpecEqpCraneTransAccounts(MultipartFile file) throws IOException {
        SpecEqpCraneTransAccountsImportListener listener = new SpecEqpCraneTransAccountsImportListener();
        ExcelUtils.importExcel(file.getInputStream(), SpecEqpCraneTransAccountsExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "起重运输类导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateSpecEqpCraneTransAccounts(HttpServletResponse response) {
        String fileName = "起重运输类导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("起重运输类导入模板下载失败", e);
        }
    }


}
