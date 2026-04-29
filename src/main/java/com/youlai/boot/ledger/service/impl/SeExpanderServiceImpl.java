package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.SeExpanderExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SeExpanderMapper;
import com.youlai.boot.ledger.service.SeExpanderService;
import com.youlai.boot.ledger.model.entity.SeExpander;
import com.youlai.boot.ledger.model.form.SeExpanderForm;
import com.youlai.boot.ledger.model.query.SeExpanderQuery;
import com.youlai.boot.ledger.model.vo.SeExpanderVO;
import com.youlai.boot.ledger.converter.SeExpanderConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 特种设备膨胀机台账服务实现类
 *
 * @author baiwei
 * @since 2026-02-09 09:15
 */
@Service
@RequiredArgsConstructor
public class SeExpanderServiceImpl extends ServiceImpl<SeExpanderMapper, SeExpander> implements SeExpanderService {

    private final SeExpanderConverter seExpanderConverter;

    /**
    * 获取特种设备膨胀机台账分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SeExpanderVO>} 特种设备膨胀机台账分页列表
    */
    @Override
    public IPage<SeExpanderVO> getSeExpanderPage(SeExpanderQuery queryParams) {
        Page<SeExpanderVO> pageVO = this.baseMapper.getSeExpanderPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取特种设备膨胀机台账表单数据
     *
     * @param id 特种设备膨胀机台账ID
     * @return 特种设备膨胀机台账表单数据
     */
    @Override
    public SeExpanderForm getSeExpanderFormData(Long id) {
        SeExpander entity = this.getById(id);
        return seExpanderConverter.toForm(entity);
    }
    
    /**
     * 新增特种设备膨胀机台账
     *
     * @param formData 特种设备膨胀机台账表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSeExpander(SeExpanderForm formData) {
        SeExpander entity = seExpanderConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新特种设备膨胀机台账
     *
     * @param id   特种设备膨胀机台账ID
     * @param formData 特种设备膨胀机台账表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSeExpander(Long id,SeExpanderForm formData) {
        SeExpander entity = seExpanderConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除特种设备膨胀机台账
     *
     * @param ids 特种设备膨胀机台账ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSeExpanders(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的特种设备膨胀机台账数据为空");
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
     * @return {@link List < SeExpanderExportDto >} 导出压力列表
     * */
    public  List<SeExpanderExportDto> listExportSeExpander(SeExpanderQuery queryParams){
        List<SeExpanderExportDto> exportSeExpander = this.baseMapper.listExportSeExpander(queryParams);
        return exportSeExpander;
    }

}
