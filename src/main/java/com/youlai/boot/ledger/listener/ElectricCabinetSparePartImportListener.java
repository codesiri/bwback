package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.converter.ElectricCabinetSparePartConverter;
import com.youlai.boot.ledger.model.dto.ElectricCabinetSparePartDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetSparePart;
import com.youlai.boot.ledger.service.ElectricCabinetSparePartService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 电器备品备件管理记录导入监听器
 *
 * @author youlaitech
 * @since 2026-04-28
 */
@Slf4j
public class ElectricCabinetSparePartImportListener extends AnalysisEventListener<ElectricCabinetSparePartDto> {

    @Getter
    private final ExcelResult excelResult;
    private final ElectricCabinetSparePartService electricCabinetSparePartService;
    private final ElectricCabinetSparePartConverter electricCabinetSparePartConverter;

    private Integer currentRow = 1;

    public ElectricCabinetSparePartImportListener() {
        this.electricCabinetSparePartService = SpringUtil.getBean(ElectricCabinetSparePartService.class);
        this.electricCabinetSparePartConverter = SpringUtil.getBean(ElectricCabinetSparePartConverter.class);
        this.excelResult = new ExcelResult();
    }

    @Override
    public void invoke(ElectricCabinetSparePartDto dto, AnalysisContext analysisContext) {
        log.info("解析到一条电器备品备件管理记录数据:{}", JSONUtil.toJsonStr(dto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验备件名称
        String ecspPartName = dto.getEcspPartName();
        if (StrUtil.isBlank(ecspPartName)) {
            errorMsg.append("备件名称为空；");
            validation = false;
        }

        // 校验规格型号
        String ecspSpecModel = dto.getEcspSpecModel();
        if (StrUtil.isBlank(ecspSpecModel)) {
            errorMsg.append("规格型号为空；");
            validation = false;
        }

        // 校验所属工厂
        String ecspFactory = dto.getEcspFactory();
        if (StrUtil.isBlank(ecspFactory)) {
            errorMsg.append("所属工厂为空；");
            validation = false;
        }

        if (validation) {
            ElectricCabinetSparePart entity = electricCabinetSparePartConverter.toEntity(dto);
            long id = IDUtil.genIdByLeaf();
            entity.setId(id);

            boolean saveResult = electricCabinetSparePartService.save(entity);
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