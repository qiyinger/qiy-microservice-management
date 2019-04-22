package swust.qiy.microservice.management.controller.from.route;

import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/4/3
 */
@Data
@ApiModel(value = "保存路由表单")
public class RouteSaveForm {

  @ApiModelProperty(required = true, value = "路由名称")
  private String name;

  @ApiModelProperty(required = false, value = "路由描述")
  private String description;

  @ApiModelProperty(required = true, value = "所属网关标识")
  private Integer gatewayId;

  @ApiModelProperty(required = true, value = "绑定类型")
  private Byte bindType;

  @ApiModelProperty(required = true, value = "绑定id")
  private Integer bindId;

  @ApiModelProperty(required = true, value = "路由编码")
  private String code;

  @ApiModelProperty(required = true, value = "路由地址")
  private String uri;

  @ApiModelProperty(required = false, value = "过滤器")
  private String filters;

  @ApiModelProperty(required = false, value = "断言工厂")
  private String predicates;

  @ApiModelProperty(required = false, value = "优先级")
  private Integer priority;

  @ApiModelProperty(required = true, value = "是否发布")
  private Boolean publish;

}
