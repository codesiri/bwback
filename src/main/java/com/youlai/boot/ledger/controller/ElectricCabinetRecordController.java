package com.youlai.boot.ledger.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.idev.excel.EasyExcel;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.ElectricCabinetRecordsListener;
import com.youlai.boot.ledger.model.dto.ElectricCabinetDocumentExportDto;
import com.youlai.boot.ledger.model.dto.ElectricCabinetRecordExportDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetRecordExportQuery;
import com.youlai.boot.ledger.service.ElectricCabinetRecordService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ElectricCabinetRecordForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetRecordQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetRecordVO;
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
 * 电器日常巡检记录前端控制层
 *
 * @author cc
 * @since 2026-03-03 09:40
 */
@Tag(name = "电器日常巡检记录接口")
@RestController
@RequestMapping("/api/v1/electric-cabinet-record")
@RequiredArgsConstructor
public class ElectricCabinetRecordController {

    private final ElectricCabinetRecordService electricCabinetRecordService;

    @Operation(summary = "电器日常巡检记录分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-record:query')")
    public PageResult<ElectricCabinetRecordVO> getElectricCabinetRecordPage(ElectricCabinetRecordQuery queryParams) {
        IPage<ElectricCabinetRecordVO> result = electricCabinetRecordService.getElectricCabinetRecordPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增电器日常巡检记录")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-record:add')")
    public Result<Void> saveElectricCabinetRecord(@RequestBody @Valid ElectricCabinetRecordForm formData) {
        boolean result = electricCabinetRecordService.saveElectricCabinetRecord(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取电器日常巡检记录表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-record:edit')")
    public Result<ElectricCabinetRecordForm> getElectricCabinetRecordForm(
            @Parameter(description = "电器日常巡检记录ID") @PathVariable Long id
    ) {
        ElectricCabinetRecordForm formData = electricCabinetRecordService.getElectricCabinetRecordFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改电器日常巡检记录")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-record:edit')")
    public Result<Void> updateElectricCabinetRecord(
            @Parameter(description = "电器日常巡检记录ID") @PathVariable Long id,
            @RequestBody @Validated ElectricCabinetRecordForm formData
    ) {
        boolean result = electricCabinetRecordService.updateElectricCabinetRecord(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除电器日常巡检记录")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-record:delete')")
    public Result<Void> deleteElectricCabinetRecords(
            @Parameter(description = "电器日常巡检记录ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = electricCabinetRecordService.deleteElectricCabinetRecords(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出电器日常巡检记录")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-record:query')")
    public void exportElectricCabinetRecords(ElectricCabinetRecordExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "电器日常巡检记录.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<ElectricCabinetRecordExportDto> electricCabinetRecordExportDtos =
                this.electricCabinetRecordService.exportElectricCabinetRecords(queryParams);
        EasyExcel.write(response.getOutputStream(),
                        ElectricCabinetRecordExportDto.class)
                .sheet("电器日常巡检记录表")
                .doWrite(electricCabinetRecordExportDtos);
    }

    @Operation(summary = "导入电器日常巡检记录")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-record:add')")
    public Result<ExcelResult> importElectricCabinetRecords(MultipartFile file) throws IOException {
        var electricCabinetRecordsListener = new ElectricCabinetRecordsListener();
        ExcelUtils.importExcel(file.getInputStream(), ElectricCabinetDocumentExportDto.class,electricCabinetRecordsListener);
        return Result.success(electricCabinetRecordsListener.getExcelResult());
    }
}
