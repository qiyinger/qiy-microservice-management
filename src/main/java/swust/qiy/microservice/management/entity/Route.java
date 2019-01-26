package swust.qiy.microservice.management.entity;

import java.time.LocalDateTime;

public class Route {

  /**
   * 唯一标识
   */
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
   * 发布状态
   */
  private Boolean active;

  /**
   * 所属网关标识
   */
  private Integer gatewayId;

  /**
   * 路由规则(YML)
   */
  private String yml;

  /**
   * 路由规则(JSON)
   */
  private String rule;

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
   * 获取路由名称
   *
   * @return NAME - 路由名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置路由名称
   *
   * @param name 路由名称
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取创建时间
   *
   * @return CREATE_TIME - 创建时间
   */
  public LocalDateTime getCreateTime() {
    return createTime;
  }

  /**
   * 设置创建时间
   *
   * @param createTime 创建时间
   */
  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }

  /**
   * 获取更新时间
   *
   * @return UPDATE_TIME - 更新时间
   */
  public LocalDateTime getUpdateTime() {
    return updateTime;
  }

  /**
   * 设置更新时间
   *
   * @param updateTime 更新时间
   */
  public void setUpdateTime(LocalDateTime updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * 获取描述
   *
   * @return DESCRIPTION - 描述
   */
  public String getDescription() {
    return description;
  }

  /**
   * 设置描述
   *
   * @param description 描述
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * 获取发布状态
   *
   * @return ACTIVE - 发布状态
   */
  public Boolean getActive() {
    return active;
  }

  /**
   * 设置发布状态
   *
   * @param active 发布状态
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  /**
   * 获取所属网关标识
   *
   * @return GATEWAY_ID - 所属网关标识
   */
  public Integer getGatewayId() {
    return gatewayId;
  }

  /**
   * 设置所属网关标识
   *
   * @param gatewayId 所属网关标识
   */
  public void setGatewayId(Integer gatewayId) {
    this.gatewayId = gatewayId;
  }

  /**
   * 获取路由规则(YML)
   *
   * @return YML - 路由规则(YML)
   */
  public String getYml() {
    return yml;
  }

  /**
   * 设置路由规则(YML)
   *
   * @param yml 路由规则(YML)
   */
  public void setYml(String yml) {
    this.yml = yml;
  }

  /**
   * 获取路由规则(JSON)
   *
   * @return RULE - 路由规则(JSON)
   */
  public String getRule() {
    return rule;
  }

  /**
   * 设置路由规则(JSON)
   *
   * @param rule 路由规则(JSON)
   */
  public void setRule(String rule) {
    this.rule = rule;
  }
}