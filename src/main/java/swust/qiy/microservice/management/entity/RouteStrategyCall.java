package swust.qiy.microservice.management.entity;


public class RouteStrategyCall {

  private Integer id;

  /**
   * 路由id
   */
  private Integer routeId;

  /**
   * 调用策略id
   */
  private Integer strategyCallId;

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
   * 获取调用策略id
   *
   * @return strategy_call_id - 调用策略id
   */
  public Integer getStrategyCallId() {
    return strategyCallId;
  }

  /**
   * 设置调用策略id
   *
   * @param strategyCallId 调用策略id
   */
  public void setStrategyCallId(Integer strategyCallId) {
    this.strategyCallId = strategyCallId;
  }
}