package swust.qiy.microservice.management.entity;


import java.time.LocalDateTime;

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

  /**
   * 获取唯一标识
   *
   * @return ID - 唯一标识
   */
  public Integer getId() {
    return id;
  }

  /**
   * 设置唯一标识
   *
   * @param id 唯一标识
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * 获取分类：网关、路由、黑白名单
   *
   * @return type - 分类：网关、路由、黑白名单
   */
  public Byte getType() {
    return type;
  }

  /**
   * 设置分类：网关、路由、黑白名单
   *
   * @param type 分类：网关、路由、黑白名单
   */
  public void setType(Byte type) {
    this.type = type;
  }

  /**
   * 获取事件类型：创建路由、删除路由、发布路由...
   *
   * @return event_type - 事件类型：创建路由、删除路由、发布路由...
   */
  public Byte getEventType() {
    return eventType;
  }

  /**
   * 设置事件类型：创建路由、删除路由、发布路由...
   *
   * @param eventType 事件类型：创建路由、删除路由、发布路由...
   */
  public void setEventType(Byte eventType) {
    this.eventType = eventType;
  }

  /**
   * 获取发生时间
   *
   * @return TIME - 发生时间
   */
  public LocalDateTime getTime() {
    return time;
  }

  /**
   * 设置发生时间
   *
   * @param time 发生时间
   */
  public void setTime(LocalDateTime time) {
    this.time = time;
  }

  /**
   * 获取影响路由或其他资源
   *
   * @return AFFECTS - 影响路由或其他资源
   */
  public String getAffects() {
    return affects;
  }

  /**
   * 设置影响路由或其他资源
   *
   * @param affects 影响路由或其他资源
   */
  public void setAffects(String affects) {
    this.affects = affects;
  }

  /**
   * 获取预留扩展
   *
   * @return SOURCE - 预留扩展
   */
  public String getSource() {
    return source;
  }

  /**
   * 设置预留扩展
   *
   * @param source 预留扩展
   */
  public void setSource(String source) {
    this.source = source;
  }
}