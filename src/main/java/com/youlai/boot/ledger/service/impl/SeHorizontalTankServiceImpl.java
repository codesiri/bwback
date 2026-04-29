package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.SeHorizontalTankExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SeHorizontalTankMapper;
import com.youlai.boot.ledger.service.SeHorizontalTankService;
import com.youlai.boot.ledger.model.entity.SeHorizontalTank;
import com.youlai.boot.ledger.model.form.SeHorizontalTankForm;
import com.youlai.boot.ledger.model.query.SeHorizontalTankQuery;
import com.youlai.boot.ledger.model.vo.SeHorizontalTankVO;
import com.youlai.boot.ledger.converter.SeHorizontalTankConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 卧罐服务实现类
 *
 * @author baiwei
 * @since 2026-03-06 09:33
 */
@Service
@RequiredArgsConstructor
public class SeHorizontalTankServiceImpl extends ServiceImpl<SeHorizontalTankMapper, SeHorizontalTank> implements SeHorizontalTankService {

    private final SeHorizontalTankConverter seHorizontalTankConverter;

    /**
    * 获取卧罐分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SeHorizontalTankVO>} 卧罐分页列表
    */
    @Override
    public IPage<SeHorizontalTankVO> getSeHorizontalTankPage(SeHorizontalTankQuery queryParams) {
        Page<SeHorizontalTankVO> pageVO = this.baseMapper.getSeHorizontalTankPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取卧罐表单数据
     *
     * @param id 卧罐ID
     * @return 卧罐表单数据
     */
    @Override
    public SeHorizontalTankForm getSeHorizontalTankFormData(Long id) {
        SeHorizontalTank entity = this.getById(id);
        return seHorizontalTankConverter.toForm(entity);
    }
    
    /**
     * 新增卧罐
     *
     * @param formData 卧罐表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSeHorizontalTank(SeHorizontalTankForm formData) {
        SeHorizontalTank entity = seHorizontalTankConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新卧罐
     *
     * @param id   卧罐ID
     * @param formData 卧罐表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSeHorizontalTank(Long id,SeHorizontalTankForm formData) {
        SeHorizontalTank entity = seHorizontalTankConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除卧罐
     *
     * @param ids 卧罐ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSeHorizontalTanks(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的卧罐数据为空");
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
    public List<SeHorizontalTankExportDto> listExportSeHorizontalTanks(SeHorizontalTankQuery queryParams){
        List<SeHorizontalTankExportDto> exportSeHorizontalTank = this.baseMapper.listExportSeHorizontalTank(queryParams);
        return exportSeHorizontalTank;
    }

}
