package com.youlai.boot.system.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * 设备类型表单对象
 *
 * @author youlaitech
 * @since 2025-12-17 08:15
 */
@Getter
@Setter
@Schema(description = "设备类型表单对象")
public class DvMachineryTypeForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "设备类型ID")
    private Long machineryTypeId;

    @Schema(description = "设备类型编码")
    @Size(max=64, message="设备类型编码长度不能超过64个字符")
    private String machineryTypeCode;

    @Schema(description = "设备类型名称")
    @NotBlank(message = "设备类型名称不能为空")
    @Size(max=255, message="设备类型名称长度不能超过255个字符")
    private String machineryTypeName;

    @Schema(description = "父类型ID")
    private Long parentTypeId;

    @Schema(description = "所有父节点ID")
    @Size(max=255, message="所有父节点ID长度不能超过255个字符")
    private String ancestors;

    @Schema(description = "是否启用")
    @NotBlank(message = "是否启用不能为空")
    @Size(max=1, message="是否启用长度不能超过1个字符")
    private String enableFlag;

    @Schema(description = "备注")
    @Size(max=500, message="备注长度不能超过500个字符")
    private String remark;

    @Schema(description = "创建者")
    @Size(max=64, message="创建者长度不能超过64个字符")
    private String createBy;

    @Schema(description = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Schema(description = "更新者")
    @Size(max=64, message="更新者长度不能超过64个字符")
    private String updateBy;

    @Schema(description = "更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;


}
