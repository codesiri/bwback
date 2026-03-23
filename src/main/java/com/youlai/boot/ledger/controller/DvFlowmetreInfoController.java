package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.DvFlowmetreInfoImportListener;
import com.youlai.boot.ledger.listener.DvTemperatureGaugesListener;
import com.youlai.boot.ledger.model.dto.DvFlowmetreInfoExportDto;
import com.youlai.boot.ledger.model.dto.DvTemperatureGaugesExportDTO;
import com.youlai.boot.ledger.model.query.DvFlowmetreInfoQueryExport;
import com.youlai.boot.ledger.service.DvFlowmetreInfoService;
import groovy.cli.Option;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.DvFlowmetreInfoForm;
import com.youlai.boot.ledger.model.query.DvFlowmetreInfoQuery;
import com.youlai.boot.ledger.model.vo.DvFlowmetreInfoVO;
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
 * 流量计前端控制层
 *
 * @author dazao
 * @since 2026-01-09 09:04
 */
@Tag(name = "流量计接口")
@RestController
@RequestMapping("/api/v1/dv-flowmetre-info")
@RequiredArgsConstructor
public class DvFlowmetreInfoController {

    private final DvFlowmetreInfoService dvFlowmetreInfoService;

    @Operation(summary = "流量计分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:dv-flowmetre-info:query')")
    public PageResult<DvFlowmetreInfoVO> getDvFlowmetreInfoPage(DvFlowmetreInfoQuery queryParams) {
        IPage<DvFlowmetreInfoVO> result = dvFlowmetreInfoService.getDvFlowmetreInfoPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增流量计")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:dv-flowmetre-info:add')")
    public Result<Void> saveDvFlowmetreInfo(@RequestBody @Valid DvFlowmetreInfoForm formData) {
        boolean result = dvFlowmetreInfoService.saveDvFlowmetreInfo(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取流量计表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:dv-flowmetre-info:edit')")
    public Result<DvFlowmetreInfoForm> getDvFlowmetreInfoForm(
            @Parameter(description = "流量计ID") @PathVariable Long id
    ) {
        DvFlowmetreInfoForm formData = dvFlowmetreInfoService.getDvFlowmetreInfoFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改流量计")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:dv-flowmetre-info:edit')")
    public Result<Void> updateDvFlowmetreInfo(
            @Parameter(description = "流量计ID") @PathVariable Long id,
            @RequestBody @Validated DvFlowmetreInfoForm formData
    ) {
        boolean result = dvFlowmetreInfoService.updateDvFlowmetreInfo(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除流量计")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:dv-flowmetre-info:delete')")
    public Result<Void> deleteDvFlowmetreInfos(
            @Parameter(description = "流量计ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = dvFlowmetreInfoService.deleteDvFlowmetreInfos(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出流量计")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:dv-flowmetre-info:query')")
    public void exportDvFlowmetreInfo(DvFlowmetreInfoQueryExport queryParams, HttpServletResponse response) throws IOException {
        String fileName = "流量计表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<DvFlowmetreInfoExportDto> exportDvFlowmetreInfoList = this.dvFlowmetreInfoService.listExportDvFlowmetreInfo(queryParams);
        EasyExcel.write(response.getOutputStream(), DvFlowmetreInfoExportDto.class).sheet("流量计列表")
                .doWrite(exportDvFlowmetreInfoList);
    }


    @Operation(summary = "导入流量计")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:add')")
    public Result<ExcelResult> importFlowMeter(MultipartFile file) throws IOException {
        DvFlowmetreInfoImportListener listener = new DvFlowmetreInfoImportListener();
        ExcelUtils.importExcel(file.getInputStream(), DvFlowmetreInfoExportDto.class, listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "下载流量计导入模板")
    @GetMapping("/downtemplate")
    public void downFlowMetreInfoTemplate(HttpServletResponse response) {
        String fileName = "流量计导入模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);
        try (ServletOutputStream outputStream = response.getOutputStream(); ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("流量计导入模板下载失败", e);
        }
    }
}
