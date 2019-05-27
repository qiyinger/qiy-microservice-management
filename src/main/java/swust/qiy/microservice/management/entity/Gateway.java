package swust.qiy.microservice.management.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Gateway {

  @Id
  private Integer id;

  /**
   * 网关编码注册中心上使用${CODE}作为服务名
   */
  private String code;

  /**
   * 网关名称
   */
  private String name;

  /**
   * 描述
   */
  private String description;

  /**
   * 状态:PAUSE、ON、OFF
   */
  private Byte status;

  /**
   * 系统标识
   */
  private Integer systemId;

  /**
   * 全称
   */
  private String allCode;

}