package swust.qiy.microservice.management.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import java.time.LocalDateTime;

public class MicroserviceVersion {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 微服务版本号
   */
  private String version;

  /**
   * 实例数
   */
  private Integer numOfInst;

  /**
   * 上线状态, 0:待上线;1:已上线;2:已下线
   */
  private Byte onlineStatus;

  /**
   * 创建时间
   */
  private LocalDateTime createTime;

  /**
   * 描述
   */
  private String description;

  /**
   * 微服务标识
   */
  private Integer microserviceId;

  /**
   * 逻辑删除标识, 0:未删除;1:已删除
   */
  @TableLogic
  private Boolean isDeleted;

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
   * 获取微服务版本号
   *
   * @return VERSION - 微服务版本号
   */
  public String getVersion() {
    return version;
  }

  /**
   * 设置微服务版本号
   *
   * @param version 微服务版本号
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * 获取实例数
   *
   * @return NUM_OF_INST - 实例数
   */
  public Integer getNumOfInst() {
    return numOfInst;
  }

  /**
   * 设置实例数
   *
   * @param numOfInst 实例数
   */
  public void setNumOfInst(Integer numOfInst) {
    this.numOfInst = numOfInst;
  }

  /**
   * 获取上线状态, 0:待上线;1:已上线;2:已下线
   *
   * @return ONLINE_STATUS - 上线状态, 0:待上线;1:已上线;2:已下线
   */
  public Byte getOnlineStatus() {
    return onlineStatus;
  }

  /**
   * 设置上线状态, 0:待上线;1:已上线;2:已下线
   *
   * @param onlineStatus 上线状态, 0:待上线;1:已上线;2:已下线
   */
  public void setOnlineStatus(Byte onlineStatus) {
    this.onlineStatus = onlineStatus;
  }

  /**
   * 获取创建时间
   *
   * @return CREATE_TIME - 创建时间
   */
  public LocalDateTime getCreateTime() {
    return createTime;
  }

  /**
   * 设置创建时间
   *
   * @param createTime 创建时间
   */
  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
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

  /**
   * 获取微服务标识
   *
   * @return MICROSERVICE_ID - 微服务标识
   */
  public Integer getMicroserviceId() {
    return microserviceId;
  }

  /**
   * 设置微服务标识
   *
   * @param microserviceId 微服务标识
   */
  public void setMicroserviceId(Integer microserviceId) {
    this.microserviceId = microserviceId;
  }

  /**
   * 获取逻辑删除标识, 0:未删除;1:已删除
   *
   * @return IS_DELETED - 逻辑删除标识, 0:未删除;1:已删除
   */
  public Boolean getIsDeleted() {
    return isDeleted;
  }

  /**
   * 设置逻辑删除标识, 0:未删除;1:已删除
   *
   * @param isDeleted 逻辑删除标识, 0:未删除;1:已删除
   */
  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }
}