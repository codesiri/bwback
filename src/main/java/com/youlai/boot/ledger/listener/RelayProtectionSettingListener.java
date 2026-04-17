package com.youlai.boot.ledger.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDGenAdapterJDK;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.converter.RelayProtectionSettingConverter;
import com.youlai.boot.ledger.model.dto.RelayProtectionSettingExportDto;
import com.youlai.boot.ledger.model.entity.RelayProtectionSetting;
import com.youlai.boot.ledger.service.RelayProtectionSettingService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
public class RelayProtectionSettingListener extends AnalysisEventListener<RelayProtectionSettingExportDto> {
    @Getter
    private ExcelResult excelResult;
    private RelayProtectionSettingService relayProtectionSettingService;
    private RelayProtectionSettingConverter relayProtectionSettingConverter;

    private Integer currentRow = 1;

    public RelayProtectionSettingListener() {
        this.excelResult = new ExcelResult();
        this.relayProtectionSettingService = SpringUtil.getBean(RelayProtectionSettingService.class);
        this.relayProtectionSettingConverter = SpringUtil.getBean(RelayProtectionSettingConverter.class);
    }


    @Override
    public void invoke(RelayProtectionSettingExportDto relayProtectionSettingExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条继电保护定值数据:{}", JSONUtil.toJsonStr(relayProtectionSettingExportDto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验继电器编号
        String rpsRelayCode = relayProtectionSettingExportDto.getRpsRelayCode();
        if (StrUtil.isBlank(rpsRelayCode)) {
            errorMsg.append("继电器编号为空；");
            validation = false;
        } else {
            long count = this.relayProtectionSettingService.
                    count(new QueryWrapper<RelayProtectionSetting>()
                            .eq("rps_relay_code", rpsRelayCode));
            if (count > 0) {
                errorMsg.append("继电器编号已存在；");
                validation = false;
            }
        }

        // 校验继电器类型
        String rpsRelayType = relayProtectionSettingExportDto.getRpsRelayType();
        if (StrUtil.isBlank(rpsRelayType)) {
            errorMsg.append("继电器类型为空；");
            validation = false;
        }

        // 校验继电器型号
        String rpsRelayModel = relayProtectionSettingExportDto.getRpsRelayModel();
        if (StrUtil.isBlank(rpsRelayModel)) {
            errorMsg.append("继电器型号为空；");
            validation = false;
        }

        // 校验定值整定日期
        LocalDate rpsSettingDate = relayProtectionSettingExportDto.getRpsSettingDate();
        if (rpsSettingDate == null) {
            errorMsg.append("定值整定日期为空；");
            validation = false;
        }

        // 校验整定人员
        String rpsSettingPerson = relayProtectionSettingExportDto.getRpsSettingPerson();
        if (StrUtil.isBlank(rpsSettingPerson)) {
            errorMsg.append("整定人员为空；");
            validation = false;
        }

        // 校验安装位置
        String rpsInstallPosition = relayProtectionSettingExportDto.getRpsInstallPosition();
        if (StrUtil.isBlank(rpsInstallPosition)) {
            errorMsg.append("安装位置为空；");
            validation = false;
        }

        // 校验所属工厂
        String rpsFactory = relayProtectionSettingExportDto.getRpsFactory();
        if (StrUtil.isBlank(rpsFactory)) {
            errorMsg.append("所属工厂为空；");
            validation = false;
        }

        if (validation) {
            // 校验通过，持久化至数据库
            RelayProtectionSetting entity = relayProtectionSettingConverter.toEntity(relayProtectionSettingExportDto);
            long id = genIdByJdk();
            entity.setId(id);
            boolean saveResult = this.relayProtectionSettingService.save(entity);
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

    private long genIdByJdk() {
        IDGenAdapterJDK idGenAdapterJDK = new IDGenAdapterJDK();
        return idGenAdapterJDK.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
