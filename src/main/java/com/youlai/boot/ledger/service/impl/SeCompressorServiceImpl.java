package com.youlai.boot.ledger.service.impl;

import com.youlai.boot.ledger.model.dto.SeCompressorExportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.ledger.mapper.SeCompressorMapper;
import com.youlai.boot.ledger.service.SeCompressorService;
import com.youlai.boot.ledger.model.entity.SeCompressor;
import com.youlai.boot.ledger.model.form.SeCompressorForm;
import com.youlai.boot.ledger.model.query.SeCompressorQuery;
import com.youlai.boot.ledger.model.vo.SeCompressorVO;
import com.youlai.boot.ledger.converter.SeCompressorConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 特种设备压缩机台账服务实现类
 *
 * @author baiwei
 * @since 2026-02-09 09:07
 */
@Service
@RequiredArgsConstructor
public class SeCompressorServiceImpl extends ServiceImpl<SeCompressorMapper, SeCompressor> implements SeCompressorService {

    private final SeCompressorConverter seCompressorConverter;

    /**
    * 获取特种设备压缩机台账分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SeCompressorVO>} 特种设备压缩机台账分页列表
    */
    @Override
    public IPage<SeCompressorVO> getSeCompressorPage(SeCompressorQuery queryParams) {
        Page<SeCompressorVO> pageVO = this.baseMapper.getSeCompressorPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取特种设备压缩机台账表单数据
     *
     * @param id 特种设备压缩机台账ID
     * @return 特种设备压缩机台账表单数据
     */
    @Override
    public SeCompressorForm getSeCompressorFormData(Long id) {
        SeCompressor entity = this.getById(id);
        return seCompressorConverter.toForm(entity);
    }
    
    /**
     * 新增特种设备压缩机台账
     *
     * @param formData 特种设备压缩机台账表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSeCompressor(SeCompressorForm formData) {
        SeCompressor entity = seCompressorConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新特种设备压缩机台账
     *
     * @param id   特种设备压缩机台账ID
     * @param formData 特种设备压缩机台账表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSeCompressor(Long id,SeCompressorForm formData) {
        SeCompressor entity = seCompressorConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除特种设备压缩机台账
     *
     * @param ids 特种设备压缩机台账ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSeCompressors(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的特种设备压缩机台账数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }



    /**
     *
     * 获取导出列表
     * @param queryParams 查询参数
     * @return {@link List < SePumpExportDto >} 导出压力列表
     * */
   public List<SeCompressorExportDto> listExportSeCompressor(SeCompressorQuery queryParams) {
       List<SeCompressorExportDto>  exportSeCompressorList=this.baseMapper.listExportSeCompressor(queryParams);
       return exportSeCompressorList;
    }
}
