package com.youlai.boot.ledger.service;

import com.youlai.boot.ledger.model.dto.SeCompressorExportDto;
import com.youlai.boot.ledger.model.entity.SeCompressor;
import com.youlai.boot.ledger.model.form.SeCompressorForm;
import com.youlai.boot.ledger.model.query.SeCompressorQuery;
import com.youlai.boot.ledger.model.vo.SeCompressorVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 特种设备压缩机台账服务类
 *
 * @author baiwei
 * @since 2026-02-09 09:07
 */
public interface SeCompressorService extends IService<SeCompressor> {

    /**
     *特种设备压缩机台账分页列表
     *
     * @return {@link IPage<SeCompressorVO>} 特种设备压缩机台账分页列表
     */
    IPage<SeCompressorVO> getSeCompressorPage(SeCompressorQuery queryParams);

    /**
     * 获取特种设备压缩机台账表单数据
     *
     * @param id 特种设备压缩机台账ID
     * @return 特种设备压缩机台账表单数据
     */
     SeCompressorForm getSeCompressorFormData(Long id);

    /**
     * 新增特种设备压缩机台账
     *
     * @param formData 特种设备压缩机台账表单对象
     * @return 是否新增成功
     */
    boolean saveSeCompressor(SeCompressorForm formData);

    /**
     * 修改特种设备压缩机台账
     *
     * @param id   特种设备压缩机台账ID
     * @param formData 特种设备压缩机台账表单对象
     * @return 是否修改成功
     */
    boolean updateSeCompressor(Long id, SeCompressorForm formData);

    /**
     * 删除特种设备压缩机台账
     *
     * @param ids 特种设备压缩机台账ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSeCompressors(String ids);

    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SePumpExportDto >} 导出压力列表
     * */
    List<SeCompressorExportDto> listExportSeCompressor(SeCompressorQuery queryParams);

}
