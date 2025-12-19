package com.youlai.boot.system.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description ="设备类型查询对象")
@ToString
@Getter
@Setter
public class QueryDvTypeParams {
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
     * 是否启用
     */
    private String enableFlag;

    private String ancestors;

}
