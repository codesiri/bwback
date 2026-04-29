package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.SePumpExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SePumpMapper;
import com.youlai.boot.ledger.service.SePumpService;
import com.youlai.boot.ledger.model.entity.SePump;
import com.youlai.boot.ledger.model.form.SePumpForm;
import com.youlai.boot.ledger.model.query.SePumpQuery;
import com.youlai.boot.ledger.model.vo.SePumpVO;
import com.youlai.boot.ledger.converter.SePumpConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 泵服务实现类
 *
 * @author baiwei
 * @since 2026-02-05 14:46
 */
@Service
@RequiredArgsConstructor
public class SePumpServiceImpl extends ServiceImpl<SePumpMapper, SePump> implements SePumpService {

    private final SePumpConverter sePumpConverter;

    /**
    * 获取泵分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SePumpVO>} 泵分页列表
    */
    @Override
    public IPage<SePumpVO> getSePumpPage(SePumpQuery queryParams) {
        Page<SePumpVO> pageVO = this.baseMapper.getSePumpPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取泵表单数据
     *
     * @param id 泵ID
     * @return 泵表单数据
     */
    @Override
    public SePumpForm getSePumpFormData(Long id) {
        SePump entity = this.getById(id);
        return sePumpConverter.toForm(entity);
    }
    
    /**
     * 新增泵
     *
     * @param formData 泵表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSePump(SePumpForm formData) {
        SePump entity = sePumpConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新泵
     *
     * @param id   泵ID
     * @param formData 泵表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSePump(Long id,SePumpForm formData) {
        SePump entity = sePumpConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除泵
     *
     * @param ids 泵ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSePumps(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的泵数据为空");
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
     * @return {@link List < SePumpExportDto >} 导出压力列表
     * */
    public List<SePumpExportDto> listExportSePumps(SePumpQuery queryParams){
        List<SePumpExportDto> exportSePump = this.baseMapper.listExportSePump(queryParams);
        return exportSePump;
    }

}
