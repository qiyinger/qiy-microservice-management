package swust.qiy.microservice.management.entity;

import lombok.Data;

@Data
public class Configuration {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * Apollo环境
   */
  private String apolloEnv;

  /**
   * Apollo的应用ID，即微服务Code
   */
  private String apolloAppId;

  /**
   * Apollo集群名称
   */
  private String apolloClusterName;

  /**
   * Apollo名称空间名称
   */
  private String apolloNsName;

  /**
   * 所属微服务标识
   */
  private Integer serviceVersionId;

}