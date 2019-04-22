package swust.qiy.microservice.management.entity;


import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Event {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 分类：网关、路由、黑白名单
   */
  private Byte type;

  /**
   * 事件类型：创建路由、删除路由、发布路由...
   */
  private Byte eventType;

  /**
   * 发生时间
   */
  private LocalDateTime time;

  /**
   * 影响路由或其他资源
   */
  private String affects;

  /**
   * 预留扩展
   */
  private String source;

}