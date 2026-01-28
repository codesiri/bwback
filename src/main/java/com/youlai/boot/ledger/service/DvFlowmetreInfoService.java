package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.DvFlowmetreInfoExportDto;
import com.youlai.boot.ledger.model.dto.DvTemperatureGaugesExportDTO;
import com.youlai.boot.ledger.model.entity.DvFlowmetreInfo;
import com.youlai.boot.ledger.model.form.DvFlowmetreInfoForm;
import com.youlai.boot.ledger.model.query.DvFlowmetreInfoQuery;
import com.youlai.boot.ledger.model.query.DvFlowmetreInfoQueryExport;
import com.youlai.boot.ledger.model.vo.DvFlowmetreInfoVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 流量计服务类
 *
 * @author dazao
 * @since 2026-01-09 09:04
 */
public interface DvFlowmetreInfoService extends IService<DvFlowmetreInfo> {

    /**
     *流量计分页列表
     *
     * @return {@link IPage<DvFlowmetreInfoVO>} 流量计分页列表
     */
    IPage<DvFlowmetreInfoVO> getDvFlowmetreInfoPage(DvFlowmetreInfoQuery queryParams);

    /**
     * 获取流量计表单数据
     *
     * @param id 流量计ID
     * @return 流量计表单数据
     */
     DvFlowmetreInfoForm getDvFlowmetreInfoFormData(Long id);

    /**
     * 新增流量计
     *
     * @param formData 流量计表单对象
     * @return 是否新增成功
     */
    boolean saveDvFlowmetreInfo(DvFlowmetreInfoForm formData);

    /**
     * 修改流量计
     *
     * @param id   流量计ID
     * @param formData 流量计表单对象
     * @return 是否修改成功
     */
    boolean updateDvFlowmetreInfo(Long id, DvFlowmetreInfoForm formData);

    /**
     * 删除流量计
     *
     * @param ids 流量计ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteDvFlowmetreInfos(String ids);

    List<DvFlowmetreInfoExportDto> listExportDvFlowmetreInfo(DvFlowmetreInfoQueryExport queryParams);
}
