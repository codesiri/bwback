package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.ElectricCabinetMainComponentImportListener;
import com.youlai.boot.ledger.model.dto.ElectricCabinetMainComponentDto;
import com.youlai.boot.ledger.service.ElectricCabinetMainComponentService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ElectricCabinetMainComponentForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetMainComponentQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetMainComponentVO;
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
 * 抽屉柜主要元器件信息前端控制层
 *
 * @author youlaitech
 * @since 2026-03-17 09:38
 */
@Tag(name = "抽屉柜主要元器件信息接口")
@RestController
@RequestMapping("/api/v1/electric-cabinet-main-component")
@RequiredArgsConstructor
public class ElectricCabinetMainComponentController  {

    private final ElectricCabinetMainComponentService electricCabinetMainComponentService;

    @Operation(summary = "抽屉柜主要元器件信息分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-main-component:query')")
    public PageResult<ElectricCabinetMainComponentVO> getElectricCabinetMainComponentPage(ElectricCabinetMainComponentQuery queryParams ) {
        IPage<ElectricCabinetMainComponentVO> result = electricCabinetMainComponentService.getElectricCabinetMainComponentPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增抽屉柜主要元器件信息")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-main-component:add')")
    public Result<Void> saveElectricCabinetMainComponent(@RequestBody @Valid ElectricCabinetMainComponentForm formData ) {
        boolean result = electricCabinetMainComponentService.saveElectricCabinetMainComponent(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取抽屉柜主要元器件信息表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-main-component:edit')")
    public Result<ElectricCabinetMainComponentForm> getElectricCabinetMainComponentForm(
        @Parameter(description = "抽屉柜主要元器件信息ID") @PathVariable Long id
    ) {
        ElectricCabinetMainComponentForm formData = electricCabinetMainComponentService.getElectricCabinetMainComponentFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改抽屉柜主要元器件信息")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-main-component:edit')")
    public Result<Void> updateElectricCabinetMainComponent(
            @Parameter(description = "抽屉柜主要元器件信息ID") @PathVariable Long id,
            @RequestBody @Validated ElectricCabinetMainComponentForm formData
    ) {
        boolean result = electricCabinetMainComponentService.updateElectricCabinetMainComponent(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除抽屉柜主要元器件信息")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-main-component:delete')")
    public Result<Void> deleteElectricCabinetMainComponents(
        @Parameter(description = "抽屉柜主要元器件信息ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = electricCabinetMainComponentService.deleteElectricCabinetMainComponents(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出抽屉柜主要元器件信息")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-main-component:query')")
    public void exportElectricCabinetMainComponents(HttpServletResponse response) throws IOException {
        String fileName = "抽屉柜主要元器件信息.xslx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<ElectricCabinetMainComponentDto> exportElectricCabinetMainComponents =
                this.electricCabinetMainComponentService.exportElectricCabinetMainComponents();
        EasyExcel.write(response.getOutputStream(),
                        ElectricCabinetMainComponentDto.class)
                .sheet("抽屉柜主要元器件信息")
                .doWrite(exportElectricCabinetMainComponents);
    }

    @Operation(summary = "导入抽屉柜主要元器件信息")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-main-component:add')")
    public Result<ExcelResult> importElectricCabinetMainComponents(MultipartFile file) throws IOException {
        ElectricCabinetMainComponentImportListener listener = new ElectricCabinetMainComponentImportListener();
        ExcelUtils.importExcel(file.getInputStream(), ElectricCabinetMainComponentDto.class, listener);
        return Result.success(listener.getExcelResult());
    }

    @Operation(summary = "抽屉柜主要元器件信息导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateElectricCabinetMainComponents(HttpServletResponse response) {
        String fileName = "抽屉柜主要元器件信息导入模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("抽屉柜主要元器件信息导入模板下载失败", e);
        }
    }
}
