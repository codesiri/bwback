package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SeSphericalTankExportDto;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SeSphericalTankMapper;
import com.youlai.boot.ledger.service.SeSphericalTankService;
import com.youlai.boot.ledger.model.entity.SeSphericalTank;
import com.youlai.boot.ledger.model.form.SeSphericalTankForm;
import com.youlai.boot.ledger.model.query.SeSphericalTankQuery;
import com.youlai.boot.ledger.model.vo.SeSphericalTankVO;
import com.youlai.boot.ledger.converter.SeSphericalTankConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 球罐服务实现类
 *
 * @author baiwei
 * @since 2026-03-06 09:49
 */
@Service
@RequiredArgsConstructor
public class SeSphericalTankServiceImpl extends ServiceImpl<SeSphericalTankMapper, SeSphericalTank> implements SeSphericalTankService {

    private final SeSphericalTankConverter seSphericalTankConverter;

    /**
    * 获取球罐分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SeSphericalTankVO>} 球罐分页列表
    */
    @Override
    public IPage<SeSphericalTankVO> getSeSphericalTankPage(SeSphericalTankQuery queryParams) {
        Page<SeSphericalTankVO> pageVO = this.baseMapper.getSeSphericalTankPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取球罐表单数据
     *
     * @param id 球罐ID
     * @return 球罐表单数据
     */
    @Override
    public SeSphericalTankForm getSeSphericalTankFormData(Long id) {
        SeSphericalTank entity = this.getById(id);
        return seSphericalTankConverter.toForm(entity);
    }
    
    /**
     * 新增球罐
     *
     * @param formData 球罐表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSeSphericalTank(SeSphericalTankForm formData) {
        SeSphericalTank entity = seSphericalTankConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新球罐
     *
     * @param id   球罐ID
     * @param formData 球罐表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSeSphericalTank(Long id,SeSphericalTankForm formData) {
        SeSphericalTank entity = seSphericalTankConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除球罐
     *
     * @param ids 球罐ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSeSphericalTanks(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的球罐数据为空");
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
    public List<SeSphericalTankExportDto>  listExportSeSphericalTank(SeSphericalTankQuery queryParams){
        List<SeSphericalTankExportDto> exportSeHeater = this.baseMapper.listExportSeSphericalTank(queryParams);
        return exportSeHeater;
    }

}
