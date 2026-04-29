package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SeHeaterMapper;
import com.youlai.boot.ledger.service.SeHeaterService;
import com.youlai.boot.ledger.model.entity.SeHeater;
import com.youlai.boot.ledger.model.form.SeHeaterForm;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.model.vo.SeHeaterVO;
import com.youlai.boot.ledger.converter.SeHeaterConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 换热器服务实现类
 *
 * @author baiwei
 * @since 2026-03-03 10:16
 */
@Service
@RequiredArgsConstructor
public class SeHeaterServiceImpl extends ServiceImpl<SeHeaterMapper, SeHeater> implements SeHeaterService {

    private final SeHeaterConverter seHeaterConverter;

    /**
    * 获取换热器分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SeHeaterVO>} 换热器分页列表
    */
    @Override
    public IPage<SeHeaterVO> getSeHeaterPage(SeHeaterQuery queryParams) {
        Page<SeHeaterVO> pageVO = this.baseMapper.getSeHeaterPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取换热器表单数据
     *
     * @param id 换热器ID
     * @return 换热器表单数据
     */
    @Override
    public SeHeaterForm getSeHeaterFormData(Long id) {
        SeHeater entity = this.getById(id);
        return seHeaterConverter.toForm(entity);
    }
    
    /**
     * 新增换热器
     *
     * @param formData 换热器表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSeHeater(SeHeaterForm formData) {
        SeHeater entity = seHeaterConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新换热器
     *
     * @param id   换热器ID
     * @param formData 换热器表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSeHeater(Long id,SeHeaterForm formData) {
        SeHeater entity = seHeaterConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除换热器
     *
     * @param ids 换热器ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSeHeaters(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的换热器数据为空");
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
     * @return {@link List < SeHeaterExportDto >} 导出压力列表
     * */
    public List<SeHeaterExportDto>  listExportSeHeater(SeHeaterQuery queryParams){
        List<SeHeaterExportDto> exportSeHeater = this.baseMapper.listExportSeHeater(queryParams);
        return exportSeHeater;
    }

}
