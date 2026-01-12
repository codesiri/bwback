package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 流量计表单对象
 *
 * @author dazao
 * @since 2026-01-09 09:04
 */
@Getter
@Setter
@Schema(description = "流量计表单对象")
public class DvFlowmetreInfoForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "仪表位号")
    @NotBlank(message = "仪表位号不能为空")
    @Size(max=255, message="仪表位号长度不能超过255个字符")
    private String tagNumber;

    @Schema(description = "装置")
    @NotBlank(message = "装置不能为空")
    @Size(max=255, message="装置长度不能超过255个字符")
    private String device;

    @Schema(description = "用途")
    @Size(max=255, message="用途长度不能超过255个字符")
    private String purpose;

    @Schema(description = "仪表名称")
    @NotBlank(message = "仪表名称不能为空")
    @Size(max=255, message="仪表名称长度不能超过255个字符")
    private String instrumentName;

    @Schema(description = "量程")
    @Size(max=255, message="量程长度不能超过255个字符")
    private String measurementRange;

    @Schema(description = "厂家")
    @Size(max=255, message="厂家长度不能超过255个字符")
    private String manufacturer;

    @Schema(description = "工艺介质-介质")
    @NotBlank(message = "工艺介质-介质不能为空")
    @Size(max=255, message="工艺介质-介质长度不能超过255个字符")
    private String medium;

    @Schema(description = "工艺介质-状态")
    private Integer mediumStatus;

    @Schema(description = "工艺介质-压力")
    @Size(max=255, message="工艺介质-压力长度不能超过255个字符")
    private String mediumPressure;

    @Schema(description = "工艺介质-温度")
    @Size(max=255, message="工艺介质-温度长度不能超过255个字符")
    private String mediumTemperature;

    @Schema(description = "出厂编号")
    @Size(max=255, message="出厂编号长度不能超过255个字符")
    private String factoryNumber;

    @Schema(description = "备注")
    @Size(max=100, message="备注长度不能超过100个字符")
    private String remark;

    @Schema(description = "设备状态")
    @NotNull(message = "设备状态不能为空")
    private Integer status;

    @Schema(description = "设备类型")
    @NotBlank(message = "设备类型不能为空")
    @Size(max=255, message="设备类型长度不能超过255个字符")
    private String dvType;


}
