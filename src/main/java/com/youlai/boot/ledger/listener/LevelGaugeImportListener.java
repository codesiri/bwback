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
import com.youlai.boot.ledger.converter.LevelGaugeConverter;
import com.youlai.boot.ledger.model.dto.LevelGaugeExportDto;
import com.youlai.boot.ledger.model.entity.LevelGauge;
import com.youlai.boot.ledger.service.LevelGaugeService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LevelGaugeImportListener extends AnalysisEventListener<LevelGaugeExportDto> {
    /**
     * Excel 导入结果
     */
    @Getter
    private final ExcelResult excelResult;
    private final LevelGaugeService levelGaugeService;
    private final LevelGaugeConverter levelGaugeConverter;

    public LevelGaugeImportListener() {
        this.excelResult = new ExcelResult();
        this.levelGaugeService = SpringUtil.getBean(LevelGaugeService.class);
        this.levelGaugeConverter = SpringUtil.getBean(LevelGaugeConverter.class);
    }

    private Integer currentRow = 1;


    @Override
    public void invoke(LevelGaugeExportDto levelGaugeExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条用户数据:{}", JSONUtil.toJsonStr(levelGaugeExportDto));
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");
        boolean validation = true;

        // 校验位号
        String levelTag = levelGaugeExportDto.getLevelTag();
        if (StrUtil.isBlank(levelTag)) {
            errorMsg.append("位号为空；");
            validation = false;
        } else {
            long count = levelGaugeService.count(new LambdaQueryWrapper<LevelGauge>().eq(LevelGauge::getLevelTag, levelTag));
            if (count > 0) {
                errorMsg.append("位号已存在；");
                validation = false;
            }
        }

        // 校验装置名称
        String levelDevice = levelGaugeExportDto.getLevelDevice();
        if (StrUtil.isBlank(levelDevice)) {
            errorMsg.append("装置名称为空；");
            validation = false;
        }

        // 校验安装位置
        String levelLocation = levelGaugeExportDto.getLevelLocation();
        if (StrUtil.isBlank(levelLocation)) {
            errorMsg.append("安装位置为空；");
            validation = false;
        }

        // 校验设备名称
        String levelEquip = levelGaugeExportDto.getLevelEquip();
        if (StrUtil.isBlank(levelEquip)) {
            errorMsg.append("设备名称为空；");
            validation = false;
        }

        // 校验规格型号
        String levelModel = levelGaugeExportDto.getLevelModel();
        if (StrUtil.isBlank(levelModel)) {
            errorMsg.append("规格型号为空；");
            validation = false;
        }

        // 校验生产厂家
        String levelManu = levelGaugeExportDto.getLevelManu();
        if (StrUtil.isBlank(levelManu)) {
            errorMsg.append("生产厂家为空；");
            validation = false;
        }

        // 校验介质
        String levelMedium = levelGaugeExportDto.getLevelMedium();
        if (StrUtil.isBlank(levelMedium)) {
            errorMsg.append("介质为空；");
            validation = false;
        }

        // 校验测量范围
        String levelRange = levelGaugeExportDto.getLevelRange();
        if (StrUtil.isBlank(levelRange)) {
            errorMsg.append("测量范围为空；");
            validation = false;
        }

        // 校验连接方式
        String levelConnection = levelGaugeExportDto.getLevelConnection();
        if (StrUtil.isBlank(levelConnection)) {
            errorMsg.append("连接方式为空；");
            validation = false;
        }

        // 校验是否联锁
        Integer levelInterlock = levelGaugeExportDto.getLevelInterlock();
        if (levelInterlock == null) {
            errorMsg.append("是否联锁为空；");
            validation = false;
        }

        // 校验联锁设定值
        String levelInterlockVal = levelGaugeExportDto.getLevelInterlockVal();
        if (StrUtil.isBlank(levelInterlockVal)) {
            errorMsg.append("联锁设定值为空；");
            validation = false;
        }

        // 校验设备状态
        Integer status = levelGaugeExportDto.getStatus();
        if (status == null) {
            errorMsg.append("设备状态为空；");
            validation = false;
        }

        // 校验设备类型
        String dvType = levelGaugeExportDto.getDvType();
        if (StrUtil.isBlank(dvType)) {
            errorMsg.append("设备类型为空；");
            validation = false;
        }

        if (validation) {
            //执行入库
            LevelGauge entity = levelGaugeConverter.toEntity(levelGaugeExportDto);
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            //生成id
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult = levelGaugeService.save(entity);
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
