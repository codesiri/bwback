package com.youlai.boot.ledger.listener;

import cn.hutool.core.lang.Assert;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDGenAdapterJDK;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.converter.GroundSystemEquipmentConverter;
import com.youlai.boot.ledger.model.dto.GroundSystemEquipmentExportDto;
import com.youlai.boot.ledger.model.entity.GroundSystemEquipment;
import com.youlai.boot.ledger.service.GroundSystemEquipmentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroundSystemEquipmentsImportListener extends AnalysisEventListener<GroundSystemEquipmentExportDto> {
    @Getter
    private ExcelResult excelResult;
    private GroundSystemEquipmentService groundSystemEquipmentService;
    private GroundSystemEquipmentConverter groundSystemEquipmentConverter;

    private Integer currentRow = 1;

    public GroundSystemEquipmentsImportListener(){
        this.excelResult = new ExcelResult();
        this.groundSystemEquipmentConverter = SpringUtil.getBean(GroundSystemEquipmentConverter.class);
        this.groundSystemEquipmentService = SpringUtil.getBean(GroundSystemEquipmentService.class);
    }

    @Override
    public void invoke(GroundSystemEquipmentExportDto groundSystemEquipmentExportDto, AnalysisContext analysisContext) {
        log.info("解析到第一条数据: {}", JSONUtil.toJsonStr(groundSystemEquipmentExportDto));
        boolean validation = true;
        String errorMsg = "第" + currentRow + "行数据校验失败：";
        String gseGroundCode = groundSystemEquipmentExportDto.getGseGroundCode();
        long count = this.groundSystemEquipmentService
                .count(new QueryWrapper<GroundSystemEquipment>().eq("gse_ground_code", gseGroundCode));
        Assert.isTrue(count == 0 , "编号已经存在");
        if(validation){
            GroundSystemEquipment entity = this
                    .groundSystemEquipmentConverter
                    .toEntity(groundSystemEquipmentExportDto);
            long id = idGenByJdk();
            entity.setId(id);
            boolean saveResult = this.groundSystemEquipmentService.save(entity);
            if(saveResult){
                excelResult.setInvalidCount(excelResult.getValidCount() + 1);
            }else{
                excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
                errorMsg += "第" + currentRow + "行数据保存失败；";
                excelResult.getMessageList().add(errorMsg);
            }
        }else{
            excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
            errorMsg += "第" + currentRow + "行数据保存失败；";
            excelResult.getMessageList().add(errorMsg);
        }
        currentRow ++;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
    //TODO 改为美团leaf生成id
    private long idGenByJdk(){
        IDGenAdapterJDK idGenAdapterJDK = new IDGenAdapterJDK();
        return idGenAdapterJDK.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
    }
}
