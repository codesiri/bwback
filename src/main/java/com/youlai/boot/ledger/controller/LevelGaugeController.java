package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.LevelGaugeImportListener;
import com.youlai.boot.ledger.model.dto.LevelGaugeExportDto;
import com.youlai.boot.ledger.model.dto.PressureInstrumentExportDTO;
import com.youlai.boot.ledger.model.query.LevelGaugeExportQuery;
import com.youlai.boot.ledger.service.LevelGaugeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.LevelGaugeForm;
import com.youlai.boot.ledger.model.query.LevelGaugeQuery;
import com.youlai.boot.ledger.model.vo.LevelGaugeVO;
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

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 液位计前端控制层
 *
 * @author dazao
 * @since 2026-01-20 15:40
 */
@Tag(name = "液位计接口")
@RestController
@RequestMapping("/api/v1/level-gauge")
@RequiredArgsConstructor
public class LevelGaugeController  {

    private final LevelGaugeService levelGaugeService;

    @Operation(summary = "液位计分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:level-gauge:query')")
    public PageResult<LevelGaugeVO> getLevelGaugePage(LevelGaugeQuery queryParams ) {
        IPage<LevelGaugeVO> result = levelGaugeService.getLevelGaugePage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增液位计")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:level-gauge:add')")
    public Result<Void> saveLevelGauge(@RequestBody @Valid LevelGaugeForm formData ) {
        boolean result = levelGaugeService.saveLevelGauge(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取液位计表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:level-gauge:edit')")
    public Result<LevelGaugeForm> getLevelGaugeForm(
        @Parameter(description = "液位计ID") @PathVariable Long id
    ) {
        LevelGaugeForm formData = levelGaugeService.getLevelGaugeFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改液位计")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:level-gauge:edit')")
    public Result<Void> updateLevelGauge(
            @Parameter(description = "液位计ID") @PathVariable Long id,
            @RequestBody @Validated LevelGaugeForm formData
    ) {
        boolean result = levelGaugeService.updateLevelGauge(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除液位计")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:level-gauge:delete')")
    public Result<Void> deleteLevelGauges(
        @Parameter(description = "液位计ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = levelGaugeService.deleteLevelGauges(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出液位计表")
    @PreAuthorize("@ss.hasPerm('ledger:level-gauge:query')")
    @GetMapping("/export")
    public void exportLevelGauges(LevelGaugeExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "液位计表.xslx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<LevelGaugeExportDto> listExportLevelGauge = levelGaugeService.listExportLevelGauge(queryParams);
        EasyExcel.write(response.getOutputStream(), LevelGaugeExportDto.class).sheet("导出液位计表")
                .doWrite(listExportLevelGauge);
    }
    @Operation(summary = "导入液位计")
    @PreAuthorize("@ss.hasPerm('ledger:level-gauge:add')")
    @PostMapping("/import")
    public Result<ExcelResult> importLevelGauge(MultipartFile file) throws IOException {
        LevelGaugeImportListener listener = new LevelGaugeImportListener();
        ExcelUtils.importExcel(file.getInputStream(), LevelGaugeExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }
}
