package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SeFanExportDto;
import com.youlai.boot.ledger.model.entity.SeFan;
import com.youlai.boot.ledger.model.form.SeFanForm;
import com.youlai.boot.ledger.model.query.SeFanQuery;
import com.youlai.boot.ledger.model.vo.SeFanVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 特种设备风机台账服务类
 *
 * @author youlaitech
 * @since 2026-02-09 09:18
 */
public interface SeFanService extends IService<SeFan> {

    /**
     *特种设备风机台账分页列表
     *
     * @return {@link IPage<SeFanVO>} 特种设备风机台账分页列表
     */
    IPage<SeFanVO> getSeFanPage(SeFanQuery queryParams);

    /**
     * 获取特种设备风机台账表单数据
     *
     * @param id 特种设备风机台账ID
     * @return 特种设备风机台账表单数据
     */
     SeFanForm getSeFanFormData(Long id);

    /**
     * 新增特种设备风机台账
     *
     * @param formData 特种设备风机台账表单对象
     * @return 是否新增成功
     */
    boolean saveSeFan(SeFanForm formData);

    /**
     * 修改特种设备风机台账
     *
     * @param id   特种设备风机台账ID
     * @param formData 特种设备风机台账表单对象
     * @return 是否修改成功
     */
    boolean updateSeFan(Long id, SeFanForm formData);

    /**
     * 删除特种设备风机台账
     *
     * @param ids 特种设备风机台账ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSeFans(String ids);
    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SeFanExportDto >} 导出压力列表
     * */
    List<SeFanExportDto> listExportSeFans(SeFanQuery queryParams);

}
