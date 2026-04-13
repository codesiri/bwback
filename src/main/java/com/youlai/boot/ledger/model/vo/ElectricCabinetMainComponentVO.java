package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 抽屉柜主要元器件信息视图对象
 *
 * @author youlaitech
 * @since 2026-03-17 09:38
 */
@Getter
@Setter
@Schema( description = "抽屉柜主要元器件信息视图对象")
public class ElectricCabinetMainComponentVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "元器件名称")
    private String ecmComponentName;
    @Schema(description = "规格型号")
    private String ecmSpecModel;
    @Schema(description = "生产厂家")
    private String ecmManufacturer;
    @Schema(description = "	出厂编号")
    private String ecmFactoryNo;
    @Schema(description = "安装位置")
    private String ecmInstallLocation;
    @Schema(description = "投运日期")
    private LocalDate ecmCommissioningDate;
    @Schema(description = "额定参数")
    private String ecmRatedParameters;
    @Schema(description = "所属工厂")
    private String ecmFactory;
    @Schema(description = "备用1")
    private String ecmReserve1;
    @Schema(description = "备用2")
    private String ecmReserve2;
    @Schema(description = "备用3")
    private String ecmReserve3;
}
