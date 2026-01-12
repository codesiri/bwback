package com.youlai.boot.ledger.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * 静设备表单对象
 *
 * @author dazao
 * @since 2026-01-08 08:37
 */
@Getter
@Setter
@Schema(description = "静设备表单对象")
public class StaticEquipForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "设备名称")
    @NotBlank(message = "设备名称不能为空")
    @Size(max=255, message="设备名称长度不能超过255个字符")
    private String staticEquipName;

    @Schema(description = "位号")
    @NotBlank(message = "位号不能为空")
    @Size(max=255, message="位号长度不能超过255个字符")
    private String staticEquipTag;

    @Schema(description = "所处位置")
    @Size(max=255, message="所处位置长度不能超过255个字符")
    private String staticEquipLoc;

    @Schema(description = "操作温度")
    @Size(max=255, message="操作温度长度不能超过255个字符")
    private String staticEquipOpTemp;

    @Schema(description = "操作压力")
    @Size(max=255, message="操作压力长度不能超过255个字符")
    private String staticEquipOpPress;

    @Schema(description = "介质")
    @Size(max=255, message="介质长度不能超过255个字符")
    private String staticEquipMed;

    @Schema(description = "出厂编号")
    @Size(max=255, message="出厂编号长度不能超过255个字符")
    private String staticEquipFactoryNo;

    @Schema(description = "类别")
    @Size(max=255, message="类别长度不能超过255个字符")
    private String staticEquipCategory;

    @Schema(description = "重量（kg）")
    @Size(max=255, message="重量（kg）长度不能超过255个字符")
    private String staticEquipWeght;

    @Schema(description = "检验日期")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime staticEquipInspestDate;

    @Schema(description = "下次检验日期")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime staticEquipNextInspestDate;

    @Schema(description = "设备状态")
    @NotNull(message = "设备状态不能为空")
    private Integer status;

    @Schema(description = "设备编码")
    @NotBlank(message = "设备编码不能为空")
    @Size(max=255, message="设备编码长度不能超过255个字符")
    private String dvCode;


}
