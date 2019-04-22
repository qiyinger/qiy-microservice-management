package swust.qiy.microservice.management.entity;


import com.baomidou.mybatisplus.annotation.TableLogic;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Microservice {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 微服务编号
   */
  private String code;

  /**
   * 微服务完整编码
   */
  private String allCode;

  /**
   * 微服务名称
   */
  private String name;

  /**
   * 所属应用标识
   */
  private Integer appId;

  /**
   * 创建时间
   */
  private LocalDateTime createTime;

  /**
   * 描述
   */
  private String description;

  /**
   * 逻辑删除标识, 0:未删除;1:已删除
   */
  @TableLogic
  private Boolean isDeleted;

  /**
   * 所属用户
   */
  private Integer userId;

  /**
   * 所属系统
   */
  private Integer systemId;


}