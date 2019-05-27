package swust.qiy.microservice.management.controller.from;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author qiying
 * @create 2019/1/24
 */
@ApiModel(value = "基础表单")
public class BaseForm {

  @ApiModelProperty(required = false, value = "id列表", example = "1,2,3")
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
