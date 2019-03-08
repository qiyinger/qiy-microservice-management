package swust.qiy.microservice.management.entity;


public class StrategyCall {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 策略名称
   */
  private String name;

  /**
   * 描述
   */
  private String description;

  /**
   * 时间单位，参考JAVA TimeUnit枚举类型
   */
  private Byte timeUnit;

  /**
   * 时间长度
   */
  private Integer timePeriod;

  /**
   * 访问次数限制
   */
  private Integer rateLimit;

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
   * 获取策略名称
   *
   * @return name - 策略名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置策略名称
   *
   * @param name 策略名称
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取描述
   *
   * @return description - 描述
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
   * 获取时间单位，参考JAVA TimeUnit枚举类型
   *
   * @return TIME_UNIT - 时间单位，参考JAVA TimeUnit枚举类型
   */
  public Byte getTimeUnit() {
    return timeUnit;
  }

  /**
   * 设置时间单位，参考JAVA TimeUnit枚举类型
   *
   * @param timeUnit 时间单位，参考JAVA TimeUnit枚举类型
   */
  public void setTimeUnit(Byte timeUnit) {
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
}