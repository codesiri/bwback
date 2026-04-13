package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 抽屉柜主要元器件信息表单对象
 *
 * @author youlaitech
 * @since 2026-03-17 09:38
 */
@Getter
@Setter
@Schema(description = "抽屉柜主要元器件信息表单对象")
public class ElectricCabinetMainComponentForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;

    @Schema(description = "元器件名称")
    @Size(max=255, message="元器件名称长度不能超过255个字符")
    private String ecmComponentName;

    @Schema(description = "规格型号")
    @Size(max=255, message="规格型号长度不能超过255个字符")
    private String ecmSpecModel;

    @Schema(description = "生产厂家")
    @Size(max=255, message="生产厂家长度不能超过255个字符")
    private String ecmManufacturer;

    @Schema(description = "	出厂编号")
    @Size(max=255, message="	出厂编号长度不能超过255个字符")
    private String ecmFactoryNo;

    @Schema(description = "安装位置")
    @Size(max=255, message="安装位置长度不能超过255个字符")
    private String ecmInstallLocation;

    @Schema(description = "投运日期")
    private LocalDate ecmCommissioningDate;

    @Schema(description = "额定参数")
    @Size(max=255, message="额定参数长度不能超过255个字符")
    private String ecmRatedParameters;

    @Schema(description = "所属工厂")
    @Size(max=255, message="所属工厂长度不能超过255个字符")
    private String ecmFactory;

    @Schema(description = "备用1")
    @Size(max=255, message="备用1长度不能超过255个字符")
    private String ecmReserve1;

    @Schema(description = "备用2")
    @Size(max=255, message="备用2长度不能超过255个字符")
    private String ecmReserve2;

    @Schema(description = "备用3")
    @Size(max=255, message="备用3长度不能超过255个字符")
    private String ecmReserve3;


}
