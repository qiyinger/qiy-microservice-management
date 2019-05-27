package swust.qiy.microservice.management.entity;


import com.baomidou.mybatisplus.annotation.TableLogic;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MicroserviceVersion {

  private Integer id;

  /**
   * 微服务版本号
   */
  private String version;

  /**
   * 上线状态, 0:未上线；1：已上线
   */
  private Boolean online;

  /**
   * 创建时间
   */
  private LocalDateTime createTime;

  /**
   * 描述
   */
  private String description;

  /**
   * 微服务标识
   */
  private Integer microserviceId;

  /**
   * 是否已创建配置
   */
  private Boolean configurated;

  /**
   * 发布状态，0：未发布；1：已发布
   */
  private Boolean publish;

  /**
   * 逻辑删除标识, 0:未删除;1:已删除
   */
  @TableLogic
  private Boolean isDeleted;

}