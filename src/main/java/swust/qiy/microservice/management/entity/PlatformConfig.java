package swust.qiy.microservice.management.entity;

import lombok.Data;

@Data
public class PlatformConfig {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 配置项
   */
  private String configKey;

  /**
   * 配置值
   */
  private String configValue;

  /**
   * 配置名称
   */
  private String configName;

}