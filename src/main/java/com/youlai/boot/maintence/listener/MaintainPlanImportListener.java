package com.youlai.boot.maintence.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.maintence.converter.MaintainPlanConverter;
import com.youlai.boot.maintence.model.dto.MaintainPlanExportDto;
import com.youlai.boot.maintence.model.entity.MaintainPlan;
import com.youlai.boot.maintence.service.MaintainPlanService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 维修计划导入监听器
 *
 * @author youlaitech
 * @since 2026-04-28
 */
@Slf4j
public class MaintainPlanImportListener extends AnalysisEventListener<MaintainPlanExportDto> {

    @Getter
    private final ExcelResult excelResult;
    private final MaintainPlanService maintainPlanService;
    private final MaintainPlanConverter maintainPlanConverter;

    private Integer currentRow = 1;

    public MaintainPlanImportListener() {
        this.maintainPlanService = SpringUtil.getBean(MaintainPlanService.class);
        this.maintainPlanConverter = SpringUtil.getBean(MaintainPlanConverter.class);
        this.excelResult = new ExcelResult();
    }

    @Override
    public void invoke(MaintainPlanExportDto dto, AnalysisContext analysisContext) {
        log.info("解析到一条维修计划数据:{}", JSONUtil.toJsonStr(dto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验设备编号
        String maintainPlanEquipCode = dto.getMaintainPlanEquipCode();
        if (StrUtil.isBlank(maintainPlanEquipCode)) {
            errorMsg.append("设备编号为空；");
            validation = false;
        }

        // 校验设备名称
        String maintainPlanEquipName = dto.getMaintainPlanEquipName();
        if (StrUtil.isBlank(maintainPlanEquipName)) {
            errorMsg.append("设备名称为空；");
            validation = false;
        }

        // 校验计划类型
        String maintainPlanType = dto.getMaintainPlanType();
        if (StrUtil.isBlank(maintainPlanType)) {
            errorMsg.append("计划类型为空；");
            validation = false;
        }

        if (validation) {
            MaintainPlan entity = maintainPlanConverter.toEntity(dto);
            long id = IDUtil.genIdByLeaf();
            entity.setId(id);

            boolean saveResult = maintainPlanService.save(entity);
            if (saveResult) {
                excelResult.setValidCount(excelResult.getValidCount() + 1);
            } else {
                excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
                errorMsg = new StringBuilder("第" + currentRow + "行数据保存失败；");
                excelResult.getMessageList().add(errorMsg.toString());
            }
        } else {
            excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
            excelResult.getMessageList().add(errorMsg.toString());
        }
        currentRow++;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }
}