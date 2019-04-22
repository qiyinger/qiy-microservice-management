package swust.qiy.microservice.management.controller.from.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/3/28
 */
@Data
@ApiModel(value = "导入Api信息")
public class ApiImportForm {

  @ApiModelProperty(required = true, value = "swagger导入地址")
  private String url;

  @ApiModelProperty(required = true, value = "微服务版本id")
  private Integer serviceVersionId;

}
