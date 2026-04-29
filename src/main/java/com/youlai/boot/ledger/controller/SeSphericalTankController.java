package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.SeHeaterImportListener;
import com.youlai.boot.ledger.listener.SeSphericalTankImportListener;
import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SeSphericalTankExportDto;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.service.SeSphericalTankService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SeSphericalTankForm;
import com.youlai.boot.ledger.model.query.SeSphericalTankQuery;
import com.youlai.boot.ledger.model.vo.SeSphericalTankVO;
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
 * 球罐前端控制层
 *
 * @author baiwei
 * @since 2026-03-06 09:49
 */
@Tag(name = "球罐接口")
@RestController
@RequestMapping("/api/v1/se-spherical-tank")
@RequiredArgsConstructor
public class SeSphericalTankController  {

    private final SeSphericalTankService seSphericalTankService;

    @Operation(summary = "球罐分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:se-spherical-tank:query')")
    public PageResult<SeSphericalTankVO> getSeSphericalTankPage(SeSphericalTankQuery queryParams ) {
        IPage<SeSphericalTankVO> result = seSphericalTankService.getSeSphericalTankPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增球罐")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:se-spherical-tank:add')")
    public Result<Void> saveSeSphericalTank(@RequestBody @Valid SeSphericalTankForm formData ) {
        boolean result = seSphericalTankService.saveSeSphericalTank(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取球罐表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:se-spherical-tank:edit')")
    public Result<SeSphericalTankForm> getSeSphericalTankForm(
        @Parameter(description = "球罐ID") @PathVariable Long id
    ) {
        SeSphericalTankForm formData = seSphericalTankService.getSeSphericalTankFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改球罐")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:se-spherical-tank:edit')")
    public Result<Void> updateSeSphericalTank(
            @Parameter(description = "球罐ID") @PathVariable Long id,
            @RequestBody @Validated SeSphericalTankForm formData
    ) {
        boolean result = seSphericalTankService.updateSeSphericalTank(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除球罐")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:se-spherical-tank:delete')")
    public Result<Void> deleteSeSphericalTanks(
        @Parameter(description = "球罐ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = seSphericalTankService.deleteSeSphericalTanks(ids);
        return Result.judge(result);
    }


    @Operation(summary = "导出球罐")
    @GetMapping("/export")
    public void exportSeSphericalTanks(SeSphericalTankQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "球罐";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SeSphericalTankExportDto> listExportSeSphericalTank = seSphericalTankService.listExportSeSphericalTank(queryParams);
        EasyExcel.write(response.getOutputStream(), SeSphericalTankExportDto.class).sheet("导出球罐")
                .doWrite(listExportSeSphericalTank);
    }


    @Operation(summary = "导入球罐")
    @PostMapping("/import")
    public Result<ExcelResult> importSeSphericalTanks(MultipartFile file) throws IOException {
        SeSphericalTankImportListener listener = new SeSphericalTankImportListener();
        ExcelUtils.importExcel(file.getInputStream(), SeSphericalTankExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "球罐导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateSeSphericalTanks(HttpServletResponse response) {
        String fileName = "球罐导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("球罐导入模板下载失败", e);
        }
    }




}
