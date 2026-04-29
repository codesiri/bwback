package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SeRefrigeratorExportDto;
import com.youlai.boot.ledger.model.entity.SeRefrigerator;
import com.youlai.boot.ledger.model.form.SeRefrigeratorForm;
import com.youlai.boot.ledger.model.query.SeRefrigeratorQuery;
import com.youlai.boot.ledger.model.vo.SeRefrigeratorVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 特种设备制冷机台账服务类
 *
 * @author baiwei
 * @since 2026-02-14 08:38
 */
public interface SeRefrigeratorService extends IService<SeRefrigerator> {

    /**
     *特种设备制冷机台账分页列表
     *
     * @return {@link IPage<SeRefrigeratorVO>} 特种设备制冷机台账分页列表
     */
    IPage<SeRefrigeratorVO> getSeRefrigeratorPage(SeRefrigeratorQuery queryParams);

    /**
     * 获取特种设备制冷机台账表单数据
     *
     * @param id 特种设备制冷机台账ID
     * @return 特种设备制冷机台账表单数据
     */
     SeRefrigeratorForm getSeRefrigeratorFormData(Long id);

    /**
     * 新增特种设备制冷机台账
     *
     * @param formData 特种设备制冷机台账表单对象
     * @return 是否新增成功
     */
    boolean saveSeRefrigerator(SeRefrigeratorForm formData);

    /**
     * 修改特种设备制冷机台账
     *
     * @param id   特种设备制冷机台账ID
     * @param formData 特种设备制冷机台账表单对象
     * @return 是否修改成功
     */
    boolean updateSeRefrigerator(Long id, SeRefrigeratorForm formData);

    /**
     * 删除特种设备制冷机台账
     *
     * @param ids 特种设备制冷机台账ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSeRefrigerators(String ids);

    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SePumpExportDto >} 导出压力列表
     * */
    List<SeRefrigeratorExportDto> listExportSeRefrigerators(SeRefrigeratorQuery queryParams);

}
