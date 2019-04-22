package swust.qiy.microservice.management.controller.from.route.strategy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/4/2
 */
@Data
@ApiModel(value = "保存限流策略表单")
public class StrategyCallSaveForm {

  @ApiModelProperty(required = true, value = "策略名称")
  private String name;

  @ApiModelProperty(required = false, value = "策略描述")
  private String description;

  @ApiModelProperty(required = true, value = "时间单位")
  private Byte timeUnit;

  @ApiModelProperty(required = true, value = "时间长度")
  private Integer timePeriod;

  @ApiModelProperty(required = true, value = "时间长度内限制次数")
  private Integer rateLimit;

  @ApiModelProperty(required = true, value = "网关id")
  private Integer gatewayId;

}
