package swust.qiy.microservice.management.entity;


import com.baomidou.mybatisplus.annotation.TableLogic;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MicroserviceVersion {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 微服务版本号
   */
  private String version;

  /**
   * 实例数
   */
  private Integer numOfInst;

  /**
   * 上线状态, 0:待上线;1:已上线;2:已下线
   */
  private Byte onlineStatus;

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
   * 逻辑删除标识, 0:未删除;1:已删除
   */
  @TableLogic
  private Boolean isDeleted;

}