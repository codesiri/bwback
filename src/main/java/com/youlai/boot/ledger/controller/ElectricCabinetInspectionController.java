package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.ElectricCabinetInspectionImportListener;
import com.youlai.boot.ledger.model.dto.ElectricCabinetInspectionExportDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetInspectionExportQuery;
import com.youlai.boot.ledger.service.ElectricCabinetInspectionService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ElectricCabinetInspectionForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetInspectionQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetInspectionVO;
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
 * 抽屉柜检修试验记录前端控制层
 *
 * @author youlaitech
 * @since 2026-03-18 16:19
 */
@Tag(name = "抽屉柜检修试验记录接口")
@RestController
@RequestMapping("/api/v1/electric-cabinet-inspection")
@RequiredArgsConstructor
public class ElectricCabinetInspectionController  {

    private final ElectricCabinetInspectionService electricCabinetInspectionService;

    @Operation(summary = "抽屉柜检修试验记录分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-inspection:query')")
    public PageResult<ElectricCabinetInspectionVO> getElectricCabinetInspectionPage(ElectricCabinetInspectionQuery queryParams ) {
        IPage<ElectricCabinetInspectionVO> result = electricCabinetInspectionService.getElectricCabinetInspectionPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增抽屉柜检修试验记录")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-inspection:add')")
    public Result<Void> saveElectricCabinetInspection(@RequestBody @Valid ElectricCabinetInspectionForm formData ) {
        boolean result = electricCabinetInspectionService.saveElectricCabinetInspection(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取抽屉柜检修试验记录表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-inspection:edit')")
    public Result<ElectricCabinetInspectionForm> getElectricCabinetInspectionForm(
        @Parameter(description = "抽屉柜检修试验记录ID") @PathVariable Long id
    ) {
        ElectricCabinetInspectionForm formData = electricCabinetInspectionService.getElectricCabinetInspectionFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改抽屉柜检修试验记录")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-inspection:edit')")
    public Result<Void> updateElectricCabinetInspection(
            @Parameter(description = "抽屉柜检修试验记录ID") @PathVariable Long id,
            @RequestBody @Validated ElectricCabinetInspectionForm formData
    ) {
        boolean result = electricCabinetInspectionService.updateElectricCabinetInspection(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除抽屉柜检修试验记录")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-inspection:delete')")
    public Result<Void> deleteElectricCabinetInspections(
        @Parameter(description = "抽屉柜检修试验记录ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = electricCabinetInspectionService.deleteElectricCabinetInspections(ids);
        return Result.judge(result);
    }
    @Operation(summary = "导出抽屉柜检修试验记录")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-inspection:query')")
    public void exportElectricCabinetInspections(ElectricCabinetInspectionExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "抽屉柜检修试验记录.xslx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<ElectricCabinetInspectionExportDto> electricCabinetInspectionExportDtoList = this.electricCabinetInspectionService.exportElectricCabinetInspections(queryParams);
        EasyExcel.write(response.getOutputStream(), ElectricCabinetInspectionExportDto.class)
                .sheet("抽屉柜检修试验记录").doWrite(electricCabinetInspectionExportDtoList);
    }

    @Operation(summary = "导入抽屉柜检修试验记录")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-inspection:add')")
    public Result<ExcelResult> importElectricCabinetInspections(MultipartFile file) throws IOException {
        ElectricCabinetInspectionImportListener listener = new ElectricCabinetInspectionImportListener();
        ExcelUtils.importExcel(file.getInputStream(), ElectricCabinetInspectionExportDto.class, listener);
        return Result.success(listener.getExcelResult());
    }

    @Operation(summary = "抽屉柜检修试验记录导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateElectricCabinetInspections(HttpServletResponse response) {
        String fileName = "抽屉柜检修试验记录导入模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("抽屉柜检修试验记录导入模板下载失败", e);
        }
    }
}
