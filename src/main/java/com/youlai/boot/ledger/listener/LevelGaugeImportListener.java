package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.converter.LevelGaugeConverter;
import com.youlai.boot.ledger.model.dto.LevelGaugeExportDto;
import com.youlai.boot.ledger.model.entity.LevelGauge;
import com.youlai.boot.ledger.service.LevelGaugeService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LevelGaugeImportListener extends AnalysisEventListener<LevelGaugeExportDto> {
    /**
     * Excel 导入结果
     */
    @Getter
    private final ExcelResult excelResult;
    private final LevelGaugeService levelGaugeService;
    private final LevelGaugeConverter levelGaugeConverter;

    public LevelGaugeImportListener() {
        this.excelResult = new ExcelResult();
        this.levelGaugeService = SpringUtil.getBean(LevelGaugeService.class);
        this.levelGaugeConverter = SpringUtil.getBean(LevelGaugeConverter.class);
    }

    private Integer currentRow = 1;


    @Override
    public void invoke(LevelGaugeExportDto levelGaugeExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条用户数据:{}", JSONUtil.toJsonStr(levelGaugeExportDto));
        String errorMsg = "第" + currentRow + "行数据校验失败：";
        String levelTag = levelGaugeExportDto.getLevelTag();
        boolean validation = true;

        if (StrUtil.isBlank(levelTag)) {
            errorMsg += "位号为空";
            validation = false;
        } else {
            long count = levelGaugeService.count(new LambdaQueryWrapper<LevelGauge>().eq(LevelGauge::getLevelTag, levelTag));
            if (count > 0) {
                errorMsg += "位号已存在；";
                validation = false;
            }
        }
        if (validation) {
            //执行入库
            LevelGauge entity = levelGaugeConverter.toEntity(levelGaugeExportDto);
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            //生成id
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult = levelGaugeService.save(entity);
            if (saveResult) {
                excelResult.setValidCount(excelResult.getValidCount() + 1);
            } else {
                excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
                errorMsg += "第" + currentRow + "行数据保存失败；";
                excelResult.getMessageList().add(errorMsg);
            }
        } else {
            excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
            excelResult.getMessageList().add(errorMsg);
        }
        currentRow++;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
