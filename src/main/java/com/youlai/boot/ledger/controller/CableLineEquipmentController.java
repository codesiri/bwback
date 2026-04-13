package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.CableLineEquipmentImportListener;
import com.youlai.boot.ledger.model.dto.CableLineEquipmentExportDto;
import com.youlai.boot.ledger.model.query.CableLineEquipmentExportQuery;
import com.youlai.boot.ledger.service.CableLineEquipmentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.CableLineEquipmentForm;
import com.youlai.boot.ledger.model.query.CableLineEquipmentQuery;
import com.youlai.boot.ledger.model.vo.CableLineEquipmentVO;
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
 * 电器电缆线路前端控制层
 *
 * @author dazao
 * @since 2026-03-05 08:45
 */
@Tag(name = "电器电缆线路接口")
@RestController
@RequestMapping("/api/v1/cable-line-equipment")
@RequiredArgsConstructor
public class CableLineEquipmentController {

    private final CableLineEquipmentService cableLineEquipmentService;

    @Operation(summary = "电器电缆线路分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:cable-line-equipment:query')")
    public PageResult<CableLineEquipmentVO> getCableLineEquipmentPage(CableLineEquipmentQuery queryParams) {
        IPage<CableLineEquipmentVO> result = cableLineEquipmentService.getCableLineEquipmentPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增电器电缆线路")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:cable-line-equipment:add')")
    public Result<Void> saveCableLineEquipment(@RequestBody @Valid CableLineEquipmentForm formData) {
        boolean result = cableLineEquipmentService.saveCableLineEquipment(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取电器电缆线路表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:cable-line-equipment:edit')")
    public Result<CableLineEquipmentForm> getCableLineEquipmentForm(
            @Parameter(description = "电器电缆线路ID") @PathVariable Long id
    ) {
        CableLineEquipmentForm formData = cableLineEquipmentService.getCableLineEquipmentFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改电器电缆线路")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:cable-line-equipment:edit')")
    public Result<Void> updateCableLineEquipment(
            @Parameter(description = "电器电缆线路ID") @PathVariable Long id,
            @RequestBody @Validated CableLineEquipmentForm formData
    ) {
        boolean result = cableLineEquipmentService.updateCableLineEquipment(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除电器电缆线路")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:cable-line-equipment:delete')")
    public Result<Void> deleteCableLineEquipments(
            @Parameter(description = "电器电缆线路ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = cableLineEquipmentService.deleteCableLineEquipments(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出电器电缆线路接口")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:cable-line-equipment:query')")
    public void exportCableLineEquipments(CableLineEquipmentExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "导出电器电缆线路接口.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<CableLineEquipmentExportDto> cableLineEquipmentExportDtoList = this.cableLineEquipmentService.exportCableLineEquipments(queryParams);
        EasyExcel.write(response.getOutputStream(), CableLineEquipmentExportDto.class)
                .sheet("电器电缆线路接口表")
                .doWrite(cableLineEquipmentExportDtoList);
    }

    @Operation(summary = "导入电器电缆线路接口")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:cable-line-equipment:add')")
    public Result<ExcelResult> importCableLineEquipments(MultipartFile file) throws IOException {
        var cableLineEquipmentImportListener =new CableLineEquipmentImportListener();
        ExcelUtils.importExcel(file.getInputStream(), CableLineEquipmentExportDto.class, cableLineEquipmentImportListener);
        return Result.success(cableLineEquipmentImportListener.getExcelResult());
    }

}
