package com.youlai.boot.ledger.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 电器电缆线路视图对象
 *
 * @author dazao
 * @since 2026-03-05 08:45
 */
@Getter
@Setter
@Schema( description = "电器电缆线路视图对象")
public class CableLineEquipmentVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "序号")
    private Long id;
    @Schema(description = "电缆编号")
    private String cleCableCode;
    @Schema(description = "电缆名称")
    private String cleCableName;
    @Schema(description = "规格型号")
    private String cleSpecModel;
    @Schema(description = "绝缘等级")
    private String cleInsulationLevel;
    @Schema(description = "电缆长度（m）")
    private String cleCableLength;
    @Schema(description = "敷设方式")
    private String cleLayingMethod;
    @Schema(description = "敷设路径")
    private String cleLayingPath;
    @Schema(description = "安装区域及危险等级")
    private String cleInstallArea;
    @Schema(description = "电缆芯数")
    private String cleCoreNumber;
    @Schema(description = "芯线截面（mm²）")
    private String cleCoreSection;
    @Schema(description = "生产厂家")
    private String cleManufacturer;
    @Schema(description = "生产日期")
    private LocalDate cleProductionDate;
    @Schema(description = "敷设安装日期")
    private LocalDate cleInstallDate;
    @Schema(description = "上次耐压 / 绝缘测试日期")
    private LocalDate cleLastTestDate;
    @Schema(description = "上次测试数据（MΩ/kV）")
    private String cleLastTestData;
    @Schema(description = "中间接头数量")
    private String cleJointCount;
    @Schema(description = "电缆状态（在用 / 备用 / 停用）")
    private String cleStatus;
    @Schema(description = "所属工厂")
    private String cleFactory;
}
