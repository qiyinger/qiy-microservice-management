package swust.qiy.microservice.management.entity;

public class StrategyCall {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 时间单位，参考JAVA TimeUnit枚举类型
   */
  private String timeUnit;

  /**
   * 时间长度
   */
  private Integer timePeriod;

  /**
   * 访问次数限制
   */
  private Integer rateLimit;

  /**
   * 策略标识
   */
  private Integer strategyId;

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
   * 获取时间单位，参考JAVA TimeUnit枚举类型
   *
   * @return TIME_UNIT - 时间单位，参考JAVA TimeUnit枚举类型
   */
  public String getTimeUnit() {
    return timeUnit;
  }

  /**
   * 设置时间单位，参考JAVA TimeUnit枚举类型
   *
   * @param timeUnit 时间单位，参考JAVA TimeUnit枚举类型
   */
  public void setTimeUnit(String timeUnit) {
    this.timeUnit = timeUnit;
  }

  /**
   * 获取时间长度
   *
   * @return TIME_PERIOD - 时间长度
   */
  public Integer getTimePeriod() {
    return timePeriod;
  }

  /**
   * 设置时间长度
   *
   * @param timePeriod 时间长度
   */
  public void setTimePeriod(Integer timePeriod) {
    this.timePeriod = timePeriod;
  }

  /**
   * 获取访问次数限制
   *
   * @return RATE_LIMIT - 访问次数限制
   */
  public Integer getRateLimit() {
    return rateLimit;
  }

  /**
   * 设置访问次数限制
   *
   * @param rateLimit 访问次数限制
   */
  public void setRateLimit(Integer rateLimit) {
    this.rateLimit = rateLimit;
  }

  /**
   * 获取策略标识
   *
   * @return STRATEGY_ID - 策略标识
   */
  public Integer getStrategyId() {
    return strategyId;
  }

  /**
   * 设置策略标识
   *
   * @param strategyId 策略标识
   */
  public void setStrategyId(Integer strategyId) {
    this.strategyId = strategyId;
  }
}