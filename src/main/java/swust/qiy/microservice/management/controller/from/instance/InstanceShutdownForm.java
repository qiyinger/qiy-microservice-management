package swust.qiy.microservice.management.controller.from.instance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/3/27
 */
@Data
@ApiModel(value = "停止服务实例表单")
public class InstanceShutdownForm {

  @ApiModelProperty(required = true, value = "实例Id")
  private String instanceId;

  @ApiModelProperty(required = true, value = "微服务实例名称")
  private String serviceName;

}
