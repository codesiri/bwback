package com.youlai.boot.ledger.controller;

import cn.idev.excel.EasyExcel;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.listener.ElectricCabinetFaultListener;
import com.youlai.boot.ledger.model.dto.ElectricCabinetFaultExportDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetFaultExportQuery;
import com.youlai.boot.ledger.service.ElectricCabinetFaultService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.ledger.model.form.ElectricCabinetFaultForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetFaultQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetFaultVO;
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
 * 抽屉柜故障维修记录前端控制层
 *
 * @author youlaitech
 * @since 2026-03-23 17:05
 */
@Tag(name = "抽屉柜故障维修记录接口")
@RestController
@RequestMapping("/api/v1/electric-cabinet-fault")
@RequiredArgsConstructor
public class ElectricCabinetFaultController  {

    private final ElectricCabinetFaultService electricCabinetFaultService;

    @Operation(summary = "抽屉柜故障维修记录分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-fault:query')")
    public PageResult<ElectricCabinetFaultVO> getElectricCabinetFaultPage(ElectricCabinetFaultQuery queryParams ) {
        IPage<ElectricCabinetFaultVO> result = electricCabinetFaultService.getElectricCabinetFaultPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增抽屉柜故障维修记录")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-fault:add')")
    public Result<Void> saveElectricCabinetFault(@RequestBody @Valid ElectricCabinetFaultForm formData ) {
        boolean result = electricCabinetFaultService.saveElectricCabinetFault(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取抽屉柜故障维修记录表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-fault:edit')")
    public Result<ElectricCabinetFaultForm> getElectricCabinetFaultForm(
        @Parameter(description = "抽屉柜故障维修记录ID") @PathVariable Long id
    ) {
        ElectricCabinetFaultForm formData = electricCabinetFaultService.getElectricCabinetFaultFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改抽屉柜故障维修记录")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-fault:edit')")
    public Result<Void> updateElectricCabinetFault(
            @Parameter(description = "抽屉柜故障维修记录ID") @PathVariable Long id,
            @RequestBody @Validated ElectricCabinetFaultForm formData
    ) {
        boolean result = electricCabinetFaultService.updateElectricCabinetFault(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除抽屉柜故障维修记录")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-fault:delete')")
    public Result<Void> deleteElectricCabinetFaults(
        @Parameter(description = "抽屉柜故障维修记录ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = electricCabinetFaultService.deleteElectricCabinetFaults(ids);
        return Result.judge(result);
    }
    @Operation(summary = "导出抽屉柜故障维修记录")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-fault:query')")
    public void exportElectricCabinetFaults(ElectricCabinetFaultExportQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "抽屉柜故障维修记录.xslx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<ElectricCabinetFaultExportDto> exportElectricCabinetFaults =
                this.electricCabinetFaultService.exportElectricCabinetFaults(queryParams);
        EasyExcel.write(response.getOutputStream(),
                ElectricCabinetFaultExportDto.class)
                .sheet("抽屉柜故障维修记录").doWrite(exportElectricCabinetFaults);
    }
    @Operation(summary = "导入抽屉柜故障维修记录")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('ledger:electric-cabinet-fault:add')")
    public Result<ExcelResult> importElectricCabinetFaults(MultipartFile file) throws IOException {
        var electricCabinetFaultListener = new ElectricCabinetFaultListener();
        ExcelUtils.importExcel(file.getInputStream(), ElectricCabinetFaultExportDto.class,electricCabinetFaultListener);
        return Result.success(electricCabinetFaultListener.getExcelResult());
    }
}
