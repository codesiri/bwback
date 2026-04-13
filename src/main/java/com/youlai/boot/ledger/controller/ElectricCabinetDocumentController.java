package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.ElectricCabinetDocumentsListener;
import com.youlai.boot.ledger.model.dto.ElectricCabinetDocumentExportDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetDocumentsExportQuery;
import com.youlai.boot.ledger.service.ElectricCabinetDocumentService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ElectricCabinetDocumentForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetDocumentQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetDocumentVO;
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
 * 抽屉柜相关资料归档前端控制层
 *
 * @author dazao
 * @since 2026-03-12 09:11
 */
@Tag(name = "抽屉柜相关资料归档接口")
@RestController
@RequestMapping("/api/v1/electric-cabinet-document")
@RequiredArgsConstructor
public class ElectricCabinetDocumentController {

    private final ElectricCabinetDocumentService electricCabinetDocumentService;

    @Operation(summary = "抽屉柜相关资料归档分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-document:query')")
    public PageResult<ElectricCabinetDocumentVO> getElectricCabinetDocumentPage(ElectricCabinetDocumentQuery queryParams) {
        IPage<ElectricCabinetDocumentVO> result = electricCabinetDocumentService.getElectricCabinetDocumentPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增抽屉柜相关资料归档")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-document:add')")
    public Result<Void> saveElectricCabinetDocument(@RequestBody @Valid ElectricCabinetDocumentForm formData) {
        boolean result = electricCabinetDocumentService.saveElectricCabinetDocument(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取抽屉柜相关资料归档表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-document:edit')")
    public Result<ElectricCabinetDocumentForm> getElectricCabinetDocumentForm(
            @Parameter(description = "抽屉柜相关资料归档ID") @PathVariable Long id
    ) {
        ElectricCabinetDocumentForm formData = electricCabinetDocumentService.getElectricCabinetDocumentFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改抽屉柜相关资料归档")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-document:edit')")
    public Result<Void> updateElectricCabinetDocument(
            @Parameter(description = "抽屉柜相关资料归档ID") @PathVariable Long id,
            @RequestBody @Validated ElectricCabinetDocumentForm formData
    ) {
        boolean result = electricCabinetDocumentService.updateElectricCabinetDocument(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除抽屉柜相关资料归档")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-document:delete')")
    public Result<Void> deleteElectricCabinetDocuments(
            @Parameter(description = "抽屉柜相关资料归档ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = electricCabinetDocumentService.deleteElectricCabinetDocuments(ids);
        return Result.judge(result);
    }

    @Operation(summary = "下载抽屉柜相关资料归档导入模板")
    @GetMapping("/template")
    public void templateElectricCabinetDocuments(HttpServletResponse response) {
        String fileName = "抽屉柜相关资料归档导入模板.xslx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);
        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("抽屉柜相关资料归档导入模板", e);
        }
    }

    @Operation(summary = "导出抽屉柜相关资料归档表")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-document:query')")
    public void exportElectricCabinetDocuments(ElectricCabinetDocumentsExportQuery queryParams,
                                               HttpServletResponse response) throws IOException {
        String fileName = "抽屉柜相关资料归档表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<ElectricCabinetDocumentExportDto> exportElectricCabinetDocuments =
                this.electricCabinetDocumentService.exportElectricCabinetDocuments(queryParams);
        EasyExcel.write(response.getOutputStream(),
                ElectricCabinetDocumentExportDto.class)
                .sheet("抽屉柜相关资料归档表").doWrite(exportElectricCabinetDocuments
                );
    }
    @Operation(summary = "导入抽屉柜相关资料归档表")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-document:query')")
    public Result<ExcelResult> importElectricCabinetDocuments(MultipartFile file) throws IOException {
        var electricCabinetDocumentListener = new ElectricCabinetDocumentsListener();
        ExcelUtils.importExcel(file.getInputStream(), ElectricCabinetDocumentExportDto.class,electricCabinetDocumentListener);
        return Result.success(electricCabinetDocumentListener.getExcelResult());
    }
}
