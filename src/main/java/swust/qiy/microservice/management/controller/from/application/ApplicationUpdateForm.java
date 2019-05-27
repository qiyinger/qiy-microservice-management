package swust.qiy.microservice.management.controller.from.application;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/5/22
 */
@Data
public class ApplicationUpdateForm {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 应用名称
   */
  private String name;

  /**
   * 描述
   */
  private String description;


}
