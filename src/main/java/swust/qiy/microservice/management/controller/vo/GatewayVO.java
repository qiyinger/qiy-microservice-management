package swust.qiy.microservice.management.controller.vo;

import lombok.Data;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.management.entity.Gateway;

/**
 * @author qiying
 * @create 2019/4/29
 */
@Data
public class GatewayVO {

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

  public GatewayVO(Gateway gateway) {
    this.id = gateway.getId();
    this.code = gateway.getCode();
    this.name = gateway.getName();
    this.description = gateway.getDescription();
    this.status = gateway.getStatus();
    this.systemId = gateway.getSystemId();
    this.allCode = gateway.getAllCode();
  }
}
