package com.youlai.boot.ledger.listener;


import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDGenAdapterJDK;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.core.web.ExcelResult;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.converter.ExplosionProofElectricEquipmentConverter;
import com.youlai.boot.ledger.model.dto.ExplosionProofElectricEquipmentExportDto;
import com.youlai.boot.ledger.model.dto.LevelGaugeExportDto;
import com.youlai.boot.ledger.model.entity.ExplosionProofElectricEquipment;
import com.youlai.boot.ledger.service.ExplosionProofElectricEquipmentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExplosionProofElectricEquipmentsListener extends AnalysisEventListener<ExplosionProofElectricEquipmentExportDto> {
    @Getter
    private ExcelResult excelResult;
    private ExplosionProofElectricEquipmentService explosionProofElectricEquipmentService;
    private ExplosionProofElectricEquipmentConverter explosionProofElectricEquipmentConverter;

    private Integer currentRow = 1;

    public ExplosionProofElectricEquipmentsListener() {
        this.excelResult = new ExcelResult();
        this.explosionProofElectricEquipmentService = SpringUtil.getBean(ExplosionProofElectricEquipmentService.class);
        this.explosionProofElectricEquipmentConverter = SpringUtil.getBean(ExplosionProofElectricEquipmentConverter.class);
    }

    @Override
    public void invoke(ExplosionProofElectricEquipmentExportDto explosionProofElectricEquipmentExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条用户数据:{}", JSONUtil.toJsonStr(explosionProofElectricEquipmentExportDto));
        boolean validation = true;
        String errorMsg = "第" + currentRow + "行数据校验失败：";
        String equipmentCode = explosionProofElectricEquipmentExportDto.getEquipmentCode();

        if (StrUtil.isBlank(equipmentCode)) {
            errorMsg += "编号为空";
            validation = false;
        } else {
            long count = this.explosionProofElectricEquipmentService
                    .count(new QueryWrapper<ExplosionProofElectricEquipment>()
                            .eq("equipment_code", equipmentCode));
            if (count > 0) {
                errorMsg += "编号已经存在";
                validation = false;
            }
        }
        if (validation) {
            com.youlai.boot.ledger.model.entity.ExplosionProofElectricEquipment explosionProofElectricEquipment
                    = this.explosionProofElectricEquipmentConverter.toEntity(explosionProofElectricEquipmentExportDto);
//            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
//            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            long id = idGenByJdk();
            explosionProofElectricEquipment.setId(id);
            boolean save = this.explosionProofElectricEquipmentService.save(explosionProofElectricEquipment);
            if (save) {
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

    private long idGenByJdk(){
        IDGenAdapterJDK idGenAdapterJDK = new IDGenAdapterJDK();
        return idGenAdapterJDK.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
