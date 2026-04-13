package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 抽屉柜抽屉单元明细表单对象
 *
 * @author youlaitech
 * @since 2026-03-17 09:40
 */
@Getter
@Setter
@Schema(description = "抽屉柜抽屉单元明细表单对象")
public class ElectricCabinetDrawerUnitForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "抽屉编号")
    @NotBlank(message = "抽屉编号不能为空")
    @Size(max=255, message="抽屉编号长度不能超过255个字符")
    private String ecduDrawerNo;

    @Schema(description = "单元名称")
    @Size(max=255, message="单元名称长度不能超过255个字符")
    private String ecduUnitName;

    @Schema(description = "额定电流（A）")
    @NotBlank(message = "额定电流（A）不能为空")
    @Size(max=255, message="额定电流（A）长度不能超过255个字符")
    private String ecduRatedCurrent;

    @Schema(description = "额定电压（V）")
    @NotBlank(message = "额定电压（V）不能为空")
    @Size(max=255, message="额定电压（V）长度不能超过255个字符")
    private String ecduRatedVoltage;

    @Schema(description = "开关型号")
    @Size(max=255, message="开关型号长度不能超过255个字符")
    private String ecduSwitchModel;

    @Schema(description = "开关厂家")
    @Size(max=255, message="开关厂家长度不能超过255个字符")
    private String ecduSwitchManufacturer;

    @Schema(description = "整定电流（A）")
    @Size(max=255, message="整定电流（A）长度不能超过255个字符")
    private String ecduSettingCurrent;

    @Schema(description = "对应负载")
    @Size(max=255, message="对应负载长度不能超过255个字符")
    private String ecduCorrespondingLoad;

    @Schema(description = "安装位置")
    @Size(max=255, message="安装位置长度不能超过255个字符")
    private String ecduInstallLocation;

    @Schema(description = "单元状态")
    @Size(max=255, message="单元状态长度不能超过255个字符")
    private String ecduUnitStatus;

    @Schema(description = "所属工厂")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String ecduFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String ecduReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String ecduReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String ecduReserve3;


}
