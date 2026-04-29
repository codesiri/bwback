package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SePumpExportDto;
import com.youlai.boot.ledger.model.entity.SePump;
import com.youlai.boot.ledger.model.form.SePumpForm;
import com.youlai.boot.ledger.model.query.SePumpQuery;
import com.youlai.boot.ledger.model.vo.SePumpVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 泵服务类
 *
 * @author baiwei
 * @since 2026-02-05 14:46
 */
public interface SePumpService extends IService<SePump> {

    /**
     *泵分页列表
     *
     * @return {@link IPage<SePumpVO>} 泵分页列表
     */
    IPage<SePumpVO> getSePumpPage(SePumpQuery queryParams);

    /**
     * 获取泵表单数据
     *
     * @param id 泵ID
     * @return 泵表单数据
     */
     SePumpForm getSePumpFormData(Long id);

    /**
     * 新增泵
     *
     * @param formData 泵表单对象
     * @return 是否新增成功
     */
    boolean saveSePump(SePumpForm formData);

    /**
     * 修改泵
     *
     * @param id   泵ID
     * @param formData 泵表单对象
     * @return 是否修改成功
     */
    boolean updateSePump(Long id, SePumpForm formData);

    /**
     * 删除泵
     *
     * @param ids 泵ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSePumps(String ids);
    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SePumpExportDto >} 导出压力列表
     * */
    List<SePumpExportDto> listExportSePumps(SePumpQuery queryParams);

}
