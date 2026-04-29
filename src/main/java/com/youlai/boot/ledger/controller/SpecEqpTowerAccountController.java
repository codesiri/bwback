package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.SeHeaterImportListener;
import com.youlai.boot.ledger.listener.SpecEqpTowerAccountImportListener;
import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SpecEqpTowerAccountExportDto;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.service.SpecEqpTowerAccountService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SpecEqpTowerAccountForm;
import com.youlai.boot.ledger.model.query.SpecEqpTowerAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpTowerAccountVO;
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
 * 塔类前端控制层
 *
 * @author baiwei
 * @since 2026-03-06 09:57
 */
@Tag(name = "塔类接口")
@RestController
@RequestMapping("/api/v1/spec-eqp-tower-account")
@RequiredArgsConstructor
public class SpecEqpTowerAccountController  {

    private final SpecEqpTowerAccountService specEqpTowerAccountService;

    @Operation(summary = "塔类分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-tower-account:query')")
    public PageResult<SpecEqpTowerAccountVO> getSpecEqpTowerAccountPage(SpecEqpTowerAccountQuery queryParams ) {
        IPage<SpecEqpTowerAccountVO> result = specEqpTowerAccountService.getSpecEqpTowerAccountPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增塔类")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-tower-account:add')")
    public Result<Void> saveSpecEqpTowerAccount(@RequestBody @Valid SpecEqpTowerAccountForm formData ) {
        boolean result = specEqpTowerAccountService.saveSpecEqpTowerAccount(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取塔类表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-tower-account:edit')")
    public Result<SpecEqpTowerAccountForm> getSpecEqpTowerAccountForm(
        @Parameter(description = "塔类ID") @PathVariable Long id
    ) {
        SpecEqpTowerAccountForm formData = specEqpTowerAccountService.getSpecEqpTowerAccountFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改塔类")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-tower-account:edit')")
    public Result<Void> updateSpecEqpTowerAccount(
            @Parameter(description = "塔类ID") @PathVariable Long id,
            @RequestBody @Validated SpecEqpTowerAccountForm formData
    ) {
        boolean result = specEqpTowerAccountService.updateSpecEqpTowerAccount(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除塔类")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-tower-account:delete')")
    public Result<Void> deleteSpecEqpTowerAccounts(
        @Parameter(description = "塔类ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = specEqpTowerAccountService.deleteSpecEqpTowerAccounts(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出塔类")
    @GetMapping("/export")
    public void exportSpecEqpTowerAccounts(SpecEqpTowerAccountQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "塔类";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SpecEqpTowerAccountExportDto> listExportSeHeaters = specEqpTowerAccountService.listExportSpecEqpTowerAccount(queryParams);
        EasyExcel.write(response.getOutputStream(), SpecEqpTowerAccountExportDto.class).sheet("塔类")
                .doWrite(listExportSeHeaters);
    }


    @Operation(summary = "导入塔类")
    @PostMapping("/import")
    public Result<ExcelResult> importSpecEqpTowerAccounts(MultipartFile file) throws IOException {
        SpecEqpTowerAccountImportListener listener = new SpecEqpTowerAccountImportListener();
        ExcelUtils.importExcel(file.getInputStream(), SpecEqpTowerAccountExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "塔类导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateSpecEqpTowerAccounts(HttpServletResponse response) {
        String fileName = "塔类导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("塔类导入模板下载失败", e);
        }
    }





}
