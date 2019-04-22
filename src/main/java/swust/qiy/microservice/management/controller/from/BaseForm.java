package swust.qiy.microservice.management.controller.from;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author qiying
 * @create 2019/1/24
 */
@ApiModel(value = "基础表单")
public class BaseForm {

  @ApiModelProperty(required = true, value = "id列表", example = "1,2,3")
  private String ids;

  public String getIds() {
    return ids;
  }

  public void setIds(String ids) {
    this.ids = ids;
  }
}
