package swust.qiy.microservice.management.controller.from.microservice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/3/22
 */
@Data
@ApiModel(value = "更新微服务表单")
public class MicroserviceUpdateForm {

  @ApiModelProperty(required = true, value = "唯一标识")
  private Integer id;

  @ApiModelProperty(required = false, value = "微服务编码")
  private String code;

  @ApiModelProperty(required = false, value = "微服务名称")
  private String name;

  @ApiModelProperty(required = false, value = "描述")
  private String description;

}
