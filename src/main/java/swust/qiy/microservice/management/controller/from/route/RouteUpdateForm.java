package swust.qiy.microservice.management.controller.from.route;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/4/3
 */
@Data
@ApiModel(value = "更新路由表单")
public class RouteUpdateForm {

  @ApiModelProperty(required = true, value = "id")
  private Integer id;

  @ApiModelProperty(required = true, value = "路由名称")
  private String name;

  @ApiModelProperty(required = false, value = "路由描述")
  private String description;

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

  @ApiModelProperty(required = true, value = "是否动态刷新路由")
  private Boolean publish;

}
