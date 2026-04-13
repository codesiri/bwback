package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.common.util.IDUtil;
import com.youlai.boot.ledger.model.dto.ElectricCabinetFaultExportDto;
import com.youlai.boot.ledger.model.query.ElectricCabinetFaultExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ElectricCabinetFaultMapper;
import com.youlai.boot.ledger.service.ElectricCabinetFaultService;
import com.youlai.boot.ledger.model.entity.ElectricCabinetFault;
import com.youlai.boot.ledger.model.form.ElectricCabinetFaultForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetFaultQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetFaultVO;
import com.youlai.boot.ledger.converter.ElectricCabinetFaultConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 抽屉柜故障维修记录服务实现类
 *
 * @author youlaitech
 * @since 2026-03-23 17:05
 */
@Service
@RequiredArgsConstructor
public class ElectricCabinetFaultServiceImpl extends ServiceImpl<ElectricCabinetFaultMapper, ElectricCabinetFault> implements ElectricCabinetFaultService {

    private final ElectricCabinetFaultConverter electricCabinetFaultConverter;

    /**
    * 获取抽屉柜故障维修记录分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<ElectricCabinetFaultVO>} 抽屉柜故障维修记录分页列表
    */
    @Override
    public IPage<ElectricCabinetFaultVO> getElectricCabinetFaultPage(ElectricCabinetFaultQuery queryParams) {
        Page<ElectricCabinetFaultVO> pageVO = this.baseMapper.getElectricCabinetFaultPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取抽屉柜故障维修记录表单数据
     *
     * @param id 抽屉柜故障维修记录ID
     * @return 抽屉柜故障维修记录表单数据
     */
    @Override
    public ElectricCabinetFaultForm getElectricCabinetFaultFormData(Long id) {
        ElectricCabinetFault entity = this.getById(id);
        return electricCabinetFaultConverter.toForm(entity);
    }
    
    /**
     * 新增抽屉柜故障维修记录
     *
     * @param formData 抽屉柜故障维修记录表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveElectricCabinetFault(ElectricCabinetFaultForm formData) {
        ElectricCabinetFault entity = electricCabinetFaultConverter.toEntity(formData);
        //TODO 之后换为美团leaf生成id
        long genIdByJdk = IDUtil.genIdByJdk();
        entity.setId(genIdByJdk);
        return this.save(entity);
    }
    
    /**
     * 更新抽屉柜故障维修记录
     *
     * @param id   抽屉柜故障维修记录ID
     * @param formData 抽屉柜故障维修记录表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateElectricCabinetFault(Long id,ElectricCabinetFaultForm formData) {
        ElectricCabinetFault entity = electricCabinetFaultConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除抽屉柜故障维修记录
     *
     * @param ids 抽屉柜故障维修记录ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteElectricCabinetFaults(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的抽屉柜故障维修记录数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<ElectricCabinetFaultExportDto> exportElectricCabinetFaults(ElectricCabinetFaultExportQuery queryParams) {
        List<ElectricCabinetFaultExportDto> exportElectricCabinetFaults =this.baseMapper.exportElectricCabinetFaults(queryParams);
        return exportElectricCabinetFaults;
    }

}
