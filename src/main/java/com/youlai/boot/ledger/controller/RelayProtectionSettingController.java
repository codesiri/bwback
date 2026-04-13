package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.RelayProtectionSettingListener;
import com.youlai.boot.ledger.model.dto.RelayProtectionSettingExportDto;
import com.youlai.boot.ledger.model.query.RelayProtectionSettingExportQuery;
import com.youlai.boot.ledger.service.RelayProtectionSettingService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.RelayProtectionSettingForm;
import com.youlai.boot.ledger.model.query.RelayProtectionSettingQuery;
import com.youlai.boot.ledger.model.vo.RelayProtectionSettingVO;
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
 * 继电保护定值台账前端控制层
 *
 * @author dazao
 * @since 2026-02-11 09:41
 */
@Tag(name = "继电保护定值台账接口")
@RestController
@RequestMapping("/api/v1/relay-protection-setting")
@RequiredArgsConstructor
public class RelayProtectionSettingController {

    private final RelayProtectionSettingService relayProtectionSettingService;

    @Operation(summary = "继电保护定值台账分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:relay-protection-setting:query')")
    public PageResult<RelayProtectionSettingVO> getRelayProtectionSettingPage(RelayProtectionSettingQuery queryParams) {
        IPage<RelayProtectionSettingVO> result = relayProtectionSettingService.getRelayProtectionSettingPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增继电保护定值台账")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:relay-protection-setting:add')")
    public Result<Void> saveRelayProtectionSetting(@RequestBody @Valid RelayProtectionSettingForm formData) {
        boolean result = relayProtectionSettingService.saveRelayProtectionSetting(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取继电保护定值台账表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:relay-protection-setting:edit')")
    public Result<RelayProtectionSettingForm> getRelayProtectionSettingForm(
            @Parameter(description = "继电保护定值台账ID") @PathVariable Long id
    ) {
        RelayProtectionSettingForm formData = relayProtectionSettingService.getRelayProtectionSettingFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改继电保护定值台账")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:relay-protection-setting:edit')")
    public Result<Void> updateRelayProtectionSetting(
            @Parameter(description = "继电保护定值台账ID") @PathVariable Long id,
            @RequestBody @Validated RelayProtectionSettingForm formData
    ) {
        boolean result = relayProtectionSettingService.updateRelayProtectionSetting(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除继电保护定值台账")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:relay-protection-setting:delete')")
    public Result<Void> deleteRelayProtectionSettings(
            @Parameter(description = "继电保护定值台账ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = relayProtectionSettingService.deleteRelayProtectionSettings(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出继电保护定值台账")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:relay-protection-setting:query')")
    public void exportRelayProtectionSettings(RelayProtectionSettingExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "继电保护定值台账.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<RelayProtectionSettingExportDto> list = this
                .relayProtectionSettingService
                .exportRelayProtectionSettings(queryParams);
        EasyExcel.write(response.getOutputStream(), RelayProtectionSettingExportDto.class)
                .sheet("放射仪表").doWrite(list);
    }

    @Operation(summary = "导入继电保护定值台账")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:relay-protection-setting:add')")
    public Result<ExcelResult> importRelayProtectionSettings(MultipartFile file) throws IOException {
        RelayProtectionSettingListener relayProtectionSettingListener = new RelayProtectionSettingListener();
        ExcelUtils.importExcel(file.getInputStream(), RelayProtectionSettingExportDto.class, relayProtectionSettingListener);
        return Result.success(relayProtectionSettingListener.getExcelResult());
    }

    @Operation(summary = "导入继电保护定值模板下载")
    @GetMapping("/template")
    public void downloadTemplateRelayProtectionSettings(HttpServletResponse response) {
        String fileName = "导入继电保护定值模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);
        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
