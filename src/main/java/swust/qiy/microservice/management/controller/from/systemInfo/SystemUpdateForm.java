package swust.qiy.microservice.management.controller.from.systemInfo;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/5/22
 */
@Data
public class SystemUpdateForm {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 业务系统名称
   */
  private String name;

  /**
   * 创建时间
   */
  private LocalDateTime createTime;

  /**
   * 描述
   */
  private String description;

}
