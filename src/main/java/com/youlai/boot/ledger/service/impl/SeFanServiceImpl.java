package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.SeFanExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SeFanMapper;
import com.youlai.boot.ledger.service.SeFanService;
import com.youlai.boot.ledger.model.entity.SeFan;
import com.youlai.boot.ledger.model.form.SeFanForm;
import com.youlai.boot.ledger.model.query.SeFanQuery;
import com.youlai.boot.ledger.model.vo.SeFanVO;
import com.youlai.boot.ledger.converter.SeFanConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 特种设备风机台账服务实现类
 *
 * @author youlaitech
 * @since 2026-02-09 09:18
 */
@Service
@RequiredArgsConstructor
public class SeFanServiceImpl extends ServiceImpl<SeFanMapper, SeFan> implements SeFanService {

    private final SeFanConverter seFanConverter;

    /**
    * 获取特种设备风机台账分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SeFanVO>} 特种设备风机台账分页列表
    */
    @Override
    public IPage<SeFanVO> getSeFanPage(SeFanQuery queryParams) {
        Page<SeFanVO> pageVO = this.baseMapper.getSeFanPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取特种设备风机台账表单数据
     *
     * @param id 特种设备风机台账ID
     * @return 特种设备风机台账表单数据
     */
    @Override
    public SeFanForm getSeFanFormData(Long id) {
        SeFan entity = this.getById(id);
        return seFanConverter.toForm(entity);
    }
    
    /**
     * 新增特种设备风机台账
     *
     * @param formData 特种设备风机台账表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSeFan(SeFanForm formData) {
        SeFan entity = seFanConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新特种设备风机台账
     *
     * @param id   特种设备风机台账ID
     * @param formData 特种设备风机台账表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSeFan(Long id,SeFanForm formData) {
        SeFan entity = seFanConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除特种设备风机台账
     *
     * @param ids 特种设备风机台账ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSeFans(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的特种设备风机台账数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }
    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SeFanExportDto >} 导出压力列表
     * */
    public List<SeFanExportDto> listExportSeFans(SeFanQuery queryParams){
        List<SeFanExportDto> exportSeFan = this.baseMapper.listExportSeFan(queryParams);
        return exportSeFan;
    }

}
