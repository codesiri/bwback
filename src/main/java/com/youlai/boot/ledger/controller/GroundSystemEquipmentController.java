package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.GroundSystemEquipmentsImportListener;
import com.youlai.boot.ledger.model.dto.GroundSystemEquipmentExportDto;
import com.youlai.boot.ledger.model.query.GroundSystemEquipmentExportQuery;
import com.youlai.boot.ledger.service.GroundSystemEquipmentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.GroundSystemEquipmentForm;
import com.youlai.boot.ledger.model.query.GroundSystemEquipmentQuery;
import com.youlai.boot.ledger.model.vo.GroundSystemEquipmentVO;
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
 * 电器接地系统前端控制层
 *
 * @author dazao
 * @since 2026-03-09 08:51
 */
@Tag(name = "电器接地系统接口")
@RestController
@RequestMapping("/api/v1/ground-system-equipment")
@RequiredArgsConstructor
public class GroundSystemEquipmentController  {

    private final GroundSystemEquipmentService groundSystemEquipmentService;

    @Operation(summary = "电器接地系统分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:ground-system-equipment:query')")
    public PageResult<GroundSystemEquipmentVO> getGroundSystemEquipmentPage(GroundSystemEquipmentQuery queryParams ) {
        IPage<GroundSystemEquipmentVO> result = groundSystemEquipmentService.getGroundSystemEquipmentPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增电器接地系统")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:ground-system-equipment:add')")
    public Result<Void> saveGroundSystemEquipment(@RequestBody @Valid GroundSystemEquipmentForm formData ) {
        boolean result = groundSystemEquipmentService.saveGroundSystemEquipment(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取电器接地系统表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:ground-system-equipment:edit')")
    public Result<GroundSystemEquipmentForm> getGroundSystemEquipmentForm(
        @Parameter(description = "电器接地系统ID") @PathVariable Long id
    ) {
        GroundSystemEquipmentForm formData = groundSystemEquipmentService.getGroundSystemEquipmentFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改电器接地系统")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:ground-system-equipment:edit')")
    public Result<Void> updateGroundSystemEquipment(
            @Parameter(description = "电器接地系统ID") @PathVariable Long id,
            @RequestBody @Validated GroundSystemEquipmentForm formData
    ) {
        boolean result = groundSystemEquipmentService.updateGroundSystemEquipment(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除电器接地系统")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:ground-system-equipment:delete')")
    public Result<Void> deleteGroundSystemEquipments(
        @Parameter(description = "电器接地系统ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = groundSystemEquipmentService.deleteGroundSystemEquipments(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出电器接地系统")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:ground-system-equipment:query')")
    public void exportGroundSystemEquipments(GroundSystemEquipmentExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "电器接地系统表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<GroundSystemEquipmentExportDto> exportGroundSystemEquipments = groundSystemEquipmentService
                .exportGroundSystemEquipments(queryParams);
        EasyExcel
                .write(response.getOutputStream(),
                        GroundSystemEquipmentExportDto.class)
                .sheet("电器接地系统").doWrite(exportGroundSystemEquipments);
    }

    @Operation(summary = "导入电器接地系统")
    @PreAuthorize("@ss.hasPerm('ledger:ground-system-equipment:add')")
    @PostMapping("/import")
    public Result<ExcelResult> importGroundSystemEquipments(MultipartFile file) throws IOException {
        GroundSystemEquipmentsImportListener groundSystemEquipmentsImportListener = new GroundSystemEquipmentsImportListener();
        ExcelUtils.importExcel(file.getInputStream(), GroundSystemEquipmentExportDto.class,groundSystemEquipmentsImportListener);
        return Result.success(groundSystemEquipmentsImportListener.getExcelResult());
    }

 }
