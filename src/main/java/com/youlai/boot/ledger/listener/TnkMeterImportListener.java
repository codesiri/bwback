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
        StringBuilder errorMsg = new StringBuilder("第" + this.currentRow + "行数据校验失败：");

        // 校验仪表位号
        String tnkMeterTag = tnkMeterExportDto.getTnkMeterTag();
        if(StrUtil.isBlank(tnkMeterTag)){
            errorMsg.append("仪表位号为空；");
            validation = false;
        }else{
            long count = tnkMeterService
                    .count(new QueryWrapper<TnkMeter>()
                            .eq("tnk_meter_tag",tnkMeterTag));
            if(count > 0){
                errorMsg.append("仪表位号已经存在；");
                validation = false;
            }
        }

        // 校验装置
        String tnkMeterDev = tnkMeterExportDto.getTnkMeterDev();
        if(StrUtil.isBlank(tnkMeterDev)){
            errorMsg.append("装置为空；");
            validation = false;
        }

        // 校验用途
        String tnkMeterPurp = tnkMeterExportDto.getTnkMeterPurp();
        if(StrUtil.isBlank(tnkMeterPurp)){
            errorMsg.append("用途为空；");
            validation = false;
        }

        // 校验仪表名称
        String tnkMeterName = tnkMeterExportDto.getTnkMeterName();
        if(StrUtil.isBlank(tnkMeterName)){
            errorMsg.append("仪表名称为空；");
            validation = false;
        }

        // 校验型号
        String tnkMeterModel = tnkMeterExportDto.getTnkMeterModel();
        if(StrUtil.isBlank(tnkMeterModel)){
            errorMsg.append("型号为空；");
            validation = false;
        }

        // 校验规格
        String tnkMeterSpec = tnkMeterExportDto.getTnkMeterSpec();
        if(StrUtil.isBlank(tnkMeterSpec)){
            errorMsg.append("规格为空；");
            validation = false;
        }

        // 校验量程
        String tnkMeterRange = tnkMeterExportDto.getTnkMeterRange();
        if(StrUtil.isBlank(tnkMeterRange)){
            errorMsg.append("量程为空；");
            validation = false;
        }

        // 校验厂家
        String tnkMeterManu = tnkMeterExportDto.getTnkMeterManu();
        if(StrUtil.isBlank(tnkMeterManu)){
            errorMsg.append("厂家为空；");
            validation = false;
        }

        // 校验泄露状态
        Integer tnkMeterLeakStat = tnkMeterExportDto.getTnkMeterLeakStat();
        if(tnkMeterLeakStat == null){
            errorMsg.append("泄露状态为空；");
            validation = false;
        }

        // 校验检查时间
        if(tnkMeterExportDto.getTnkMeterChkTime() == null){
            errorMsg.append("检查时间为空；");
            validation = false;
        }

        // 校验检查周期
        String tnkMeterChkCycle = tnkMeterExportDto.getTnkMeterChkCycle();
        if(StrUtil.isBlank(tnkMeterChkCycle)){
            errorMsg.append("检查周期为空；");
            validation = false;
        }

        // 校验出厂编号
        String tnkMeterFactoryNo = tnkMeterExportDto.getTnkMeterFactoryNo();
        if(StrUtil.isBlank(tnkMeterFactoryNo)){
            errorMsg.append("出厂编号为空；");
            validation = false;
        }

        // 校验设备状态
        Integer status = tnkMeterExportDto.getStatus();
        if(status == null){
            errorMsg.append("设备状态为空；");
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
                errorMsg = new StringBuilder("第" + currentRow + "行数据保存失败；");
                excelResult.getMessageList().add(errorMsg.toString());
            }
        }else{
            excelResult.setInvalidCount(excelResult.getInvalidCount() + 1);
            excelResult.getMessageList().add(errorMsg.toString());
        }
        currentRow ++;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
