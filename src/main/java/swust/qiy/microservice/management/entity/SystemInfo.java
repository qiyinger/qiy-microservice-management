package swust.qiy.microservice.management.entity;


import com.baomidou.mybatisplus.annotation.TableLogic;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SystemInfo {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 业务系统编号
   */
  private String code;

  /**
   * 业务系统名称
   */
  private String name;

  /**
   * 是否启用, 0:未启用 1:已启用
   */
  private Byte status;

  /**
   * 创建时间
   */
  private LocalDateTime createTime;

  /**
   * 描述
   */
  private String description;

  /**
   * 订阅码
   */
  private String rsskey;

  /**
   * 所属用户
   */
  private Integer userId;

  /**
   * 用户名
   */
  private String userName;

  /**
   * 逻辑删除标识, 0:未删除;1:已删除
   */
  @TableLogic
  private Boolean isDeleted;

}