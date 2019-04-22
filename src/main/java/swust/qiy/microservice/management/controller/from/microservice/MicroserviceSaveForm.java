package swust.qiy.microservice.management.controller.from.microservice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/3/22
 */
@Data
@ApiModel(value = "保存微服务表单")
public class MicroserviceSaveForm {

  @ApiModelProperty(required = true, value = "微服务编码")
  private String code;

  @ApiModelProperty(required = true, value = "微服务名称")
  private String name;

  @ApiModelProperty(required = true, value = "所属应用标识")
  private Integer appId;

  @ApiModelProperty(required = false, value = "描述")
  private String description;

  @ApiModelProperty(required = false, value = "所属用户")
  private Integer userId;

  @ApiModelProperty(required = false, value = "微服务版本, 默认为V1")
  private String version;

  @ApiModelProperty(required = false, value = "微服务版本描述")
  private String versionDesc;

}
