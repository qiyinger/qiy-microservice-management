package swust.qiy.microservice.management.vo;

import java.util.Date;

/**
 * @author qiying
 * @create 2018/11/9
 */
public class SystemVO {

  /**
   * 系统id
   */
  private String id;

  /**
   * 系统编号
   */
  private String code;

  /**
   * 系统名称
   */
  private String name;

  /**
   * 系统状态
   */
  private Integer status;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 系统描述
   */
  private String description;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "SystemVO{" +
      "id='" + id + '\'' +
      ", code='" + code + '\'' +
      ", name='" + name + '\'' +
      ", status=" + status +
      ", createTime=" + createTime +
      ", description='" + description + '\'' +
      '}';
  }
}
