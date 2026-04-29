package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.SeRefrigeratorExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SeRefrigeratorMapper;
import com.youlai.boot.ledger.service.SeRefrigeratorService;
import com.youlai.boot.ledger.model.entity.SeRefrigerator;
import com.youlai.boot.ledger.model.form.SeRefrigeratorForm;
import com.youlai.boot.ledger.model.query.SeRefrigeratorQuery;
import com.youlai.boot.ledger.model.vo.SeRefrigeratorVO;
import com.youlai.boot.ledger.converter.SeRefrigeratorConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 特种设备制冷机台账服务实现类
 *
 * @author baiwei
 * @since 2026-02-14 08:38
 */
@Service
@RequiredArgsConstructor
public class SeRefrigeratorServiceImpl extends ServiceImpl<SeRefrigeratorMapper, SeRefrigerator> implements SeRefrigeratorService {

    private final SeRefrigeratorConverter seRefrigeratorConverter;

    /**
    * 获取特种设备制冷机台账分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SeRefrigeratorVO>} 特种设备制冷机台账分页列表
    */
    @Override
    public IPage<SeRefrigeratorVO> getSeRefrigeratorPage(SeRefrigeratorQuery queryParams) {
        Page<SeRefrigeratorVO> pageVO = this.baseMapper.getSeRefrigeratorPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取特种设备制冷机台账表单数据
     *
     * @param id 特种设备制冷机台账ID
     * @return 特种设备制冷机台账表单数据
     */
    @Override
    public SeRefrigeratorForm getSeRefrigeratorFormData(Long id) {
        SeRefrigerator entity = this.getById(id);
        return seRefrigeratorConverter.toForm(entity);
    }
    
    /**
     * 新增特种设备制冷机台账
     *
     * @param formData 特种设备制冷机台账表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSeRefrigerator(SeRefrigeratorForm formData) {
        SeRefrigerator entity = seRefrigeratorConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新特种设备制冷机台账
     *
     * @param id   特种设备制冷机台账ID
     * @param formData 特种设备制冷机台账表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSeRefrigerator(Long id,SeRefrigeratorForm formData) {
        SeRefrigerator entity = seRefrigeratorConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除特种设备制冷机台账
     *
     * @param ids 特种设备制冷机台账ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSeRefrigerators(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的特种设备制冷机台账数据为空");
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
    public List<SeRefrigeratorExportDto> listExportSeRefrigerators(SeRefrigeratorQuery queryParams){
        List<SeRefrigeratorExportDto> exportSePump = this.baseMapper.listExportSeRefrigerator(queryParams);
        return exportSePump;
    }

}
