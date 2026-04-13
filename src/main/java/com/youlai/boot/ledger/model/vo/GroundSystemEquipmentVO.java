package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 电器接地系统视图对象
 *
 * @author dazao
 * @since 2026-03-09 08:51
 */
@Getter
@Setter
@Schema( description = "电器接地系统视图对象")
public class GroundSystemEquipmentVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "接地编号")
    private String gseGroundCode;
    @Schema(description = "接地类型")
    private String gseGroundType;
    @Schema(description = "接地结构")
    private String gseGroundStruct;
    @Schema(description = "材质")
    private String gseMaterial;
    @Schema(description = "安装位置")
    private String gseInstallArea;
    @Schema(description = "安装区域及危险等级")
    private String gseInstallPosition;
    @Schema(description = "设计接地电阻值（Ω）")
    private String gseDesignResistance;
    @Schema(description = "上次接地电阻测试日期")
    private LocalDate gseLastTestDate;
    @Schema(description = "上次测试电阻值（Ω）")
    private String gseLastTestData;
    @Schema(description = "下次测试日期")
    private LocalDate gseNextTestDate;
    @Schema(description = "测试人员")
    private String gseTestPerson;
    @Schema(description = "安装日期")
    private LocalDate gseInstallDate;
    @Schema(description = "接地状态")
    private String gseStatus;
    @Schema(description = "所属工厂")
    private String gseFactory;
}
