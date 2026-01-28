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
import com.youlai.boot.ledger.converter.UnitSpecialInstrumentsConverter;
import com.youlai.boot.ledger.model.dto.UnitSpecialInstrumentsExportDto;
import com.youlai.boot.ledger.model.entity.UnitSpecialInstruments;
import com.youlai.boot.ledger.service.UnitSpecialInstrumentsService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@Slf4j
public class UnitSpecialInstrumentImportListener extends AnalysisEventListener<UnitSpecialInstrumentsExportDto> {

    /**
     * Excel 导入结果
     */
    @Getter
    private final ExcelResult excelResult;
    private final UnitSpecialInstrumentsService unitSpecialInstrumentsService;
    private final UnitSpecialInstrumentsConverter unitSpecialInstrumentConverter;

    /**
     * 当前行
     */
    private Integer currentRow = 1;
    /**
     * 构造方法
     * <p>在构造方法中给需要查询的内容查询好，尽量避免每条数据查询一次</p>
     */
    public UnitSpecialInstrumentImportListener() {
        this.unitSpecialInstrumentsService = SpringUtil.getBean(UnitSpecialInstrumentsService.class);
        this.unitSpecialInstrumentConverter = SpringUtil.getBean(UnitSpecialInstrumentsConverter.class);
        this.excelResult = new ExcelResult();
    }




    @Override
    public void invoke(UnitSpecialInstrumentsExportDto unitSpecialInstrumentsExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条用户数据:{}", JSONUtil.toJsonStr(unitSpecialInstrumentsExportDto));

        boolean validation = true;
        String errorMsg = "第" + currentRow + "行数据校验失败：";



        String pressureTag = unitSpecialInstrumentsExportDto.getTagNumber();
        if (StrUtil.isBlank(pressureTag)) {
            errorMsg += "位号为空；";
            validation = false;
        } else {
            long count = unitSpecialInstrumentsService.count(new LambdaQueryWrapper<UnitSpecialInstruments>().eq(UnitSpecialInstruments::getTagNumber, pressureTag));
            if (count > 0) {
                errorMsg += "位号已存在；";
                validation = false;
            }
        }

        String pressureDevice = unitSpecialInstrumentsExportDto.getInstrumentName();
        if (StrUtil.isBlank(pressureDevice)) {
            errorMsg += "仪表名称；";
            validation = false;
        }

        if (validation) {
            // 校验通过，持久化至数据库
//            UnitSpecialInstruments entity = unitSpecialInstrumentConverter.toEntity(unitSpecialInstrumentsExportDto);
            UnitSpecialInstruments entity = new UnitSpecialInstruments();
            BeanUtils.copyProperties(unitSpecialInstrumentsExportDto, entity);
            log.info("实体数据:{}", JSONUtil.toJsonStr(entity));
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            //生成id
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult = unitSpecialInstrumentsService.save(entity);
            if (saveResult) {
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

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }
}
