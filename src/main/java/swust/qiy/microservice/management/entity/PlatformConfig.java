package swust.qiy.microservice.management.entity;

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
   * 获取配置项
   *
   * @return CONFIG_KEY - 配置项
   */
  public String getConfigKey() {
    return configKey;
  }

  /**
   * 设置配置项
   *
   * @param configKey 配置项
   */
  public void setConfigKey(String configKey) {
    this.configKey = configKey;
  }

  /**
   * 获取配置值
   *
   * @return CONFIG_VALUE - 配置值
   */
  public String getConfigValue() {
    return configValue;
  }

  /**
   * 设置配置值
   *
   * @param configValue 配置值
   */
  public void setConfigValue(String configValue) {
    this.configValue = configValue;
  }

  /**
   * 获取配置名称
   *
   * @return CONFIG_NAME - 配置名称
   */
  public String getConfigName() {
    return configName;
  }

  /**
   * 设置配置名称
   *
   * @param configName 配置名称
   */
  public void setConfigName(String configName) {
    this.configName = configName;
  }
}