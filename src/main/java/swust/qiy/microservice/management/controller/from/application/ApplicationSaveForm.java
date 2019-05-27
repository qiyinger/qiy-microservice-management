package swust.qiy.microservice.management.controller.from.application;

import lombok.Data;

/**
 * @author qiying
 * @create 2019/5/22
 */
@Data
public class ApplicationSaveForm {

  /**
   * 应用编码
   */
  private String code;

  /**
   * 应用名称
   */
  private String name;

  /**
   * 描述
   */
  private String description;

  /**
   * 所属系统标识
   */
  private Integer systemId;

  /**
   * 所属用户
   */
  private Integer userId;

}
