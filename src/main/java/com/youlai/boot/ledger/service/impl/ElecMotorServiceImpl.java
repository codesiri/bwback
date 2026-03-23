package com.youlai.boot.ledger.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;
import com.youlai.boot.ledger.model.dto.ElecMotorsExportDto;
import com.youlai.boot.ledger.model.query.ElecMotorExportQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.springframework.beans.BeanUtils;
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
@Slf4j
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
        log.info("获取到的实体内容为: {}", JSONUtil.toJsonStr(entity));
        //这里不能用converter转换，需要换成beanutils
        ElecMotorForm form = new ElecMotorForm();
        BeanUtils.copyProperties(entity,form);
        log.info("转换后的内容为: {}", JSONUtil.toJsonStr(form));
        return form;
    }

    /**
     * form
     *
     * @param formData 电器电动机表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveElecMotor(ElecMotorForm formData) {
        ElecMotor entity = elecMotorConverter.toEntity(formData);
        String elecMotorTag = entity.getElecMotorTag();
        long count = this.count(new QueryWrapper<ElecMotor>().eq("elec_motor_tag", elecMotorTag));
        Assert.isTrue(count == 0, "位号已经存在");
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        long id = iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
        entity.setElecMotorId(id);
        return this.save(entity);
    }

    /**
     * 更新电器电动机
     *
     * @param id       电器电动机ID
     * @param formData 电器电动机表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateElecMotor(Long id, ElecMotorForm formData) {
        ElecMotor entity = new ElecMotor();
        BeanUtils.copyProperties(formData,entity);
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

    @Override
    public List<ElecMotorsExportDto> listExportElecMotor(ElecMotorExportQuery query) {
        List<ElecMotorsExportDto> listExportElecMotor = this.baseMapper.listExportElecMotor(query);
        return listExportElecMotor;
    }

}
