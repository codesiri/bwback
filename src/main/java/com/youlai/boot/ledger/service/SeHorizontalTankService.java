package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SeHorizontalTankExportDto;
import com.youlai.boot.ledger.model.entity.SeHorizontalTank;
import com.youlai.boot.ledger.model.form.SeHorizontalTankForm;
import com.youlai.boot.ledger.model.query.SeHorizontalTankQuery;
import com.youlai.boot.ledger.model.vo.SeHorizontalTankVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 卧罐服务类
 *
 * @author baiwei
 * @since 2026-03-06 09:33
 */
public interface SeHorizontalTankService extends IService<SeHorizontalTank> {

    /**
     *卧罐分页列表
     *
     * @return {@link IPage<SeHorizontalTankVO>} 卧罐分页列表
     */
    IPage<SeHorizontalTankVO> getSeHorizontalTankPage(SeHorizontalTankQuery queryParams);

    /**
     * 获取卧罐表单数据
     *
     * @param id 卧罐ID
     * @return 卧罐表单数据
     */
     SeHorizontalTankForm getSeHorizontalTankFormData(Long id);

    /**
     * 新增卧罐
     *
     * @param formData 卧罐表单对象
     * @return 是否新增成功
     */
    boolean saveSeHorizontalTank(SeHorizontalTankForm formData);

    /**
     * 修改卧罐
     *
     * @param id   卧罐ID
     * @param formData 卧罐表单对象
     * @return 是否修改成功
     */
    boolean updateSeHorizontalTank(Long id, SeHorizontalTankForm formData);

    /**
     * 删除卧罐
     *
     * @param ids 卧罐ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSeHorizontalTanks(String ids);
    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SePumpExportDto >} 导出压力列表
     * */
    List<SeHorizontalTankExportDto> listExportSeHorizontalTanks(SeHorizontalTankQuery queryParams);

}
