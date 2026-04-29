package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.ElectricCabinetMaintenanceExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ElectricCabinetMaintenanceMapper;
import com.youlai.boot.ledger.service.ElectricCabinetMaintenanceService;
import com.youlai.boot.ledger.model.entity.ElectricCabinetMaintenance;
import com.youlai.boot.ledger.model.form.ElectricCabinetMaintenanceForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetMaintenanceQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetMaintenanceVO;
import com.youlai.boot.ledger.converter.ElectricCabinetMaintenanceConverter;

import java.util.Arrays;
import java.util.List;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 抽屉柜维护保养记录服务实现类
 *
 * @author c
 * @since 2026-04-16 14:43
 */
@Service
@RequiredArgsConstructor
public class ElectricCabinetMaintenanceServiceImpl extends ServiceImpl<ElectricCabinetMaintenanceMapper, ElectricCabinetMaintenance> implements ElectricCabinetMaintenanceService {

    private final ElectricCabinetMaintenanceConverter electricCabinetMaintenanceConverter;

    /**
    * 获取抽屉柜维护保养记录分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<ElectricCabinetMaintenanceVO>} 抽屉柜维护保养记录分页列表
    */
    @Override
    public IPage<ElectricCabinetMaintenanceVO> getElectricCabinetMaintenancePage(ElectricCabinetMaintenanceQuery queryParams) {
        Page<ElectricCabinetMaintenanceVO> pageVO = this.baseMapper.getElectricCabinetMaintenancePage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }

    /**
     * 获取抽屉柜维护保养记录表单数据
     *
     * @param id 抽屉柜维护保养记录ID
     * @return 抽屉柜维护保养记录表单数据
     */
    @Override
    public ElectricCabinetMaintenanceForm getElectricCabinetMaintenanceFormData(Long id) {
        ElectricCabinetMaintenance entity = this.getById(id);
        return electricCabinetMaintenanceConverter.toForm(entity);
    }

    /**
     * 新增抽屉柜维护保养记录
     *
     * @param formData 抽屉柜维护保养记录表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveElectricCabinetMaintenance(ElectricCabinetMaintenanceForm formData) {
        ElectricCabinetMaintenance entity = electricCabinetMaintenanceConverter.toEntity(formData);
        // 使用美团Leaf生成ID
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);

        return this.save(entity);
    }

    /**
     * 更新抽屉柜维护保养记录
     *
     * @param id   抽屉柜维护保养记录ID
     * @param formData 抽屉柜维护保养记录表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateElectricCabinetMaintenance(Long id,ElectricCabinetMaintenanceForm formData) {
        ElectricCabinetMaintenance entity = electricCabinetMaintenanceConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除抽屉柜维护保养记录
     *
     * @param ids 抽屉柜维护保养记录ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteElectricCabinetMaintenances(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的抽屉柜维护保养记录数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    /**
     * 获取导出抽屉柜维护保养记录列表
     *
     * @param queryParams 查询参数
     * @return {@link List<ElectricCabinetMaintenanceExportDto>} 导出列表
     */
    @Override
    public List<ElectricCabinetMaintenanceExportDto> listExportElectricCabinetMaintenances(ElectricCabinetMaintenanceQuery queryParams) {
        return this.baseMapper.listExportElectricCabinetMaintenances(queryParams);
    }

}
