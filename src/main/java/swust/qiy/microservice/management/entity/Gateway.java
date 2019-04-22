package swust.qiy.microservice.management.entity;

import lombok.Data;
import swust.qiy.microservice.core.constant.StatusConstant;

@Data
public class Gateway {

  /**
   * 唯一标识
   */
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
   * 状态:ON、OFF
   */
  private Byte status = StatusConstant.DISABLE;

  /**
   * 系统标识
   */
  private Integer systemId;

  /**
   * 网关完整编码
   */
  private String allCode;

}