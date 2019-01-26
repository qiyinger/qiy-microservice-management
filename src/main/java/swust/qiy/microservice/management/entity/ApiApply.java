package swust.qiy.microservice.management.entity;

import java.time.LocalDateTime;

public class ApiApply {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 申请人
   */
  private String applicant;

  /**
   * 审核状态,0:等待审核;1:通过;2:打回
   */
  private Byte status;

  /**
   * 申请类型:service(微服务),api(接口)
   */
  private Byte type;

  /**
   * 申请时间
   */
  private LocalDateTime applyTime;

  /**
   * 描述
   */
  private String description;

  /**
   * 审核人
   */
  private String auditorName;

  /**
   * 接口/微服务版本标识
   */
  private Integer asId;

  /**
   * 修改时间
   */
  private LocalDateTime modifyTime;

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
   * 获取申请人
   *
   * @return APPLICANT - 申请人
   */
  public String getApplicant() {
    return applicant;
  }

  /**
   * 设置申请人
   *
   * @param applicant 申请人
   */
  public void setApplicant(String applicant) {
    this.applicant = applicant;
  }

  /**
   * 获取审核状态,0:等待审核;1:通过;2:打回
   *
   * @return STATUS - 审核状态,0:等待审核;1:通过;2:打回
   */
  public Byte getStatus() {
    return status;
  }

  /**
   * 设置审核状态,0:等待审核;1:通过;2:打回
   *
   * @param status 审核状态,0:等待审核;1:通过;2:打回
   */
  public void setStatus(Byte status) {
    this.status = status;
  }

  /**
   * 获取申请类型:service(微服务),api(接口)
   *
   * @return TYPE - 申请类型:service(微服务),api(接口)
   */
  public Byte getType() {
    return type;
  }

  /**
   * 设置申请类型:service(微服务),api(接口)
   *
   * @param type 申请类型:service(微服务),api(接口)
   */
  public void setType(Byte type) {
    this.type = type;
  }

  /**
   * 获取申请时间
   *
   * @return APPLY_TIME - 申请时间
   */
  public LocalDateTime getApplyTime() {
    return applyTime;
  }

  /**
   * 设置申请时间
   *
   * @param applyTime 申请时间
   */
  public void setApplyTime(LocalDateTime applyTime) {
    this.applyTime = applyTime;
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
   * 获取审核人
   *
   * @return AUDITOR_NAME - 审核人
   */
  public String getAuditorName() {
    return auditorName;
  }

  /**
   * 设置审核人
   *
   * @param auditorName 审核人
   */
  public void setAuditorName(String auditorName) {
    this.auditorName = auditorName;
  }

  /**
   * 获取接口/微服务版本标识
   *
   * @return AS_ID - 接口/微服务版本标识
   */
  public Integer getAsId() {
    return asId;
  }

  /**
   * 设置接口/微服务版本标识
   *
   * @param asId 接口/微服务版本标识
   */
  public void setAsId(Integer asId) {
    this.asId = asId;
  }

  /**
   * 获取修改时间
   *
   * @return modify_time - 修改时间
   */
  public LocalDateTime getModifyTime() {
    return modifyTime;
  }

  /**
   * 设置修改时间
   *
   * @param modifyTime 修改时间
   */
  public void setModifyTime(LocalDateTime modifyTime) {
    this.modifyTime = modifyTime;
  }
}