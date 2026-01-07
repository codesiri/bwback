package com.youlai.boot.system.service.impl;

import cn.hutool.core.date.DateTime;
import com.aliyuncs.utils.StringUtils;
import com.youlai.boot.common.constant.DvTypeConstants;
import com.youlai.boot.common.util.IDGenAdapterJDK;
import com.youlai.boot.common.util.IDgenAdapterLeaf;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.system.model.dto.CurrentUserDTO;
import com.youlai.boot.system.model.entity.User;
import com.youlai.boot.system.model.query.QueryDvTypeParams;
import com.youlai.boot.system.service.UserService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.apache.groovy.util.BeanUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.system.mapper.DvMachineryTypeMapper;
import com.youlai.boot.system.service.DvMachineryTypeService;
import com.youlai.boot.system.model.entity.DvMachineryType;
import com.youlai.boot.system.model.form.DvMachineryTypeForm;
import com.youlai.boot.system.model.query.DvMachineryTypeQuery;
import com.youlai.boot.system.model.vo.DvMachineryTypeVO;
import com.youlai.boot.system.converter.DvMachineryTypeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.client.RestTemplate;

/**
 * 设备类型服务实现类
 *
 * @author youlaitech
 * @since 2025-12-17 08:15
 */
@Service
@RequiredArgsConstructor
public class DvMachineryTypeServiceImpl extends ServiceImpl<DvMachineryTypeMapper, DvMachineryType> implements DvMachineryTypeService {

    private final DvMachineryTypeConverter dvMachineryTypeConverter;

    @Resource
    UserService userService;


    /**
    * 获取设备类型分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<DvMachineryTypeVO>} 设备类型分页列表
    */
    @Override
    public IPage<DvMachineryTypeVO> getDvMachineryTypePage(DvMachineryTypeQuery queryParams) {
        Page<DvMachineryTypeVO> pageVO = this.baseMapper.getDvMachineryTypePage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取设备类型表单数据
     *
     * @param id 设备类型ID
     * @return 设备类型表单数据
     */
    @Override
    public DvMachineryTypeForm getDvMachineryTypeFormData(Long id) {
        DvMachineryType entity = this.getById(id);
        return dvMachineryTypeConverter.toForm(entity);
    }
    
    /**
     * 新增设备类型
     *
     * @param formData 设备类型表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveDvMachineryType(DvMachineryTypeForm formData) {
        //-----------------------插入根节点还是子节点----------------------------------------------
        DvMachineryType entity = dvMachineryTypeConverter.toEntity(formData);
        if(entity.getParentTypeId() != 0) {
            //说明是某一个类的子类
            DvMachineryType dvMachineryType = this.baseMapper.selectById(entity.getParentTypeId());
            if(!Objects.isNull(dvMachineryType)){
                entity.setAncestors(dvMachineryType.getAncestors() + "," + dvMachineryType.getMachineryTypeId());
            }
        }else {
            //如果不是说明是跟节点，直接插入即可
            entity.setAncestors("0");
            entity.setParentTypeId(0L);
        }
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        //-------------------------------获取用户的信息--------------------------------------------
        CurrentUserDTO user = userService.getCurrentUserInfo();
        entity.setCreateBy(user.getNickname());
        entity.setCreateTime(DateTime.now().toLocalDateTime());
        //-------------------------------生成id------------------------------------------------
        long id = iDgenAdapter.genID(DvTypeConstants.REQ_DV_TYPE_ID_URL);
        entity.setMachineryTypeId(id);
        entity.setMachineryTypeCode("M_TYPE_" + id);
        return this.save(entity);
    }
    
    /**
     * 更新设备类型
     *
     * @param id   设备类型ID
     * @param formData 设备类型表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateDvMachineryType(Long id,DvMachineryTypeForm formData) {
        DvMachineryType entity = dvMachineryTypeConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除设备类型
     *
     * @param ids 设备类型ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteDvMachineryTypes(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的设备类型数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<DvMachineryTypeVO> selectDvMachineryTypeList(DvMachineryType dvMachineryType) {
        return this.baseMapper.selectDvMachineryTypeList(dvMachineryType);
    }
    @Deprecated
    @Override
    public List<DvMachineryTypeVO> queryDvTypeByParams(QueryDvTypeParams queryDvTypeParams) {
        this.baseMapper.queryDvTypeByParams(queryDvTypeParams);
        return List.of();
    }

}
