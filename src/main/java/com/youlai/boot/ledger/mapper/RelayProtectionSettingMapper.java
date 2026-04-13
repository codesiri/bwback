package com.youlai.boot.ledger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.ledger.model.dto.RelayProtectionSettingExportDto;
import com.youlai.boot.ledger.model.entity.RelayProtectionSetting;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.ledger.model.query.RelayProtectionSettingExportQuery;
import com.youlai.boot.ledger.model.query.RelayProtectionSettingQuery;
import com.youlai.boot.ledger.model.vo.RelayProtectionSettingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 继电保护定值台账Mapper接口
 *
 * @author dazao
 * @since 2026-02-11 09:41
 */
@Mapper
public interface RelayProtectionSettingMapper extends BaseMapper<RelayProtectionSetting> {

    /**
     * 获取继电保护定值台账分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<RelayProtectionSettingVO>} 继电保护定值台账分页列表
     */
    Page<RelayProtectionSettingVO> getRelayProtectionSettingPage(Page<RelayProtectionSettingVO> page, RelayProtectionSettingQuery queryParams);
    List<RelayProtectionSettingExportDto> exportRelayProtectionSetting(RelayProtectionSettingExportQuery queryParams);
}
