package com.youlai.boot.ledger.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.ElecMotorMapper;
import com.youlai.boot.ledger.service.ElecMotorService;
import com.youlai.boot.ledger.model.entity.ElecMotor;
import com.youlai.boot.ledger.model.form.ElecMotorForm;
import com.youlai.boot.ledger.model.query.ElecMotorQuery;
import com.youlai.boot.ledger.model.vo.ElecMotorVO;
import com.youlai.boot.ledger.converter.ElecMotorConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 电器电动机服务实现类
 *
 * @author dazao
 * @since 2026-01-13 10:10
 */
@Service
@RequiredArgsConstructor
public class ElecMotorServiceImpl extends ServiceImpl<ElecMotorMapper, ElecMotor> implements ElecMotorService {

    private final ElecMotorConverter elecMotorConverter;

    /**
    * 获取电器电动机分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<ElecMotorVO>} 电器电动机分页列表
    */
    @Override
    public IPage<ElecMotorVO> getElecMotorPage(ElecMotorQuery queryParams) {
        Page<ElecMotorVO> pageVO = this.baseMapper.getElecMotorPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取电器电动机表单数据
     *
     * @param id 电器电动机ID
     * @return 电器电动机表单数据
     */
    @Override
    public ElecMotorForm getElecMotorFormData(Long id) {
        ElecMotor entity = this.getById(id);
        return elecMotorConverter.toForm(entity);
    }
    
    /**
     * 新增电器电动机
     *
     * @param formData 电器电动机表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveElecMotor(ElecMotorForm formData) {
        ElecMotor entity = elecMotorConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新电器电动机
     *
     * @param id   电器电动机ID
     * @param formData 电器电动机表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateElecMotor(Long id,ElecMotorForm formData) {
        ElecMotor entity = elecMotorConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除电器电动机
     *
     * @param ids 电器电动机ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteElecMotors(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的电器电动机数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
