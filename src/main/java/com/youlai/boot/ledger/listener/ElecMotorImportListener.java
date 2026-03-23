package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.converter.ElecMotorConverter;
import com.youlai.boot.ledger.model.dto.ElecMotorsExportDto;
import com.youlai.boot.ledger.model.entity.ElecMotor;
import com.youlai.boot.ledger.service.ElecMotorService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ElecMotorImportListener extends AnalysisEventListener<ElecMotorsExportDto> {
    @Getter
    private final ExcelResult excelResult;
    private final ElecMotorService elecMotorService;
    private final ElecMotorConverter elecMotorConverter;
    private Integer currentRow = 1;

    public ElecMotorImportListener() {
        this.excelResult = new ExcelResult();
        this.elecMotorService = SpringUtil.getBean(ElecMotorService.class);
        this.elecMotorConverter = SpringUtil.getBean(ElecMotorConverter.class);
    }


    @Override
    public void invoke(ElecMotorsExportDto elecMotorsExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条用户数据:{}", JSONUtil.toJsonStr(elecMotorsExportDto));
        String errorMsg = "第" + currentRow + "行数据校验失败：";
        String levelTag = elecMotorsExportDto.getElecMotorTag();
        boolean validation = true;
        if (StrUtil.isBlank(levelTag)) {
            errorMsg += "位号为空";
            validation = false;
        } else {
            long count = this.elecMotorService.count(new QueryWrapper<ElecMotor>().eq("elec_motor_tag", levelTag));
            if (count > 0) {
                errorMsg += "位号已经存在";
                validation = false;
            }
        }
        if (validation) {
            ElecMotor entity = this.elecMotorConverter.toEntity(elecMotorsExportDto);
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setElecMotorId(id);
            boolean saveResult = this.elecMotorService.save(entity);
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
