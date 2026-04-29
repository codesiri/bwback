package com.youlai.boot.ledger.controller;

import cn.hutool.json.JSONUtil;
import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.annotation.Log;
import com.youlai.boot.common.annotation.RepeatSubmit;
import com.youlai.boot.common.enums.LogModuleEnum;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.DvTemperatureGaugesListener;
import com.youlai.boot.ledger.listener.PressureInstrumentImportListener;
import com.youlai.boot.ledger.model.dto.DvTemperatureGaugesExportDTO;
import com.youlai.boot.ledger.model.dto.PressureInstrumentExportDTO;
import com.youlai.boot.ledger.model.query.DvTemperatureGaugeQueryPlus;
import com.youlai.boot.ledger.service.DvTemperatureGaugeService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.DvTemperatureGaugeForm;
import com.youlai.boot.ledger.model.query.DvTemperatureGaugeQuery;
import com.youlai.boot.ledger.model.vo.DvTemperatureGaugeVO;
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
 * 温度前端控制层
 *
 * @author dazao
 * @since 2025-12-29 11:00
 */
@Tag(name = "温度接口")
@RestController
@RequestMapping("/api/v1/dv-temperature-gauge")
@RequiredArgsConstructor
@Slf4j
public class DvTemperatureGaugeController {

    private final DvTemperatureGaugeService dvTemperatureGaugeService;

    @Operation(summary = "温度分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:query')")
    public PageResult<DvTemperatureGaugeVO> getDvTemperatureGaugePage(DvTemperatureGaugeQueryPlus queryParams, String tagNumber, String status, String dvName) {
        System.out.println(status);
        IPage<DvTemperatureGaugeVO> result = dvTemperatureGaugeService.getDvTemperatureGaugePage(queryParams, tagNumber, status, dvName);
        return PageResult.success(result);
    }

    @RepeatSubmit
    @Operation(summary = "新增温度")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:add')")
    public Result<Void> saveDvTemperatureGauge(@RequestBody @Valid DvTemperatureGaugeForm formData) {
        log.info("传入的温度对象:{}", JSONUtil.toJsonStr(formData));
        boolean result = dvTemperatureGaugeService.saveDvTemperatureGauge(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取温度表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:edit')")
    public Result<DvTemperatureGaugeForm> getDvTemperatureGaugeForm(
            @Parameter(description = "温度ID") @PathVariable Long id
    ) {
        DvTemperatureGaugeForm formData = dvTemperatureGaugeService.getDvTemperatureGaugeFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改温度")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:edit')")
    public Result<Void> updateDvTemperatureGauge(
            @Parameter(description = "温度ID") @PathVariable Long id,
            @RequestBody @Validated DvTemperatureGaugeForm formData
    ) {
        boolean result = dvTemperatureGaugeService.updateDvTemperatureGauge(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除温度")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:delete')")
    public Result<Void> deleteDvTemperatureGauges(
            @Parameter(description = "温度ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = dvTemperatureGaugeService.deleteDvTemperatureGauges(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出温度表")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:query')")
    public void exportDvTemperatureGauges(DvTemperatureGaugeQuery queryParams, HttpServletResponse response) throws Exception {
        String fileName = "温度仪表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<DvTemperatureGaugesExportDTO> exportDvTemperatureGaugeList = this.dvTemperatureGaugeService.listExportDvTemperatureGauge(queryParams);
        EasyExcel.write(response.getOutputStream(), DvTemperatureGaugesExportDTO.class).sheet("温度列表")
                .doWrite(exportDvTemperatureGaugeList);
    }

    @Operation(summary = "导入温度")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:dv-temperature-gauge:add')")
    @Log(value = "导入温度", module = LogModuleEnum.PRESSURE_INSTRUMENT)
    public Result<ExcelResult> importUsers(MultipartFile file) throws IOException {

        DvTemperatureGaugesListener listener = new DvTemperatureGaugesListener();
        ExcelUtils.importExcel(file.getInputStream(), DvTemperatureGaugesExportDTO.class, listener);
        return Result.success(listener.getExcelResult());

    }

    @Operation(summary = "温度导入模板下载")
    @GetMapping("/template")
    public void downloadTemplate(HttpServletResponse response){
        //这块以后可以优化为minio存储
        String fileName = "温度导入模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);
        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
             excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("温度导入模板下载失败", e);
        }
    }
}
