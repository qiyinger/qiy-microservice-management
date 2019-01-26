package swust.qiy.microservice.management.entity;

public class Strategy {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 策略名称
   */
  private String name;

  /**
   * 策略类型:调控数(RateLimit)/IP控制(IP)
   */
  private String type;

  /**
   * 描述
   */
  private String description;

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
   * @return NAME - 策略名称
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
   * 获取策略类型:调控数(RateLimit)/IP控制(IP)
   *
   * @return TYPE - 策略类型:调控数(RateLimit)/IP控制(IP)
   */
  public String getType() {
    return type;
  }

  /**
   * 设置策略类型:调控数(RateLimit)/IP控制(IP)
   *
   * @param type 策略类型:调控数(RateLimit)/IP控制(IP)
   */
  public void setType(String type) {
    this.type = type;
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
}