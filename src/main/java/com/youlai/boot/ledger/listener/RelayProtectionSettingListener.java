package com.youlai.boot.ledger.listener;

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
import jodd.util.StringUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

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
        log.info("解析到一条用户数据:{}", JSONUtil.toJsonStr(relayProtectionSettingExportDto));
        boolean validation = true;
        String errorMsg = "第" + currentRow + "行数据校验失败：";
        String code = relayProtectionSettingExportDto.getRpsRelayCode();
        if (StringUtil.isBlank(code)) {
            validation = false;
            errorMsg += "继电器编号为空";
        } else {
            long count = this.relayProtectionSettingService.
                    count(new QueryWrapper<RelayProtectionSetting>()
                            .eq("rps_relay_code", code));
            if (count > 0) {
                errorMsg += "继电器编号已经存在";
                validation = false;
            }
            if (validation) {
                RelayProtectionSetting entity = relayProtectionSettingConverter.toEntity(relayProtectionSettingExportDto);
                //TODO 上线替换为美团leaf id 生成器
                long id = genIdByJdk();
                entity.setId(id);
                boolean saveResult=this.relayProtectionSettingService.save(entity);
                if(saveResult){
                    excelResult.setValidCount(excelResult.getValidCount() + 1);
                }else{
                    excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
                    errorMsg += "第" + currentRow + "行数据保存失败；";
                    excelResult.getMessageList().add(errorMsg);
                }
            }else{
                excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
                excelResult.getMessageList().add(errorMsg);
            }
            currentRow ++;
        }

    }

    private long genIdByJdk() {
        IDGenAdapterJDK idGenAdapterJDK = new IDGenAdapterJDK();
        return idGenAdapterJDK.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
