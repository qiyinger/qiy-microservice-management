package swust.qiy.microservice.management.entity;

public class UserRole {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 角色编码
   */
  private String code;

  /**
   * 角色名
   */
  private String name;

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
   * 获取角色编码
   *
   * @return CODE - 角色编码
   */
  public String getCode() {
    return code;
  }

  /**
   * 设置角色编码
   *
   * @param code 角色编码
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * 获取角色名
   *
   * @return NAME - 角色名
   */
  public String getName() {
    return name;
  }

  /**
   * 设置角色名
   *
   * @param name 角色名
   */
  public void setName(String name) {
    this.name = name;
  }
}