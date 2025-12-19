package com.youlai.boot.system.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 设备类型视图对象
 *
 * @author youlaitech
 * @since 2025-12-17 08:15
 */
@Getter
@Setter
@Schema( description = "设备类型视图对象")
public class DvMachineryTypeVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "设备类型ID")
    private Long machineryTypeId;
    @Schema(description = "设备类型编码")
    private String machineryTypeCode;
    @Schema(description = "设备类型名称")
    private String machineryTypeName;
    @Schema(description = "父类型ID")
    private Long parentTypeId;
    @Schema(description = "所有父节点ID")
    private String ancestors;
    @Schema(description = "是否启用")
    private String enableFlag;
    @Schema(description = "备注")
    private String remark;
    @Schema(description = "创建者")
    private String createBy;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新者")
    private String updateBy;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
