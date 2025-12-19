package com.youlai.boot.system.service;

import com.youlai.boot.system.model.entity.DvMachineryType;
import com.youlai.boot.system.model.form.DvMachineryTypeForm;
import com.youlai.boot.system.model.query.DvMachineryTypeQuery;
import com.youlai.boot.system.model.query.QueryDvTypeParams;
import com.youlai.boot.system.model.vo.DvMachineryTypeVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 设备类型服务类
 *
 * @author youlaitech
 * @since 2025-12-17 08:15
 */
public interface DvMachineryTypeService extends IService<DvMachineryType> {

    /**
     *设备类型分页列表
     *
     * @return {@link IPage<DvMachineryTypeVO>} 设备类型分页列表
     */
    IPage<DvMachineryTypeVO> getDvMachineryTypePage(DvMachineryTypeQuery queryParams);

    /**
     * 获取设备类型表单数据
     *
     * @param id 设备类型ID
     * @return 设备类型表单数据
     */
     DvMachineryTypeForm getDvMachineryTypeFormData(Long id);

    /**
     * 新增设备类型
     *
     * @param formData 设备类型表单对象
     * @return 是否新增成功
     */
    boolean saveDvMachineryType(DvMachineryTypeForm formData);

    /**
     * 修改设备类型
     *
     * @param id   设备类型ID
     * @param formData 设备类型表单对象
     * @return 是否修改成功
     */
    boolean updateDvMachineryType(Long id, DvMachineryTypeForm formData);

    /**
     * 删除设备类型
     *
     * @param ids 设备类型ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteDvMachineryTypes(String ids);

    List<DvMachineryTypeVO> selectDvMachineryTypeList(DvMachineryType dvMachineryType);
    @Deprecated
    List<DvMachineryTypeVO> queryDvTypeByParams(QueryDvTypeParams queryDvTypeParams);
}
