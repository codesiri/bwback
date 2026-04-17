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
import com.youlai.boot.ledger.converter.RadiationInstrumentConverter;
import com.youlai.boot.ledger.model.dto.RadiationInstrumentExportDTO;
import com.youlai.boot.ledger.model.entity.RadiationInstrument;
import com.youlai.boot.ledger.service.RadiationInstrumentService;
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
public class RadiationInstrumentsImportListener extends AnalysisEventListener<RadiationInstrumentExportDTO> {

    /**
     * Excel 导入结果
     */
    @Getter
    private final ExcelResult excelResult;
    private final RadiationInstrumentService radiationInstrumentServices;
    private final RadiationInstrumentConverter radiationInstrumentConverters;

    /**
     * 当前行
     */
    private Integer currentRow = 1;

    /**
     * 构造方法
     * <p>在构造方法中给需要查询的内容查询好，尽量避免每条数据查询一次</p>
     */
    public RadiationInstrumentsImportListener() {
        this.radiationInstrumentServices = SpringUtil.getBean(RadiationInstrumentService.class);
        this.radiationInstrumentConverters = SpringUtil.getBean(RadiationInstrumentConverter.class);
        this.excelResult = new ExcelResult();
    }

    /**
     * 每一条数据解析都会来调用
     * <p>
     * 1. 数据校验；全字段校验
     * 2. 数据持久化；
     *
     * @param radiationInstrumentDTO 一行数据，类似于 {@link AnalysisContext#readRowHolder()}
     */
    @Override
    public void invoke(RadiationInstrumentExportDTO radiationInstrumentDTO, AnalysisContext analysisContext) {
        log.info("解析到一条放射仪数据:{}", JSONUtil.toJsonStr(radiationInstrumentDTO));

        boolean validation = true;
        StringBuilder errorMsg = new StringBuilder("第" + currentRow + "行数据校验失败：");

        // 校验装置名称
        String unitName = radiationInstrumentDTO.getUnitName();
        if (StrUtil.isBlank(unitName)) {
            errorMsg.append("装置名称为空；");
            validation = false;
        }

        // 校验位号
        String tagNumber = radiationInstrumentDTO.getTagNumber();
        if (StrUtil.isBlank(tagNumber)) {
            errorMsg.append("位号为空；");
            validation = false;
        } else {
            long count = radiationInstrumentServices.count(new LambdaQueryWrapper<RadiationInstrument>().eq(RadiationInstrument::getTagNumber, tagNumber));
            if (count > 0) {
                errorMsg.append("位号已存在；");
                validation = false;
            }
        }

        // 校验仪表名称
        String instrumentName = radiationInstrumentDTO.getInstrumentName();
        if (StrUtil.isBlank(instrumentName)) {
            errorMsg.append("仪表名称为空；");
            validation = false;
        }

        // 校验射源位号
        String sourceTagNumber = radiationInstrumentDTO.getSourceTagNumber();
        if (StrUtil.isBlank(sourceTagNumber)) {
            errorMsg.append("射源位号为空；");
            validation = false;
        }

        // 校验材质
        String material = radiationInstrumentDTO.getMaterial();
        if (StrUtil.isBlank(material)) {
            errorMsg.append("材质为空；");
            validation = false;
        }

        // 校验测量范围
        String measuringRange = radiationInstrumentDTO.getMeasuringRange();
        if (StrUtil.isBlank(measuringRange)) {
            errorMsg.append("测量范围为空；");
            validation = false;
        }

        // 校验精度
        String accuracy = radiationInstrumentDTO.getAccuracy();
        if (StrUtil.isBlank(accuracy)) {
            errorMsg.append("精度为空；");
            validation = false;
        }

        // 校验是否联锁
        Integer whetherInterlocked = radiationInstrumentDTO.getWhetherInterlocked();
        if (whetherInterlocked == null) {
            errorMsg.append("是否联锁为空；");
            validation = false;
        }

        // 校验安装位置及用途
        String installationLocationAndPurpose = radiationInstrumentDTO.getInstallationLocationAndPurpose();
        if (StrUtil.isBlank(installationLocationAndPurpose)) {
            errorMsg.append("安装位置及用途为空；");
            validation = false;
        }

        // 校验规格型号
        String specificationModel = radiationInstrumentDTO.getSpecificationModel();
        if (StrUtil.isBlank(specificationModel)) {
            errorMsg.append("规格型号为空；");
            validation = false;
        }

        // 校验生产厂家
        String manufacturer = radiationInstrumentDTO.getManufacturer();
        if (StrUtil.isBlank(manufacturer)) {
            errorMsg.append("生产厂家为空；");
            validation = false;
        }

        // 校验状态
        Integer radioactiveStatus = radiationInstrumentDTO.getRadioactiveStatus();
        if (radioactiveStatus == null) {
            errorMsg.append("状态为空；");
            validation = false;
        }

        if (validation) {
            // 校验通过，持久化至数据库
            RadiationInstrument entity = radiationInstrumentConverters.toEntity(radiationInstrumentDTO);

            IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
            //生成id
            long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
            entity.setId(id);

            boolean saveResult = radiationInstrumentServices.save(entity);
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


