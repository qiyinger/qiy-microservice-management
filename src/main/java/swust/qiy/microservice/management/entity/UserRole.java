package swust.qiy.microservice.management.entity;

import lombok.Data;

@Data
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

}