package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.SeHorizontalTankImportListener;
import com.youlai.boot.ledger.model.dto.SeHorizontalTankExportDto;
import com.youlai.boot.ledger.service.SeHorizontalTankService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.SeHorizontalTankForm;
import com.youlai.boot.ledger.model.query.SeHorizontalTankQuery;
import com.youlai.boot.ledger.model.vo.SeHorizontalTankVO;
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
 * 卧罐前端控制层
 *
 * @author baiwei
 * @since 2026-03-06 09:33
 */
@Tag(name = "卧罐接口")
@RestController
@RequestMapping("/api/v1/se-horizontal-tank")
@RequiredArgsConstructor
public class SeHorizontalTankController  {

    private final SeHorizontalTankService seHorizontalTankService;

    @Operation(summary = "卧罐分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:se-horizontal-tank:query')")
    public PageResult<SeHorizontalTankVO> getSeHorizontalTankPage(SeHorizontalTankQuery queryParams ) {
        IPage<SeHorizontalTankVO> result = seHorizontalTankService.getSeHorizontalTankPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增卧罐")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:se-horizontal-tank:add')")
    public Result<Void> saveSeHorizontalTank(@RequestBody @Valid SeHorizontalTankForm formData ) {
        boolean result = seHorizontalTankService.saveSeHorizontalTank(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取卧罐表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:se-horizontal-tank:edit')")
    public Result<SeHorizontalTankForm> getSeHorizontalTankForm(
        @Parameter(description = "卧罐ID") @PathVariable Long id
    ) {
        SeHorizontalTankForm formData = seHorizontalTankService.getSeHorizontalTankFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改卧罐")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:se-horizontal-tank:edit')")
    public Result<Void> updateSeHorizontalTank(
            @Parameter(description = "卧罐ID") @PathVariable Long id,
            @RequestBody @Validated SeHorizontalTankForm formData
    ) {
        boolean result = seHorizontalTankService.updateSeHorizontalTank(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除卧罐")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:se-horizontal-tank:delete')")
    public Result<Void> deleteSeHorizontalTanks(
        @Parameter(description = "卧罐ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = seHorizontalTankService.deleteSeHorizontalTanks(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出卧罐")
    @GetMapping("/export")
    public void exportSeHorizontalTanks(SeHorizontalTankQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "卧罐";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<SeHorizontalTankExportDto> listExportSeHorizontalTanks = seHorizontalTankService.listExportSeHorizontalTanks(queryParams);
        EasyExcel.write(response.getOutputStream(), SeHorizontalTankExportDto.class).sheet("导出卧罐")
                .doWrite(listExportSeHorizontalTanks);
    }


    @Operation(summary = "导入卧罐")
    @PostMapping("/import")
    public Result<ExcelResult> importSeHorizontalTank(MultipartFile file) throws IOException {
        SeHorizontalTankImportListener listener = new SeHorizontalTankImportListener();
        ExcelUtils.importExcel(file.getInputStream(), SeHorizontalTankExportDto.class,listener);
        return Result.success(listener.getExcelResult());
    }


    @Operation(summary = "泵导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateSeHorizontalTank(HttpServletResponse response) {
        String fileName = "卧罐导入模板下载.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("卧罐导入模板下载失败", e);
        }
    }


}
