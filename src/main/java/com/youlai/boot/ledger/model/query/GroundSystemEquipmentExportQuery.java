package com.youlai.boot.ledger.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class GroundSystemEquipmentExportQuery {

    @Schema(description = "接地编号")
    private String gseGroundCode;
    @Schema(description = "接地类型")
    private String gseGroundType;
    @Schema(description = "安装位置")
    private String gseInstallArea;
    @Schema(description = "安装区域及危险等级")
    private String gseInstallPosition;
    @Schema(description = "上次接地电阻测试日期")
    private List<String> gseLastTestDate;
    @Schema(description = "上次测试电阻值（Ω）")
    private String gseLastTestData;
    @Schema(description = "下次测试日期")
    private List<String> gseNextTestDate;
    @Schema(description = "测试人员")
    private String gseTestPerson;
    @Schema(description = "安装日期")
    private List<String> gseInstallDate;
    @Schema(description = "接地状态")
    private String gseStatus;
    @Schema(description = "所属工厂")
    private String gseFactory;
}
