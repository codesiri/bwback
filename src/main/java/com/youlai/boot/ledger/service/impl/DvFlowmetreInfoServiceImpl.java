package com.youlai.boot.ledger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.DvFlowmetreInfoExportDto;
import com.youlai.boot.ledger.model.query.DvFlowmetreInfoQueryExport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.DvFlowmetreInfoMapper;
import com.youlai.boot.ledger.service.DvFlowmetreInfoService;
import com.youlai.boot.ledger.model.entity.DvFlowmetreInfo;
import com.youlai.boot.ledger.model.form.DvFlowmetreInfoForm;
import com.youlai.boot.ledger.model.query.DvFlowmetreInfoQuery;
import com.youlai.boot.ledger.model.vo.DvFlowmetreInfoVO;
import com.youlai.boot.ledger.converter.DvFlowmetreInfoConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 流量计服务实现类
 *
 * @author dazao
 * @since 2026-01-09 09:04
 */
@Service
@RequiredArgsConstructor
public class DvFlowmetreInfoServiceImpl extends ServiceImpl<DvFlowmetreInfoMapper, DvFlowmetreInfo> implements DvFlowmetreInfoService {

    private final DvFlowmetreInfoConverter dvFlowmetreInfoConverter;

    /**
    * 获取流量计分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<DvFlowmetreInfoVO>} 流量计分页列表
    */
    @Override
    public IPage<DvFlowmetreInfoVO> getDvFlowmetreInfoPage(DvFlowmetreInfoQuery queryParams) {
        Page<DvFlowmetreInfoVO> pageVO = this.baseMapper.getDvFlowmetreInfoPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取流量计表单数据
     *
     * @param id 流量计ID
     * @return 流量计表单数据
     */
    @Override
    public DvFlowmetreInfoForm getDvFlowmetreInfoFormData(Long id) {
        DvFlowmetreInfo entity = this.getById(id);
        return dvFlowmetreInfoConverter.toForm(entity);
    }
    
    /**
     * 新增流量计
     *
     * @param formData 流量计表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveDvFlowmetreInfo(DvFlowmetreInfoForm formData) {
        DvFlowmetreInfo entity = dvFlowmetreInfoConverter.toEntity(formData);
        long count = this.baseMapper.selectCount(new QueryWrapper<DvFlowmetreInfo>().eq("tag_number", entity.getTagNumber()));
        Assert.isTrue((count == 0) , "位号已经存在");
        IDgenAdapter idgen = new IDgenAdapterLeaf();
        long id = idgen.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setId(id);
        return this.save(entity);
    }
    
    /**
     * 更新流量计
     *
     * @param id   流量计ID
     * @param formData 流量计表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateDvFlowmetreInfo(Long id,DvFlowmetreInfoForm formData) {
        DvFlowmetreInfo entity = dvFlowmetreInfoConverter.toEntity(formData);
        entity.setId(id);
        return this.updateById(entity);
    }
    
    /**
     * 删除流量计
     *
     * @param ids 流量计ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteDvFlowmetreInfos(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的流量计数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<DvFlowmetreInfoExportDto> listExportDvFlowmetreInfo(DvFlowmetreInfoQueryExport queryParams) {
        List<DvFlowmetreInfoExportDto> listExportDvFlowmetreInfo = this.baseMapper.listExportDvFlowmetreInfo(queryParams);
        return listExportDvFlowmetreInfo;
    }

}
