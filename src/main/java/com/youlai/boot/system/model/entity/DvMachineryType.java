package com.youlai.boot.system.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 设备类型实体对象
 *
 * @author youlaitech
 * @since 2025-12-17 08:15
 */
@Getter
@Setter
@TableName("dv_machinery_type")
public class DvMachineryType  {

    private static final long serialVersionUID = 1L;

    /**
     * 设备类型ID
     */
    @TableId
    private Long machineryTypeId;
    /**
     * 设备类型编码
     */
    private String machineryTypeCode;
    /**
     * 设备类型名称
     */
    private String machineryTypeName;
    /**
     * 父类型ID
     */
    private Long parentTypeId;
    /**
     * 所有父节点ID
     */
    private String ancestors;
    /**
     * 是否启用
     */
    private String enableFlag;
    /**
     * 备注
     */
    private String remark;
    /**
     * 预留字段1
     */
    private String attr1;
    /**
     * 预留字段2
     */
    private String attr2;
    /**
     * 预留字段3
     */
    private Integer attr3;
    /**
     * 预留字段4
     */
    private Integer attr4;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
