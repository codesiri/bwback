package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 液位计表单对象
 *
 * @author dazao
 * @since 2026-01-20 15:40
 */
@Getter
@Setter
@Schema(description = "液位计表单对象")
public class LevelGaugeForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Schema(description = "序号")
    private Long id;
    @Schema(description = "装置名称")
    @NotBlank(message = "装置名称不能为空")
    @Size(max=255, message="装置名称长度不能超过255个字符")
    private String levelDevice;

    @Schema(description = "位号")
    @NotBlank(message = "位号不能为空")
    @Size(max=255, message="位号长度不能超过255个字符")
    private String levelTag;

    @Schema(description = "安装位置及用途")
    @NotBlank(message = "安装位置及用途不能为空")
    @Size(max=255, message="安装位置及用途长度不能超过255个字符")
    private String levelLocation;

    @Schema(description = "设备名称（液位计）")
    @NotBlank(message = "设备名称（液位计）不能为空")
    @Size(max=255, message="设备名称（液位计）长度不能超过255个字符")
    private String levelEquip;

    @Schema(description = "规格型号")
    @NotBlank(message = "规格型号不能为空")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String levelModel;

    @Schema(description = "生产厂家")
    @NotBlank(message = "生产厂家不能为空")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String levelManu;

    @Schema(description = "介质")
    @NotBlank(message = "介质不能为空")
    @Size(max=255, message="介质长度不能超过255个字符")
    private String levelMedium;

    @Schema(description = "测量范围")
    @NotBlank(message = "测量范围不能为空")
    @Size(max=255, message="测量范围长度不能超过255个字符")
    private String levelRange;

    @Schema(description = "精度")
    @Size(max=255, message="精度长度不能超过255个字符")
    private String levelAccuracy;

    @Schema(description = "电源")
    @Size(max=255, message="电源长度不能超过255个字符")
    private String levelPower;

    @Schema(description = "输出信号")
    @Size(max=255, message="输出信号长度不能超过255个字符")
    private String levelOutput;

    @Schema(description = "连接方式及规格")
    @NotBlank(message = "连接方式及规格不能为空")
    @Size(max=255, message="连接方式及规格长度不能超过255个字符")
    private String levelConnection;

    @Schema(description = "是否联锁（是 / 否）")
    @NotNull(message = "是否联锁（是 / 否）不能为空")
    private Integer levelInterlock;

    @Schema(description = "联锁设定值")
    @NotBlank(message = "联锁设定值不能为空")
    @Size(max=255, message="联锁设定值长度不能超过255个字符")
    private String levelInterlockVal;

    @Schema(description = "备注")
    @Size(max=255, message="备注长度不能超过255个字符")
    private String levelRemark;

    @Schema(description = "设备状态")
    @NotNull(message = "设备状态不能为空")
    private Integer status;

    @Schema(description = "设备类型")
    @NotNull(message = "设备类型不能为空")
    private String dvType;

}
