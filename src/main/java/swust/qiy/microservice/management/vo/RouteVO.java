package swust.qiy.microservice.management.vo;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.management.entity.Route;

/**
 * @author qiying
 * @create 2019/4/24
 */
@Data
public class RouteVO {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * 路由名称
   */
  private String name;

  /**
   * 创建时间
   */
  private LocalDateTime createTime;

  /**
   * 更新时间
   */
  private LocalDateTime updateTime;

  /**
   * 描述
   */
  private String description;

  /**
   * 发布状态: 0:未发布, 1:已发布, 2:正在发布, 3: 正在停止
   */
  private Byte publish = StatusConstant.PUBLISH_PENDING;

  /**
   * 所属网关标识
   */
  private Integer gatewayId;

  /**
   * 绑定id
   */
  private Integer bindId;

  /**
   * 路由编码
   */
  private String code;

  /**
   * 路由地址
   */
  private String uri;

  /**
   * 过滤器
   */
  private List<String> filters;

  /**
   * 断言工厂
   */
  private List<String> predicates;

  /**
   * 优先级
   */
  private Integer priority;

  public RouteVO(Route route) {
    this.id = route.getId();
    this.name = route.getName();
    this.createTime = route.getCreateTime();
    this.updateTime = route.getUpdateTime();
    this.description = route.getDescription();
    this.publish = route.getPublish();
    this.gatewayId = route.getGatewayId();
    this.bindId = route.getBindServiceId();
    this.code = route.getCode();
    this.uri = route.getUri();
    if (StringUtils.isNotBlank(route.getFilters())) {
      this.filters = Arrays.asList(route.getFilters().split(";"));
    }
    if (StringUtils.isNotBlank(route.getFilters())) {
      this.predicates = Arrays.asList(route.getPredicates().split(";"));
    }
  }
}
