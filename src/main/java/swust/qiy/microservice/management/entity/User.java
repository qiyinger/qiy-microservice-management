package swust.qiy.microservice.management.entity;


public class User {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 用户名
   */
  private String name;

  /**
   * 密码
   */
  private String password;

  /**
   * 角色ID
   */
  private Integer roleId;

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
   * 获取用户名
   *
   * @return NAME - 用户名
   */
  public String getName() {
    return name;
  }

  /**
   * 设置用户名
   *
   * @param name 用户名
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取密码
   *
   * @return password - 密码
   */
  public String getPassword() {
    return password;
  }

  /**
   * 设置密码
   *
   * @param password 密码
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * 获取角色ID
   *
   * @return role_id - 角色ID
   */
  public Integer getRoleId() {
    return roleId;
  }

  /**
   * 设置角色ID
   *
   * @param roleId 角色ID
   */
  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }
}