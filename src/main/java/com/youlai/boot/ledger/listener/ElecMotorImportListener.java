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

import java.time.LocalDateTime;

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
        log.info("解析到一条电机数据:{}", JSONUtil.toJsonStr(elecMotorsExportDto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验位号
        String elecMotorTag = elecMotorsExportDto.getElecMotorTag();
        if (StrUtil.isBlank(elecMotorTag)) {
            errorMsg.append("位号为空；");
            validation = false;
        } else {
            long count = this.elecMotorService.count(new QueryWrapper<ElecMotor>().eq("elec_motor_tag", elecMotorTag));
            if (count > 0) {
                errorMsg.append("位号已存在；");
                validation = false;
            }
        }

        // 校验工艺名称
        String elecMotorProcess = elecMotorsExportDto.getElecMotorProcess();
        if (StrUtil.isBlank(elecMotorProcess)) {
            errorMsg.append("工艺名称为空；");
            validation = false;
        }

        // 校验型号
        String elecMotorModel = elecMotorsExportDto.getElecMotorModel();
        if (StrUtil.isBlank(elecMotorModel)) {
            errorMsg.append("型号为空；");
            validation = false;
        }

        // 校验出厂编号
        String elecMotorFactoryNo = elecMotorsExportDto.getElecMotorFactoryNo();
        if (StrUtil.isBlank(elecMotorFactoryNo)) {
            errorMsg.append("出厂编号为空；");
            validation = false;
        }

        // 校验生产日期
        LocalDateTime elecMotorProdDate = elecMotorsExportDto.getElecMotorProdDate();
        if (elecMotorProdDate == null) {
            errorMsg.append("生产日期为空；");
            validation = false;
        }

        // 校验生产厂家
        String elecMotorManufacturer = elecMotorsExportDto.getElecMotorManufacturer();
        if (StrUtil.isBlank(elecMotorManufacturer)) {
            errorMsg.append("生产厂家为空；");
            validation = false;
        }

        if (validation) {
            // 校验通过，持久化至数据库
            ElecMotor entity = this.elecMotorConverter.toEntity(elecMotorsExportDto);
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setElecMotorId(id);
            boolean saveResult = this.elecMotorService.save(entity);
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

    }
}
