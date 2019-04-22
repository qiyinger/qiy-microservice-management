package swust.qiy.microservice.management.controller.from.gateway;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author qiying
 * @create 2019/4/4
 */
@ApiModel(value = "更新网关表单")
public class GatewayUpdateForm {

  @ApiModelProperty(required = true, value = "网关id")
  private Integer id;

  @ApiModelProperty(required = false, value = "网关编码")
  private String code;

  @ApiModelProperty(required = false, value = "网关名称")
  private String name;

  @ApiModelProperty(required = false, value = "网关描述")
  private String description;

}
