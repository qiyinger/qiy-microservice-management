package swust.qiy.microservice.management.controller.from.api.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/4/2
 */
@Data
@ApiModel(value = "申请Api/微服务表单")
public class ApiApplyForm {

  /**
   * 申请人
   */
  private String applicant;

  /**
   * 描述
   */
  private String description;

  /**
   * 接口/微服务版本标识
   */
  private Integer asId;

  /**
   * 系统id
   */
  private Integer systemId;

}
