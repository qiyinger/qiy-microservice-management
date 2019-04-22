package swust.qiy.microservice.management.controller.from.api.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/4/2
 */
@Data
@ApiModel(value = "申请Api/微服务表单")
public class ApiApplyForm {

  @ApiModelProperty(required = true, value = "申请人")
  private String applicant;

  @ApiModelProperty(required = true, value = "申请类型:0(微服务版本),1(接口)", allowableValues = "0,1")
  private Byte type;

  @ApiModelProperty(required = false, value = "描述")
  private String description;

  @ApiModelProperty(required = true, value = "微服务版本/api接口 id")
  private Integer asId;

}
