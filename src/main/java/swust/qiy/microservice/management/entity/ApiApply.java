package swust.qiy.microservice.management.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ApiApply {

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
   * 系统id
   */
  private Integer systemId;

  /**
   * 版本id
   */
  private Integer serviceVersionId;

}