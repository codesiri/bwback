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

import java.time.LocalDate;

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
        log.info("解析到一条防爆电气设备数据:{}", JSONUtil.toJsonStr(explosionProofElectricEquipmentExportDto));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验设备编号
        String equipmentCode = explosionProofElectricEquipmentExportDto.getEquipmentCode();
        if (StrUtil.isBlank(equipmentCode)) {
            errorMsg.append("设备编号为空；");
            validation = false;
        } else {
            long count = this.explosionProofElectricEquipmentService
                    .count(new QueryWrapper<ExplosionProofElectricEquipment>()
                            .eq("equipment_code", equipmentCode));
            if (count > 0) {
                errorMsg.append("设备编号已存在；");
                validation = false;
            }
        }

        // 校验设备名称
        String equipmentName = explosionProofElectricEquipmentExportDto.getEquipmentName();
        if (StrUtil.isBlank(equipmentName)) {
            errorMsg.append("设备名称为空；");
            validation = false;
        }

        // 校验规格型号
        String specModel = explosionProofElectricEquipmentExportDto.getSpecModel();
        if (StrUtil.isBlank(specModel)) {
            errorMsg.append("规格型号为空；");
            validation = false;
        }

        // 校验防爆标志
        String exMark = explosionProofElectricEquipmentExportDto.getExMark();
        if (StrUtil.isBlank(exMark)) {
            errorMsg.append("防爆标志为空；");
            validation = false;
        }

        // 校验防爆合格证号
        String exCertNo = explosionProofElectricEquipmentExportDto.getExCertNo();
        if (StrUtil.isBlank(exCertNo)) {
            errorMsg.append("防爆合格证号为空；");
            validation = false;
        }

        // 校验防爆合格证有效期
        String exCertExpire = explosionProofElectricEquipmentExportDto.getExCertExpire();
        if (StrUtil.isBlank(exCertExpire)) {
            errorMsg.append("防爆合格证有效期为空；");
            validation = false;
        }

        // 校验安装位置及危险区域等级
        String installArea = explosionProofElectricEquipmentExportDto.getInstallArea();
        if (StrUtil.isBlank(installArea)) {
            errorMsg.append("安装位置及危险区域等级为空；");
            validation = false;
        }

        // 校验投运日期
        LocalDate commissioningDate = explosionProofElectricEquipmentExportDto.getCommissioningDate();
        if (commissioningDate == null) {
            errorMsg.append("投运日期为空；");
            validation = false;
        }

        // 校验设备状态
        String status = explosionProofElectricEquipmentExportDto.getStatus();
        if (StrUtil.isBlank(status)) {
            errorMsg.append("设备状态为空；");
            validation = false;
        } else if (!"0".equals(status) && !"1".equals(status)) {
            errorMsg.append("设备状态必须是0或1；");
            validation = false;
        }

        // 校验所属工厂
        String factory = explosionProofElectricEquipmentExportDto.getFactory();
        if (StrUtil.isBlank(factory)) {
            errorMsg.append("所属工厂为空；");
            validation = false;
        }

        if (validation) {
            // 校验通过，持久化至数据库
            ExplosionProofElectricEquipment explosionProofElectricEquipment
                    = this.explosionProofElectricEquipmentConverter.toEntity(explosionProofElectricEquipmentExportDto);
            long id = idGenByJdk();
            explosionProofElectricEquipment.setId(id);
            boolean save = this.explosionProofElectricEquipmentService.save(explosionProofElectricEquipment);
            if (save) {
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

    private long idGenByJdk(){
        IDGenAdapterJDK idGenAdapterJDK = new IDGenAdapterJDK();
        return idGenAdapterJDK.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
