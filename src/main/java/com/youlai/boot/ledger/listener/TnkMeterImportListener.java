package com.youlai.boot.ledger.listener;

import cn.hutool.core.lang.Assert;
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
import com.youlai.boot.ledger.converter.TnkMeterConverter;
import com.youlai.boot.ledger.model.dto.TnkMeterExportDto;
import com.youlai.boot.ledger.model.entity.TnkMeter;
import com.youlai.boot.ledger.service.TnkMeterService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class TnkMeterImportListener extends AnalysisEventListener<TnkMeterExportDto> {
    /**
     * 当前行
     */
    private Integer currentRow = 1;


    /**
     * Excel 导入结果
     */
    @Getter
    private final ExcelResult excelResult;
    private final TnkMeterService tnkMeterService;
    private final TnkMeterConverter tnkMeterConverter;

    public TnkMeterImportListener(){
        this.excelResult = new ExcelResult();
        this.tnkMeterService = SpringUtil.getBean(TnkMeterService.class);
        this.tnkMeterConverter = SpringUtil.getBean(TnkMeterConverter.class);
    }


    @Override
    public void invoke(TnkMeterExportDto tnkMeterExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条用户数据:{}", JSONUtil.toJsonStr(tnkMeterExportDto));
        boolean validation = true;
        String errorMsg = "第" + this.currentRow + "行数据校验失败：";
        //校验位号是否重复
        String tnkMeterTag = tnkMeterExportDto.getTnkMeterTag();
        if(StrUtil.isBlank(tnkMeterTag)){
            errorMsg += "位号为空";
            validation = false;
        }else{
            long count = tnkMeterService
                    .count(new QueryWrapper<TnkMeter>()
                            .eq("tnk_meter_tag",tnkMeterTag));
            if(count > 0){
                errorMsg += "位号已经存在";
                validation = false;
            }
        }
        String dvType = tnkMeterExportDto.getDvType();
        if(StrUtil.isBlank(dvType)){
            errorMsg += "设备类型为空";
            validation = false;
        }
        Integer status = tnkMeterExportDto.getStatus();
        if(status == null){
            errorMsg += "设备状态为空";
            validation = false;
        }
        String tnkMeterPurp = tnkMeterExportDto.getTnkMeterPurp();
        if(StrUtil.isBlank(tnkMeterPurp)){
            errorMsg += "设备用途为空";
            validation = false;
        }
        if(validation){
            //校验通过执行入库
            TnkMeter entity = tnkMeterConverter.toEntity(tnkMeterExportDto);
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult = tnkMeterService.save(entity);
            if (saveResult) {
                excelResult.setValidCount(excelResult.getValidCount() + 1);
            } else {
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

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
