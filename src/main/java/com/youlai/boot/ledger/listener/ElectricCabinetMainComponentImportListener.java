package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.converter.ElectricCabinetMainComponentConverter;
import com.youlai.boot.ledger.model.dto.ElectricCabinetMainComponentDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetMainComponent;
import com.youlai.boot.ledger.service.ElectricCabinetMainComponentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 抽屉柜主要元器件信息导入监听器
 *
 * @author youlaitech
 * @since 2026-04-28
 */
@Slf4j
public class ElectricCabinetMainComponentImportListener extends AnalysisEventListener<ElectricCabinetMainComponentDto> {

    @Getter
    private final ExcelResult excelResult;
    private final ElectricCabinetMainComponentService electricCabinetMainComponentService;
    private final ElectricCabinetMainComponentConverter electricCabinetMainComponentConverter;

    private Integer currentRow = 1;

    public ElectricCabinetMainComponentImportListener() {
        this.electricCabinetMainComponentService = SpringUtil.getBean(ElectricCabinetMainComponentService.class);
        this.electricCabinetMainComponentConverter = SpringUtil.getBean(ElectricCabinetMainComponentConverter.class);
        this.excelResult = new ExcelResult();
    }

    @Override
    public void invoke(ElectricCabinetMainComponentDto dto, AnalysisContext analysisContext) {
        log.info("解析到一条抽屉柜主要元器件数据:{}", JSONUtil.toJsonStr(dto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验元器件名称
        String ecmComponentName = dto.getEcmComponentName();
        if (StrUtil.isBlank(ecmComponentName)) {
            errorMsg.append("元器件名称为空；");
            validation = false;
        }

        // 校验规格型号
        String ecmSpecModel = dto.getEcmSpecModel();
        if (StrUtil.isBlank(ecmSpecModel)) {
            errorMsg.append("规格型号为空；");
            validation = false;
        }

        // 校验所属工厂
        String ecmFactory = dto.getEcmFactory();
        if (StrUtil.isBlank(ecmFactory)) {
            errorMsg.append("所属工厂为空；");
            validation = false;
        }

        if (validation) {
            ElectricCabinetMainComponent entity = electricCabinetMainComponentConverter.toEntity(dto);
            long id = IDUtil.genIdByLeaf();
            entity.setId(id);

            boolean saveResult = electricCabinetMainComponentService.save(entity);
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