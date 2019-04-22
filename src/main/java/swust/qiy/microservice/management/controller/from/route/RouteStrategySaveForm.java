package swust.qiy.microservice.management.controller.from.route;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/4/3
 */
@Data
@ApiModel(value = "绑定路由策略关系表")
public class RouteStrategySaveForm {

  @ApiModelProperty(required = true, value = "路由id")
  private Integer routeId;

  @ApiModelProperty(required = true, value = "调用策略id")
  private List<Integer> strategyIds;

}
