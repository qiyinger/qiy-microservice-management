package swust.qiy.microservice.management.entity;


public class StrategyIp {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 策略名称
   */
  private String name;

  /**
   * 控制类型:黑名单black/白名单white
   */
  private Byte type;

  /**
   * 描述
   */
  private String description;

  /**
   * ip列表
   */
  private String ipList;

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
   * 获取控制类型:黑名单black/白名单white
   *
   * @return TYPE - 控制类型:黑名单black/白名单white
   */
  public Byte getType() {
    return type;
  }

  /**
   * 设置控制类型:黑名单black/白名单white
   *
   * @param type 控制类型:黑名单black/白名单white
   */
  public void setType(Byte type) {
    this.type = type;
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
   * 获取ip列表
   *
   * @return IP_LIST - ip列表
   */
  public String getIpList() {
    return ipList;
  }

  /**
   * 设置ip列表
   *
   * @param ipList ip列表
   */
  public void setIpList(String ipList) {
    this.ipList = ipList;
  }
}