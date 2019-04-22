package swust.qiy.microservice.management.entity;


import com.baomidou.mybatisplus.annotation.TableLogic;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Application {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 应用编号
   */
  private String code;

  /**
   * 应用完整编码
   */
  private String allCode;

  /**
   * 应用名称
   */
  private String name;

  /**
   * 创建时间
   */
  private LocalDateTime createTime;

  /**
   * 描述
   */
  private String description;

  /**
   * api数量
   */
  private Integer apiCount;

  /**
   * 所属系统标识
   */
  private Integer systemId;

  /**
   * 逻辑删除标识, 0:未删除;1:已删除
   */
  @TableLogic
  private Boolean isDeleted;

  /**
   * 是否启用, 0:未启用 1:已启用
   */
  private Byte status;

  /**
   * 所属用户
   */
  private Integer userId;

}