package swust.qiy.microservice.management.controller.from.route.strategy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/4/2
 */
@Data
@ApiModel(value = "保存IP策略表单")
public class StrategyIpSaveForm {

  @ApiModelProperty(required = true, value = "策略名称")
  private String name;

  @ApiModelProperty(required = true, value = "控制类型:黑名单0/1", allowableValues = "0,1")
  private Byte type;

  @ApiModelProperty(required = false, value = "策略描述")
  private String description;

  @ApiModelProperty(required = true, value = "ip列表")
  private String ipList;

  @ApiModelProperty(required = true, value = "网关id")
  private Integer gatewayId;

}
