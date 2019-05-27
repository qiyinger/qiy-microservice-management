package swust.qiy.microservice.management.entity;


import lombok.Data;

@Data
public class ApiInfo {

  private Integer id;

  /**
   * API名称
   */
  private String name;

  /**
   * 请求协议
   */
  private String protocol;

  /**
   * HTTP Method
   */
  private String method;

  /**
   * 请求路径
   */
  private String path;

  /**
   * 描述
   */
  private String description;

  /**
   * 是否失效, 0:有效, 1:失效
   */
  private Boolean invalid;

  /**
   * 微服务版本标识
   */
  private Integer serviceVersionId;

  /**
   * 所属微服务
   */
  private Integer microserviceId;

}