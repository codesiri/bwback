package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.SeFanImportListener;
import com.youlai.boot.ledger.listener.SePumpImportListener;
import com.youlai.boot.ledger.model.dto.SeFanExportDto;
import com.youlai.boot.ledger.model.dto.SePumpExportDto;
import com.youlai.boot.ledger.model.query.SePumpQuery;
import com.youlai.boot.ledger.service.SeFanService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SeFanForm;
import com.youlai.boot.ledger.model.query.SeFanQuery;
import com.youlai.boot.ledger.model.vo.SeFanVO;
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
 * 特种设备风机台账前端控制层
 *
 * @author youlaitech
 * @since 2026-02-09 09:18
 */
@Tag(name = "特种设备风机台账接口")
@RestController
@RequestMapping("/api/v1/se-fan")
@RequiredArgsConstructor
public class SeFanController  {

    private final SeFanService seFanService;

    @Operation(summary = "特种设备风机台账分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:se-fan:query')")
    public PageResult<SeFanVO> getSeFanPage(SeFanQuery queryParams ) {
        IPage<SeFanVO> result = seFanService.getSeFanPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增特种设备风机台账")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:se-fan:add')")
    public Result<Void> saveSeFan(@RequestBody @Valid SeFanForm formData ) {
        boolean result = seFanService.saveSeFan(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取特种设备风机台账表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:se-fan:edit')")
    public Result<SeFanForm> getSeFanForm(
        @Parameter(description = "特种设备风机台账ID") @PathVariable Long id
    ) {
        SeFanForm formData = seFanService.getSeFanFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改特种设备风机台账")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:se-fan:edit')")
    public Result<Void> updateSeFan(
            @Parameter(description = "特种设备风机台账ID") @PathVariable Long id,
            @RequestBody @Validated SeFanForm formData
    ) {
        boolean result = seFanService.updateSeFan(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除特种设备风机台账")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:se-fan:delete')")
    public Result<Void> deleteSeFans(
        @Parameter(description = "特种设备风机台账ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = seFanService.deleteSeFans(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出风机台账")
    @GetMapping("/export")
    public void exportSeFan(SeFanQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "风机";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SeFanExportDto> listExportSeFans = seFanService.listExportSeFans(queryParams);
        EasyExcel.write(response.getOutputStream(), SeFanExportDto.class).sheet("导出风机")
                .doWrite(listExportSeFans);
    }


    @Operation(summary = "导入风机台账")
    @PostMapping("/import")
    public Result<ExcelResult> importSeFan(MultipartFile file) throws IOException {
        SeFanImportListener listener = new SeFanImportListener();
        ExcelUtils.importExcel(file.getInputStream(), SeFanExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "风机导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateSeFan(HttpServletResponse response) {
        String fileName = "风机导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("风机导入模板下载失败", e);
        }
    }


}
