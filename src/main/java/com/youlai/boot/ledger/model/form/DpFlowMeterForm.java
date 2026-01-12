package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 差压流量计表单对象
 *
 * @author dazao
 * @since 2026-01-08 16:41
 */
@Getter
@Setter
@Schema(description = "差压流量计表单对象")
public class DpFlowMeterForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    @NotNull(message = "序号不能为空")
    private Long id;

    @Schema(description = "装置名称")
    @NotBlank(message = "装置名称不能为空")
    @Size(max=255, message="装置名称长度不能超过255个字符")
    private String dpFlowDevice;

    @Schema(description = "位号")
    @NotBlank(message = "位号不能为空")
    @Size(max=255, message="位号长度不能超过255个字符")
    private String dpFlowTag;

    @Schema(description = "安装位置及用途")
    @Size(max=255, message="安装位置及用途长度不能超过255个字符")
    private String dpFlowLocation;

    @Schema(description = "设备名称（差压流量计）")
    @Size(max=255, message="设备名称（差压流量计）长度不能超过255个字符")
    private String dpFlowEquip;

    @Schema(description = "规格型号")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String dpFlowModel;

    @Schema(description = "生产厂家")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String dpFlowManu;

    @Schema(description = "量程")
    @Size(max=255, message="量程长度不能超过255个字符")
    private String dpFlowRange;

    @Schema(description = "测量范围")
    @Size(max=255, message="测量范围长度不能超过255个字符")
    private String dpFlowMeasRange;

    @Schema(description = "介质名称")
    @Size(max=255, message="介质名称长度不能超过255个字符")
    private String dpFlowMedName;

    @Schema(description = "介质设计温度")
    @Size(max=255, message="介质设计温度长度不能超过255个字符")
    private String dpFlowMedTemp;

    @Schema(description = "介质设计力（MPa）")
    @Size(max=255, message="介质设计力（MPa）长度不能超过255个字符")
    private String dpFlowMedPress;

    @Schema(description = "连接方式及规格")
    @Size(max=255, message="连接方式及规格长度不能超过255个字符")
    private String dpFlowConnection;

    @Schema(description = "精度")
    @Size(max=255, message="精度长度不能超过255个字符")
    private String dpFlowAccuracy;

    @Schema(description = "是否伴热（是 / 否）")
    private Integer dpFlowHeat;

    @Schema(description = "是否联锁（是 / 否）")
    private Integer dpFlowInterlock;

    @Schema(description = "联锁设定值")
    @Size(max=255, message="联锁设定值长度不能超过255个字符")
    private String dpFlowInterlockVal;

    @Schema(description = "备注")
    @Size(max=255, message="备注长度不能超过255个字符")
    private String dpFlowRemark;

    @Schema(description = "设备编码")
    @Size(max=255, message="设备编码长度不能超过255个字符")
    private String dvCode;

    @Schema(description = "设备状态")
    private Integer status;

    @Schema(description = "设备类型")
    @NotBlank(message = "设备类型不能为空")
    @Size(max=255, message="设备类型长度不能超过255个字符")
    private String dvType;


}
