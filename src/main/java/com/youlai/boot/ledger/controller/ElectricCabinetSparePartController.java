package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.model.dto.ElectricCabinetRecordExportDto;
import com.youlai.boot.ledger.model.dto.ElectricCabinetSparePartDto;
import com.youlai.boot.ledger.model.dto.ElectricLightEquipmentDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetRecordExportQuery;
import com.youlai.boot.ledger.model.query.ElectricCabinetSparePartExportQuery;
import com.youlai.boot.ledger.service.ElectricCabinetSparePartService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ElectricCabinetSparePartForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetSparePartQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetSparePartVO;
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
 * 电器备品备件管理记录前端控制层
 *
 * @author youlaitech
 * @since 2026-03-04 08:46
 */
@Tag(name = "电器备品备件管理记录接口")
@RestController
@RequestMapping("/api/v1/electric-cabinet-spare-part")
@RequiredArgsConstructor
public class ElectricCabinetSparePartController  {

    private final ElectricCabinetSparePartService electricCabinetSparePartService;

    @Operation(summary = "电器备品备件管理记录分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-spare-part:query')")
    public PageResult<ElectricCabinetSparePartVO> getElectricCabinetSparePartPage(ElectricCabinetSparePartQuery queryParams ) {
        IPage<ElectricCabinetSparePartVO> result = electricCabinetSparePartService.getElectricCabinetSparePartPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增电器备品备件管理记录")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-spare-part:add')")
    public Result<Void> saveElectricCabinetSparePart(@RequestBody @Valid ElectricCabinetSparePartForm formData ) {
        boolean result = electricCabinetSparePartService.saveElectricCabinetSparePart(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取电器备品备件管理记录表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-spare-part:edit')")
    public Result<ElectricCabinetSparePartForm> getElectricCabinetSparePartForm(
        @Parameter(description = "电器备品备件管理记录ID") @PathVariable Long id
    ) {
        ElectricCabinetSparePartForm formData = electricCabinetSparePartService.getElectricCabinetSparePartFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改电器备品备件管理记录")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-spare-part:edit')")
    public Result<Void> updateElectricCabinetSparePart(
            @Parameter(description = "电器备品备件管理记录ID") @PathVariable Long id,
            @RequestBody @Validated ElectricCabinetSparePartForm formData
    ) {
        boolean result = electricCabinetSparePartService.updateElectricCabinetSparePart(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除电器备品备件管理记录")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-spare-part:delete')")
    public Result<Void> deleteElectricCabinetSpareParts(
        @Parameter(description = "电器备品备件管理记录ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = electricCabinetSparePartService.deleteElectricCabinetSpareParts(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出电器备品备件管理记录")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-spare-part:query')")
    public void exportElectricCabinetSpareParts(ElectricCabinetSparePartExportQuery params, HttpServletResponse response) throws IOException {
        String fileName = "电器备品备件管理记录表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<ElectricCabinetSparePartDto> electricCabinetRecordExportDtoList=this.electricCabinetSparePartService.exportElectricCabinetSpareParts(params);
        EasyExcel.write(response.getOutputStream(), ElectricCabinetSparePartDto.class).sheet("电器备品备件管理记录表")
                .doWrite(electricCabinetRecordExportDtoList);
    }

    @Operation(summary = "导入电器备品备件管理记录")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPrem('ledger:electric-cabinet-spare-part:add')")
    public Result<ExcelResult> importElectricCabinetSpareParts(MultipartFile file){
        return null;
    }
}
