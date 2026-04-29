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
import com.youlai.boot.ledger.converter.SeHeaterConverter;
import com.youlai.boot.ledger.converter.SeHorizontalTankConverter;
import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SeHorizontalTankExportDto;
import com.youlai.boot.ledger.model.entity.SeHeater;
import com.youlai.boot.ledger.model.entity.SeHorizontalTank;
import com.youlai.boot.ledger.service.SeHeaterService;
import com.youlai.boot.ledger.service.SeHorizontalTankService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 导入监听器
 * <p>
 * <a href="https://easyexcel.opensource.alibaba.com/docs/current/quickstart/read#%E6%9C%80%E7%AE%80%E5%8D%95%E7%9A%84%E8%AF%BB%E7%9A%84%E7%9B%91%E5%90%AC%E5%99%A8">最简单的读的监听器</a>
 *
 * @author Ray
 * @since 2022/4/10
 */
@Slf4j
public class SeHorizontalTankImportListener extends AnalysisEventListener<SeHorizontalTankExportDto> {

    /**
     * Excel 导入结果
     */
    @Getter
    private final ExcelResult excelResult;
    private final SeHorizontalTankService seHorizontalTankService;
    private final SeHorizontalTankConverter seHorizontalTankConverter;

    /**
     * 当前行
     */
    private Integer currentRow = 1;

    /**
     * 构造方法
     * <p>在构造方法中给需要查询的内容查询好，尽量避免每条数据查询一次</p>
     */
    public SeHorizontalTankImportListener() {
        this.seHorizontalTankService = SpringUtil.getBean(SeHorizontalTankService.class);
        this.seHorizontalTankConverter = SpringUtil.getBean(SeHorizontalTankConverter.class);
        this.excelResult = new ExcelResult();
    }

    /**
     * 每一条数据解析都会来调用
     * <p>
     * 1. 数据校验；全字段校验
     * 2. 数据持久化；
     *
     * @param seHorizontalTankExportDto 一行数据，类似于 {@link AnalysisContext#readRowHolder()}
     */
    @Override
    public void invoke(SeHorizontalTankExportDto seHorizontalTankExportDto, AnalysisContext analysisContext) {
        log.info("解析到一条用户数据:{}", JSONUtil.toJsonStr(seHorizontalTankExportDto));

        boolean validation = true;
        String errorMsg = "第" + currentRow + "行数据校验失败：";



        String pressureTag = seHorizontalTankExportDto.getSeHtankEquipCode();
        if (StrUtil.isBlank(pressureTag)) {
            errorMsg += "编号为空；";
            validation = false;
        } else {
            long count = seHorizontalTankService.count(new LambdaQueryWrapper<SeHorizontalTank>().eq(SeHorizontalTank::getSeHtankEquipCode, pressureTag));
            if (count > 0) {
                errorMsg += "编号已存在；";
                validation = false;
            }
        }

        if (validation) {
            // 校验通过，持久化至数据库
            SeHorizontalTank entity = seHorizontalTankConverter.toEntity(seHorizontalTankExportDto);
            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            //生成id
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);
            boolean saveResult = seHorizontalTankService.save(entity);
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

    /**
     * 所有数据解析完成会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }

}

