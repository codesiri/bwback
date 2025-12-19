package com.youlai.boot.system.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 设备类型分页查询对象
 *
 * @author youlaitech
 * @since 2025-12-17 08:15
 */
@Schema(description ="设备类型查询对象")
@Getter
@Setter
public class DvMachineryTypeQuery extends BasePageQuery {

}
