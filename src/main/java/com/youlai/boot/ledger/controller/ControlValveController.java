package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.annotation.Log;
import com.youlai.boot.common.enums.LogModuleEnum;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.ControlValveImportListener;
import com.youlai.boot.ledger.model.dto.ControlValveExportDto;
import com.youlai.boot.ledger.service.ControlValveService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ControlValveForm;
import com.youlai.boot.ledger.model.query.ControlValveQuery;
import com.youlai.boot.ledger.model.vo.ControlValveVO;
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
 * 调节阀前端控制层
 *
 * @author cc
 * @since 2026-01-28 11:03
 */
@Tag(name = "调节阀接口")
@RestController
@RequestMapping("/api/v1/control-valve")
@RequiredArgsConstructor
public class ControlValveController  {

    private final ControlValveService controlValveService;

    @Operation(summary = "调节阀分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:control-valve:query')")
    public PageResult<ControlValveVO> getControlValvePage(ControlValveQuery queryParams ) {
        IPage<ControlValveVO> result = controlValveService.getControlValvePage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增调节阀")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:control-valve:add')")
    public Result<Void> saveControlValve(@RequestBody @Valid ControlValveForm formData ) {
        boolean result = controlValveService.saveControlValve(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取调节阀表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:control-valve:edit')")
    public Result<ControlValveForm> getControlValveForm(
            @Parameter(description = "调节阀ID") @PathVariable Long id
    ) {
        ControlValveForm formData = controlValveService.getControlValveFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改调节阀")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:control-valve:edit')")
    public Result<Void> updateControlValve(
            @Parameter(description = "调节阀ID") @PathVariable Long id,
            @RequestBody @Validated ControlValveForm formData
    ) {
        boolean result = controlValveService.updateControlValve(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除调节阀")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:control-valve:delete')")
    public Result<Void> deleteControlValves(
            @Parameter(description = "调节阀ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = controlValveService.deleteControlValves(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出表")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:control-valve:export')")

    public void exportControlValves(ControlValveQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "导出调节阀.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        List<ControlValveExportDto> exportControlValvesList = controlValveService.listExportControlValves(queryParams);
        EasyExcel.write(response.getOutputStream(), ControlValveExportDto.class).sheet("放射仪表")
                .doWrite(exportControlValvesList);
    }

    @Operation(summary = "导入")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:control-valve:import')")

    public Result<ExcelResult> importControlValves(MultipartFile file) throws IOException {

        ControlValveImportListener listener = new ControlValveImportListener();
        ExcelUtils.importExcel(file.getInputStream(), ControlValveExportDto.class, listener);
        return Result.success(listener.getExcelResult());

    }


    @Operation(summary = "调节阀导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateControlValves(HttpServletResponse response) {
        String fileName = "调节阀导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("调节阀导入模板下载失败", e);
        }
    }




}

