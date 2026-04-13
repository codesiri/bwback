package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ElectricCabinetMainComponentDto;
import com.youlai.boot.ledger.model.entity.ElectricCabinetMainComponent;
import com.youlai.boot.ledger.model.form.ElectricCabinetMainComponentForm;
import com.youlai.boot.ledger.model.query.ElectricCabinetMainComponentQuery;
import com.youlai.boot.ledger.model.vo.ElectricCabinetMainComponentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 抽屉柜主要元器件信息服务类
 *
 * @author youlaitech
 * @since 2026-03-17 09:38
 */
public interface ElectricCabinetMainComponentService extends IService<ElectricCabinetMainComponent> {

    /**
     *抽屉柜主要元器件信息分页列表
     *
     * @return {@link IPage<ElectricCabinetMainComponentVO>} 抽屉柜主要元器件信息分页列表
     */
    IPage<ElectricCabinetMainComponentVO> getElectricCabinetMainComponentPage(ElectricCabinetMainComponentQuery queryParams);

    /**
     * 获取抽屉柜主要元器件信息表单数据
     *
     * @param id 抽屉柜主要元器件信息ID
     * @return 抽屉柜主要元器件信息表单数据
     */
     ElectricCabinetMainComponentForm getElectricCabinetMainComponentFormData(Long id);

    /**
     * 新增抽屉柜主要元器件信息
     *
     * @param formData 抽屉柜主要元器件信息表单对象
     * @return 是否新增成功
     */
    boolean saveElectricCabinetMainComponent(ElectricCabinetMainComponentForm formData);

    /**
     * 修改抽屉柜主要元器件信息
     *
     * @param id   抽屉柜主要元器件信息ID
     * @param formData 抽屉柜主要元器件信息表单对象
     * @return 是否修改成功
     */
    boolean updateElectricCabinetMainComponent(Long id, ElectricCabinetMainComponentForm formData);

    /**
     * 删除抽屉柜主要元器件信息
     *
     * @param ids 抽屉柜主要元器件信息ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteElectricCabinetMainComponents(String ids);

    List<ElectricCabinetMainComponentDto> exportElectricCabinetMainComponents();

}
