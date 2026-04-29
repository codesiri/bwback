package com.youlai.boot.maintence.controller;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.ExcelWriter;
import com.youlai.boot.common.util.ExcelUtils;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.maintence.listener.MaintainPlanImportListener;
import com.youlai.boot.maintence.model.dto.MaintainPlanExportDto;
import com.youlai.boot.maintence.service.MaintainPlanService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.maintence.model.form.MaintainPlanForm;
import com.youlai.boot.maintence.model.query.MaintainPlanQuery;
import com.youlai.boot.maintence.model.vo.MaintainPlanVO;
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
 * 维修计划前端控制层
 *
 * @author youlaitech
 * @since 2026-04-10 08:37
 */
@Tag(name = "维修计划接口")
@RestController
@RequestMapping("/api/v1/maintain-plan")
@RequiredArgsConstructor
public class MaintainPlanController  {

    private final MaintainPlanService maintainPlanService;

    @Operation(summary = "维修计划分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('maintence:maintain-plan:query')")
    public PageResult<MaintainPlanVO> getMaintainPlanPage(MaintainPlanQuery queryParams ) {
        IPage<MaintainPlanVO> result = maintainPlanService.getMaintainPlanPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增维修计划")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('maintence:maintain-plan:add')")
    public Result<Void> saveMaintainPlan(@RequestBody @Valid MaintainPlanForm formData ) {
        boolean result = maintainPlanService.saveMaintainPlan(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取维修计划表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('maintence:maintain-plan:edit')")
    public Result<MaintainPlanForm> getMaintainPlanForm(
        @Parameter(description = "维修计划ID") @PathVariable Long id
    ) {
        MaintainPlanForm formData = maintainPlanService.getMaintainPlanFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改维修计划")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('maintence:maintain-plan:edit')")
    public Result<Void> updateMaintainPlan(
            @Parameter(description = "维修计划ID") @PathVariable Long id,
            @RequestBody @Validated MaintainPlanForm formData
    ) {
        boolean result = maintainPlanService.updateMaintainPlan(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除维修计划")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('maintence:maintain-plan:delete')")
    public Result<Void> deleteMaintainPlans(
        @Parameter(description = "维修计划ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = maintainPlanService.deleteMaintainPlans(ids);
        return Result.judge(result);
    }

    @Operation(summary = "导出维修计划")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPerm('maintence:maintain-plan:query')")
    public void exportMaintainPlans(HttpServletResponse response) throws IOException {
        String fileName = "维修计划.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        List<MaintainPlanExportDto> exportMaintainPlans = this.maintainPlanService.exportMaintainPlans();
        EasyExcel.write(response.getOutputStream(), MaintainPlanExportDto.class)
                .sheet("维修计划")
                .doWrite(exportMaintainPlans);
    }

    @Operation(summary = "导入维修计划")
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPerm('maintence:maintain-plan:add')")
    public Result<ExcelResult> importMaintainPlans(MultipartFile file) throws IOException {
        MaintainPlanImportListener listener = new MaintainPlanImportListener();
        ExcelUtils.importExcel(file.getInputStream(), MaintainPlanExportDto.class, listener);
        return Result.success(listener.getExcelResult());
    }

    @Operation(summary = "维修计划导入模板下载")
    @GetMapping("/template")
    public void downloadTemplateMaintainPlans(HttpServletResponse response) {
        String fileName = "维修计划导入模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        try (ServletOutputStream outputStream = response.getOutputStream();
             ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build()) {
            excelWriter.finish();
        } catch (IOException e) {
            throw new RuntimeException("维修计划导入模板下载失败", e);
        }
    }
}
