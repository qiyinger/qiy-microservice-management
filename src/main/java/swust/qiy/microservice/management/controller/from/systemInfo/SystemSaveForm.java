package swust.qiy.microservice.management.controller.from.systemInfo;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/5/22
 */
@Data
public class SystemSaveForm {

  /**
   * 业务系统编号
   */
  private String code;

  /**
   * 业务系统名称
   */
  private String name;

  /**
   * 描述
   */
  private String description;

}
