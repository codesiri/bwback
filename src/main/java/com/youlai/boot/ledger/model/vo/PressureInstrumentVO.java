package com.youlai.boot.ledger.model.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 压力视图对象
 *
 * @author wy
 * @since 2025-12-29 11:00
 */
@Getter
@Setter
@Schema( description = "压力视图对象")
public class PressureInstrumentVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键id")
    private Long id;
    @Schema(description = "装置名称")
    private String pressureDevice;
    @Schema(description = "位号")
    private String pressureTag;
    @Schema(description = "安装位置以及用途")
    private String pressureLocation;
    @Schema(description = "设备名称")
    private String pressureEquip;
    @Schema(description = "规格型号")
    private String pressureModel;
    @Schema(description = "生产厂家")
    private String pressureManu;
    @Schema(description = "测量范围")
    private String pressureRange;
    @Schema(description = "连接方式及规格")
    private String pressureConnection;
    @Schema(description = "精度")
    private String pressureAccuracy;
    @Schema(description = "电源（如 24V DC）")
    private String pressurePower;
    @Schema(description = "输出信号（如 4-20mA）")
    private String pressureOutput;
    @Schema(description = "是否伴热（是 / 否）")
    private String pressureHeat;
    @Schema(description = "是否带连锁")
    private String pressureInterlock;
    @Schema(description = "联锁设定值")
    private String pressureInterlockVal;
    @Schema(description = "备注")
    private String pressureRemark;



}

