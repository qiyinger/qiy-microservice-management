package swust.qiy.microservice.management.entity;


public class RouteStrategyIp {

  private Integer id;

  /**
   * 路由id
   */
  private Integer routeId;

  /**
   * ip策略id
   */
  private Integer strategyIpId;

  /**
   * @return id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * 获取路由id
   *
   * @return route_id - 路由id
   */
  public Integer getRouteId() {
    return routeId;
  }

  /**
   * 设置路由id
   *
   * @param routeId 路由id
   */
  public void setRouteId(Integer routeId) {
    this.routeId = routeId;
  }

  /**
   * 获取ip策略id
   *
   * @return strategy_ip_id - ip策略id
   */
  public Integer getStrategyIpId() {
    return strategyIpId;
  }

  /**
   * 设置ip策略id
   *
   * @param strategyIpId ip策略id
   */
  public void setStrategyIpId(Integer strategyIpId) {
    this.strategyIpId = strategyIpId;
  }
}