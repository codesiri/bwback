package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 机组特殊仪表单对象
 *
 * @author dazao
 * @since 2026-01-21 09:01
 */
@Getter
@Setter
@Schema(description = "机组特殊仪表单对象")
public class UnitSpecialInstrumentsForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "位号")
    @NotBlank(message = "位号不能为空")
    @Size(max=255, message="位号长度不能超过255个字符")
    private String tagNumber;

    @Schema(description = "仪表名称")
    @Size(max=255, message="仪表名称长度不能超过255个字符")
    private String instrumentName;

    @Schema(description = "设备名称")
    @NotBlank(message = "设备名称不能为空")
    @Size(max=255, message="设备名称长度不能超过255个字符")
    private String deviceName;

    @Schema(description = "装置")
    @NotBlank(message = "装置不能为空")
    @Size(max=255, message="装置长度不能超过255个字符")
    private String device;

    @Schema(description = "安装位置及用途")
    @NotBlank(message = "安装位置及用途不能为空")
    @Size(max=255, message="安装位置及用途长度不能超过255个字符")
    private String installationLocation;

    @Schema(description = "规格型号")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String specificationModel;

    @Schema(description = "量程")
    @NotBlank(message = "量程不能为空")
    @Size(max=255, message="量程长度不能超过255个字符")
    private String measurementRange;

    @Schema(description = "数量")
    @Size(max=255, message="数量长度不能超过255个字符")
    private String quantity;

    @Schema(description = "厂家")
    @NotBlank(message = "厂家不能为空")
    @Size(max=255, message="厂家长度不能超过255个字符")
    private String manufacturer;


    @Schema(description = "编号")
    @Size(max=255, message="编号长度不能超过255个字符")
    private String unitSpecialCode;

    @Schema(description = "设备状态")
    @NotNull(message = "设备状态不能为空")
    private Integer status;

    @Schema(description = "设备类型")
    @NotBlank(message = "设备类型不能为空")
    @Size(max=255, message="设备类型长度不能超过255个字符")
    private String dvType;


}
