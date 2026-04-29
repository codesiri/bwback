package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.SpecEqpSteamTurbineAccountImportListener;
import com.youlai.boot.ledger.model.dto.SpecEqpSteamTurbineAccountExportDto;
import com.youlai.boot.ledger.service.SpecEqpSteamTurbineAccountService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SpecEqpSteamTurbineAccountForm;
import com.youlai.boot.ledger.model.query.SpecEqpSteamTurbineAccountQuery;
import com.youlai.boot.ledger.model.vo.SpecEqpSteamTurbineAccountVO;
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
 * 汽轮机前端控制层
 *
 * @author baiwei
 * @since 2026-02-03 09:38
 */
@Tag(name = "汽轮机接口")
@RestController
@RequestMapping("/api/v1/spec-eqp-steam-turbine-account")
@RequiredArgsConstructor
public class SpecEqpSteamTurbineAccountController  {

    private final SpecEqpSteamTurbineAccountService specEqpSteamTurbineAccountService;

    @Operation(summary = "汽轮机分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-steam-turbine-account:query')")
    public PageResult<SpecEqpSteamTurbineAccountVO> getSpecEqpSteamTurbineAccountPage(SpecEqpSteamTurbineAccountQuery queryParams ) {
        IPage<SpecEqpSteamTurbineAccountVO> result = specEqpSteamTurbineAccountService.getSpecEqpSteamTurbineAccountPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增汽轮机")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-steam-turbine-account:add')")
    public Result<Void> saveSpecEqpSteamTurbineAccount(@RequestBody @Valid SpecEqpSteamTurbineAccountForm formData ) {
        boolean result = specEqpSteamTurbineAccountService.saveSpecEqpSteamTurbineAccount(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取汽轮机表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-steam-turbine-account:edit')")
    public Result<SpecEqpSteamTurbineAccountForm> getSpecEqpSteamTurbineAccountForm(
        @Parameter(description = "汽轮机ID") @PathVariable Long id
    ) {
        SpecEqpSteamTurbineAccountForm formData = specEqpSteamTurbineAccountService.getSpecEqpSteamTurbineAccountFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改汽轮机")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-steam-turbine-account:edit')")
    public Result<Void> updateSpecEqpSteamTurbineAccount(
            @Parameter(description = "汽轮机ID") @PathVariable Long id,
            @RequestBody @Validated SpecEqpSteamTurbineAccountForm formData
    ) {
        boolean result = specEqpSteamTurbineAccountService.updateSpecEqpSteamTurbineAccount(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除汽轮机")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:spec-eqp-steam-turbine-account:delete')")
    public Result<Void> deleteSpecEqpSteamTurbineAccounts(
        @Parameter(description = "汽轮机ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = specEqpSteamTurbineAccountService.deleteSpecEqpSteamTurbineAccounts(ids);
        return Result.judge(result);
    }


    @Operation(summary = "导出汽轮机")
    @GetMapping("/export")
    public void exportSpecEqpSteamTurbineAccount(SpecEqpSteamTurbineAccountQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "导出汽轮机";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SpecEqpSteamTurbineAccountExportDto> listExportSpecEqpSteamTurbineAccounts = specEqpSteamTurbineAccountService.listExportSpecEqpSteamTurbineAccount(queryParams);
        EasyExcel.write(response.getOutputStream(), SpecEqpSteamTurbineAccountExportDto.class).sheet("导出汽轮机表")
                .doWrite(listExportSpecEqpSteamTurbineAccounts);
    }


    @Operation(summary = "导入汽轮机")
    @PostMapping("/import")
    public Result<ExcelResult> importSpecEqpSteamTurbineAccount(MultipartFile file) throws IOException {
        SpecEqpSteamTurbineAccountImportListener listener = new SpecEqpSteamTurbineAccountImportListener();
        ExcelUtils.importExcel(file.getInputStream(), SpecEqpSteamTurbineAccountExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "汽轮机导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateSpecEqpSteamTurbineAccount(HttpServletResponse response) {
        String fileName = "汽轮机导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("汽轮机导入模板下载失败", e);
        }
    }




}
