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
import com.youlai.boot.ledger.converter.DvTemperatureGaugeConverter;
import com.youlai.boot.ledger.model.dto.DvTemperatureGaugesExportDTO;
import com.youlai.boot.ledger.model.entity.DvTemperatureGauge;
import com.youlai.boot.ledger.service.DvTemperatureGaugeService;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DvTemperatureGaugesListener extends AnalysisEventListener<DvTemperatureGaugesExportDTO> {
    /**
     * Excel 导入结果
     */
    @Getter
    private final ExcelResult excelResult;
    private final DvTemperatureGaugeService dvTemperatureGaugeService;
    private final DvTemperatureGaugeConverter dvTemperatureGaugeConverter;

    /**
     * 当前行
     */
    private Integer currentRow = 1;

    /**
     * 构造方法
     * <p>在构造方法中给需要查询的内容查询好，尽量避免每条数据查询一次</p>
     */
    public DvTemperatureGaugesListener() {
        this.dvTemperatureGaugeService = SpringUtil.getBean(DvTemperatureGaugeService.class);
        this.dvTemperatureGaugeConverter = SpringUtil.getBean(DvTemperatureGaugeConverter.class);
        this.excelResult = new ExcelResult();
    }

    /*
     * 每一条数据解析都会来调用
     * <p>
     * 1. 数据校验；全字段校验
     * 2. 数据持久化；
     */
    @Override
    public void invoke(DvTemperatureGaugesExportDTO dvTemperatureGaugesExportDTO, AnalysisContext analysisContext) {
        log.info("解析到一条温度数据", JSONUtil.toJsonStr(dvTemperatureGaugesExportDTO));
        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验位号
        String tagNumber = dvTemperatureGaugesExportDTO.getTagNumber();
        log.info(tagNumber);
        if (StrUtil.isBlank(tagNumber)) {
            errorMsg.append("位号为空；");
            validation = false;
        } else {
            //检测位号是否有重复
            long count = dvTemperatureGaugeService
                    .count(new LambdaQueryWrapper<DvTemperatureGauge>()
                            .eq(DvTemperatureGauge::getTagNumber, tagNumber));
            if (count > 0) {
                errorMsg.append("位号已经存在；");
                validation = false;
            }
        }

        // 校验设备名称
        String dvName = dvTemperatureGaugesExportDTO.getDeviceName();
        if (StrUtil.isBlank(dvName)) {
            errorMsg.append("设备名称为空；");
            validation = false;
        }

        // 校验装置名称(device_name_suffix)
        String deviceNameSuffix = dvTemperatureGaugesExportDTO.getDeviceNameSuffix();
        if (StrUtil.isBlank(deviceNameSuffix)) {
            errorMsg.append("装置名称为空；");
            validation = false;
        }

        // 校验设备状态
        int status = dvTemperatureGaugesExportDTO.getStatus();
        if (status != 0 && status != 1) {
            errorMsg.append("设备状态必须是0或1；");
            validation = false;
        }

        if (validation) {
            //校验通过，入库
            DvTemperatureGauge entity = this.dvTemperatureGaugeConverter.toEntity(dvTemperatureGaugesExportDTO);
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult = this.dvTemperatureGaugeService.save(entity);
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

    /**
     * 所有数据解析完成会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }


}
