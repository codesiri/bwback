package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.ControlValveExportDto;
import com.youlai.boot.ledger.model.entity.ControlValve;
import com.youlai.boot.ledger.model.form.ControlValveForm;
import com.youlai.boot.ledger.model.query.ControlValveQuery;
import com.youlai.boot.ledger.model.vo.ControlValveVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 调节阀服务类
 *
 * @author cc
 * @since 2026-01-28 11:03
 */
public interface ControlValveService extends IService<ControlValve> {

    /**
     *调节阀分页列表
     *
     * @return {@link IPage<ControlValveVO>} 调节阀分页列表
     */
    IPage<ControlValveVO> getControlValvePage(ControlValveQuery queryParams);

    /**
     * 获取调节阀表单数据
     *
     * @param id 调节阀ID
     * @return 调节阀表单数据
     */
    ControlValveForm getControlValveFormData(Long id);

    /**
     * 新增调节阀
     *
     * @param formData 调节阀表单对象
     * @return 是否新增成功
     */
    boolean saveControlValve(ControlValveForm formData);

    /**
     * 修改调节阀
     *
     * @param id   调节阀ID
     * @param formData 调节阀表单对象
     * @return 是否修改成功
     */
    boolean updateControlValve(Long id, ControlValveForm formData);

    /**
     * 删除调节阀
     *
     * @param ids 调节阀ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteControlValves(String ids);

    /**
     * 获取导出调节阀
     *
     * @param queryParams 查询参数
     * @return {@link List < ControlValveExportDto >} 导出压力列表
     */
    List<ControlValveExportDto> listExportControlValves(ControlValveQuery queryParams);

}

