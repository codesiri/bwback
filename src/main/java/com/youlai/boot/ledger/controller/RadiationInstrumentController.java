package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.annotation.Log;
import com.youlai.boot.common.enums.LogModuleEnum;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.RadiationInstrumentsImportListener;
import com.youlai.boot.ledger.model.dto.RadiationInstrumentExportDTO;
import com.youlai.boot.ledger.service.RadiationInstrumentService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.RadiationInstrumentForm;
import com.youlai.boot.ledger.model.query.RadiationInstrumentQuery;
import com.youlai.boot.ledger.model.vo.RadiationInstrumentVO;
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
 * 放射仪前端控制层
 *
 * @author baiwei
 * @since 2026-01-28 09:50
 */
@Tag(name = "放射仪接口")
@RestController
@RequestMapping("/api/v1/radiation-instrument")
@RequiredArgsConstructor
public class RadiationInstrumentController  {

    private final RadiationInstrumentService radiationInstrumentService;

    @Operation(summary = "放射仪分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:radiation-instrument:query')")
    public PageResult<RadiationInstrumentVO> getRadiationInstrumentPage(RadiationInstrumentQuery queryParams ) {
        IPage<RadiationInstrumentVO> result = radiationInstrumentService.getRadiationInstrumentPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增放射仪")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:radiation-instrument:add')")
    public Result<Void> saveRadiationInstrument(@RequestBody @Valid RadiationInstrumentForm formData ) {
        boolean result = radiationInstrumentService.saveRadiationInstrument(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取放射仪表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:radiation-instrument:edit')")
    public Result<RadiationInstrumentForm> getRadiationInstrumentForm(
            @Parameter(description = "放射仪ID") @PathVariable Long id
    ) {
        RadiationInstrumentForm formData = radiationInstrumentService.getRadiationInstrumentFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改放射仪")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:radiation-instrument:edit')")
    public Result<Void> updateRadiationInstrument(
            @Parameter(description = "放射仪ID") @PathVariable Long id,
            @RequestBody @Validated RadiationInstrumentForm formData
    ) {
        boolean result = radiationInstrumentService.updateRadiationInstrument(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除放射仪")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:radiation-instrument:delete')")
    public Result<Void> deleteRadiationInstruments(
            @Parameter(description = "放射仪ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = radiationInstrumentService.deleteRadiationInstruments(ids);
        return Result.judge(result);
    }



    @Operation(summary = "导出放射仪表")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:radiation-instrument:export')")
    public void exportRadiationInstruments(RadiationInstrumentQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "放射仪表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        List<RadiationInstrumentExportDTO> exportRadiationInstrumentsList = radiationInstrumentService.listExportRadiationInstruments(queryParams);
        EasyExcel.write(response.getOutputStream(), RadiationInstrumentExportDTO.class).sheet("放射仪表")
                .doWrite(exportRadiationInstrumentsList);
    }


    @Operation(summary = "导入放射仪表")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:radiation-instrument:add')")
    public Result<ExcelResult> importRadiationInstruments(MultipartFile file) throws IOException {
        RadiationInstrumentsImportListener listener = new RadiationInstrumentsImportListener();
        ExcelUtils.importExcel(file.getInputStream(), RadiationInstrumentExportDTO.class, listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "放射仪表导入模板下载")
    @GetMapping("/template")

    public void downloadTemplateRadiationInstruments(HttpServletResponse response) {
        String fileName = "放射仪表导入模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
             excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("放射仪表导入模板下载失败", e);
        }
    }

}

