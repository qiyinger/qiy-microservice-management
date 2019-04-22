package swust.qiy.microservice.management.controller.from.microservice.version;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/3/27
 */
@Data
@ApiModel(value = "保存微服务版本表单")
public class VersionSaveForm {

  @ApiModelProperty(required = true, value = "微服务版本号")
  private String version;

  @ApiModelProperty(required = false, value = "实例数")
  private Integer numOfInst;

  @ApiModelProperty(required = false, value = "描述")
  private String description;

  @ApiModelProperty(required = true, value = "微服务标识")
  private Integer microserviceId;

}
