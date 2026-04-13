package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.ExplosionProofElectricEquipmentsListener;
import com.youlai.boot.ledger.model.dto.ElectricLightEquipmentDto;
import com.youlai.boot.ledger.model.dto.ExplosionProofElectricEquipmentExportDto;
import com.youlai.boot.ledger.model.query.ExplosionProofElectricEquipmentExportQuery;
import com.youlai.boot.ledger.service.ExplosionProofElectricEquipmentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ExplosionProofElectricEquipmentForm;
import com.youlai.boot.ledger.model.query.ExplosionProofElectricEquipmentQuery;
import com.youlai.boot.ledger.model.vo.ExplosionProofElectricEquipmentVO;
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
 * 防爆电气设备前端控制层
 *
 * @author dazao
 * @since 2026-02-06 15:59
 */
@Tag(name = "防爆电气设备接口")
@RestController
@RequestMapping("/api/v1/explosion-proof-electric-equipment")
@RequiredArgsConstructor
public class ExplosionProofElectricEquipmentController {

    private final ExplosionProofElectricEquipmentService explosionProofElectricEquipmentService;

    @Operation(summary = "防爆电气设备分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:explosion-proof-electric-equipment:query')")
    public PageResult<ExplosionProofElectricEquipmentVO> getExplosionProofElectricEquipmentPage(ExplosionProofElectricEquipmentQuery queryParams) {
        IPage<ExplosionProofElectricEquipmentVO> result = explosionProofElectricEquipmentService.getExplosionProofElectricEquipmentPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增防爆电气设备")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:explosion-proof-electric-equipment:add')")
    public Result<Void> saveExplosionProofElectricEquipment(@RequestBody @Valid ExplosionProofElectricEquipmentForm formData) {
        boolean result = explosionProofElectricEquipmentService.saveExplosionProofElectricEquipment(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取防爆电气设备表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:explosion-proof-electric-equipment:edit')")
    public Result<ExplosionProofElectricEquipmentForm> getExplosionProofElectricEquipmentForm(
            @Parameter(description = "防爆电气设备ID") @PathVariable Long id
    ) {
        ExplosionProofElectricEquipmentForm formData = explosionProofElectricEquipmentService.getExplosionProofElectricEquipmentFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改防爆电气设备")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:explosion-proof-electric-equipment:edit')")
    public Result<Void> updateExplosionProofElectricEquipment(
            @Parameter(description = "防爆电气设备ID") @PathVariable Long id,
            @RequestBody @Validated ExplosionProofElectricEquipmentForm formData
    ) {
        boolean result = explosionProofElectricEquipmentService.updateExplosionProofElectricEquipment(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除防爆电气设备")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:explosion-proof-electric-equipment:delete')")
    public Result<Void> deleteExplosionProofElectricEquipments(
            @Parameter(description = "防爆电气设备ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = explosionProofElectricEquipmentService.deleteExplosionProofElectricEquipments(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出防爆电气设备")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:explosion-proof-electric-equipment:queru')")
    public void exportExplosionProofElectricEquipments(ExplosionProofElectricEquipmentExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "防爆电气设备.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<ExplosionProofElectricEquipmentExportDto> exportExplosionProofElectricEquipments = explosionProofElectricEquipmentService
                .exportExplosionProofElectricEquipments(queryParams);
        EasyExcel.write(response.getOutputStream(), ExplosionProofElectricEquipmentExportDto.class).sheet("防爆电气设备")
                .doWrite(exportExplosionProofElectricEquipments);
    }

    @Operation(summary = "导入防爆电气设备")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:explosion-proof-electric-equipment:add')")
    public Result<ExcelResult> importExplosionProofElectricEquipments(MultipartFile file) throws IOException {
        ExplosionProofElectricEquipmentsListener explosionProofElectricEquipmentsListener = new ExplosionProofElectricEquipmentsListener();
        ExcelUtils.importExcel(file.getInputStream(), ExplosionProofElectricEquipmentExportDto.class,explosionProofElectricEquipmentsListener);
        return Result.success(explosionProofElectricEquipmentsListener.getExcelResult());
    }


}
