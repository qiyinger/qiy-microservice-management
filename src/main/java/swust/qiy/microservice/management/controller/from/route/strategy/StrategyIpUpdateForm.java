package swust.qiy.microservice.management.controller.from.route.strategy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/4/2
 */
@Data
@ApiModel(value = "修改IP策略表单")
public class StrategyIpUpdateForm {

  @ApiModelProperty(required = true, value = "id")
  private Integer id;

  @ApiModelProperty(required = true, value = "策略名称")
  private String name;

  @ApiModelProperty(required = false, value = "策略描述")
  private String description;

  @ApiModelProperty(required = true, value = "ip列表")
  private String ipList;

}
