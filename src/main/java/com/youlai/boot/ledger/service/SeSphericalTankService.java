package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SeHeaterExportDto;
import com.youlai.boot.ledger.model.dto.SeSphericalTankExportDto;
import com.youlai.boot.ledger.model.entity.SeSphericalTank;
import com.youlai.boot.ledger.model.form.SeSphericalTankForm;
import com.youlai.boot.ledger.model.query.SeHeaterQuery;
import com.youlai.boot.ledger.model.query.SeSphericalTankQuery;
import com.youlai.boot.ledger.model.vo.SeSphericalTankVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 球罐服务类
 *
 * @author baiwei
 * @since 2026-03-06 09:49
 */
public interface SeSphericalTankService extends IService<SeSphericalTank> {

    /**
     *球罐分页列表
     *
     * @return {@link IPage<SeSphericalTankVO>} 球罐分页列表
     */
    IPage<SeSphericalTankVO> getSeSphericalTankPage(SeSphericalTankQuery queryParams);

    /**
     * 获取球罐表单数据
     *
     * @param id 球罐ID
     * @return 球罐表单数据
     */
     SeSphericalTankForm getSeSphericalTankFormData(Long id);

    /**
     * 新增球罐
     *
     * @param formData 球罐表单对象
     * @return 是否新增成功
     */
    boolean saveSeSphericalTank(SeSphericalTankForm formData);

    /**
     * 修改球罐
     *
     * @param id   球罐ID
     * @param formData 球罐表单对象
     * @return 是否修改成功
     */
    boolean updateSeSphericalTank(Long id, SeSphericalTankForm formData);

    /**
     * 删除球罐
     *
     * @param ids 球罐ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSeSphericalTanks(String ids);

    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SeHeaterExportDto >} 导出压力列表
     * */
    List<SeSphericalTankExportDto>  listExportSeSphericalTank(SeSphericalTankQuery queryParams);


}
