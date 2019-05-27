package swust.qiy.microservice.management.entity;

import lombok.Data;

@Data
public class User {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 用户名
   */
  private String username;

  /**
   * 密码
   */
  private String password;

  /**
   * 角色ID
   */
  private Integer roleId;
}