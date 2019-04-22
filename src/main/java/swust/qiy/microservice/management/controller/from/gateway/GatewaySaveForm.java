package swust.qiy.microservice.management.controller.from.gateway;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/4/4
 */
@Data
@ApiModel(value = "保存网关表单")
public class GatewaySaveForm {

  @ApiModelProperty(required = true, value = "网关编码")
  private String code;

  @ApiModelProperty(required = true, value = "网关名称")
  private String name;

  @ApiModelProperty(required = false, value = "网关描述")
  private String description;

  @ApiModelProperty(required = true, value = "系统id")
  private Integer systemId;


}
