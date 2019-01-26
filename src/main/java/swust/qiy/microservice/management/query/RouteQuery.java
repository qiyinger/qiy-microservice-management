package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.time.LocalDateTime;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.Route;

/**
 * @author qiying
 */
@Data
public class RouteQuery extends BaseQuery<Route> {

  private Integer id;
  private String name;
  private LocalDateTime startCreateTime;
  private LocalDateTime endCreateTime;
  private LocalDateTime createTime;
  private LocalDateTime startUpdateTime;
  private LocalDateTime endUpdateTime;
  private LocalDateTime updateTime;
  private String description;
  private Boolean active;
  private Integer gatewayId;
  private String yml;
  private String rule;

  @Override
  public QueryWrapper<Route> toQueryWrapper() {
    QueryWrapper<Route> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
        queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(name)) {
        queryWrapper.eq("name", name);
      }
      if (!CommonUtil.isEmpty(startCreateTime)) {
        queryWrapper.ge("create_time", startCreateTime);
      }
      if (!CommonUtil.isEmpty(endCreateTime)) {
        queryWrapper.le("create_time", endCreateTime);
      }
      if (!CommonUtil.isEmpty(createTime)) {
        queryWrapper.eq("create_time", createTime);
      }
      if (!CommonUtil.isEmpty(startUpdateTime)) {
        queryWrapper.ge("update_time", startUpdateTime);
      }
      if (!CommonUtil.isEmpty(endUpdateTime)) {
        queryWrapper.le("update_time", endUpdateTime);
      }
      if (!CommonUtil.isEmpty(updateTime)) {
        queryWrapper.eq("update_time", updateTime);
      }
      if (!CommonUtil.isEmpty(description)) {
        queryWrapper.eq("description", description);
      }
      if (!CommonUtil.isEmpty(active)) {
        queryWrapper.eq("active", active);
      }
      if (!CommonUtil.isEmpty(gatewayId)) {
        queryWrapper.eq("gateway_id", gatewayId);
      }
      if (!CommonUtil.isEmpty(yml)) {
        queryWrapper.eq("yml", yml);
      }
      if (!CommonUtil.isEmpty(rule)) {
        queryWrapper.eq("rule", rule);
      }
    return queryWrapper;
  }
}