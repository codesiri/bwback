package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.RelayProtectionSettingDto;
import com.youlai.boot.ledger.model.dto.RelayProtectionSettingExportDto;
import com.youlai.boot.ledger.model.query.ExplosionProofElectricEquipmentExportQuery;
import com.youlai.boot.ledger.model.query.RelayProtectionSettingExportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.RelayProtectionSettingMapper;
import com.youlai.boot.ledger.service.RelayProtectionSettingService;
import com.youlai.boot.ledger.model.entity.RelayProtectionSetting;
import com.youlai.boot.ledger.model.form.RelayProtectionSettingForm;
import com.youlai.boot.ledger.model.query.RelayProtectionSettingQuery;
import com.youlai.boot.ledger.model.vo.RelayProtectionSettingVO;
import com.youlai.boot.ledger.converter.RelayProtectionSettingConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 继电保护定值台账服务实现类
 *
 * @author dazao
 * @since 2026-02-11 09:41
 */
@Service
@RequiredArgsConstructor
public class RelayProtectionSettingServiceImpl extends ServiceImpl<RelayProtectionSettingMapper, RelayProtectionSetting> implements RelayProtectionSettingService {

    private final RelayProtectionSettingConverter relayProtectionSettingConverter;

    /**
    * 获取继电保护定值台账分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<RelayProtectionSettingVO>} 继电保护定值台账分页列表
    */
    @Override
    public IPage<RelayProtectionSettingVO> getRelayProtectionSettingPage(RelayProtectionSettingQuery queryParams) {
        Page<RelayProtectionSettingVO> pageVO = this.baseMapper.getRelayProtectionSettingPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取继电保护定值台账表单数据
     *
     * @param id 继电保护定值台账ID
     * @return 继电保护定值台账表单数据
     */
    @Override
    public RelayProtectionSettingForm getRelayProtectionSettingFormData(Long id) {
        RelayProtectionSetting entity = this.getById(id);
        return relayProtectionSettingConverter.toForm(entity);
    }
    
    /**
     * 新增继电保护定值台账
     *
     * @param formData 继电保护定值台账表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveRelayProtectionSetting(RelayProtectionSettingForm formData) {
        RelayProtectionSetting entity = relayProtectionSettingConverter.toEntity(formData);
        String rpsRelayCode = entity.getRpsRelayCode();
        long count = this.count(new QueryWrapper<RelayProtectionSetting>().eq("rps_relay_code", rpsRelayCode));
        Assert.isTrue(count == 0,"编号已存在");
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }
    
    /**
     * 更新继电保护定值台账
     *
     * @param id   继电保护定值台账ID
     * @param formData 继电保护定值台账表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateRelayProtectionSetting(Long id,RelayProtectionSettingForm formData) {
        RelayProtectionSetting entity = relayProtectionSettingConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除继电保护定值台账
     *
     * @param ids 继电保护定值台账ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteRelayProtectionSettings(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的继电保护定值台账数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<RelayProtectionSettingExportDto> exportRelayProtectionSettings(RelayProtectionSettingExportQuery queryParams) {
        List<RelayProtectionSettingExportDto> relayProtectionSettingVOS = this.baseMapper.exportRelayProtectionSetting(queryParams);
        return relayProtectionSettingVOS;
    }
}
