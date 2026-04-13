package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.model.dto.ElectricCabinetDocumentExportDto;
import com.youlai.boot.ledger.model.dto.ElectricCabinetDrawerUnitsExportDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetDrawerUnitsExportQuery;
import com.youlai.boot.ledger.service.ElectricCabinetDrawerUnitService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ElectricCabinetDrawerUnitForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetDrawerUnitQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetDrawerUnitVO;
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
 * 抽屉柜抽屉单元明细前端控制层
 *
 * @author youlaitech
 * @since 2026-03-17 09:40
 */
@Tag(name = "抽屉柜抽屉单元明细接口")
@RestController
@RequestMapping("/api/v1/electric-cabinet-drawer-unit")
@RequiredArgsConstructor
public class ElectricCabinetDrawerUnitController  {

    private final ElectricCabinetDrawerUnitService electricCabinetDrawerUnitService;

    @Operation(summary = "抽屉柜抽屉单元明细分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-drawer-unit:query')")
    public PageResult<ElectricCabinetDrawerUnitVO> getElectricCabinetDrawerUnitPage(ElectricCabinetDrawerUnitQuery queryParams ) {
        IPage<ElectricCabinetDrawerUnitVO> result = electricCabinetDrawerUnitService.getElectricCabinetDrawerUnitPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增抽屉柜抽屉单元明细")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-drawer-unit:add')")
    public Result<Void> saveElectricCabinetDrawerUnit(@RequestBody @Valid ElectricCabinetDrawerUnitForm formData ) {
        boolean result = electricCabinetDrawerUnitService.saveElectricCabinetDrawerUnit(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取抽屉柜抽屉单元明细表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-drawer-unit:edit')")
    public Result<ElectricCabinetDrawerUnitForm> getElectricCabinetDrawerUnitForm(
        @Parameter(description = "抽屉柜抽屉单元明细ID") @PathVariable Long id
    ) {
        ElectricCabinetDrawerUnitForm formData = electricCabinetDrawerUnitService.getElectricCabinetDrawerUnitFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改抽屉柜抽屉单元明细")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-drawer-unit:edit')")
    public Result<Void> updateElectricCabinetDrawerUnit(
            @Parameter(description = "抽屉柜抽屉单元明细ID") @PathVariable Long id,
            @RequestBody @Validated ElectricCabinetDrawerUnitForm formData
    ) {
        boolean result = electricCabinetDrawerUnitService.updateElectricCabinetDrawerUnit(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除抽屉柜抽屉单元明细")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-drawer-unit:delete')")
    public Result<Void> deleteElectricCabinetDrawerUnits(
        @Parameter(description = "抽屉柜抽屉单元明细ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = electricCabinetDrawerUnitService.deleteElectricCabinetDrawerUnits(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出抽屉柜抽屉单元明细")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-drawer-unit:query')")
    public void exportElectricCabinetDrawerUnits(ElectricCabinetDrawerUnitsExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "抽屉柜抽屉单元明细.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<ElectricCabinetDocumentExportDto> exportElectricCabinetDrawerUnits =
                this.electricCabinetDrawerUnitService.exportElectricCabinetDrawerUnits(queryParams);
        EasyExcel.write(response.getOutputStream(),
                ElectricCabinetDrawerUnitsExportDto.class)
                .sheet("抽屉柜抽屉单元明细")
                .doWrite(exportElectricCabinetDrawerUnits);
    }
    @Operation(summary = "导入抽屉柜抽屉单元明细")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-drawer-unit:add')")
    public Result<ExcelResult> importElectricCabinetDrawerUnits(MultipartFile file){
        return null;
    }
}
