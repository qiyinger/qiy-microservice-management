package swust.qiy.microservice.management.entity;


import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Route {

  private Integer id;

  /**
   * 路由名称
   */
  private String name;

  /**
   * 创建时间
   */
  private LocalDateTime createTime;

  /**
   * 更新时间
   */
  private LocalDateTime updateTime;

  /**
   * 描述
   */
  private String description;

  /**
   * 发布状态: 0未发布, 1:已发布, 2:正在发布, 3: 正在停止
   */
  private Byte publish;

  /**
   * 所属网关标识
   */
  private Integer gatewayId;

  /**
   * 绑定id
   */
  private Integer bindServiceId;

  /**
   * 路由编码
   */
  private String code;

  /**
   * 路由路径
   */
  private String uri;

  /**
   * 过滤器
   */
  private String filters;

  /**
   * 断言工厂
   */
  private String predicates;

  /**
   * 优先级
   */
  private Integer priority;
}