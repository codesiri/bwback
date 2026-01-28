package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SwitchValveExportDto;
import com.youlai.boot.ledger.model.entity.SwitchValve;
import com.youlai.boot.ledger.model.form.SwitchValveForm;
import com.youlai.boot.ledger.model.query.SwitchValveQuery;
import com.youlai.boot.ledger.model.vo.SwitchValveVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 开关阀服务类
 *
 * @author dazao
 * @since 2026-01-27 08:43
 */
public interface SwitchValveService extends IService<SwitchValve> {

    /**
     *开关阀分页列表
     *
     * @return {@link IPage<SwitchValveVO>} 开关阀分页列表
     */
    IPage<SwitchValveVO> getSwitchValvePage(SwitchValveQuery queryParams);

    /**
     * 获取开关阀表单数据
     *
     * @param id 开关阀ID
     * @return 开关阀表单数据
     */
     SwitchValveForm getSwitchValveFormData(Long id);

    /**
     * 新增开关阀
     *
     * @param formData 开关阀表单对象
     * @return 是否新增成功
     */
    boolean saveSwitchValve(SwitchValveForm formData);

    /**
     * 修改开关阀
     *
     * @param id   开关阀ID
     * @param formData 开关阀表单对象
     * @return 是否修改成功
     */
    boolean updateSwitchValve(Long id, SwitchValveForm formData);

    /**
     * 删除开关阀
     *
     * @param ids 开关阀ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSwitchValves(String ids);

    List<SwitchValveExportDto> exportSwitchValveTable(SwitchValveQuery queryParams);
}
