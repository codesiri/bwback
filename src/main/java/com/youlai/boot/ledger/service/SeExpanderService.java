package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SeExpanderExportDto;
import com.youlai.boot.ledger.model.entity.SeExpander;
import com.youlai.boot.ledger.model.form.SeExpanderForm;
import com.youlai.boot.ledger.model.query.SeExpanderQuery;
import com.youlai.boot.ledger.model.vo.SeExpanderVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 特种设备膨胀机台账服务类
 *
 * @author baiwei
 * @since 2026-02-09 09:15
 */
public interface SeExpanderService extends IService<SeExpander> {

    /**
     *特种设备膨胀机台账分页列表
     *
     * @return {@link IPage<SeExpanderVO>} 特种设备膨胀机台账分页列表
     */
    IPage<SeExpanderVO> getSeExpanderPage(SeExpanderQuery queryParams);

    /**
     * 获取特种设备膨胀机台账表单数据
     *
     * @param id 特种设备膨胀机台账ID
     * @return 特种设备膨胀机台账表单数据
     */
     SeExpanderForm getSeExpanderFormData(Long id);

    /**
     * 新增特种设备膨胀机台账
     *
     * @param formData 特种设备膨胀机台账表单对象
     * @return 是否新增成功
     */
    boolean saveSeExpander(SeExpanderForm formData);

    /**
     * 修改特种设备膨胀机台账
     *
     * @param id   特种设备膨胀机台账ID
     * @param formData 特种设备膨胀机台账表单对象
     * @return 是否修改成功
     */
    boolean updateSeExpander(Long id, SeExpanderForm formData);

    /**
     * 删除特种设备膨胀机台账
     *
     * @param ids 特种设备膨胀机台账ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSeExpanders(String ids);

    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SeExpanderExportDto >} 导出压力列表
     * */
    List<SeExpanderExportDto> listExportSeExpander(SeExpanderQuery queryParams);

}
