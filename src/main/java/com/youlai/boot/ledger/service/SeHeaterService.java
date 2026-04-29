package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.entity.SeHeater;
import com.youlai.boot.ledger.model.form.SeHeaterForm;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.model.vo.SeHeaterVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 换热器服务类
 *
 * @author baiwei
 * @since 2026-03-03 10:16
 */
public interface SeHeaterService extends IService<SeHeater> {

    /**
     *换热器分页列表
     *
     * @return {@link IPage<SeHeaterVO>} 换热器分页列表
     */
    IPage<SeHeaterVO> getSeHeaterPage(SeHeaterQuery queryParams);

    /**
     * 获取换热器表单数据
     *
     * @param id 换热器ID
     * @return 换热器表单数据
     */
     SeHeaterForm getSeHeaterFormData(Long id);

    /**
     * 新增换热器
     *
     * @param formData 换热器表单对象
     * @return 是否新增成功
     */
    boolean saveSeHeater(SeHeaterForm formData);

    /**
     * 修改换热器
     *
     * @param id   换热器ID
     * @param formData 换热器表单对象
     * @return 是否修改成功
     */
    boolean updateSeHeater(Long id, SeHeaterForm formData);

    /**
     * 删除换热器
     *
     * @param ids 换热器ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSeHeaters(String ids);
    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SeHeaterExportDto >} 导出压力列表
     * */
    List<SeHeaterExportDto>  listExportSeHeater(SeHeaterQuery queryParams);

}
